package cl.uchile.dcc.scrabble.model;

public abstract class abstractNumber extends abstractType implements IAddType{
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract SString toSString();

    public abstract SFloat toSFloat();
}
