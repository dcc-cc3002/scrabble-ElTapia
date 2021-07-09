package cl.uchile.dcc.scrabble.model.Types;
import cl.uchile.dcc.scrabble.model.Interfaces.IOpBinary;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractBaseNumber;
import cl.uchile.dcc.scrabble.model.Interfaces.SNumber;
import java.util.Objects;
/**
 * Scrabble int that encapsulates a Java int.
 * Contains proper methods and operations with other Scrabble types,
 * in particular, some functions to transform from Java ints to binary strings
 */
public class SInt extends AbstractBaseNumber implements IOpBinary {
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
    public int getInt(){
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
     * Add this to a SString
     *
     * @param addend SString
     * @return SString
     */
    @Override
    public SString addToSString(SString addend) {
        return new SString(addend.toString() + this.Int);
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
     * Add operation
     * @param addend IOpFloat
     * @return IOpFloat
     */
    public SNumber add(SNumber addend){
        return addend.addSInt(this);
    }

    /**
     * Minus operation
     * @param addend SType
     * @return SType
     */
    public SNumber minus(SNumber addend){
        return addend.minusSInt(this);
    }

    /**
     * Times operation
     * @param addend SType
     * @return SType
     */
    public SNumber times(SNumber addend){
        return addend.timesSInt(this);
    }

    /**
     * Divide operation
     * @param addend SType
     * @return SType
     */
    public SNumber divide(SNumber addend){
        return addend.divideSInt(this);
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
        return new SInt(toMinusSInt.getInt() - this.Int);
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
        return new SInt(toDivideSInt.getInt() / this.Int);
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
        return new SFloat(toMinusSFloat.getDouble() - this.Int);
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
        return new SFloat(toDivideSFloat.getDouble() / this.Int);
    }

    /**
     * {@inheritDoc}
     * @param toAddSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SBinary addSBinary(SBinary toAddSBinary) {
        SInt toAddSInt = toAddSBinary.toSInt();
        SInt result = this.addSInt(toAddSInt);
        return result.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SBinary minusSBinary(SBinary toMinusSBinary) {
        SInt toMinusSInt = toMinusSBinary.toSInt();
        SInt result = this.minusSInt(toMinusSInt);
        return result.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SBinary timesSBinary(SBinary toTimesSBinary) {
        SInt toTimesSInt = toTimesSBinary.toSInt();
        SInt result = this.timesSInt(toTimesSInt);
        return result.toSBinary();
    }

    /**
     * {@inheritDoc}
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble int
     */
    @Override
    public SBinary divideSBinary(SBinary toDivideSBinary) {
        SInt toDivideSInt = toDivideSBinary.toSInt();
        SInt result = this.divideSInt(toDivideSInt);
        return result.toSBinary();
    }
}
