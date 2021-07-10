package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

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
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this.Op.eval().toConstantFloat();
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep() {
    return "ToFloat(" + Op.stringRep() + ")";
  }
}
