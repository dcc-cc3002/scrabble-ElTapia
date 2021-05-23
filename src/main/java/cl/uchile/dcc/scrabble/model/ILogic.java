package cl.uchile.dcc.scrabble.model;

public interface ILogic {
    abstractType negate();
    abstractType orSBool(SBool toOrSBool);
    abstractType andSBool(SBool toAndSBool);
    abstractType orSBinary(SBinary toOrSBinary);
    abstractType andSBinary(SBinary toAndSBinary);
}
