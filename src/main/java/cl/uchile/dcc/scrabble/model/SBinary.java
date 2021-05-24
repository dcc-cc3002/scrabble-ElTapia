package cl.uchile.dcc.scrabble.model;

//TODO: Implement operator add with int and binary
//TODO: Implement operator minus with int and binary
//TODO: Implement operator times with int and binary
//TODO: Implement operator divide with int and binary
//TODO: Implement toSInt method
//TODO: Implement toSFloat method

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
        for(char bit: this.binary.toCharArray()){
            if (bit != '0') {
                negateStrBinary = negateStrBinary + "0";
            } else {
                negateStrBinary = negateStrBinary + "1";
            }
        }
        return new SBinary(negateStrBinary);
    }

    @Override
    public SBinary orSBinary(SBinary toOrSBinary) {
        String outStringSBinary = "";
        for(int i = 0; i < this.binary.length(); i++){
            if (this.binary.charAt(i) != '0'|toOrSBinary.binary.charAt(i)!='0') {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary andSBinary(SBinary toAndSBinary) {
        String outStringSBinary = "";
        for(int i = 0; i < this.binary.length(); i++){
            if (this.binary.charAt(i) != '0' & toAndSBinary.binary.charAt(i)!='0') {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary orSBool(SBool toOrSBool) {
        String outStringSBinary = "";
        for(char bit: this.binary.toCharArray()){
            if (bit != '0'|toOrSBool.bool) {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public SBinary andSBool(SBool toAndSBool) {
        String outStringSBinary = "";
        for(char bit: this.binary.toCharArray()){
            if (bit != '0'&toAndSBool.bool) {
                outStringSBinary = outStringSBinary + "1";
            } else {
                outStringSBinary = outStringSBinary + "0";
            }
        }
        return new SBinary(outStringSBinary);
    }

    @Override
    public abstractType addSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType minusSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType timesSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType divideSInt(SInt toAddSInt) {
        return null;
    }

    @Override
    public abstractType addSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType minusSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType timesSBinary(SBinary toAddSBinary) {
        return null;
    }

    @Override
    public abstractType divideSBinary(SBinary toAddSBinary) {
        return null;
    }
}
