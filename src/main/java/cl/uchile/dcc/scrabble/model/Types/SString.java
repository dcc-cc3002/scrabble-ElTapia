package cl.uchile.dcc.scrabble.model.Types;

import cl.uchile.dcc.scrabble.model.Interfaces.IOpSString;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractType;

/**
 * Scrabble string that encapsulates a Java string.
 * Contains proper methods and operations with other Scrabble types.
 */
public class SString extends AbstractType implements IOpSString {
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
     * {@inheritDoc}
     * @param toAddSString Scrabble string
     * @return Scrabble string
     */
    @Override
    public SString addSString(SString toAddSString) {
        return new SString(this.string + toAddSString.toString());
    }

    /**
     * {@inheritDoc}
     * @param toAddSFloat Scrabble float
     * @return Scrabble string
     */
    @Override
    public SString addSFloat(SFloat toAddSFloat) {
        return this.addSString(toAddSFloat.toSString());
    }

    /**
     * {@inheritDoc}
     * @param toAddSInt Scrabble int
     * @return Scrabble string
     */
    @Override
    public SString addSInt(SInt toAddSInt) {
        return this.addSString(toAddSInt.toSString());
    }

    /**
     * {@inheritDoc}
     * @param toAddSBinary Scrabble binary
     * @return Scrabble string
     */
    @Override
    public SString addSBinary(SBinary toAddSBinary) {
        return this.addSString(toAddSBinary.toSString());
    }

    /**
     * Sum a Scrabble bool
     * @param toAddSBool Scrabble bool
     * @return new Scrabble string
     */
    public SString addSBool(SBool toAddSBool) {
        return this.addSString(toAddSBool.toSString());
    }
}