package org.langclub.service.user.service;

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
public interface UserDataService { //TODO: rename to UserService
	
    UserDataDTO getUserData();

    UserDataDTO getUserData(String userId);

    void setUserData(UserDataDTO userData);

	void createUser(UserDataDTO userDataDTO);

}
