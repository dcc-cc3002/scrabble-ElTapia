package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SBinary;

/**
 * Define subtraction, multiplication and division with Scrabble float
 */
public interface IOpBinary extends SNumber {
    /**
     * Add a Scrabble Binary
     * @param toAddSBinary Scrabble Binary
     * @return Scrabble type
     */
    IOpBinary addSBinary(SBinary toAddSBinary);
    /**
     * Subtract a Scrabble Binary
     * @param toMinusSBinary Scrabble Binary
     * @return Scrabble float
     */
    IOpBinary minusSBinary(SBinary toMinusSBinary);

    /**
     * Multiply a Scrabble Binary
     * @param toTimesSBinary Scrabble Binary
     * @return Scrabble float
     */
    IOpBinary timesSBinary(SBinary toTimesSBinary);

    /**
     * Divide a Scrabble Binary
     * @param toDivideSBinary Scrabble Binary
     * @return Scrabble float
     */
    IOpBinary divideSBinary(SBinary toDivideSBinary);
}
