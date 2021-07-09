package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SInt;

/**
 * Define subtraction, multiplication and division with Scrabble int and binary
 */
public interface SNumber {

    /**
     * Sum a Scrabble int
     * @param toAddSInt Scrabble int
     * @return Scrabble type
     */
    SNumber addSInt(SInt toAddSInt);

    /**
     * Subtract a Scrabble int
     * @param toMinusSInt Scrabble int
     * @return Scrabble type
     */
    SNumber minusSInt(SInt toMinusSInt);

    /**
     * Multiply a Scrabble int
     * @param toTimesSInt Scrabble int
     * @return Scrabble type
     */
    SNumber timesSInt(SInt toTimesSInt);

    /**
     * Divide a Scrabble int
     * @param toDivideSInt Scrabble int
     * @return Scrabble type
     */
    SNumber divideSInt(SInt toDivideSInt);

    /**
     * Sum a Scrabble Float
     * @param toAddSFloat Scrabble Float
     * @return Scrabble type
     */
    SNumber addSFloat(SFloat toAddSFloat);

    /**
     * Subtract a Scrabble Float
     * @param toMinusSFloat Scrabble Float
     * @return Scrabble type
     */
    SNumber minusSFloat(SFloat toMinusSFloat);

    /**
     * Multiply a Scrabble Float
     * @param toTimesSFloat Scrabble Float
     * @return Scrabble type
     */
    SNumber timesSFloat(SFloat toTimesSFloat);

    /**
     * Divide a Scrabble Float
     * @param toDivideSFloat Scrabble Float
     * @return Scrabble type
     */
    SNumber divideSFloat(SFloat toDivideSFloat);

}
