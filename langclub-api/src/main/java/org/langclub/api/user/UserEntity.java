package org.langclub.api.user;

import org.langclub.api.club.conference.ConferenceSearchCriteriaEntity;
import org.langclub.api.club.conference.UserConferenceEntity;

import javax.persistence.*;
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
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private String id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FULL_NAME")
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserLanguageEntity> userLanguageSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserConferenceEntity> userConferencesSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<ConferenceSearchCriteriaEntity> userConferenceSearchCriteria = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<UserLanguageEntity> getUserLanguageSet() {
        return userLanguageSet;
    }

    public void setUserLanguageSet(Set<UserLanguageEntity> userLanguageSet) {
        this.userLanguageSet = userLanguageSet;
    }

    public Set<UserConferenceEntity> getUserConferencesSet() {
        return userConferencesSet;
    }

    public void setUserConferencesSet(Set<UserConferenceEntity> userConferencesSet) {
        this.userConferencesSet = userConferencesSet;
    }

    public Set<ConferenceSearchCriteriaEntity> getUserConferenceSearchCriteria() {
        return userConferenceSearchCriteria;
    }

    public void setUserConferenceSearchCriteria(Set<ConferenceSearchCriteriaEntity> userConferenceSearchCriteria) {
        this.userConferenceSearchCriteria = userConferenceSearchCriteria;
    }
}
