package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SInt;

/**
 * Define subtraction, multiplication and division with Scrabble int and binary
 */
public interface SType {
    /**
     * Subtract a Scrabble int
     * @param toMinusSInt Scrabble int
     * @return Scrabble type
     */
    SType minusSInt(SInt toMinusSInt);

    /**
     * Multiply a Scrabble int
     * @param toTimesSInt Scrabble int
     * @return Scrabble type
     */
    SType timesSInt(SInt toTimesSInt);

    /**
     * Divide a Scrabble int
     * @param toDivideSInt Scrabble int
     * @return Scrabble type
     */
    SType divideSInt(SInt toDivideSInt);

    /**
     * Subtract a Scrabble binary
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble type
     */
    SType minusSBinary(SBinary toMinusSBinary);

    /**
     * Multiply a Scrabble binary
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble type
     */
    SType timesSBinary(SBinary toTimesSBinary);

    /**
     * Divide a Scrabble binary
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble type
     */
    SType divideSBinary(SBinary toDivideSBinary);

    /**
     * Sum a Scrabble int
     * @param toAddSInt Scrabble int
     * @return Scrabble type
     */
    SType addSInt(SInt toAddSInt);

    /**
     * Sum a Scrabble binary
     * @param toAddSBinary Scrabble binary
     * @return Scrabble type
     */
    SType addSBinary(SBinary toAddSBinary);
}
