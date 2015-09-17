package org.langclub.api.club.conference;

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
@Table(name = "CONF_USER")
public class UserConferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_CONF_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @Column(name = "USER")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "CONFERENCE_ID")
    @Column(name = "CONF")
    private ConferenceEntity conference;

    @Enumerated(EnumType.STRING)
    @Column(name = "PARTICIPANT_TYPE")
    private ParticipantType participantType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ConferenceEntity getConference() {
        return conference;
    }

    public void setConference(ConferenceEntity conference) {
        this.conference = conference;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }
}
