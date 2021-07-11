package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;

/**
 * Add operation in composite pattern
 */
public class Add extends AbstractDualOperation {

  /**
   * Constructor
   * @param leftOp IComponent
   * @param rightOp IComponent
   */
  public Add(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.leftOp.eval().add(this.rightOp.eval());
  }
}
