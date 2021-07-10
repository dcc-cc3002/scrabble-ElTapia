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
public interface Constant extends IComponent {

  /**
   * Get SType that the constant encapsulate
   * @return AbstractType
   */
  SType getSType();

  /**
   * String representation of a constant
   * @return String
   */
  String toString();

  /**
   * Add a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant add(Constant constant){
    return null;
  }


  /**
   * Subtract a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant sub(Constant constant){
    return null;
  }


  /**
   * Multiply a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant times(Constant constant){
    return null;
  }


  /**
   * Divide a constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant divide(Constant constant){
    return null;
  }


  /**
   * Or logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant or(Constant constant){
    return null;
  }

  /**
   * And logic with constant. It uses Double Dispatch depending on Constant type
   * @param constant Constant
   * @return Constant
   */
  default Constant and(Constant constant){
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
  default Constant addConsStr(ConsString constant){
    return null;
  }

  /**
   * Add a Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsInt(ConsInt constant){
    return null;
  }

  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Add a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Add a Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsBool(Constant constant){
    return null;
  }

  /**
   * Subtract a Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsStr(Constant constant){
    return null;
  }

  /**
   * Subtract a Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsInt(ConsInt constant){
    return null;
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Subtract a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Subtract a Scrabble Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsBool(Constant constant){
    return null;
  }

  /**
   * Multiply a Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsStr(Constant constant){
    return null;
  }

  /**
   * Multiply a Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsInt(ConsInt constant){
    return null;
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Multiply a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Multiply a Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsBool(Constant constant){
    return null;
  }

  /**
   * Divide a Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsStr(Constant constant){
    return null;
  }

  /**
   * Divide a Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsInt(ConsInt constant){
    return null;
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsFloat(ConsFloat constant){
    return null;
  }

  /**
   * Divide a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Divide a Scrabble Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsBool(Constant constant){
    return null;
  }

  /**
   * Logical Or with Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsStr(Constant constant){
    return null;
  }

  /**
   * Logical Or with Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsInt(Constant constant){
    return null;
  }

  /**
   * Logical Or with Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsFloat(Constant constant){
    return null;
  }

  /**
   * Logical Or with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Logical Or with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsBool(ConsBool constant){
    return null;
  }

  /**
   * Logical And with Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsStr(Constant constant){
    return null;
  }

  /**
   * Logical And with Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsInt(Constant constant){
    return null;
  }

  /**
   * Logical And with Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsFloat(Constant constant){
    return null;
  }

  /**
   * Logical And with Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsBinary(ConsBinary constant){
    return null;
  }

  /**
   * Logical And with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsBool(ConsBool constant){
    return null;
  }

  /**
   * Negate a Constant
   * @return Constant
   */
  default Constant negateConstant(){
    return null;
  }

  /**
   * Convert to string constant
   * @return Constant
   */
  default Constant toConstantStr(){
    return null;
  }

  /**
   * Convert to int constant
   * @return Constant
   */
  default Constant toConstantInt(){
    return null;
  }

  /**
   * Convert to float constant
   * @return Constant
   */
  default Constant toConstantFloat(){
    return null;
  }

  /**
   * Convert to binary constant
   * @return Constant
   */
  default Constant toConstantBinary(){
    return null;
  }

  /**
   * Convert to bool constant
   * @return Constant
   */
  default Constant toConstantBool(){
    return null;
  }

}
