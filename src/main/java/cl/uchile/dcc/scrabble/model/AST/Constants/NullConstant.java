package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;

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
   * Compares an object with a constan
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    return obj instanceof NullConstant;
  }

  /**
   * String representation of a constant
   * @return String
   */
  public String toString(){
    return "null";
  }

  /**
   * String representation of an AST
   *
   * @return String
   */
  @Override
  public String stringRep() {
    return this.toString();
  }
}
