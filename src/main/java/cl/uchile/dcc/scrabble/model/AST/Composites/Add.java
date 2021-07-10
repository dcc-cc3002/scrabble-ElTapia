package cl.uchile.dcc.scrabble.model.AST.Composites;

import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;

/**
 * Add operation in composite pattern
 */
public class Add extends AbstractOperation {

  /**
   * Constructor
   * @param leftOp IComponent
   * @param rightOp IComponent
   */
  public Add(IComponent leftOp, IComponent rightOp){
    super(leftOp, rightOp);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this.leftOp.eval().add(this.rightOp.eval());
  }

  /**
   * String representation of an AST
   * @return String
   */
  @Override
  public String stringRep() {
    return leftOp.stringRep() + " add " + rightOp.stringRep();
  }
}
