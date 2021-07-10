package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

public class Divide extends AbstractDualOperation {

  /**
   * Constructor
   * @param leftOp IOperation
   * @param rightOp IOperation
   */
  public Divide(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return leftOp.eval().divide(rightOp.eval());
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep(){
    return leftOp.stringRep() + " divide " + rightOp.stringRep();
  }

}
