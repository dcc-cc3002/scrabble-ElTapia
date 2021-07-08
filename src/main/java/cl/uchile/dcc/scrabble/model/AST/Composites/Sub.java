package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

public class Sub extends AbstractOperation{


  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Sub(IOperation leftOp, IOperation rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return rightOp.eval().sub(leftOp.eval());
  }
}
