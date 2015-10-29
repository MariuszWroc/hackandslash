package pl.mygames.hackandslash.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
/**
 * @author mczarny
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    public abstract Integer getId();

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final AbstractEntity abstractDocument = (AbstractEntity) object;
        if (this.getId() != abstractDocument.getId() && (this.getId() == null
                || !this.getId().equals(abstractDocument.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), getId());
    }
}
