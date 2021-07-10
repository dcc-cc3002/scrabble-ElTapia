package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

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
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this.Op.eval().toConstantBool();
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep() {
    return "ToBool(" + Op.stringRep() + ")";
  }
}
