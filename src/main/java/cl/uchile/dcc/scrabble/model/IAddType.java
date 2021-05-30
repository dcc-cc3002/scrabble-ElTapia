package cl.uchile.dcc.scrabble.model;
/**
 * Define add with Scrabble Int and Binary
 */
public interface IAddType{
    /**
     * Sum a Scrabble int
     * @param toAddSInt Scrabble int
     * @return Scrabble type
     */
    IAddType addSInt(SInt toAddSInt);

    /**
     * Sum a Scrabble binary
     * @param toAddSBinary Scrabble binary
     * @return Scrabble type
     */
    IAddType addSBinary(SBinary toAddSBinary);
}
