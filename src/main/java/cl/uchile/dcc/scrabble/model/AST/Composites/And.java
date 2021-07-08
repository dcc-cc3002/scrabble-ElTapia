package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

public class And extends AbstractOperation{

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public And(IOperation leftOp, IOperation rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return rightOp.eval().and(leftOp.eval());
  }

}
