package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SInt;

/**
 * Define subtraction, multiplication and division with Scrabble int and binary
 */
public interface IOpType extends IAddType{
    /**
     * Subtract a Scrabble int
     * @param toMinusSInt Scrabble int
     * @return Scrabble type
     */
    IOpType minusSInt(SInt toMinusSInt);

    /**
     * Multiply a Scrabble int
     * @param toTimesSInt Scrabble int
     * @return Scrabble type
     */
    IOpType timesSInt(SInt toTimesSInt);

    /**
     * Divide a Scrabble int
     * @param toDivideSInt Scrabble int
     * @return Scrabble type
     */
    IOpType divideSInt(SInt toDivideSInt);

    /**
     * Subtract a Scrabble binary
     * @param toMinusSBinary Scrabble binary
     * @return Scrabble type
     */
    IOpType minusSBinary(SBinary toMinusSBinary);

    /**
     * Multiply a Scrabble binary
     * @param toTimesSBinary Scrabble binary
     * @return Scrabble type
     */
    IOpType timesSBinary(SBinary toTimesSBinary);

    /**
     * Divide a Scrabble binary
     * @param toDivideSBinary Scrabble binary
     * @return Scrabble type
     */
    IOpType divideSBinary(SBinary toDivideSBinary);
}
