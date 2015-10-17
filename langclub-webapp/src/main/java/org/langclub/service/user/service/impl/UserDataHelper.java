package org.langclub.service.user.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.langclub.api.user.UserEntity;
import org.langclub.api.user.UserLanguageEntity;
import org.langclub.api.user.dto.UserLanguageDTO;
import org.langclub.api.user.dto.UserDataDTO;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public class UserDataHelper {

    public static void fillUserDataDTO(UserDataDTO userDataDTO, UserEntity userEntity) {
        userDataDTO.setUserId(userEntity.getId());
        userDataDTO.getUserPersonalData().setEmail(userEntity.getEmail());
        userDataDTO.getUserPersonalData().setNickname(userEntity.getNickname());
        userDataDTO.getUserPersonalData().setFullName(userEntity.getFullName());
        for (UserLanguageEntity userLanguageEntity: userEntity.getUserLanguageSet()) {
            userDataDTO.getUserLanguages().add(new UserLanguageDTO(userLanguageEntity.getLanguage(), userLanguageEntity.getLanguageLevel()));
        }
    }
    
    public static void fillUserEntity(UserEntity userEntity, UserDataDTO userDataDTO) {
        // personal data
        userEntity.setEmail(userDataDTO.getUserPersonalData().getEmail());
        userEntity.setNickname(userDataDTO.getUserPersonalData().getNickname());
        userEntity.setFullName(userDataDTO.getUserPersonalData().getFullName());

        // languages
        // process existing languages
        Set<UserLanguageDTO> processedLanguages = new HashSet<>();
        Iterator<UserLanguageEntity> languageEntityIterator = userEntity.getUserLanguageSet().iterator();
        while (languageEntityIterator.hasNext()) {
            UserLanguageEntity userLanguageEntity = languageEntityIterator.next();
            boolean found = false;
            for (UserLanguageDTO userLanguageDTO: userDataDTO.getUserLanguages()) {
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
        userDataDTO.getUserLanguages().removeAll(processedLanguages);
        for (UserLanguageDTO userLanguageDTO: userDataDTO.getUserLanguages()) {
            UserLanguageEntity userLanguageEntity = new UserLanguageEntity();
            userLanguageEntity.setLanguage(userLanguageDTO.getLanguage());
            userLanguageEntity.setLanguageLevel(userLanguageDTO.getLevel());
            userLanguageEntity.setUser(userEntity);
            userEntity.getUserLanguageSet().add(userLanguageEntity);
        }
    }

}
