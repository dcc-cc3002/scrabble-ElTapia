package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IOperation;

public abstract class AbstractOperation implements IOperation {
  protected IOperation leftOp;
  protected IOperation rightOp;

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public AbstractOperation(IOperation leftOp, IOperation rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
}
