package cl.uchile.dcc.scrabble.model;

//COMPLETE: Possibly implements methods that are in interface
//TODO: ADD DOCUMENTATION

public abstract class abstractNumber extends abstractType implements IOpType {
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract SString toSString();

    public abstract SFloat toSFloat();
}
