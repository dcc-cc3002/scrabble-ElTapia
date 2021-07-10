package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

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
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this.Op.eval().toConstantStr();
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep() {
    return "ToString(" + Op.stringRep() + ")";
  }
}
