package org.langclub.api.user;

import org.langclub.api.language.Language;
import org.langclub.api.language.LanguageLevel;

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
@Table(name = "USER_LANGUAGE")
public class UserLanguage {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "USER")
    @ManyToOne
    @JoinColumn(name = "ID", nullable = false)
    private User user;

    @Column(name = "LANGUAGE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "LANGUAGE_LEVEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageLevel languageLevel;
}
