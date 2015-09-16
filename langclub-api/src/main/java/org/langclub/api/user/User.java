package org.langclub.api.user;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FULL_NAME")
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "USER", fetch = FetchType.LAZY)
    private Set<UserLanguage> userLanguageSet = new HashSet<>();
}
