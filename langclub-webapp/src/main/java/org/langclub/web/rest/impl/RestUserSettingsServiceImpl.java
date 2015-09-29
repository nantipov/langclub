package org.langclub.web.rest.impl;

import org.langclub.api.user.dto.UserSettingsDTO;
import org.langclub.api.user.service.RestUserSettingsService;
import org.langclub.service.user.service.UserSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

@RestController
@RequestMapping("/rest/user")
public class RestUserSettingsServiceImpl implements RestUserSettingsService {

    @Autowired
    private UserSettingsService userSettingsService;

    @Override
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public UserSettingsDTO getUserSettings() {
        return userSettingsService.getUserSettings();
    }

}
