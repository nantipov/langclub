package org.langclub.service.club.conference.service;

import org.langclub.api.club.conference.dto.ConferenceChangeRequestDTO;
import org.langclub.api.club.conference.dto.ConferenceDTO;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public interface ConferenceService {

    ConferenceDTO createConference(ConferenceChangeRequestDTO changeRequestDTO);

}
