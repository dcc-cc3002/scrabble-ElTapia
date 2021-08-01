package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * To Bool operation in composite pattern
 */
public class ToBool extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToBool(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a ToBool
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof ToBool){
      var o = (ToBool) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public ToBool(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantBool();
  }
}
