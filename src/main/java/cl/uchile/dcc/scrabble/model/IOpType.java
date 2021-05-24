package cl.uchile.dcc.scrabble.model;

//COMPLETE: Modify interface to accept all kind of operators
//TODO: ADD DOCUMENTATION

public interface IOpType extends IAddType{

    abstractType minusSInt(SInt toMinusSInt);
    abstractType timesSInt(SInt toTimesSInt);
    abstractType divideSInt(SInt toDivideSInt);

    abstractType minusSBinary(SBinary toMinusSBinary);
    abstractType timesSBinary(SBinary toTimesSBinary);
    abstractType divideSBinary(SBinary toDivideSBinary);
}
