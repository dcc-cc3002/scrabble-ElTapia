package cl.uchile.dcc.scrabble.model;
import java.util.Objects;
/**
 * Scrabble int that encapsulates a Java int.
 * Contains proper methods and operations with other Scrabble types,
 * in particular, some functions to transform from Java ints to binary strings
 */
public class SInt extends AbstractBaseNumber implements IOpFloat {
    private final int Int;
    public SInt(int Int){
        this.Int = Int;
    }

    /**
     * {@inheritDoc}
     * @param obj Object
     * @return Boolean
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SInt){
            var o = (SInt) obj;
            return Objects.equals(o.Int, this.Int);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return String
     */
    @Override
    public String toString(){
        return String.valueOf(this.Int);
    }

    /**
     * Get Java int that encapsulates
     * @return int
     */
    protected int getInt(){
        return this.Int;
    }

    /**
     * {@inheritDoc}
     * @return Scrabble string
     */
    @Override
    public SString toSString() {
        String intString = this.toString();
        return new SString(intString);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble float
     */
    @Override
    public SFloat toSFloat() {
        String stringSInt = this.toString();
        return new SFloat(Double.parseDouble(stringSInt));
    }

    /**
     * {@inheritDoc}
     * @return Scrabble int
     */
    @Override
    public SInt toSInt() {
        return new SInt(this.Int);
    }

    /**
     * {@inheritDoc}
     * @return Scrabble binary
     */
    @Override
    public SBinary toSBinary(){
        SBinary sIntBinary;
        int absInt = Math.abs(this.Int);

        sIntBinary = new SBinary(positiveIntToBinaryString(absInt));
        if(this.Int < 0){
            sIntBinary = sIntBinary.twosComplements();
        }
        return sIntBinary;
    }

    /**
     * Convert an int to binary string
     * @param positiveInt int
     * @return String
     */
    private static String positiveIntToBinaryString(int positiveInt) {
        StringBuilder stringBinary = new StringBuilder();
        while(positiveInt > 0){
            stringBinary.insert(0, positiveInt % 2);
            positiveInt /= 2;
        }
        if(stringBinary.toString().equals("")){
            return "0";
        }
        return "0" + stringBinary;
    }

    /**
     * {@inheritDoc}
     * @param toAddSInt Scrabble int
     * @return Scrabble int
     */
    @Override
    public SInt addSInt(SInt toAddSInt) {
        return new SInt(this.Int + toAddSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSInt Scrabble int
     * @return Scrabble int
     */
    @Override
    public SInt minusSInt(SInt toMinusSInt) {
        return new SInt(this.Int - toMinusSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toTimesSInt Scrabble int
     * @return Scrabble int
     */
    @Override
    public SInt timesSInt(SInt toTimesSInt) {
        return new SInt(this.Int * toTimesSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSInt Scrabble int
     * @return Scrabble int
     */
    @Override
    public SInt divideSInt(SInt toDivideSInt) {
        return new SInt(this.Int / toDivideSInt.getInt());
    }

    /**
     * {@inheritDoc}
     * @param toAddSFloat Scrabble Float
     * @return Scrabble float
     */
    @Override
    public SFloat addSFloat(SFloat toAddSFloat) {
        return new SFloat(this.Int + toAddSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat minusSFloat(SFloat toMinusSFloat) {
        return new SFloat(this.Int - toMinusSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toTimesSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat timesSFloat(SFloat toTimesSFloat) {
        return new SFloat(this.Int * toTimesSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSFloat Scrabble float
     * @return Scrabble float
     */
    @Override
    public SFloat divideSFloat(SFloat toDivideSFloat) {
        return new SFloat(this.Int / toDivideSFloat.getDouble());
    }

    /**
     * {@inheritDoc}
     * @param toAddSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SInt addSBinary(SBinary toAddSBinary) {
        return this.addSInt(toAddSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SInt minusSBinary(SBinary toMinusSBinary) {
        return this.minusSInt(toMinusSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SInt timesSBinary(SBinary toTimesSBinary) {
        return this.timesSInt(toTimesSBinary.toSInt());
    }

    /**
     * {@inheritDoc}
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SInt divideSBinary(SBinary toDivideSBinary) {
        return this.divideSInt(toDivideSBinary.toSInt());
    }
}
