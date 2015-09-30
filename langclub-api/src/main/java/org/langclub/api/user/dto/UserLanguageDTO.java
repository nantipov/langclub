package org.langclub.api.user.dto;

import org.langclub.api.language.Language;
import org.langclub.api.language.LanguageLevel;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */
public class UserLanguageDTO {

    private Language language;
    private LanguageLevel level;

    public UserLanguageDTO() {
    }

    public UserLanguageDTO(Language language, LanguageLevel level) {
        this.language = language;
        this.level = level;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLanguageDTO that = (UserLanguageDTO) o;

        if (language != that.language) return false;
        if (level != that.level) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = language.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }
}
