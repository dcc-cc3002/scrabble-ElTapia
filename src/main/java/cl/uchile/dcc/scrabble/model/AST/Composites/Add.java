package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

/**
 * Add operation in composite pattern
 */
public class Add implements IOperation {

  private final IOperation leftOp;
  private final IOperation rightOp;

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Add(IOperation leftOp, IOperation rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }

  /**
   * Eval operation between the to sub-trees
   * @return Constant
   */
  @Override
  public Constant eval() {
    return rightOp.eval().add(leftOp.eval());
  }
}
