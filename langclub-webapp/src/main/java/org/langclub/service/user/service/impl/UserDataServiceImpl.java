package org.langclub.service.user.service.impl;

import org.langclub.api.user.UserEntity;
import org.langclub.api.user.UserLanguageEntity;
import org.langclub.api.user.dto.UserLanguageDTO;
import org.langclub.api.user.dto.UserDataDTO;
import org.langclub.service.user.dao.UserDao;
import org.langclub.service.user.service.UserDataService;
import org.langclub.service.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDataDTO getUserData() {
        return getUserData(UserUtils.getCurrentUserId());
    }

    @Override
    @Transactional
    public UserDataDTO getUserData(String userId) {
        UserEntity userEntity = userDao.findOne(userId);
        if (userEntity == null) {
            List<UserEntity> users = userDao.findAll();
            if (!users.isEmpty()) {
                userEntity = users.get(0);
            }
        }

        UserDataDTO userDataDTO = new UserDataDTO();

        UserDataHelper.fillUserDataDTO(userDataDTO, userEntity);

        return userDataDTO;
    }

    @Override
    @Transactional
    public void setUserData(UserDataDTO userData) {
        String userId = UserUtils.getCurrentUserId();

        UserEntity userEntity = userDao.findOne(userId);

        if (userEntity == null) {
        	//TODO: throw NoUserException or something like that
            userEntity = new UserEntity();
            //userEntity.setId(userId);
        }

        UserDataHelper.fillUserEntity(userEntity, userData);
        
        userDao.saveAndFlush(userEntity);
    }

	@Override
	public void createUser(UserDataDTO userDataDTO) {
		
	}

}
