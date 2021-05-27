package cl.uchile.dcc.scrabble.model;

//COMPLETE: Implement operator add with binary
//COMPLETE: Implement operator minus with binary
//COMPLETE: Implement operator times with binary
//COMPLETE: Implement operator divide with binary
//COMPLETE: Fix equals


public class SFloat extends abstractNumber implements IOpFloat {
    protected final double Float;
    public SFloat(double Float){
        this.Float = Float;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SFloat){
            var o = (SFloat) obj;
            return o.Float == this.Float;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.valueOf(this.Float);
    }

    protected double getDouble(){
        return this.Float;
    }

    @Override
    public SString toSString() {
        String doubleString = this.toString();
        return new SString(doubleString);
    }

    @Override
    public SFloat toSFloat() {
        return new SFloat(this.Float);
    }

    @Override
    public SFloat addSInt(SInt toAddSInt) {
        return new SFloat(this.Float + toAddSInt.Int);
    }

    @Override
    public SFloat minusSInt(SInt toMinusSInt) {
        return new SFloat(this.Float - toMinusSInt.Int);
    }

    @Override
    public SFloat timesSInt(SInt toTimesSInt) {
        return new SFloat(this.Float * toTimesSInt.Int);
    }

    @Override
    public SFloat divideSInt(SInt toDivideSInt) {
        return new SFloat(this.Float / toDivideSInt.Int);
    }

    @Override
    public SFloat addSFloat(SFloat toAddSFloat) {
        return new SFloat(this.Float + toAddSFloat.Float);
    }

    @Override
    public SFloat minusSFloat(SFloat toMinusSFloat) {
        return new SFloat(this.Float - toMinusSFloat.Float);
    }

    @Override
    public SFloat timesSFloat(SFloat toTimesSFloat) {
        return new SFloat(this.Float * toTimesSFloat.Float);
    }

    @Override
    public SFloat divideSFloat(SFloat toDivideSFloat) {
        return new SFloat(this.Float / toDivideSFloat.Float);
    }

    @Override
    public SFloat addSBinary(SBinary toAddSBinary) {
        return this.addSInt(toAddSBinary.toSInt());
    }

    @Override
    public SFloat minusSBinary(SBinary toMinusSBinary) {
        return this.minusSInt(toMinusSBinary.toSInt());
    }

    @Override
    public SFloat timesSBinary(SBinary toTimesSBinary) {
        return this.timesSInt(toTimesSBinary.toSInt());
    }

    @Override
    public SFloat divideSBinary(SBinary toDivideSBinary) {
        return this.divideSInt(toDivideSBinary.toSInt());
    }
}
