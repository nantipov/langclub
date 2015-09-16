package org.langclub.service.club.conference.dao;

import org.langclub.api.club.conference.mongo.ConferenceAppointment;
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
public interface ConferenceAppointmentDao extends MongoRepository<ConferenceAppointment, String> {
}
