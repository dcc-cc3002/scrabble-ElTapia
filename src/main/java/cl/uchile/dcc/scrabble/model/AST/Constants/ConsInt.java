package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;
import cl.uchile.dcc.scrabble.model.STypeFactories.SIntFactory;
import cl.uchile.dcc.scrabble.model.Types.*;

public class ConsInt extends AbstractConstant {

  private final SInt consInt;

  /**
   * Constructor with native Java
   *
   * @param Int int
   */
  public ConsInt(int Int) {
    consInt = SIntFactory.createSInt(Int);
  }

  /**
   * Constructor with SType
   *
   * @param sInt SInt
   */
  public ConsInt(SInt sInt) {
    consInt = SIntFactory.checkSInt(sInt);
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
    return SIntFactory.checkSInt(this.consInt);
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant add(IConstant IConstant) {
    return IConstant.addConsInt(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant sub(IConstant IConstant) {
    return IConstant.subConsInt(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant times(IConstant IConstant) {
    return IConstant.timesConsInt(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant divide(IConstant IConstant) {
    return IConstant.divideConsInt(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsStr(ConsString constant) {
    SString result = this.consInt.addToSString(constant.getSType());
    return new ConsString(result);
  }

  /**
   * Add a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsInt(ConsInt constant) {
    SInt result = this.consInt.addSInt(constant.getSType());
    return new ConsInt(result);
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.addSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Add a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsBinary(ConsBinary constant) {
    SBinary result = this.consInt.addSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsInt(ConsInt constant) {
    SInt result = this.consInt.minusSInt(constant.getSType());
    return new ConsInt(result);
  }

  /**
   * Subtract a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.minusSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Subtract a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsBinary(ConsBinary constant) {
    SBinary result = this.consInt.minusSBinary(constant.getSType());
    return new ConsBinary(result);
  }


  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsInt(ConsInt constant) {
    SInt result = this.consInt.timesSInt(constant.getSType());
    return new ConsInt(result);
  }

  /**
   * Multiply a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.timesSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Multiply a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsBinary(ConsBinary constant) {
    SBinary result = this.consInt.timesSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsInt(ConsInt constant) {
    SInt result = this.consInt.divideSInt(constant.getSType());
    return new ConsInt(result);
  }

  /**
   * Divide a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsFloat(ConsFloat constant) {
    SFloat result = this.consInt.divideSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Divide a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsBinary(ConsBinary constant) {
    SBinary result = this.consInt.divideSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantStr() {
    SString result = this.consInt.toSString();
    return new ConsString(result);
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantInt() {
    SInt result = this.consInt.toSInt();
    return new ConsInt(result);
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantFloat() {
    SFloat result = this.consInt.toSFloat();
    return new ConsFloat(result);
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantBinary() {
    SBinary result = this.consInt.toSBinary();
    return new ConsBinary(result);
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return new ConsInt(this.consInt);
  }

  /**
   * String representation of an AST
   *
   * @return String
   */
  @Override
  public String stringRep() {
    return "Int(" + this.toString() + ")\n";
  }
}