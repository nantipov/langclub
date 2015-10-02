package org.langclub.web.rest.impl;

import org.langclub.api.user.dto.UserDataDTO;
import org.langclub.api.user.service.RestUserDataService;
import org.langclub.service.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
public class RestUserDataServiceImpl implements RestUserDataService {

    @Autowired
    private UserDataService userDataService;

    @Override
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public UserDataDTO getUserData() {
        return userDataService.getUserData();
    }

    @Override
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public void setUserData(@RequestBody UserDataDTO userData) {
        userDataService.setUserData(userData);
    }

}
