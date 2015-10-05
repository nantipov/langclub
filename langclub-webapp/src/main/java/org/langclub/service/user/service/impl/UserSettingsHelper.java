package org.langclub.service.user.service.impl;

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
public class UserSettingsHelper {

    public static void fillUserSettingsDTO(UserDataDTO userDataDTO, UserEntity userEntity) {
        userDataDTO.setUserId(userEntity.getId());
        userDataDTO.getPersonalUserData().setEmail(userEntity.getEmail());
        userDataDTO.getPersonalUserData().setNickname(userEntity.getNickname());
        userDataDTO.getPersonalUserData().setFullName(userEntity.getFullName());
        for (UserLanguageEntity userLanguageEntity: userEntity.getUserLanguageSet()) {
            userDataDTO.getUserLanguages().add(new UserLanguageDTO(userLanguageEntity.getLanguage(), userLanguageEntity.getLanguageLevel()));
        }
    }

}
