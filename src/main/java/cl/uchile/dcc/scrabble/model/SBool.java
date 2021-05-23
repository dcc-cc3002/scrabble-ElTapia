package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class SBool extends abstractType implements ILogic{
    protected final boolean bool;
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

    @Override
    public SBool negate() {
        return new SBool(!this.bool);
    }

    @Override
    public SBool orSBool(SBool toOrSBool) {
        return new SBool(this.bool | toOrSBool.bool);
    }

    @Override
    public SBool andSBool(SBool toAndSBool) {
        return new SBool(this.bool & toAndSBool.bool);
    }

    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        String outBinaryString = "";
        for(char c: toOrSBinary.binary.toCharArray()){
            if (c != '0'|this.bool) {
                outBinaryString = outBinaryString + "1";
            } else {
                outBinaryString = outBinaryString + "0";
            }
        }
        return new SBinary(outBinaryString);
    }

    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        String outBinaryString = "";
        for(char c: toAndSBinary.binary.toCharArray()){
            if (c != '0'&this.bool) {
                outBinaryString = outBinaryString + "1";
            } else {
                outBinaryString = outBinaryString + "0";
            }
        }
        return new SBinary(outBinaryString);
    }
}
