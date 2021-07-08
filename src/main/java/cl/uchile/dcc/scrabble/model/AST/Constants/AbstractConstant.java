package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import java.util.Objects;

/**
 * Abstract class that contains generic methods for constants.
 */
public abstract class AbstractConstant implements Constant{

  /**
   * Get hashcode of type
   * @return int
   */
  @Override
  public int hashCode(){
    return Objects.hash(AbstractConstant.class);
  }

  /**
   * Compares an object with a constan
   * @param obj Object
   * @return boolean
   */
  @Override
  public abstract boolean equals(Object obj);

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this;
  }

  /**
   * String representation of a constant
   * @return String
   */
  @Override
  public abstract String toString();

}
