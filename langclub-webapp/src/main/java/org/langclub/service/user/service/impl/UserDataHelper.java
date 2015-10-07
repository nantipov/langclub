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

}
