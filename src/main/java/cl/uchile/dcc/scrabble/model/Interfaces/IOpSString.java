package cl.uchile.dcc.scrabble.model.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SString;

/**
 * Define add with Scrabble string
 */
public interface IOpSString extends IAddSFloat{
    /**
     * Concatenate a Scrabble string
     * @param toAddSString Scrabble string
     * @return Scrabble string
     */
    IOpSString addSString(SString toAddSString);
}
