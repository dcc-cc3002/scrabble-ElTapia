package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

/**
 * Add operation in composite pattern
 */
public class Add extends AbstractOperation {

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Add(IOperation leftOp, IOperation rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this.leftOp.eval().add(this.rightOp.eval());
  }
}
