package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IComponent;

public abstract class AbstractOperation implements IComponent {
  protected IComponent leftOp;
  protected IComponent rightOp;

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public AbstractOperation(IComponent leftOp, IComponent rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
}
