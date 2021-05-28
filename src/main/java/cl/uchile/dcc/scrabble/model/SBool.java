package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBool extends abstractType implements ILogic{
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

    protected boolean getBool(){
        return this.bool;
    }

    public SBool toSBool() {
        return new SBool(this.bool);
    }

    @Override
    public SBool negate() {
        return new SBool(!this.bool);
    }

    @Override
    public SBool orSBool(SBool toOrSBool) {
        return new SBool(this.bool | toOrSBool.getBool());
    }

    @Override
    public SBool andSBool(SBool toAndSBool) {
        return new SBool(this.bool & toAndSBool.getBool());
    }

    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        StringBuilder outBinaryString = new StringBuilder();
        for(char c: toOrSBinary.toString().toCharArray()){
            if (c != '0'|this.bool) {
                outBinaryString.append("1");
            } else {
                outBinaryString.append("0");
            }
        }
        return new SBinary(outBinaryString.toString());
    }

    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        StringBuilder outBinaryString = new StringBuilder();
        for(char c: toAndSBinary.toString().toCharArray()){
            if (c != '0'&this.bool) {
                outBinaryString.append("1");
            } else {
                outBinaryString.append("0");
            }
        }
        return new SBinary(outBinaryString.toString());
    }
}
