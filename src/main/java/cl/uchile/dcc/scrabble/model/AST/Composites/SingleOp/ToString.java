package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * To String operation in composite pattern
 */
public class ToString extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToString(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a ToString
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof ToString){
      var o = (ToString) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public ToString(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantStr();
  }
}
