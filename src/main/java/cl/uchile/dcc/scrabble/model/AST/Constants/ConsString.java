package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.*;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.*;
import cl.uchile.dcc.scrabble.model.Types.*;

//TODO: Agregar factories para facilitar constructor

public class ConsString implements Constant, IOperation {
  private final SString consString;

  public ConsString(String string){
    consString = new SString(string);
  }

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
  public Constant addConsStr(Constant constant) {
    SString result = this.consString.addSString((SString) constant.getSType());
    return new ConsString(result.toString());
  }

  /**
   * Add a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsInt(Constant constant) {
    SString result = this.consString.addSInt((SInt) constant.getSType());
    return new ConsString(result.toString());
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsFloat(Constant constant) {
    SString result = this.consString.addSFloat((SFloat) constant.getSType());
    return new ConsString(result.toString());
  }

  /**
   * Add a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBinary(Constant constant) {
    SString result = this.consString.addSBinary((SBinary) constant.getSType());
    return new ConsString(result.toString());
  }

  /**
   * Add a Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBool(Constant constant) {
    SString result = this.consString.addSBool((SBool) constant.getSType());
    return new ConsString(result.toString());
  }
}
