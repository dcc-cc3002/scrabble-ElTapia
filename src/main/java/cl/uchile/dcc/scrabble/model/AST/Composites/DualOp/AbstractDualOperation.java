package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;

public abstract class AbstractDualOperation implements IComponent {
  protected IComponent leftOp;
  protected IComponent rightOp;

  /**
   * Constructor
   * @param leftOp IComponent
   * @param rightOp IComponent
   */
  public AbstractDualOperation(IComponent leftOp, IComponent rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }
}
