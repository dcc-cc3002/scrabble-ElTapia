package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * To Float operation in composite pattern
 */
public class ToFloat extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToFloat(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a ToFloat
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof ToFloat){
      var o = (ToFloat) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public ToFloat(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantFloat();
  }
}
