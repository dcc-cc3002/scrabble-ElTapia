package cl.uchile.dcc.scrabble.model;


public class SString extends abstractType implements IOpSString {
    private final String string;
    public SString(String string) {
        this.string = string;
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

    @Override
    public SString toSString() {
        return new SString(this.string);
    }

    public SString addSString(SString toAddSString) {
        return new SString(this.string + toAddSString.toString());
    }

    public SString addSBool(SBool toAddSBool) {
        return this.addSString(toAddSBool.toSString());
    }

    public SString addSFloat(SFloat toAddSFloat) {
        return this.addSString(toAddSFloat.toSString());
    }

    public SString addSInt(SInt toAddSInt) {
        return this.addSString(toAddSInt.toSString());
    }

    public SString addSBinary(SBinary toAddSBinary) {
        return this.addSString(toAddSBinary.toSString());
    }
}