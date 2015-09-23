package org.langclub.web.service;

import org.langclub.api.user.dto.UserSettingsDTO;
import org.langclub.api.user.service.RestUserSettingsService;
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
public class RestUserSettingsClientServiceImpl implements RestUserSettingsService {

    @Override
    public UserSettingsDTO getUserSettings() {
        return null;
    }

}
