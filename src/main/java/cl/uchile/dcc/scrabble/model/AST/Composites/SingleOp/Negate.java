package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;

/**
 * Negate operation in composite pattern
 */
public class Negate extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public Negate(IComponent Op){
    super(Op);
  }

  /**
   * Compares an object with a Negate
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (obj instanceof Negate){
      var o = (Negate) obj;
      return o.getOp().equals(this.Op);
    }
    return false;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public Negate(){
    super();
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().negateConstant();
  }


  /**
   * String representation of a component
   * @return String
   */
  @Override
  public String toString(){
    return "Negate( \n\t" + Op.toString() + "\n\t)";
  }

}
