package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SFloat;

/**
 * Define subtraction, multiplication and division with Scrabble float
 */
public interface IOpFloat extends SType {
    /**
     * Add a Scrabble Float
     * @param toAddSFloat Scrabble Float
     * @return Scrabble type
     */
    IOpFloat addSFloat(SFloat toAddSFloat);
    /**
     * Subtract a Scrabble float
     * @param toMinusSFloat Scrabble float
     * @return Scrabble float
     */
    IOpFloat minusSFloat(SFloat toMinusSFloat);

    /**
     * Multiply a Scrabble float
     * @param toTimesSFloat Scrabble float
     * @return Scrabble float
     */
    IOpFloat timesSFloat(SFloat toTimesSFloat);

    /**
     * Divide a Scrabble float
     * @param toDivideSFloat Scrabble float
     * @return Scrabble float
     */
    IOpFloat divideSFloat(SFloat toDivideSFloat);
}
