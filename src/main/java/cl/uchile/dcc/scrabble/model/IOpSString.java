package cl.uchile.dcc.scrabble.model;
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
