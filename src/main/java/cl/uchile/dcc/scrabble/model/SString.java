package cl.uchile.dcc.scrabble.model;


public class SString extends abstractType{
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
}