package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.SInt;
import java.util.HashMap;
import java.util.Map;

/**
 * SInt factory. It optimize use of memory.
 */
public class SIntFactory {
  private static final Map<Integer, SInt> createdInts = new HashMap<>();

  /**
   * Create a SInt, checking if is in the dictionary
   * @param Int int
   * @return SInt
   */
  public static SInt createSInt(int Int) {
    if(!createdInts.containsKey(Int)) {
      createdInts.put(Int, new SInt(Int));
    }
    return createdInts.get(Int);
  }

  /**
   * Check if SInt has been created.
   * @param sInt SInt
   * @return SInt
   */
  public static SInt checkSInt(SInt sInt) {
    if(!createdInts.containsKey(sInt.getInt())) {
      createdInts.put(sInt.getInt(), sInt);
    }
    return sInt;
  }
}
