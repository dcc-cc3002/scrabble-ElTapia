package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SFloat;

/**
 * Define add operation with Scrabble Float
 */
public interface IAddSFloat extends IAddType{
    /**
     * Add a Scrabble Float
     * @param toAddSFloat Scrabble Float
     * @return Scrabble type
     */
    IAddSFloat addSFloat(SFloat toAddSFloat);
}
