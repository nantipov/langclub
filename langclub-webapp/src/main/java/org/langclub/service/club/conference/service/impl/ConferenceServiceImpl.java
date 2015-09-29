package org.langclub.service.club.conference.service.impl;

import org.langclub.api.club.conference.dto.ConferenceChangeRequestDTO;
import org.langclub.api.club.conference.dto.ConferenceDTO;
import org.langclub.service.club.conference.dao.ConferenceDao;
import org.langclub.service.club.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    @Override
    public ConferenceDTO createConference(ConferenceChangeRequestDTO changeRequestDTO) {
        return null;
    }

}
