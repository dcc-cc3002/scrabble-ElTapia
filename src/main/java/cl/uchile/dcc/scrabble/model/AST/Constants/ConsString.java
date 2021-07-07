package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.*;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;
import cl.uchile.dcc.scrabble.model.Abstract.AbstractType;
import cl.uchile.dcc.scrabble.model.Types.*;
import java.util.Objects;

//TODO: Agregar factories para facilitar constructor
//COMPLETE: Arreglar casteo a suma

/**
 * Constant String that represents a leaf of the AST. It wraps a Scrabble type.
 */
public class ConsString implements Constant, IOperation {
  private final SString consString;

  /**
   * Constructor
   * @param string String
   */
  public ConsString(String string){
    consString = new SString(string);
  }

  /**
   * Add this constant string to other constant.
   * @param otherCons Constant
   * @return Constant
   */
  @Override
  public Constant add(Constant otherCons){
    return otherCons.addConsStr(this);
  }

  /**
   * Get intern Scrabble string
   * @return SString
   */
  @Override
  public SString getSType() {
    return new SString(this.consString.toString());
  }

  /**
   * String representation of a constant
   * @return String
   */
  @Override
  public String toString(){
    return this.consString.toString();
  }

  /**
   * Get hashcode of type
   * @return int
   */
  @Override
  public int hashCode(){
    return Objects.hash(AbstractType.class);
  }

  /**
   * Compares an object with a constan
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ConsString){
      var o = (ConsString) obj;
      return o.getSType().equals(this.consString);
    }
    return false;
  }

  /**
   * Eval Operation.
   * @return Constant - Is a single type
   */
  @Override
  public Constant eval() {
    return this;
  }

  /**
   * Add a Constant string
   *
   * @param constant ConsString
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = constant.getSType().add(this.consString);
    return new ConsString(result.toString());
  }

}
