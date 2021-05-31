package cl.uchile.dcc.scrabble.model;
/**
 * Scrabble float that encapsulates a Java double.
 * Contains proper methods and operations with other Scrabble types.
 */
public class SFloat extends AbstractNumber implements IOpFloat {
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
    protected double getDouble(){
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
     * {@inheritDoc}
     * @return Scrabble float
     */
    @Override
    public SFloat toSFloat() {
        return new SFloat(this.Float);
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
        return new SFloat(this.Float - toMinusSInt.getInt());
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
        return new SFloat(this.Float / toDivideSInt.getInt());
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
        return new SFloat(this.Float - toMinusSFloat.getDouble());
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
        return new SFloat(this.Float / toDivideSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toAddSBinary Scrabble binary
     * @return Scrabble float
     */
    @Override
    public SFloat addSBinary(SBinary toAddSBinary) {
        return this.addSInt(toAddSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble float
     */
    @Override
    public SFloat minusSBinary(SBinary toMinusSBinary) {
        return this.minusSInt(toMinusSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble float
     */
    @Override
    public SFloat timesSBinary(SBinary toTimesSBinary) {
        return this.timesSInt(toTimesSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble float
     */
    @Override
    public SFloat divideSBinary(SBinary toDivideSBinary) {
        return this.divideSInt(toDivideSBinary.toSInt());
    }
}
