package cl.uchile.dcc.scrabble.model.STypeFactories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsString;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsStringTest;
import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SStringFactoryTest extends ConsStringTest {

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(50)
  void cleanFactoryAndIsEmptyTest(){
    SStringFactory.createSString(testString);
    SStringFactory.cleanFactory();
    assertTrue(SStringFactory.isEmpty());

    SStringFactory.createSString(testString);
    assertFalse(SStringFactory.isEmpty());

  }

  @RepeatedTest(50)
  void createAndCheckSBinary() {
    SBinaryFactory.cleanFactory();

    assertSame(SStringFactory.createSString(testString), SStringFactory.createSString(testString));
    assertSame(SStringFactory.createSString(testString), consString.getSType());

    SStringFactory.cleanFactory();
    SString testSString = new SString(testString);

    assertSame(SStringFactory.checkSString(testSString), SStringFactory.createSString(testString));
    assertSame(SStringFactory.checkSString(testSString), consString.getSType());
  }
}