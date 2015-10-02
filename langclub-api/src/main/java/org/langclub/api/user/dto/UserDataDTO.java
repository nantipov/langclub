package org.langclub.api.user.dto;

import java.util.HashSet;
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

public class UserDataDTO {

    private String userId;

    private UserPersonalDataDTO userPersonalData = new UserPersonalDataDTO();
    private Set<UserLanguageDTO> userLanguages = new HashSet<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserPersonalDataDTO getPersonalUserData() {
		return userPersonalData;
	}

	public Set<UserLanguageDTO> getUserLanguages() {
        return userLanguages;
    }

}
