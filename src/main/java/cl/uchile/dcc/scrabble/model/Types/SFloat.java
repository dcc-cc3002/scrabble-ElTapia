package cl.uchile.dcc.scrabble.model.Types;

import cl.uchile.dcc.scrabble.model.Interfaces.IOpBinary;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractNumber;
import cl.uchile.dcc.scrabble.model.Interfaces.SNumber;

/**
 * Scrabble float that encapsulates a Java double.
 * Contains proper methods and operations with other Scrabble types.
 */
public class SFloat extends AbstractNumber{
    private final double Float;
    public SFloat(double Float){
        this.Float = Float;
    }

    /**
     * {@inheritDoc}
     * @param obj Object
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SFloat){
            var o = (SFloat) obj;
            return o.Float == this.Float;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return String
     */
    @Override
    public String toString(){
        return String.valueOf(this.Float);
    }

    /**
     * Get Java double that encapsulates
     * @return double
     */
    public double getDouble(){
        return this.Float;
    }

    /**
     * {@inheritDoc}
     * @return Scrabble string
     */
    @Override
    public SString toSString() {
        String doubleString = this.toString();
        return new SString(doubleString);
    }

    /**
     * Add this to a SString
     *
     * @param addend SString
     * @return SString
     */
    @Override
    public SString addToSString(SString addend) {
        return new SString(addend.toString() + this.Float);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble float
     */
    @Override
    public SFloat toSFloat() {
        return new SFloat(this.Float);
    }

    /**
     * Add operation
     * @param addend IOpFloat
     * @return IOpFloat
     */
    public SNumber add(SNumber addend){
        return addend.addSFloat(this);
    }

    /**
     * Minus operation
     * @param addend IOpFloat
     * @return IOpFloat
     */
    public SNumber minus(SNumber addend){
        return addend.minusSFloat(this);
    }

    /**
     * Times operation
     * @param addend IOpFloat
     * @return IOpFloat
     */
    public SNumber times(SNumber addend){
        return addend.timesSFloat(this);
    }

    /**
     * Divide operation
     * @param addend IOpFloat
     * @return IOpFloat
     */
    public SNumber divide(SNumber addend){
        return addend.divideSFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param toAddSInt Scrabble int
     * @return Scrabble float
     */
    @Override
    public SFloat addSInt(SInt toAddSInt) {
        return new SFloat(this.Float + toAddSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSInt Scrabble int
     * @return Scrabble float
     */
    @Override
    public SFloat minusSInt(SInt toMinusSInt) {
        return new SFloat(toMinusSInt.getInt() - this.Float);
    }

    /**
     * {@inheritDoc}
     * @param toTimesSInt Scrabble int
     * @return Scrabble float
     */
    @Override
    public SFloat timesSInt(SInt toTimesSInt) {
        return new SFloat(this.Float * toTimesSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSInt Scrabble int
     * @return Scrabble float
     */
    @Override
    public SFloat divideSInt(SInt toDivideSInt) {
        return new SFloat(toDivideSInt.getInt() / this.Float);
    }

    /**
     * {@inheritDoc}
     * @param toAddSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat addSFloat(SFloat toAddSFloat) {
        return new SFloat(this.Float + toAddSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat minusSFloat(SFloat toMinusSFloat) {
        return new SFloat(toMinusSFloat.getDouble() - this.Float);
    }

    /**
     * {@inheritDoc}
     * @param toTimesSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat timesSFloat(SFloat toTimesSFloat) {
        return new SFloat(this.Float * toTimesSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat divideSFloat(SFloat toDivideSFloat) {
        return new SFloat(toDivideSFloat.getDouble() / this.Float);
    }
}
