package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.*;
import cl.uchile.dcc.scrabble.model.Types.Interfaces.SType;
import java.util.Objects;

/**
 * Abstract class that contains generic methods for constants.
 */
public abstract class AbstractConstant implements IConstant {

  /**
   * Get hashcode of type
   * @return int
   */
  @Override
  public int hashCode(){
    return Objects.hash(AbstractConstant.class);
  }

  /**
   * Get SType that the constant encapsulate
   * @return AbstractType
   */
  public abstract SType getSType();
}
