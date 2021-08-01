package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * To Int operation in composite pattern
 */
public class ToInt extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToInt(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a ToInt
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof ToInt){
      var o = (ToInt) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public ToInt(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantInt();
  }
}
