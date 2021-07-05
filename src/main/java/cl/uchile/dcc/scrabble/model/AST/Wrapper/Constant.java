package cl.uchile.dcc.scrabble.model.AST.Wrapper;

import cl.uchile.dcc.scrabble.model.Abstract.AbstractType;
import cl.uchile.dcc.scrabble.model.Types.*;

//TODO: Segregar métodos en más interfaces

/**
 * Interface to wrap Scrabble STypes. Implements methods that are not allowed.
 *
 * It will be used to implement composite pattern.
 */
public interface Constant {

  AbstractType getSType();

  /**
   * Add a Constant string
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsStr(Constant constant){
    return null;
  }

  /**
   * Add a Constant int
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsInt(Constant constant){
    return null;
  }

  /**
   * Add a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsFloat(Constant constant){
    return null;
  }

  /**
   * Add a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant addConsBinary(Constant constant){
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
  default Constant subConsInt(Constant constant){
    return null;
  }

  /**
   * Subtract a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant subConsFloat(Constant constant){
    return null;
  }

  /**
   * Subtract a Constant binary
   * @param sBinary Constant
   * @return Constant
   */
  default Constant subConsBinary(SBinary sBinary){
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
  default Constant timesConsInt(Constant constant){
    return null;
  }

  /**
   * Multiply a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsFloat(Constant constant){
    return null;
  }

  /**
   * Multiply a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant timesConsBinary(Constant constant){
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
  default Constant divideConsInt(Constant constant){
    return null;
  }

  /**
   * Divide a Constant float
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsFloat(Constant constant){
    return null;
  }

  /**
   * Divide a Constant binary
   * @param constant Constant
   * @return Constant
   */
  default Constant divideConsBinary(Constant constant){
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
  default Constant orConsBinary(Constant constant){
    return null;
  }

  /**
   * Logical Or with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant orConsBool(Constant constant){
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
  default Constant andConsBinary(Constant constant){
    return null;
  }

  /**
   * Logical And with Constant Bool
   * @param constant Constant
   * @return Constant
   */
  default Constant andConsBool(Constant constant){
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
