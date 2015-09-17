package org.langclub.service.user.service.impl;

import org.langclub.api.user.UserEntity;
import org.langclub.api.user.dto.UserSettingsDTO;
import org.langclub.service.user.dao.UserDao;
import org.langclub.service.user.service.UserSettingsService;
import org.langclub.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserSettingsDTO getUserSettings() {
        return getUserSettings(UserUtils.getCurrentUserId());
    }

    @Override
    public UserSettingsDTO getUserSettings(String userId) {
        UserEntity userEntity = userDao.findOne(userId);
        UserSettingsDTO userSettingsDTO = new UserSettingsDTO();

        UserSettingsHelper.fillUserSettings(userSettingsDTO, userEntity);

        return userSettingsDTO;
    }

}
