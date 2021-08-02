package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

public class And extends AbstractDualOperation {

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public And(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Compares an object with an And
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof And){
      var o = (And) obj;
      return o.getLeftOp().equals(this.leftOp) & o.getRightOp().equals(this.rightOp);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public And(){
    super();
  }


  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return leftOp.eval().and(rightOp.eval());
  }

  /**
   * String representation of a component
   * @return String
   */
  @Override
  public String toString(){
    return "And( \n\t" + leftOp.toString() + "\n\t" + rightOp.toString() + "\n\t)";
  }

}
