package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;

public interface IComponent {

  /**
   * Eval an operation
   * @return Constant
   */
  IConstant eval();

  /**
   * String representation of an AST
   * @return String
   */
  String stringRep();
}
