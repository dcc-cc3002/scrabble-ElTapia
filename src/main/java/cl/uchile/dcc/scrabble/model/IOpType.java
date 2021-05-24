package cl.uchile.dcc.scrabble.model;

//TODO: Modify interface to accept all kind of operators
//TODO: ADD DOCUMENTATION

public interface IOpType extends IAddType{

    abstractType minusSInt(SInt toAddSInt);
    abstractType timesSInt(SInt toAddSInt);
    abstractType divideSInt(SInt toAddSInt);

    abstractType minusSBinary(SBinary toAddSBinary);
    abstractType timesSBinary(SBinary toAddSBinary);
    abstractType divideSBinary(SBinary toAddSBinary);
}
