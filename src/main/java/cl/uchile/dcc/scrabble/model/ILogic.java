package cl.uchile.dcc.scrabble.model;
/**
 * Define logic methods between Scrabble Boolean and binary
 */
public interface ILogic {
    /**
     * Negate Scrabble type
     * @return Scrabble type
     */
    ILogic negate();

    /**
     * Or logic operation with Scrabble bool
     * @param toOrSBool Scrabble Boolean
     * @return Scrabble type
     */
    ILogic orSBool(SBool toOrSBool);

    /**
     * And logic operation with Scrabble bool
     * @param toAndSBool Scrabble Boolean
     * @return Scrabble type
     */
    ILogic andSBool(SBool toAndSBool);

    /**
     * Or logic operation with Scrabble binary
     * @param toOrSBinary Scrabble Binary
     * @return Scrabble type
     */
    ILogic orSBinary(SBinary toOrSBinary);

    /**
     * And logic operation with Scrabble binary
     * @param toAndSBinary Scrabble Binary
     * @return Scrabble type
     */
    ILogic andSBinary(SBinary toAndSBinary);
}
