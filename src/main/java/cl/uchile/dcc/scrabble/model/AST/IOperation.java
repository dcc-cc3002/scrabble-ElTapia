package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;

public interface IOperation {
  Constant eval();
}
