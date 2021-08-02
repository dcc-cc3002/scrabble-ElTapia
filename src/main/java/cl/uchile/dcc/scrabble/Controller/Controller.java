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

public class Controller {
    private static IComponent root = NullConstant.getInstance();
    private static final StringProperty tree = new SimpleStringProperty();

  public static void insertAdd(){
    Add toInsert = new Add();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
    }

  public static void insertSub(){
    Sub toInsert = new Sub();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertTimes(){
    Times toInsert = new Times();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertDivide(){
    Divide toInsert = new Divide();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertNegate(){
    Negate toInsert = new Negate();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertToString(){
    ToString toInsert = new ToString();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertToInt(){
    ToInt toInsert = new ToInt();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertToFloat(){
    ToFloat toInsert = new ToFloat();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertToBool(){
    ToBool toInsert = new ToBool();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertToBinary(){
    ToBinary toInsert = new ToBinary();
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertString(String input){
    ConsString toInsert = new ConsString(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertInt(int input){
    ConsInt toInsert = new ConsInt(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertFloat(double input){
    ConsFloat toInsert = new ConsFloat(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertBinary(String input){
    ConsBinary toInsert = new ConsBinary(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void insertBool(boolean input){
    ConsBool toInsert = new ConsBool(input);
    if (root.equals(NullConstant.getInstance()))
      root = toInsert;

    else root.insert(toInsert);
  }

  public static void clear(){
    root = NullConstant.getInstance();
  }

  public static void update(){
    tree.setValue(root.toString());
    System.out.println(tree.getValue());
  }

  public static String eval(){
    IComponent evalResult = root.eval();
    String result;
    if (evalResult.equals(NullConstant.getInstance()))
      result = "Syntax Error";
    else result = evalResult.toString();

    return result;
  }

  public static StringProperty getTree(){
    return tree;
  }
}
