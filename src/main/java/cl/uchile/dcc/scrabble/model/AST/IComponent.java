package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;

public interface IComponent {

  /**
   * Eval an operation
   * @return Constant
   */
  Constant eval();

  /**
   * String representation of an AST
   * @return String
   */
  String stringRep();
}
