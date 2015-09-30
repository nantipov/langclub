package org.langclub.service.user.service.impl;

import org.langclub.api.user.UserEntity;
import org.langclub.api.user.UserLanguageEntity;
import org.langclub.api.user.dto.UserLanguageDTO;
import org.langclub.api.user.dto.UserSettingsDTO;
import org.langclub.service.user.dao.UserDao;
import org.langclub.service.user.service.UserSettingsService;
import org.langclub.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

@Service
public class UserSettingsServiceImpl implements UserSettingsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserSettingsDTO getUserSettings() {
        return getUserSettings(UserUtils.getCurrentUserId());
    }

    @Override
    @Transactional
    public UserSettingsDTO getUserSettings(String userId) {
        UserEntity userEntity = userDao.findOne(userId);
        if (userEntity == null) {
            List<UserEntity> users = userDao.findAll();
            if (!users.isEmpty()) {
                userEntity = users.get(0);
            }
        }

        UserSettingsDTO userSettingsDTO = new UserSettingsDTO();

        UserSettingsHelper.fillUserSettingsDTO(userSettingsDTO, userEntity);

        return userSettingsDTO;
    }

    @Override
    public void setUserSettings(UserSettingsDTO userSettings) {
        String userId = userSettings.getUserId();
        UserEntity userEntity = userDao.findOne(userId);

        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setId(userId);
        }

        // process existing languages
        Set<UserLanguageDTO> processedLanguages = new HashSet<>();
        Iterator<UserLanguageEntity> languageEntityIterator = userEntity.getUserLanguageSet().iterator();
        while (languageEntityIterator.hasNext()) {
            UserLanguageEntity userLanguageEntity = languageEntityIterator.next();
            boolean found = false;
            for (UserLanguageDTO userLanguageDTO: userSettings.getUserLanguages()) {
                if (userLanguageDTO.getLanguage() == userLanguageEntity.getLanguage()) {
                    found = true;
                    processedLanguages.add(userLanguageDTO);
                    if (userLanguageDTO.getLevel() != userLanguageEntity.getLanguageLevel()) {
                        userLanguageEntity.setLanguageLevel(userLanguageDTO.getLevel());
                    }
                    break;
                }
            }
            if (!found) {
                // has been removed
                languageEntityIterator.remove();
            }
        }

        // process new languages
        userSettings.getUserLanguages().removeAll(processedLanguages);
        for (UserLanguageDTO userLanguageDTO: userSettings.getUserLanguages()) {
            UserLanguageEntity userLanguageEntity = new UserLanguageEntity();
            userLanguageEntity.setLanguage(userLanguageDTO.getLanguage());
            userLanguageEntity.setLanguageLevel(userLanguageDTO.getLevel());
            userLanguageEntity.setUser(userEntity);
            userEntity.getUserLanguageSet().add(userLanguageEntity);
        }

        userDao.saveAndFlush(userEntity);
    }

}
