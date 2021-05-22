package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SFloat extends abstractNumber{
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
}
