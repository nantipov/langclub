package org.langclub.api.club.conference;

import org.langclub.api.language.LanguageLevel;
import org.langclub.api.user.UserEntity;

import javax.persistence.*;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

@Entity
@Table(name = "CONF_SEARCH_CRITERIA")
public class ConferenceSearchCriteriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONF_SEARCH_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @Column(name = "USER", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONF_TRN_TYPE", nullable = false)
    private ConferenceTransportType conferenceTransportType;

    @Enumerated(EnumType.STRING)
    @Column(name = "MIN_LANG_LEVEL", nullable = false)
    private LanguageLevel minLanguageLevel = LanguageLevel.THE_LOWEST;

    //TODO: topics, data/time range/expression

}
