package cl.uchile.dcc.scrabble.model.Abstract;

import cl.uchile.dcc.scrabble.model.Interfaces.SType;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SString;

/**
 * Abstract class that encapsulates Scrabble number types.
 * Implements operations with Scrabble int and binary, and define common methods.
 */
public abstract class AbstractNumber extends AbstractType implements SType {
    /**
     * {@inheritDoc}
     * @param obj Object
     * @return Boolean
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * {@inheritDoc}
     * @return String
     */
    @Override
    public abstract String toString();

    /**
     * {@inheritDoc}
     * @return Scrabble string
     */
    @Override
    public abstract SString toSString();

    /**
     * Convert this Scrabble number to Scrabble float
     * @return Scrabble float
     */
    public abstract SFloat toSFloat();
}
