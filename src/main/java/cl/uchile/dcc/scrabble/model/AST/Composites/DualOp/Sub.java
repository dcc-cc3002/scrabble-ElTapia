package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

public class Sub extends AbstractDualOperation {


  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Sub(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }


  /**
   * Compares an object with a Sub
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof Sub){
      var o = (Sub) obj;
      return o.getLeftOp().equals(this.leftOp) & o.getRightOp().equals(this.rightOp);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public Sub(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return leftOp.eval().sub(rightOp.eval());
  }
}
