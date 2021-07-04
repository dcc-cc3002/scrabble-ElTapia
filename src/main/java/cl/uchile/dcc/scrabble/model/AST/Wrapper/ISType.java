package cl.uchile.dcc.scrabble.model.AST.Wrapper;

import cl.uchile.dcc.scrabble.model.Types.*;

public interface ISType {
  default ISType addSStr(SString sString){
    return null;
  }

  default ISType addSInt(SInt sInt){
    return null;
  }

  default ISType addSFloat(SFloat sFloat){
    return null;
  }

  default ISType addSBinary(SBinary sBinary){
    return null;
  }

  default ISType addSBool(SBool sBool){
    return null;
  }

  default ISType subSStr(SString sString){
    return null;
  }

  default ISType subSInt(SInt sInt){
    return null;
  }

  default ISType subSFloat(SFloat sFloat){
    return null;
  }

  default ISType subSBinary(SBinary sBinary){
    return null;
  }

  default ISType subSBool(SBool sBool){
    return null;
  }

  default ISType timesSStr(SString sString){
    return null;
  }

  default ISType timesSInt(SInt sInt){
    return null;
  }

  default ISType timesSFloat(SFloat sFloat){
    return null;
  }

  default ISType timesSBinary(SBinary sBinary){
    return null;
  }

  default ISType timesSBool(SBool sBool){
    return null;
  }

  default ISType divideSStr(SString sString){
    return null;
  }

  default ISType divideSInt(SInt sInt){
    return null;
  }

  default ISType divideSFloat(SFloat sFloat){
    return null;
  }

  default ISType divideSBinary(SBinary sBinary){
    return null;
  }

  default ISType divideSBool(SBool sBool){
    return null;
  }

  default ISType orSStr(SString sString){
    return null;
  }

  default ISType orSInt(SInt sInt){
    return null;
  }

  default ISType orSFloat(SFloat sFloat){
    return null;
  }

  default ISType orSBinary(SBinary sBinary){
    return null;
  }

  default ISType orSBool(SBool sBool){
    return null;
  }

  default ISType andSStr(SString sString){
    return null;
  }

  default ISType andSInt(SInt sInt){
    return null;
  }

  default ISType andSFloat(SFloat sFloat){
    return null;
  }

  default ISType andSBinary(SBinary sBinary){
    return null;
  }

  default ISType andSBool(SBool sBool){
    return null;
  }

  default ISType negate(){
    return null;
  }

  default ISType toSString(){
    return null;
  }
  
  default ISType toSInt(){
    return null;
  }

  default ISType toSFloat(){
    return null;
  }

  default ISType toSBinary(){
    return null;
  }

  default ISType toSBool(){
    return null;
  }


}
