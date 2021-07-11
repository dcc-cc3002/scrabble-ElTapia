package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;
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
  public IConstant negateConstant() {
    return new ConsBinary(this.consBinary.negate());
  }

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   *
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant add(IConstant IConstant) {
    return IConstant.addConsBinary(this);
  }

  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant sub(IConstant IConstant){
    return IConstant.subConsBinary(this);
  }

  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant times(IConstant IConstant){
    return IConstant.timesConsBinary(this);
  }

  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant divide(IConstant IConstant){
    return IConstant.divideConsBinary(this);
  }

  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant or(IConstant IConstant){
    return IConstant.orConsBinary(this);
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant and(IConstant IConstant){
    return IConstant.andConsBinary(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsStr(ConsString constant) {
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
  public IConstant addConsInt(ConsInt constant) {
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
  public IConstant addConsBinary(ConsBinary constant) {
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
  public IConstant subConsInt(ConsInt constant) {
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
  public IConstant subConsBinary(ConsBinary constant) {
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
  public IConstant timesConsInt(ConsInt constant) {
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
  public IConstant timesConsBinary(ConsBinary constant) {
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
  public IConstant divideConsInt(ConsInt constant) {
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
  public IConstant divideConsBinary(ConsBinary constant) {
    SBinary result = this.consBinary.divideSBinary(constant.getSType());
    return new ConsBinary(result);
  }


  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.addSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant subConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.minusSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant timesConsFloat(ConsFloat constant){
    SFloat result = this.consBinary.timesSFloat(constant.getSType());
    return new ConsFloat(result);
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant divideConsFloat(ConsFloat constant){
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
  public IConstant orConsBinary(ConsBinary constant) {
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
  public IConstant orConsBool(ConsBool constant) {
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
  public IConstant andConsBinary(ConsBinary constant) {
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
  public IConstant andConsBool(ConsBool constant) {
    SBinary result = this.consBinary.andSBool(constant.getSType());
    return new ConsBinary(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantStr() {
    SString result = this.consBinary.toSString();
    return new ConsString(result);
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantInt() {
    SInt result = this.consBinary.toSInt();
    return new ConsInt(result);
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantFloat() {
    SFloat result = this.consBinary.toSFloat();
    return new ConsFloat(result);
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantBinary() {
    SBinary result = this.consBinary.toSBinary();
    return new ConsBinary(result);
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public IConstant eval() {
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
