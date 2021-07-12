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
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantBinary();
  }
}
