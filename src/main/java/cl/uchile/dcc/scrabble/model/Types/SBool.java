package cl.uchile.dcc.scrabble.model.Types;
import cl.uchile.dcc.scrabble.model.Interfaces.ILogic;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractType;
import java.util.Objects;
/**
 * Scrabble bool that encapsulates a Java Boolean.
 * Contains proper methods and operations with other Scrabble types.
 */
public class SBool extends AbstractType implements ILogic {
    private final boolean bool;

    /**
     * Scrabble bool constructor
     * @param bool Boolean
     */
    public SBool(boolean bool) {
        this.bool = bool;
    }

    /**
     * {@inheritDoc}
     * @param obj Object
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SBool){
            var o = (SBool) obj;
            return Objects.equals(o.bool, this.bool);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return string
     */
    @Override
    public String toString(){
        return String.valueOf(this.bool);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble string
     */
    @Override
    public SString toSString() {
        String boolString = this.toString();
        return new SString(boolString);
    }

    /**
     * Get Java bool that encapsulates
     * @return Boolean
     */
    public boolean getBool(){
        return this.bool;
    }

    /**
     * Convert this to Scrabble bool
     * @return Scrabble bool
     */
    public SBool toSBool() {
        return new SBool(this.bool);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble bool
     */
    @Override
    public SBool negate() {
        return new SBool(!this.bool);
    }

    /**
     * {@inheritDoc}
     * @param toOrSBool Scrabble bool
     * @return Scrabble bool
     */
    @Override
    public SBool orSBool(SBool toOrSBool) {
        return new SBool(this.bool | toOrSBool.getBool());
    }

    /**
     * {@inheritDoc}
     * @param toAndSBool Scrabble bool
     * @return Scrabble bool
     */
    @Override
    public SBool andSBool(SBool toAndSBool) {
        return new SBool(this.bool & toAndSBool.getBool());
    }

    /**
     * {@inheritDoc}
     * @param toOrSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        StringBuilder outBinaryString = new StringBuilder();
        for(char c: toOrSBinary.toString().toCharArray()){
            if (c != '0'|this.bool) {
                outBinaryString.append("1");
            } else {
                outBinaryString.append("0");
            }
        }
        return new SBinary(outBinaryString.toString());
    }

    /**
     * {@inheritDoc}
     * @param toAndSBinary Scrabble binary
     * @return Scrabble binary
     */
    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        StringBuilder outBinaryString = new StringBuilder();
        for(char c: toAndSBinary.toString().toCharArray()){
            if (c != '0'&this.bool) {
                outBinaryString.append("1");
            } else {
                outBinaryString.append("0");
            }
        }
        return new SBinary(outBinaryString.toString());
    }
}
