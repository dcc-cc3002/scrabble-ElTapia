package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBool {
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
}
