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

public class UserSettingsDTO {

    private String userId;

    private Set<UserLanguageDTO> userLanguages = new HashSet<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<UserLanguageDTO> getUserLanguages() {
        return userLanguages;
    }

}
