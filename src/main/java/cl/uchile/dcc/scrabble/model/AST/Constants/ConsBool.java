package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import cl.uchile.dcc.scrabble.model.STypeFactories.SBoolFactory;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SBool;
import cl.uchile.dcc.scrabble.model.Types.SString;

/**
 * Constant boolean that represents a leaf of the AST. It wraps a Scrabble type.
 */
public class ConsBool extends AbstractConstant{
  private final SBool consBool;

  /**
   * Constructor
   * @param bool boolean
   */
  public ConsBool(boolean bool){
    consBool = SBoolFactory.createSBool(bool);
  }

  /**
   * Constructor
   * @param sBool SBool
   */
  public ConsBool(SBool sBool){
    consBool = SBoolFactory.checkSBool(sBool);
  }

  /**
   * Get SType that the constant encapsulate
   *
   * @return AbstractType
   */
  @Override
  public SBool getSType() {
    return SBoolFactory.checkSBool(this.consBool);
  }

  /**
   * Compares an object with a constan
   * @param obj Object
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ConsBool){
      var o = (ConsBool) obj;
      return o.getSType().equals(this.consBool);
    }
    return false;
  }

  /**
   * String representation of a constant
   * @return String
   */
  @Override
  public String toString(){
    return this.consBool.toString();
  }

  /**
   * Negate a Constant
   *
   * @return Constant
   */
  @Override
  public IConstant negateConstant() {
    return new ConsBool(this.consBool.negate());
  }

  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant or(IConstant IConstant){
    return IConstant.orConsBool(this);
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  @Override
  public IConstant and(IConstant IConstant){
    return IConstant.andConsBool(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant addConsStr(ConsString constant) {
    SString result = this.consBool.addToSString(constant.getSType());
    return new ConsString(result);
  }

  /**
   * Logical Or with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant orConsBinary(ConsBinary constant) {
    SBinary result = this.consBool.orSBinary(constant.getSType());
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
    SBool result = this.consBool.orSBool(constant.getSType());
    return new ConsBool(result);
  }

  /**
   * Logical And with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public IConstant andConsBinary(ConsBinary constant) {
    SBinary result = this.consBool.andSBinary(constant.getSType());
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
    SBool result = this.consBool.andSBool(constant.getSType());
    return new ConsBool(result);
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantStr() {
    SString result = this.consBool.toSString();
    return new ConsString(result);
  }

  /**
   * Convert to bool constant
   *
   * @return Constant
   */
  @Override
  public IConstant toConstantBool() {
    SBool result = this.consBool.toSBool();
    return new ConsBool(result);
  }

  /**
   * Eval an operation
   *
   * @return Constant
   */
  @Override
  public IConstant eval() {
    return new ConsBool(this.consBool);
  }
}
