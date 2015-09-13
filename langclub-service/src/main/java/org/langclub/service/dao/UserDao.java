package org.langclub.service.dao;

import org.langclub.api.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.stereotype.Repository;

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

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, String> {

    List<User> findByName(String name);

}
