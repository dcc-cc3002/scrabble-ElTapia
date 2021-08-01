package cl.uchile.dcc.scrabble.model.AST;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.*;

public interface IComponent {

  /**
   * Eval an operation
   * @return Constant
   */
  IConstant eval();

  /**
   * Insert a Component
   * @param component IComponent
   */
  default void insert(IComponent component){}


  /**
   * Function that check if some node has null nodes
   * @return boolean
   */
  default boolean hasNull(){
    return false;
  }


  /**
   * Compares an object with a Component
   * @param obj Object
   * @return boolean
   */
  @Override
  boolean equals(Object obj);
}
