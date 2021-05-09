package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class ScrblString {
    private final String string;
    public ScrblString(String string){
        this.string = string;
    }

    @Override
    public int hashCode(){
        return Objects.hash(ScrblString.class);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof ScrblString){
            var o = (ScrblString) obj;
            return o.string.equals(this.string);
        }
        return false;
    }
    @Override
    public String toString(){
        return "Java string{" + string + "}";
    }
}