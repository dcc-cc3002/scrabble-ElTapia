package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SInt extends abstractBaseNumber{
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
}
