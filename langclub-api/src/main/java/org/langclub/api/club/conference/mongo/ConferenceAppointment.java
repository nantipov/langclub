package org.langclub.api.club.conference.mongo;

import org.langclub.api.club.conference.ConferenceType;
import org.springframework.data.annotation.Id;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

/**
 * MongoDB entity
 */
public class ConferenceAppointment {

    @Id
    private String id;

    private ConferenceType conferenceType;
    private String description;

}
