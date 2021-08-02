package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

public class Or extends AbstractDualOperation {

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Or(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }


  /**
   * Compares an object with an Or
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof Or){
      var o = (Or) obj;
      return o.getLeftOp().equals(this.leftOp) & o.getRightOp().equals(this.rightOp);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public Or(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return leftOp.eval().or(rightOp.eval());
  }


  /**
   * String representation of a component
   * @return String
   */
  @Override
  public String toString(){
    return "Or( \n\t" + leftOp.toString() + "\n\t" + rightOp.toString() + "\n\t)";
  }
}
