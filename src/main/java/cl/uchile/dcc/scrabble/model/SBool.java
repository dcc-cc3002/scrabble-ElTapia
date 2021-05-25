package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBool implements ISString, ISBool{
    private final boolean bool;
    public SBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public int hashCode(){
        return Objects.hash(SBool.class);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof SBool){
            var o = (SBool) obj;
            return Objects.equals(o.bool, this.bool);
        }
        return false;
    }

    @Override
    public String toString(){
        return String.valueOf(this.bool);
    }

    public SString toSString() {
        String boolString = this.toString();
        return new SString(boolString);
    }

    public SBool toSBool() {
        return this;
    }
}
