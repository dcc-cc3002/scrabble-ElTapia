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
   * Compares an object with a Times
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof Times){
      var o = (Times) obj;
      return o.getLeftOp().equals(this.leftOp) & o.getRightOp().equals(this.rightOp);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public Times(){
    super();
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
