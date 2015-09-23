package org.langclub.api.club.conference;

import org.langclub.api.language.Language;
import org.langclub.api.language.LanguageLevel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "CONFERENCE")
public class ConferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONFERENCE_ID")
    private String id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "CONF_TRN_TYPE", nullable = false)
    private ConferenceTransportType conferenceTransportType;

    @Column(name = "CONF_DESCRIPTION")
    private String description;

    @Column(name = "CONF_TOPIC")
    private String topic;

    @Column(name = "MIN_PARTICIPANTS")
    private int minParticipantsNumber = 2;

    @Column(name = "MAX_PARTICIPANTS")
    private int maxParticipantsNumber = -1;

    @Column(name = "CURR_PARTICIPANTS")
    private int currentParticipantsNumber = 1;

    @Temporal(TemporalType.DATE)
    @Column(name = "CONF_APPOINTMENT_DATE", nullable = false)
    private Date conferenceAppointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONF_LANGUAGE", nullable = false)
    private Language conferenceLanguage;

    @Enumerated(EnumType.STRING)
    @Column(name = "MIN_LANG_LEVEL")
    private LanguageLevel minLanguageLevel = LanguageLevel.THE_LOWEST;

    @Enumerated(EnumType.STRING)
    @Column(name = "MAX_LANG_LEVEL")
    private LanguageLevel maxLanguageLevel = LanguageLevel.THE_HIGHEST;

    @Version
    @Column(name = "OPTLOCK_VERSION", nullable = false)
    private long version = 0L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference", fetch = FetchType.LAZY)
    private Set<UserConferenceEntity> userConferencesSet = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConferenceTransportType getConferenceTransportType() {
        return conferenceTransportType;
    }

    public void setConferenceTransportType(ConferenceTransportType conferenceTransportType) {
        this.conferenceTransportType = conferenceTransportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getMinParticipantsNumber() {
        return minParticipantsNumber;
    }

    public void setMinParticipantsNumber(int minParticipantsNumber) {
        this.minParticipantsNumber = minParticipantsNumber;
    }

    public int getMaxParticipantsNumber() {
        return maxParticipantsNumber;
    }

    public void setMaxParticipantsNumber(int maxParticipantsNumber) {
        this.maxParticipantsNumber = maxParticipantsNumber;
    }

    public int getCurrentParticipantsNumber() {
        return currentParticipantsNumber;
    }

    public void setCurrentParticipantsNumber(int currentParticipantsNumber) {
        this.currentParticipantsNumber = currentParticipantsNumber;
    }

    public Date getConferenceAppointmentDate() {
        return conferenceAppointmentDate;
    }

    public void setConferenceAppointmentDate(Date conferenceAppointmentDate) {
        this.conferenceAppointmentDate = conferenceAppointmentDate;
    }

    public Language getConferenceLanguage() {
        return conferenceLanguage;
    }

    public void setConferenceLanguage(Language conferenceLanguage) {
        this.conferenceLanguage = conferenceLanguage;
    }

    public LanguageLevel getMinLanguageLevel() {
        return minLanguageLevel;
    }

    public void setMinLanguageLevel(LanguageLevel minLanguageLevel) {
        this.minLanguageLevel = minLanguageLevel;
    }

    public LanguageLevel getMaxLanguageLevel() {
        return maxLanguageLevel;
    }

    public void setMaxLanguageLevel(LanguageLevel maxLanguageLevel) {
        this.maxLanguageLevel = maxLanguageLevel;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<UserConferenceEntity> getUserConferencesSet() {
        return userConferencesSet;
    }
}
