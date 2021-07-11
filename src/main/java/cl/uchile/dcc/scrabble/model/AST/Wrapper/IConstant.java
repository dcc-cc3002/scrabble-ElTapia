package cl.uchile.dcc.scrabble.model.AST.Wrapper;

import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.Interfaces.SType;

//TODO: Segregar métodos en más interfaces

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
    return null;
  }


  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant sub(IConstant IConstant){
    return null;
  }


  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant times(IConstant IConstant){
    return null;
  }


  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divide(IConstant IConstant){
    return null;
  }


  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant or(IConstant IConstant){
    return null;
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant and(IConstant IConstant){
    return null;
  }

  /**
   * Compares an object with a constan
   * @param obj Object
   * @return boolean
   */
  boolean equals(Object obj);

  /**
   * Add a Constant string
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsStr(ConsString constant){
    return null;
  }

  /**
   * Add a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsInt(ConsInt constant){
    return null;
  }

  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Add a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant addConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Add a Constant Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant addConsBool(IConstant IConstant){
    return null;
  }

  /**
   * Subtract a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant subConsStr(IConstant IConstant){
    return null;
  }

  /**
   * Subtract a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsInt(ConsInt constant){
    return null;
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Subtract a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant subConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Subtract a Scrabble Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant subConsBool(IConstant IConstant){
    return null;
  }

  /**
   * Multiply a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant timesConsStr(IConstant IConstant){
    return null;
  }

  /**
   * Multiply a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsInt(ConsInt constant){
    return null;
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Multiply a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant timesConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Multiply a Constant Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant timesConsBool(IConstant IConstant){
    return null;
  }

  /**
   * Divide a Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divideConsStr(IConstant IConstant){
    return null;
  }

  /**
   * Divide a Constant int
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsInt(ConsInt constant){
    return null;
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Divide a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant divideConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Divide a Scrabble Bool
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant divideConsBool(IConstant IConstant){
    return null;
  }

  /**
   * Logical Or with Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsStr(IConstant IConstant){
    return null;
  }

  /**
   * Logical Or with Constant int
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsInt(IConstant IConstant){
    return null;
  }

  /**
   * Logical Or with Constant float
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant orConsFloat(IConstant IConstant){
    return null;
  }

  /**
   * Logical Or with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant orConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Logical Or with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default IConstant orConsBool(ConsBool constant){
    return null;
  }

  /**
   * Logical And with Constant string
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsStr(IConstant IConstant){
    return null;
  }

  /**
   * Logical And with Constant int
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsInt(IConstant IConstant){
    return null;
  }

  /**
   * Logical And with Constant float
   * @param IConstant Constant
   * @return Constant
   */
  default IConstant andConsFloat(IConstant IConstant){
    return null;
  }

  /**
   * Logical And with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default IConstant andConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Logical And with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default IConstant andConsBool(ConsBool constant){
    return null;
  }

  /**
   * Negate a Constant
   * @return Constant
   */
  default IConstant negateConstant(){
    return null;
  }

  /**
   * Convert to string constant
   * @return Constant
   */
  default IConstant toConstantStr(){
    return null;
  }

  /**
   * Convert to int constant
   * @return Constant
   */
  default IConstant toConstantInt(){
    return null;
  }

  /**
   * Convert to float constant
   * @return Constant
   */
  default IConstant toConstantFloat(){
    return null;
  }

  /**
   * Convert to binary constant
   * @return Constant
   */
  default IConstant toConstantBinary(){
    return null;
  }

  /**
   * Convert to bool constant
   * @return Constant
   */
  default IConstant toConstantBool(){
    return null;
  }

}
