package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.*;

public interface IComponent {

  /**
   * Eval an operation
   * @return Constant
   */
  IConstant eval();
}
