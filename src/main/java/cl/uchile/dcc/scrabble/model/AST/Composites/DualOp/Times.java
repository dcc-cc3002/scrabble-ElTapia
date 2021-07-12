package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

public class Times extends AbstractDualOperation {

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Times(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return leftOp.eval().times(rightOp.eval());
  }
}
