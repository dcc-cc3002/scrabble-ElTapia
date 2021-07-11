package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;

/**
 * To Int operation in composite pattern
 */
public class ToInt extends AbstractSingleOperation {

  /**
   * Constructor
   * @param Op IComponent
   */
  public ToInt(IComponent Op){
    super(Op);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return this.Op.eval().toConstantInt();
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep() {
    return "ToInt(" + Op.stringRep() + ")";
  }
}
