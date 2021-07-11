package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;
import cl.uchile.dcc.scrabble.model.STypeFactories.SFloatFactory;
import cl.uchile.dcc.scrabble.model.Types.*;

public class ConsFloat extends AbstractConstant{
  private final SFloat consFloat;

  /**
   * Constructor with native Java
   * @param entryFloat double
   */
  public ConsFloat(double entryFloat){
    consFloat = SFloatFactory.createSFloat(entryFloat);
  }

  /**
   * Constructor with SType
   * @param sFloat SFloat
   */
  public ConsFloat(SFloat sFloat){
    consFloat = SFloatFactory.checkSFloat(sFloat);
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
    return SFloatFactory.checkSFloat(this.consFloat);
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant add(IConstant IConstant) {
    return IConstant.addConsFloat(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant sub(IConstant IConstant){
    return IConstant.subConsFloat(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant times(IConstant IConstant){
    return IConstant.timesConsFloat(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant divide(IConstant IConstant){
    return IConstant.divideConsFloat(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsStr(ConsString constant) {
    SString result = this.consFloat.addToSString(constant.getSType());
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
    SFloat result = this.consFloat.addSInt(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Add a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.addSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsInt(ConsInt constant) {
    SFloat result = this.consFloat.minusSInt(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Subtract a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.minusSFloat(constant.getSType());
    return new ConsFloat(result);
  }



  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsInt(ConsInt constant) {
    SFloat result = this.consFloat.timesSInt(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Multiply a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.timesSFloat(constant.getSType());
    return new ConsFloat(result);
  }


  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsInt(ConsInt constant) {
    SFloat result = this.consFloat.divideSInt(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Divide a Constant float
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsFloat(ConsFloat constant) {
    SFloat result = this.consFloat.divideSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantStr() {
    SString result = this.consFloat.toSString();
    return new ConsString(result);
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantFloat() {
    SFloat result = this.consFloat.toSFloat();
    return new ConsFloat(result);
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return new ConsFloat(this.consFloat);
  }

}
