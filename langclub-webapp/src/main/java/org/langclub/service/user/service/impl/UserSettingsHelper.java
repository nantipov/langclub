package org.langclub.service.user.service.impl;

import org.langclub.api.user.UserEntity;
import org.langclub.api.user.UserLanguageEntity;
import org.langclub.api.user.dto.UserLanguageDTO;
import org.langclub.api.user.dto.UserSettingsDTO;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public class UserSettingsHelper {

    public static void fillUserSettingsDTO(UserSettingsDTO userSettingsDTO, UserEntity userEntity) {
        userSettingsDTO.setUserId(userEntity.getId());
        for (UserLanguageEntity userLanguageEntity: userEntity.getUserLanguageSet()) {
            userSettingsDTO.getUserLanguages().add(new UserLanguageDTO(userLanguageEntity.getLanguage(), userLanguageEntity.getLanguageLevel()));
        }
    }

}
