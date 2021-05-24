package cl.uchile.dcc.scrabble.model;

//TODO: Modify interface to accept all kind of operators with float
//TODO: Possibly implement methods that are in father interface
//TODO: ADD DOCUMENTATION

public interface IOpFloat extends IAddSFloat{
    abstractType minusSFloat(SFloat toAddSFloat);
    abstractType timesFloat(SFloat toAddSFloat);
    abstractType divideSFloat(SFloat toAddSFloat);
}
