package cl.uchile.dcc.scrabble.model.Abstract;
import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Objects;
/**
 * Abstract class that represents a scrabble type.
 */
public abstract class AbstractType {

    /**
     * Get hashcode of type
     * @return int
     */
    @Override
    public int hashCode(){
        return Objects.hash(AbstractType.class);
    }

    /**
     * Compare Scrabble type and content with entry object
     * @param obj Object
     * @return Boolean
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Convert Scrabble type to Java String
     * @return String
     */
    @Override
    public abstract String toString();

    /**
     * Convert Scrabble type to Scrabble String
     * @return Scrabble string
     */
    public abstract SString toSString();

}
