package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public abstract class abstractType {

    @Override
    public int hashCode(){
        return Objects.hash(abstractType.class);
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    public abstract SString toSString();

}
