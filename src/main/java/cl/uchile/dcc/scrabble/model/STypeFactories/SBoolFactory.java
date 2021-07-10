package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.SBool;
import java.util.HashMap;
import java.util.Map;

/**
 * SBool factory. It optimize use of memory.
 */
public class SBoolFactory {
  private static final Map<Boolean, SBool> createdBools = new HashMap<>();

  /**
   * Create a SBool, checking if is in the dictionary
   * @param bool boolean
   * @return SBool
   */
  public static SBool createSBool(boolean bool) {
    if(!createdBools.containsKey(bool)) {
      createdBools.put(bool, new SBool(bool));
    }
    return createdBools.get(bool);
  }

  /**
   * Check if SBool has been created
   * @param sBool SBool
   * @return SBool
   */
  public static SBool checkSBool(SBool sBool) {
    if(!createdBools.containsKey(sBool.getBool())) {
      createdBools.put(sBool.getBool(), sBool);
    }
    return sBool;
  }
}
