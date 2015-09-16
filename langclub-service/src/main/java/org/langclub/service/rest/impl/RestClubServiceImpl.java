package org.langclub.service.rest.impl;

import org.langclub.api.SearchCriteria;
import org.langclub.api.user.User;
import org.langclub.service.club.SearchService;
import org.langclub.service.rest.RestClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/club")
public class RestClubServiceImpl implements RestClubService {

    @Autowired
    private SearchService searchService;

    @Override
    @RequestMapping("/getTime")
    public SearchCriteria getTime() {
        return searchService.getTime();
    }

    @Override
    @RequestMapping("/getY")
    public List<User> getY() {
        return searchService.getY();
    }
}
