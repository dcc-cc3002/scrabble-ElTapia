package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;

public interface IOperation {

  /**
   * Eval an operation
   * @return Constant
   */
  Constant eval();
}
