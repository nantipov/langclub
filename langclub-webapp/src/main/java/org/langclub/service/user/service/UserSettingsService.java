package org.langclub.service.user.service;

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
public interface UserSettingsService {

    UserSettingsDTO getUserSettings();

    UserSettingsDTO getUserSettings(String userId);

    void setUserSettings(UserSettingsDTO userSettings);

}
