package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBinary extends abstractBaseNumber implements ILogic{
    protected final String binary;

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

    @Override
    public SBinary negate() {
        String negateStrBinary = "";
        for(char c: this.binary.toCharArray()){
            if (c != '0') {
                negateStrBinary = negateStrBinary + "0";
            } else {
                negateStrBinary = negateStrBinary + "1";
            }
        }
        return new SBinary(negateStrBinary);
    }

    @Override
    public SBool orSBool(SBool toOrSBool) {
        return null;
    }

    @Override
    public SBool andSBool(SBool toAndSBool) {
        return null;
    }

    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        return null;
    }

    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        return null;
    }
}
