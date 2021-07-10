package cl.uchile.dcc.scrabble.model.STypeFactories;

import cl.uchile.dcc.scrabble.model.Types.*;
import java.util.HashMap;
import java.util.Map;

/**
 * SBinary factory. It optimize use of memory.
 */
public class SBinaryFactory {
  private static final Map<String, SBinary> createdBinaries = new HashMap<>();

  /**
   * Create a SBinary, checking if is in the dictionary
   * @param binary String
   * @return SBinary
   */
  public static SBinary createSBinary(String binary) {
    if(!createdBinaries.containsKey(binary)) {
      createdBinaries.put(binary, new SBinary(binary));
    }
    return createdBinaries.get(binary);
  }

  /**
   * Check if SBinary has been created
   * @param sBinary SBinary
   * @return SBinary
   */
  public static SBinary checkSBinary(SBinary sBinary) {
    if(!createdBinaries.containsKey(sBinary.toString())) {
      createdBinaries.put(sBinary.toString(), sBinary);
    }
    return sBinary;
  }
}
