package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

//TODO: Implement operator add with binary
//TODO: Implement operator minus with int, float and binary
//TODO: Implement operator times with int, float and binary
//TODO: Implement operator divide with int, float and binary


public class SFloat extends abstractNumber implements IOpFloat {
    protected final double Float;
    public SFloat(double Float){
        this.Float = Float;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SFloat){
            var o = (SFloat) obj;
            return Objects.equals(o.Float, this.Float);
        }
        return false;
    }

    @Override
    public String toString(){
        return String.valueOf(this.Float);
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
    public abstractType minusSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType timesSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType divideSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public SFloat addSFloat(SFloat toAddSFloat) {
        return new SFloat(this.Float + toAddSFloat.Float);
    }

    @Override
    public abstractType minusSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType timesFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType divideSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public SFloat addSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType minusSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType timesSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType divideSBinary(SBinary toAddSBinary) {
        return null;
    }
}
