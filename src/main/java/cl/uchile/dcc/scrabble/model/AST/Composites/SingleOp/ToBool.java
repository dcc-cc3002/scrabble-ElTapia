package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;

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
  public IConstant eval() {
    return this.Op.eval().toConstantBool();
  }
}
