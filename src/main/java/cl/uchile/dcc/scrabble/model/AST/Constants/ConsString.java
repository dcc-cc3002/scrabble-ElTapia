package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;
import cl.uchile.dcc.scrabble.model.STypeFactories.SStringFactory;
import cl.uchile.dcc.scrabble.model.Types.*;

//TODO: Agregar factories para facilitar constructor
//COMPLETE: Arreglar casteo a suma

/**
 * Constant String that represents a leaf of the AST. It wraps a Scrabble type.
 */
public class ConsString extends AbstractConstant {
  private final SString consString;

  /**
   * Constructor with native java
   * @param string String
   */
  public ConsString(String string){
    consString = SStringFactory.createSString(string);
  }

  /**
   * Constructor with SType
   * @param sString String
   */
  public ConsString(SString sString){
    consString = SStringFactory.checkSString(sString);
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
   * Add a Constant string
   *
   * @param constant ConsString
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = this.consString.addToSString(constant.getSType());
    return new ConsString(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantStr() {
    SString result = this.consString.toSString();
    return new ConsString(result);
  }

  /**
   * String representation of an AST
   *
   * @return String
   */
  @Override
  public String stringRep() {
    return "String(" + this.toString() + ")\n";
  }

}
