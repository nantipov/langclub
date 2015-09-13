package org.langclub.service.club.impl;

import org.langclub.api.SearchCriteria;
import org.langclub.api.User;
import org.langclub.service.club.SearchService;
import org.langclub.service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public SearchCriteria getTime() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setDate(new Date());
//        java.time.LocalDateTime.now().toString();

        User user = new User();
        user.setName(java.time.LocalDateTime.now().toString());
        userDao.save(user);

        return searchCriteria;
    }

    @Override
    public List<User> getY() {
        return userDao.findAll();
    }
}
