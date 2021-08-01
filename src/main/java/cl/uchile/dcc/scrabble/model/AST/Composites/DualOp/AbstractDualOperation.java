package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBinary;
import cl.uchile.dcc.scrabble.model.AST.Constants.NullConstant;
import cl.uchile.dcc.scrabble.model.AST.IComponent;

public abstract class AbstractDualOperation implements IComponent {
  protected IComponent leftOp = NullConstant.getInstance();
  protected IComponent rightOp = NullConstant.getInstance();

  /**
   * Constructor
   * @param leftOp IComponent
   * @param rightOp IComponent
   */
  public AbstractDualOperation(IComponent leftOp, IComponent rightOp){
    this.leftOp = leftOp;
    this.rightOp = rightOp;
  }

  /**
   * Get left operation
   * @return IComponent
   */
  protected IComponent getLeftOp(){
    return leftOp;
  }

  /**
   * Get right operation
   * @return IComponent
   */
  protected IComponent getRightOp(){
    return rightOp;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public AbstractDualOperation(){
  }

  /**
   * Set left operation node
   * @param component IComponent
   */
  protected void setLeftOp(IComponent component){
    this.leftOp = component;
  }

  /**
   * Set right operation node
   * @param component IComponent
   */
  protected void setRightOp(IComponent component){
    this.rightOp = component;
  }

  /**
   * Insert a Component
   * @param component IComponent
   */
  @Override
  public void insert(IComponent component){
    if (leftOp.equals(NullConstant.getInstance()))
      this.setLeftOp(component);
    else if (leftOp.hasNull())
      leftOp.insert(component);

    else if (rightOp.equals(NullConstant.getInstance()))
      this.setRightOp(component);
    else if (rightOp.hasNull())
      rightOp.insert(component);
  }

  /**
   * Function that check if some node has null nodes
   * @return boolean
   */
  @Override
  public boolean hasNull(){
    if(leftOp.equals(NullConstant.getInstance()) | rightOp.equals(NullConstant.getInstance()))
    return true;
    else return leftOp.hasNull() | rightOp.hasNull();
  }
}
