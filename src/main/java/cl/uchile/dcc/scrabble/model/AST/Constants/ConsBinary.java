package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import cl.uchile.dcc.scrabble.model.STypeFactories.SBinaryFactory;
import cl.uchile.dcc.scrabble.model.Types.*;

public class ConsBinary extends AbstractConstant{
  private final SBinary consBinary;

  /**
   * Constructor with native Java
   * @param binary String
   */
  public ConsBinary(String binary){
    consBinary = SBinaryFactory.createSBinary(binary);
  }

  /**
   * Constructor with SType
   * @param sBinary SBinary
   */
  public ConsBinary(SBinary sBinary){
    consBinary = SBinaryFactory.checkSBinary(sBinary);
  }

  /**
   * Compares an object with a constan
   *
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ConsBinary){
      var o = (ConsBinary) obj;
      return o.getSType().equals(this.consBinary);
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
    return this.consBinary.toString();
  }

  /**
   * Get SType that the constant encapsulate
   *
   * @return AbstractType
   */
  @Override
  public SBinary getSType() {
    return SBinaryFactory.checkSBinary(this.consBinary);
  }

  /**
   * Negate a Constant
   *
   * @return Constant
   */
  @Override
  public Constant negateConstant() {
    return new ConsBinary(this.consBinary.negate());
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant add(Constant constant) {
    return constant.addConsBinary(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant sub(Constant constant){
    return constant.subConsBinary(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant times(Constant constant){
    return constant.timesConsBinary(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divide(Constant constant){
    return constant.divideConsBinary(this);
  }

  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant or(Constant constant){
    return constant.orConsBinary(this);
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant and(Constant constant){
    return constant.andConsBinary(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = this.consBinary.addToSString(constant.getSType());
    return new ConsString(result);
  }

  /**
   * Add a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsInt(ConsInt constant) {
    SInt result = this.consBinary.addSInt(constant.getSType());
    return new ConsInt(result);
  }


  /**
   * Add a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.addSBinary(constant.getSType());
    return new ConsBinary(result);
  }


  /**
   * Subtract a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsInt(ConsInt constant) {
    SInt result = this.consBinary.minusSInt(constant.getSType());
    return new ConsInt(result);
  }


  /**
   * Subtract a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.minusSBinary(constant.getSType());
    return new ConsBinary(result);
  }



  /**
   * Multiply a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsInt(ConsInt constant) {
    SInt result = this.consBinary.timesSInt(constant.getSType());
    return new ConsInt(result);
  }


  /**
   * Multiply a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.timesSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Divide a Constant int
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsInt(ConsInt constant) {
    SInt result = this.consBinary.divideSInt(constant.getSType());
    return new ConsInt(result);
  }

  /**
   * Divide a Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.divideSBinary(constant.getSType());
    return new ConsBinary(result);
  }


  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.addSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant subConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.minusSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant timesConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.timesSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant divideConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.divideSFloat(constant.getSType());
    return new ConsFloat(result);
  }


  /**
   * Logical Or with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.orSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Logical Or with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBool(ConsBool constant) {
    SBinary result = this.consBinary.orSBool(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Logical And with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.andSBinary(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Logical And with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBool(ConsBool constant) {
    SBinary result = this.consBinary.andSBool(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantStr() {
    SString result = this.consBinary.toSString();
    return new ConsString(result);
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantInt() {
    SInt result = this.consBinary.toSInt();
    return new ConsInt(result);
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantFloat() {
    SFloat result = this.consBinary.toSFloat();
    return new ConsFloat(result);
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBinary() {
    SBinary result = this.consBinary.toSBinary();
    return new ConsBinary(result);
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public Constant eval() {
    return new ConsBinary(this.consBinary);
  }

  /**
   * String representation of an AST
   *
   * @return String
   */
  @Override
  public String stringRep() {
    return "Binary(" + this.toString() + ")\n";
  }
}
