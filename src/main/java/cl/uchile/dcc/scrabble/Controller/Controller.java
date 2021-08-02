package cl.uchile.dcc.scrabble.Controller;

import cl.uchile.dcc.scrabble.model.AST.Composites.DualOp.*;
import cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp.*;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBinary;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBool;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsFloat;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsInt;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsString;
import cl.uchile.dcc.scrabble.model.AST.Constants.NullConstant;
import cl.uchile.dcc.scrabble.model.AST.IComponent;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * App controller
 */
public class Controller {
    private static IComponent root = NullConstant.getInstance();
    private static final StringProperty tree = new SimpleStringProperty();

  /**
   * Insert add operation to root
   */
  public static void insertAdd(){
    Add toInsert = new Add();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
    }

  /**
   * Insert sub operation to root
   */
  public static void insertSub(){
    Sub toInsert = new Sub();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert times operation to root
   */
  public static void insertTimes(){
    Times toInsert = new Times();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert divide operation to root
   */
  public static void insertDivide(){
    Divide toInsert = new Divide();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert or operation to root
   */
  public static void insertOr(){
    Or toInsert = new Or();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert and operation to root
   */
  public static void insertAnd(){
    And toInsert = new And();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert negate operation to root
   */
  public static void insertNegate(){
    Negate toInsert = new Negate();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert to string operation to root
   */
  public static void insertToString(){
    ToString toInsert = new ToString();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert to int operation to root
   */
  public static void insertToInt(){
    ToInt toInsert = new ToInt();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert to float operation to root
   */
  public static void insertToFloat(){
    ToFloat toInsert = new ToFloat();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert to bool operation to root
   */
  public static void insertToBool(){
    ToBool toInsert = new ToBool();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert to binary operation to root
   */
  public static void insertToBinary(){
    ToBinary toInsert = new ToBinary();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert string to root
   */
  public static void insertString(String input){
    ConsString toInsert = new ConsString(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert int to root
   */
  public static void insertInt(int input){
    ConsInt toInsert = new ConsInt(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert float to root
   */
  public static void insertFloat(double input){
    ConsFloat toInsert = new ConsFloat(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert binary to root
   */
  public static void insertBinary(String input){
    ConsBinary toInsert = new ConsBinary(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Insert bool to root
   */
  public static void insertBool(boolean input){
    ConsBool toInsert = new ConsBool(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  /**
   * Clear the root
   */
  public static void clear(){
    root = NullConstant.getInstance();
  }

  /**
   * Update string property with AST string representation
   */
  public static void update(){
    tree.setValue(root.toString());
  }


  /**
   * Eval AST
   * @return String
   */
  public static String eval(){
    IComponent evalResult = root.eval();
    String result;
    if (evalResult.equals(NullConstant.getInstance()))
      result = "Syntax Error";
    else result = evalResult.toString();

    return result;
  }

  /**
   * Get string property
   * @return StringProperty
   */
  public static StringProperty getTree(){
    return tree;
  }
}
