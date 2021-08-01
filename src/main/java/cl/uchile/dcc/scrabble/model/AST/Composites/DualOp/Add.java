package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

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
   * Compares an object with an Add
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof Add){
      var o = (Add) obj;
      return o.getLeftOp().equals(this.leftOp) & o.getRightOp().equals(this.rightOp);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public Add(){
    super();
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
