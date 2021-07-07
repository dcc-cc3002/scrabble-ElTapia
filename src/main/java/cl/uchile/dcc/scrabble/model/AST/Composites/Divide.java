package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

public class Divide implements IOperation {
  private final IOperation leftOp;
  private final IOperation rightOp;

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Divide(IOperation leftOp, IOperation rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return rightOp.eval().divide(leftOp.eval());
  }

}
