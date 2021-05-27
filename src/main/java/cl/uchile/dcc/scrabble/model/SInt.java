package cl.uchile.dcc.scrabble.model;
//COMPLETE: Implement operator add with binary
//COMPLETE: Implement operator minus with int, float and binary
//COMPLETE: Implement operator times with int, float and binary
//COMPLETE: Implement operator divide with int, float and binary
//COMPLETE: Implement toSBinary method

import java.util.Objects;

public class SInt extends abstractBaseNumber implements IOpFloat {
    protected final int Int;
    public SInt(int Int){
        this.Int = Int;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof SInt){
            var o = (SInt) obj;
            return Objects.equals(o.Int, this.Int);
        }
        return false;
    }

    @Override
    public String toString(){
        return String.valueOf(this.Int);
    }

    protected int getInt(){
        return this.Int;
    }

    @Override
    public SString toSString() {
        String intString = this.toString();
        return new SString(intString);
    }

    @Override
    public SFloat toSFloat() {
        String stringSInt = this.toString();
        return new SFloat(Double.parseDouble(stringSInt));
    }

    @Override
    public SInt toSInt() {
        return new SInt(this.Int);
    }

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

    protected static String positiveIntToBinaryString(int positiveInt) {
        String stringBinary = "";
        while(positiveInt > 0){
            stringBinary = String.valueOf(positiveInt%2) + stringBinary;
            positiveInt /= 2;
        }
        if(stringBinary.equals("")){
            return "0";
        }
        return "0" + stringBinary;
    }

    @Override
    public SInt addSInt(SInt toAddSInt) {
        return new SInt(this.Int + toAddSInt.Int);
    }

    @Override
    public SInt minusSInt(SInt toMinusSInt) {
        return new SInt(this.Int - toMinusSInt.Int);
    }

    @Override
    public SInt timesSInt(SInt toTimesSInt) {
        return new SInt(this.Int * toTimesSInt.Int);
    }

    @Override
    public SInt divideSInt(SInt toDivideSInt) {
        return new SInt(this.Int / toDivideSInt.Int);
    }

    @Override
    public SFloat addSFloat(SFloat toAddSFloat) {
        return new SFloat(this.Int + toAddSFloat.Float);
    }

    @Override
    public SFloat minusSFloat(SFloat toMinusSFloat) {
        return new SFloat(this.Int - toMinusSFloat.Float);
    }

    @Override
    public SFloat timesSFloat(SFloat toTimesSFloat) {
        return new SFloat(this.Int * toTimesSFloat.Float);
    }

    @Override
    public SFloat divideSFloat(SFloat toDivideSFloat) {
        return new SFloat(this.Int / toDivideSFloat.Float);
    }

    @Override
    public SInt addSBinary(SBinary toAddSBinary) {
        return this.addSInt(toAddSBinary.toSInt());
    }

    @Override
    public SInt minusSBinary(SBinary toMinusSBinary) {
        return this.minusSInt(toMinusSBinary.toSInt());
    }

    @Override
    public SInt timesSBinary(SBinary toTimesSBinary) {
        return this.timesSInt(toTimesSBinary.toSInt());
    }

    @Override
    public SInt divideSBinary(SBinary toDivideSBinary) {
        return this.divideSInt(toDivideSBinary.toSInt());
    }
}
