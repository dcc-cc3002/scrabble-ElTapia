package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SInt implements ISString{
    private final int Int;
    public SInt(int Int){
        this.Int = Int;
    }

    @Override
    public int hashCode(){
        return Objects.hash(SInt.class);
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

    public SString toSString() {
        String intString = this.toString();
        return new SString(intString);
    }
}
