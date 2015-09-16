package org.langclub.service.club.conference.dao;

import org.langclub.api.club.conference.mongo.ConferenceSearchCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public interface ConferenceSearchCriteriaDao extends MongoRepository<ConferenceSearchCriteria, String> {



}
