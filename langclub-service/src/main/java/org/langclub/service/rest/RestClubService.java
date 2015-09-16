package org.langclub.service.rest;

import org.langclub.api.SearchCriteria;
import org.langclub.api.user.User;

import java.util.List;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public interface RestClubService {

    SearchCriteria getTime();

    List<User> getY();



}
