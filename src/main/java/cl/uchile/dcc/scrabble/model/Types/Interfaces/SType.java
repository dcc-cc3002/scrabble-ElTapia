package cl.uchile.dcc.scrabble.model.Types.Interfaces;

import cl.uchile.dcc.scrabble.model.Types.SString;

public interface SType {

  /**
   * Convert Scrabble type to Scrabble String
   * @return Scrabble string
   */
  SString toSString();

  /**
   * Add this to a SString
   * @param addend SString
   * @return SString
   */
  SString addToSString(SString addend);
}
