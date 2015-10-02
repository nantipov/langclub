package org.langclub.api.user.service;

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
public interface RestUserDataService {

    UserDataDTO getUserData();

    void setUserData(UserDataDTO userData);

}
