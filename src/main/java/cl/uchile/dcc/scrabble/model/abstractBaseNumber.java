package cl.uchile.dcc.scrabble.model;

public abstract class abstractBaseNumber extends abstractNumber{
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract SString toSString();

    @Override
    public abstract SFloat toSFloat();

    public abstract SInt toSInt();

    public abstract SBinary toSBinary();
}
