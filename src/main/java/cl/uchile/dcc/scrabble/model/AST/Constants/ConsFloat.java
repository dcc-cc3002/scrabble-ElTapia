package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SFloat;

public class ConsFloat extends AbstractConstant{
  private final SFloat consFloat;

  /**
   * Constructor
   * @param Float double
   */
  public ConsFloat(double Float){
    consFloat = new SFloat(Float);
  }

  /**
   * Compares an object with a constan
   *
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ConsFloat){
      var o = (ConsFloat) obj;
      return o.getSType().equals(this.consFloat);
    }
    return false;
  }

  /**
   * String representation of a constant
   *
   * @return String
   */
  @Override
  public String toString() {
    return this.consFloat.toString();
  }

  /**
   * Get SType that the constant encapsulate
   *
   * @return AbstractType
   */
  @Override
  public SFloat getSType() {
    return new SFloat(this.consFloat.getDouble());
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant add(Constant constant) {
    return null;
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    return null;
  }

  /**
   * Add a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsInt(Constant constant) {
    return null;
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsFloat(Constant constant) {
    return null;
  }

  /**
   * Add a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBinary(Constant constant) {
    return null;
  }

  /**
   * Add a Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBool(Constant constant) {
    return null;
  }

  /**
   * Subtract a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsStr(Constant constant) {
    return null;
  }

  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsInt(Constant constant) {
    return null;
  }

  /**
   * Subtract a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsFloat(Constant constant) {
    return null;
  }

  /**
   * Subtract a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsBinary(Constant constant) {
    return null;
  }

  /**
   * Subtract a Scrabble Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsBool(Constant constant) {
    return null;
  }

  /**
   * Multiply a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsStr(Constant constant) {
    return null;
  }

  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsInt(Constant constant) {
    return null;
  }

  /**
   * Multiply a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsFloat(Constant constant) {
    return null;
  }

  /**
   * Multiply a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsBinary(Constant constant) {
    return null;
  }

  /**
   * Multiply a Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsBool(Constant constant) {
    return null;
  }

  /**
   * Divide a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsStr(Constant constant) {
    return null;
  }

  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsInt(Constant constant) {
    return null;
  }

  /**
   * Divide a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsFloat(Constant constant) {
    return null;
  }

  /**
   * Divide a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsBinary(Constant constant) {
    return null;
  }

  /**
   * Divide a Scrabble Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsBool(Constant constant) {
    return null;
  }

  /**
   * Logical Or with Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsStr(Constant constant) {
    return null;
  }

  /**
   * Logical Or with Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsInt(Constant constant) {
    return null;
  }

  /**
   * Logical Or with Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsFloat(Constant constant) {
    return null;
  }

  /**
   * Logical Or with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBinary(ConsBinary constant) {
    return null;
  }

  /**
   * Logical Or with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBool(ConsBool constant) {
    return null;
  }

  /**
   * Logical And with Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsStr(Constant constant) {
    return null;
  }

  /**
   * Logical And with Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsInt(Constant constant) {
    return null;
  }

  /**
   * Logical And with Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsFloat(Constant constant) {
    return null;
  }

  /**
   * Logical And with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBinary(ConsBinary constant) {
    return null;
  }

  /**
   * Logical And with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBool(ConsBool constant) {
    return null;
  }

  /**
   * Negate a Constant
   *
   * @return Constant
   */
  @Override
  public Constant negateConstant() {
    return null;
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantStr() {
    return null;
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantInt() {
    return null;
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantFloat() {
    return null;
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBinary() {
    return null;
  }

  /**
   * Convert to bool constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBool() {
    return null;
  }
}
