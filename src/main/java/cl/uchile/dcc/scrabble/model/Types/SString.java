package cl.uchile.dcc.scrabble.model.Types;

import cl.uchile.dcc.scrabble.model.Abstract.AbstractType;

/**
 * Scrabble string that encapsulates a Java string.
 * Contains proper methods and operations with other Scrabble types.
 */
public class SString extends AbstractType{
    private final String string;

    /**
     * Scrabble string constructor
     * @param string Java string
     */
    public SString(String string) {
        this.string = string;
    }

    /**
     * {@inheritDoc}
     * @param obj Object
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SString){
            var o = (SString) obj;
            return o.string.equals(this.string);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return String
     */
    @Override
    public String toString(){
        return this.string;
    }

    /**
     * {@inheritDoc}
     * @return Scrabble string
     */
    @Override
    public SString toSString() {
        return new SString(this.string);
    }

    /**
     * Add this SString
     * @param addend AbstractType
     * @return SString
     */
    public SString add(AbstractType addend){
        return addend.addToSString(this);
    }

    /**
     * {@inheritDoc}
     * @param toAddSString Scrabble string
     * @return Scrabble string
     */
    @Override
    public SString addToSString(SString toAddSString) {
        return new SString(toAddSString.toString() + this.string);
    }
}