package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBool extends abstractType{
    private final boolean bool;
    public SBool(boolean bool) {
        this.bool = bool;
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

    @Override
    public SString toSString() {
        String boolString = this.toString();
        return new SString(boolString);
    }

    public SBool toSBool() {
        return new SBool(this.bool);
    }

    public SBool negation() {
        return new SBool(!this.bool);
    }

    public SBool orSBool(SBool toOrSBool) {
        return new SBool(this.bool | toOrSBool.bool);
    }

    public SBool andSBool(SBool toAndSBool) {
        return new SBool(this.bool & toAndSBool.bool);
    }
}
