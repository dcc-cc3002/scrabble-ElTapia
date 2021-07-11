package cl.uchile.dcc.scrabble.model.STypeFactories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBinaryTest;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SBinaryFactoryTest extends ConsBinaryTest  {

  @BeforeEach
  protected void setUp() {
    super.setUp();
  }

  @RepeatedTest(50)
  void cleanFactoryAndIsEmptyTest(){
    SBinaryFactory.createSBinary(testBinary);
    SBinaryFactory.cleanFactory();
    assertTrue(SBinaryFactory.isEmpty());

    SBinaryFactory.createSBinary(testBinary);
    assertFalse(SBinaryFactory.isEmpty());

  }

  @RepeatedTest(50)
  void createAndCheckSBinary() {
    SBinaryFactory.cleanFactory();

    assertSame(SBinaryFactory.createSBinary(testBinary), SBinaryFactory.createSBinary(testBinary));
    assertSame(SBinaryFactory.createSBinary(testBinary), consBinary.getSType());

    SBinaryFactory.cleanFactory();
    SBinary testSBinary = new SBinary(testBinary);

    assertSame(SBinaryFactory.checkSBinary(testSBinary), SBinaryFactory.createSBinary(testBinary));
    assertSame(SBinaryFactory.checkSBinary(testSBinary), consBinary.getSType());
  }
}