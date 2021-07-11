package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;

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
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().negateConstant();
  }
}
