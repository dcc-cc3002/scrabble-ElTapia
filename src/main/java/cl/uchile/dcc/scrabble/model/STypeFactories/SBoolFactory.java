package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.SBool;
import java.util.HashMap;
import java.util.Map;

/**
 * SBool factory. It optimize use of memory.
 */
public class SBoolFactory {
  private static final Map<Boolean, SBool> createdBooleans = new HashMap<>();

  /**
   * Create a SBool, checking if is in the dictionary
   * @param bool boolean
   * @return SBool
   */
  public static SBool createSBool(boolean bool) {
    if(!createdBooleans.containsKey(bool)) {
      createdBooleans.put(bool, new SBool(bool));
    }
    return createdBooleans.get(bool);
  }

  /**
   * Check if SBool has been created
   * @param sBool SBool
   * @return SBool
   */
  public static SBool checkSBool(SBool sBool) {
    if(!createdBooleans.containsKey(sBool.getBool())) {
      createdBooleans.put(sBool.getBool(), sBool);
    }
    return createdBooleans.get(sBool.getBool());
  }

  /**
   * Clear the dictionary
   */
  public static void cleanFactory(){
    createdBooleans.clear();
  }

  /**
   * Check if the dictionary is empty
   * @return boolean
   */
  public static boolean isEmpty(){
    return createdBooleans.isEmpty();
  }
}

