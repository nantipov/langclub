package org.langclub.service.club;

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
public interface SearchService {

    SearchCriteria getTime();

    List<User> getY();

}
