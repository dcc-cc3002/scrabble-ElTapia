package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SString;

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
    return constant.addConsFloat(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant sub(Constant constant){
    return constant.subConsFloat(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant times(Constant constant){
    return constant.timesConsFloat(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divide(Constant constant){
    return constant.divideConsFloat(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = constant.getSType().add(this.consFloat);
    return new ConsString(result.toString());
  }

  /**
   * Add a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsInt(ConsInt constant) {
    SFloat result = this.consFloat.addSInt(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.addSFloat(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Add a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBinary(ConsBinary constant) {
    SFloat result = this.consFloat.addSBinary(constant.getSType());
    return new ConsFloat(result.getDouble());
  }


  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsInt(ConsInt constant) {
    SFloat result = this.consFloat.minusSInt(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Subtract a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.minusSFloat(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Subtract a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsBinary(ConsBinary constant) {
    SFloat result = this.consFloat.minusSBinary(constant.getSType());
    return new ConsFloat(result.getDouble());
  }


  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsInt(ConsInt constant) {
    SFloat result = this.consFloat.timesSInt(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Multiply a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.timesSFloat(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Multiply a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsBinary(ConsBinary constant) {
    SFloat result = this.consFloat.timesSBinary(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsInt(ConsInt constant) {
    SFloat result = this.consFloat.divideSInt(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Divide a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.divideSFloat(constant.getSType());
    return new ConsFloat(result.getDouble());
  }

  /**
   * Divide a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsBinary(ConsBinary constant) {
    SFloat result = this.consFloat.divideSBinary(constant.getSType());
    return new ConsFloat(result.getDouble());
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
