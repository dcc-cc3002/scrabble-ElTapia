package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import cl.uchile.dcc.scrabble.model.AST.Composites.DualOp.AbstractDualOperation;
import cl.uchile.dcc.scrabble.model.AST.Constants.NullConstant;
import cl.uchile.dcc.scrabble.model.AST.IComponent;

public abstract class AbstractSingleOperation implements IComponent {
  protected IComponent Op = NullConstant.getInstance();

  /**
   * Constructor
   *
   * @param Op IComponent
   */
  public AbstractSingleOperation(IComponent Op) {
    this.Op = Op;
  }

  /**
   * Get operation
   * @return IComponent
   */
  protected IComponent getOp(){
    return Op;
  }

  /**
   * Void constructor. Used to insert components.
   */
  public AbstractSingleOperation(){
  }

  /**
   * Set operation node
   * @param component IComponent
   */
  protected void setOp(IComponent component){
    this.Op = component;
  }

  /**
   * Insert a Component
   * @param component IComponent
   */
  @Override
  public void insert(IComponent component){
    if (Op.equals(NullConstant.getInstance()))
      this.setOp(component);
    else if (Op.hasNull())
      Op.insert(component);
  }


  /**
   * Function that check if some node has null nodes
   * @return boolean
   */
  @Override
  public boolean hasNull(){
    if(Op.equals(NullConstant.getInstance()))
      return true;
    else return Op.hasNull();
  }
}
