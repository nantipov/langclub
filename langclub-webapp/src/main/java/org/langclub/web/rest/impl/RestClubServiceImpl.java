package org.langclub.web.rest.impl;

import org.langclub.api.club.conference.dto.ConferenceChangeRequestDTO;
import org.langclub.api.club.conference.dto.ConferenceDTO;
import org.langclub.api.club.service.RestClubService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

@RestController
@RequestMapping("/rest/club")
public class RestClubServiceImpl implements RestClubService {

    @Override
    public ConferenceDTO createConference(ConferenceChangeRequestDTO changeRequestDTO) {
        return null;
    }

}
