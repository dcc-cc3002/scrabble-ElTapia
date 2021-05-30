package cl.uchile.dcc.scrabble.model;
/**
 * Abstract class that encapsulates Scrabble int and Binary.
 * Define common methods in Scrabble Int and binary
 */
public abstract class AbstractBaseNumber extends AbstractNumber {
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
     * {@inheritDoc}
     * @return Scrabble float
     */
    @Override
    public abstract SFloat toSFloat();

    /**
     * Convert this Scrabble number to Scrabble int
     * @return Scrabble int
     */
    public abstract SInt toSInt();

    /**
     * Convert this Scrabble number to Scrabble binary
     * @return Scrabble binary
     */
    public abstract SBinary toSBinary();
}
