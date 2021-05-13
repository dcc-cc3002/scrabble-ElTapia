package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SFloat implements ISString, ISFloat{
    private final double Float;
    public SFloat(double Float){
        this.Float = Float;
    }

    @Override
    public int hashCode() {
        return Objects.hash(SFloat.class);
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

    public SString toSString() {
        String doubleString = this.toString();
        return new SString(doubleString);
    }

    public SFloat toSFloat() {
        return this;
    }
}
