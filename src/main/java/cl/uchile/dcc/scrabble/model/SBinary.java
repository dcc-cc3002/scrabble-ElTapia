package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBinary extends abstractBaseNumber{
    private final String binary;

    public SBinary(String binary) {
        this.binary = binary;
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

    @Override
    public SString toSString() {
        return new SString(this.binary);
    }

    @Override
    public SFloat toSFloat(){
        return null;
    }

    @Override
    public SInt toSInt(){
        return null;
    }

    @Override
    public SBinary toSBinary() {
        return new SBinary(this.binary);
    }
}
