package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.SFloat;
import java.util.HashMap;
import java.util.Map;

/**
 * SFloat factory. It optimize use of memory.
 */
public class SFloatFactory {

  private static final Map<Double, SFloat> createdFloats = new HashMap<>();

  /**
   * Create a SFloat, checking if is in the dictionary
   * @param entryDouble double
   * @return SFloat
   */
  public static SFloat createSFloat(double entryDouble) {
    if(!createdFloats.containsKey(entryDouble)) {
      createdFloats.put(entryDouble, new SFloat(entryDouble));
    }
    return createdFloats.get(entryDouble);
  }

  /**
   * Check if SFloat has been created
   * @param sFloat SFloat
   * @return SFloat
   */
  public static SFloat checkSFloat(SFloat sFloat) {
    if(!createdFloats.containsKey(sFloat.getDouble())) {
      createdFloats.put(sFloat.getDouble(), sFloat);
    }
    return createdFloats.get(sFloat.getDouble());
  }

  /**
   * Clear the dictionary
   */
  public static void cleanFactory(){
    createdFloats.clear();
  }

  /**
   * Check if the dictionary is empty
   * @return boolean
   */
  public static boolean isEmpty(){
    return createdFloats.isEmpty();
  }
}
