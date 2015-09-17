package org.langclub.service.rest;

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
public interface RestClubService {

    ConferenceDTO createConference(ConferenceChangeRequestDTO changeRequestDTO);

}
