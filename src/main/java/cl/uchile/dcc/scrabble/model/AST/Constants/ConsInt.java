package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SInt;
import cl.uchile.dcc.scrabble.model.Types.SString;

public class ConsInt extends AbstractConstant {

  private final SInt consInt;

  /**
   * Constructor
   *
   * @param Int int
   */
  public ConsInt(int Int) {
    consInt = new SInt(Int);
  }

  /**
   * Compares an object with a constan
   *
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ConsInt) {
      var o = (ConsInt) obj;
      return o.getSType().equals(this.consInt);
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
    return this.consInt.toString();
  }

  /**
   * Get SType that the constant encapsulate
   *
   * @return AbstractType
   */
  @Override
  public SInt getSType() {
    return new SInt(this.consInt.getInt());
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant add(Constant constant) {
    return constant.addConsInt(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant sub(Constant constant) {
    return constant.subConsInt(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant times(Constant constant) {
    return constant.timesConsInt(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divide(Constant constant) {
    return constant.divideConsInt(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = this.consInt.addToSString(constant.getSType());
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
    SInt result = this.consInt.addSInt(constant.getSType());
    return new ConsInt(result.getInt());
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.addSFloat(constant.getSType());
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
    SBinary result = this.consInt.addSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }

  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsInt(ConsInt constant) {
    SInt result = this.consInt.minusSInt(constant.getSType());
    return new ConsInt(result.getInt());
  }

  /**
   * Subtract a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.minusSFloat(constant.getSType());
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
    SBinary result = this.consInt.minusSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }


  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsInt(ConsInt constant) {
    SInt result = this.consInt.timesSInt(constant.getSType());
    return new ConsInt(result.getInt());
  }

  /**
   * Multiply a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.timesSFloat(constant.getSType());
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
    SBinary result = this.consInt.timesSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }

  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsInt(ConsInt constant) {
    SInt result = this.consInt.divideSInt(constant.getSType());
    return new ConsInt(result.getInt());
  }

  /**
   * Divide a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.divideSFloat(constant.getSType());
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
    SBinary result = this.consInt.divideSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantStr() {
    SString result = this.consInt.toSString();
    return new ConsString(result.toString());
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantInt() {
    SInt result = this.consInt.toSInt();
    return new ConsInt(result.getInt());
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantFloat() {
    SFloat result = this.consInt.toSFloat();
    return new ConsFloat(result.getDouble());
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBinary() {
    SBinary result = this.consInt.toSBinary();
    return new ConsBinary(result.toString());
  }
}