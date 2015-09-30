package org.langclub.api.user.service;

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
public interface RestUserSettingsService {

    UserSettingsDTO getUserSettings();

    void setUserSettings(UserSettingsDTO userSettings);

}
