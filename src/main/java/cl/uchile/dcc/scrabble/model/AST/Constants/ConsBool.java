package cl.uchile.dcc.scrabble.model.AST.Constants;

import cl.uchile.dcc.scrabble.model.AST.IOperation;
import cl.uchile.dcc.scrabble.model.AST.Wrapper.Constant;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SBool;
import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Objects;

/**
 * Constant boolean that represents a leaf of the AST. It wraps a Scrabble type.
 */
public class ConsBool implements Constant, IOperation {
  private final SBool consBool;

  /**
   * Constructor
   * @param bool boolean
   */
  public ConsBool(boolean bool){
    consBool = new SBool(bool);
  }

  /**
   * Eval an operation
   * @return Constant
   */
  @Override
  public Constant eval() {
    return this;
  }

  /**
   * Get SType that the constant encapsulate
   *
   * @return AbstractType
   */
  @Override
  public SBool getSType() {
    return new SBool(this.consBool.getBool());
  }

  /**
   * Get hashcode of type
   * @return int
   */
  @Override
  public int hashCode(){
    return Objects.hash(ConsBool.class);
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
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant or(Constant constant){
    return constant.orConsBool(this);
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant and(Constant constant){
    return constant.andConsBool(this);
  }

  /**
   * Add a Constant string
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant addConsStr(ConsString constant) {
    SString result = constant.getSType().add(this.consBool);
    return new ConsString(result.toString());
  }

  /**
   * Logical Or with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBinary(ConsBinary constant) {
    SBinary result = this.consBool.orSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }

  /**
   * Logical Or with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant orConsBool(ConsBool constant) {
    SBool result = this.consBool.orSBool(constant.getSType());
    return new ConsBool(result.getBool());
  }

  /**
   * Logical And with Constant binary
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBinary(ConsBinary constant) {
    SBinary result = this.consBool.andSBinary(constant.getSType());
    return new ConsBinary(result.toString());
  }

  /**
   * Logical And with Constant Bool
   *
   * @param constant Constant
   * @return Constant
   */
  @Override
  public Constant andConsBool(ConsBool constant) {
    SBool result = this.consBool.andSBool(constant.getSType());
    return new ConsBool(result.getBool());
  }

  /**
   * Negate a Constant
   *
   * @return Constant
   */
  @Override
  public Constant negateConstant() {
    return new ConsBool(this.consBool.negate().getBool());
  }

  /**
   * Convert to string constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantStr() {
    return Constant.super.toConstantStr();
  }

  /**
   * Convert to int constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantInt() {
    return Constant.super.toConstantInt();
  }

  /**
   * Convert to float constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantFloat() {
    return Constant.super.toConstantFloat();
  }

  /**
   * Convert to binary constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBinary() {
    return Constant.super.toConstantBinary();
  }

  /**
   * Convert to bool constant
   *
   * @return Constant
   */
  @Override
  public Constant toConstantBool() {
    return Constant.super.toConstantBool();
  }
}
