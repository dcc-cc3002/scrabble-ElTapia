package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;

public abstract class AbstractSingleOperation implements IComponent {
  protected IComponent Op;

  /**
   * Constructor
   *
   * @param Op IComponent
   */
  public AbstractSingleOperation(IComponent Op) {
    this.Op = Op;

  }
}
