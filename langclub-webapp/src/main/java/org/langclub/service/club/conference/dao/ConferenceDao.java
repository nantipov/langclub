package org.langclub.service.club.conference.dao;

import org.langclub.api.club.conference.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public interface ConferenceDao extends JpaRepository<ConferenceEntity, String> {
}
