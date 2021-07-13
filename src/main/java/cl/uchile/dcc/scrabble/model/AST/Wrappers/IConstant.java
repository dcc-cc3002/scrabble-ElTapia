package cl.uchile.dcc.scrabble.model.AST.Wrappers;

import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import cl.uchile.dcc.scrabble.model.AST.IComponent;


/**
 * Interface to wrap Scrabble STypes. Implements methods that are not allowed.
 *
 * It will be used to implement composite pattern.
 */
public interface IConstant extends IComponent {

  /**
   * String representation of a constant
   * @return String
   */
  String toString();

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant add(IConstant IConstant){
    return NullConstant.getInstance();
  }


  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant sub(IConstant IConstant){
    return NullConstant.getInstance();
  }


  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant times(IConstant IConstant){
    return NullConstant.getInstance();
  }


  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divide(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant or(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant and(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Add a Constant string
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsStr(ConsString constant){
    return NullConstant.getInstance();
  }

  /**
   * Add a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsInt(ConsInt constant){
    return NullConstant.getInstance();
  }

  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsFloat(ConsFloat constant){
    return NullConstant.getInstance();
  }

  /**
   * Add a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Add a Constant Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant addConsBool(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Subtract a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant subConsStr(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Subtract a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsInt(ConsInt constant){
    return NullConstant.getInstance();
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsFloat(ConsFloat constant){
    return NullConstant.getInstance();
  }

  /**
   * Subtract a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Subtract a Scrabble Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant subConsBool(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Multiply a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant timesConsStr(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Multiply a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsInt(ConsInt constant){
    return NullConstant.getInstance();
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsFloat(ConsFloat constant){
    return NullConstant.getInstance();
  }

  /**
   * Multiply a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Multiply a Constant Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant timesConsBool(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Divide a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divideConsStr(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Divide a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsInt(ConsInt constant){
    return NullConstant.getInstance();
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsFloat(ConsFloat constant){
    return NullConstant.getInstance();
  }

  /**
   * Divide a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Divide a Scrabble Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divideConsBool(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical Or with Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsStr(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical Or with Constant int
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsInt(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical Or with Constant float
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsFloat(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical Or with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant orConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Logical Or with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default IConstant orConsBool(ConsBool constant){
    return NullConstant.getInstance();
  }

  /**
   * Logical And with Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsStr(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical And with Constant int
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsInt(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical And with Constant float
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsFloat(IConstant IConstant){
    return NullConstant.getInstance();
  }

  /**
   * Logical And with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant andConsBinary(ConsBinary constant){
    return NullConstant.getInstance();
  }

  /**
   * Logical And with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default IConstant andConsBool(ConsBool constant){
    return NullConstant.getInstance();
  }


  /**
   * Add with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant addNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * Sub with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant subNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * Times with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant timesNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * Divide with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant divideNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * And with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant andNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * Or with null
   * @param nullConstant NullConstant
   * @return IConstant
   */
  default IConstant orNull(IConstant nullConstant){
    return NullConstant.getInstance();
  }

  /**
   * Negate a Constant
   * @return Constant
   */
  default IConstant negateConstant(){
    return NullConstant.getInstance();
  }

  /**
   * Convert to string constant
   * @return Constant
   */
  default IConstant toConstantStr(){
    return NullConstant.getInstance();
  }

  /**
   * Convert to int constant
   * @return Constant
   */
  default IConstant toConstantInt(){
    return NullConstant.getInstance();
  }

  /**
   * Convert to float constant
   * @return Constant
   */
  default IConstant toConstantFloat(){
    return NullConstant.getInstance();
  }

  /**
   * Convert to binary constant
   * @return Constant
   */
  default IConstant toConstantBinary(){
    return NullConstant.getInstance();
  }

  /**
   * Convert to bool constant
   * @return Constant
   */
  default IConstant toConstantBool(){
    return NullConstant.getInstance();
  }

}
