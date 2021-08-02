package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * To Binary operation in composite pattern
 */
public class ToBinary extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToBinary(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a ToBinary
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof ToBinary){
      var o = (ToBinary) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public ToBinary(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantBinary();
  }


  /**
   * String representation of a component
   * @return String
   */
  @Override
  public String toString(){
    return "ToBinary( \n\t" + Op.toString() + "\n\t)";
  }
}
