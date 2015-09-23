package org.langclub.service.user.dao;

import org.langclub.api.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
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

@Transactional
public interface UserDao extends JpaRepository<UserEntity, String> {

}
