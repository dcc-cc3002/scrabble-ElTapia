package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.HashMap;
import java.util.Map;

/**
 * SString factory. It optimize use of memory.
 */
public class SStringFactory {
  private static final Map<String, SString> createdStrings = new HashMap<>();

  /**
   * Create a SString, checking if is in the dictionary
   * @param string String
   * @return SString
   */
  public static SString createSString(String string) {
    if(!createdStrings.containsKey(string)) {
      createdStrings.put(string, new SString(string));
    }
    return createdStrings.get(string);
  }

  /**
   * Check if SString has been created
   * @param sString SString
   * @return SString
   */
  public static SString checkSString(SString sString) {
    if(!createdStrings.containsKey(sString.toString())) {
      createdStrings.put(sString.toString(), sString);
    }
    return sString;
  }
}
