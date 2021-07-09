package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

public class Or extends AbstractOperation{

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Or(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return leftOp.eval().or(rightOp.eval());
  }

}
