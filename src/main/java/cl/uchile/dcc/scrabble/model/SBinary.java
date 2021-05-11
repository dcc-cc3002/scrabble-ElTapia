package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBinary {
    private final String binary;

    public SBinary(String binary) {
        this.binary = binary;
    }

    @Override
    public int hashCode(){
        return Objects.hash(SBinary.class);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof SBinary){
            var o = (SBinary) obj;
            return o.binary.equals(this.binary);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.binary;
    }

}
