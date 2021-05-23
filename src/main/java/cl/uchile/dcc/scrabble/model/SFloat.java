package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

//TODO: Implement operator add with int, float and binary
//TODO: Implement operator minus with int, float and binary
//TODO: Implement operator times with int, float and binary
//TODO: Implement operator divide with int, float and binary


public class SFloat extends abstractNumber implements IAddFloat{
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
    public abstractType addSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType addSFloat(SFloat toAddSFloat) {
        return null;
    }

    @Override
    public abstractType addSBinary(SBinary toAddSBinary) {
        return null;
    }
}
