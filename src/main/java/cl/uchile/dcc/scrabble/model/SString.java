package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SString implements ISString{
    private final String string;
    public SString(String string) {
        this.string = string;
    }

    @Override
    public int hashCode(){
        return Objects.hash(SString.class);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof SString){
            var o = (SString) obj;
            return o.string.equals(this.string);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.string;
    }

    public SString toSString() {
        return this;
    }
}