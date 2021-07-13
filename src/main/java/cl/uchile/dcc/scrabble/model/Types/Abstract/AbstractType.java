package cl.uchile.dcc.scrabble.model.Types.Abstract;
import cl.uchile.dcc.scrabble.model.Types.Interfaces.SType;
import java.util.Objects;
/**
 * Abstract class that represents a scrabble type.
 */
public abstract class AbstractType implements SType{

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

}
