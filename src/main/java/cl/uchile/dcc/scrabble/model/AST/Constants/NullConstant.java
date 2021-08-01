package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.*;

/**
 * Null constant. It is used for invalid operations.
 */
public class NullConstant implements IConstant {
  private static IConstant instance;

  /**
   * Constructor. Is private due to singleton pattern.
   */
  private NullConstant() {
  }

  /**
   * Get a null constant
   * @return NullConstant
   */
  public static IConstant getInstance() {
    if (instance == null) {
      instance = new NullConstant();
    }
    return instance;
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return getInstance();
  }

  /**
   * String representation of a constant
   * @return String
   */
  public String toString(){
    return "";
  }
}
