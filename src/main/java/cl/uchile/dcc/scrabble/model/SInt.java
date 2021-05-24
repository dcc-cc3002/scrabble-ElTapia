package cl.uchile.dcc.scrabble.model;
//TODO: Implement operator add with binary
//TODO: Implement operator minus with int, float and binary
//TODO: Implement operator times with int, float and binary
//TODO: Implement operator divide with int, float and binary
//TODO: Implement toSBinary method

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
        return null;
    }

    @Override
    public SInt addSInt(SInt toAddSInt) {
        return new SInt(this.Int + toAddSInt.Int);
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
        return new SFloat(this.Int + toAddSFloat.Float);
    }

    @Override
    public abstractType minusSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType timesSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType divideSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType addSBinary(SBinary toAddSBinary) {
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
