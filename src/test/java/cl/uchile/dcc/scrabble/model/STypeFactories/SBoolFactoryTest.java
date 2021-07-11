package cl.uchile.dcc.scrabble.model.STypeFactories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBoolTest;
import cl.uchile.dcc.scrabble.model.Types.SBool;
import cl.uchile.dcc.scrabble.model.Types.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SBoolFactoryTest extends ConsBoolTest {

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(50)
  void cleanFactoryAndIsEmptyTest(){
    SBoolFactory.createSBool(boolTest);
    SBoolFactory.cleanFactory();
    assertTrue(SBoolFactory.isEmpty());

    SBoolFactory.createSBool(boolTest);
    assertFalse(SBoolFactory.isEmpty());

  }

  @RepeatedTest(50)
  void createAndCheck() {
    SBoolFactory.cleanFactory();

    assertSame(SBoolFactory.createSBool(boolTest), SBoolFactory.createSBool(boolTest));
    assertSame(SBoolFactory.createSBool(boolTest), consBool.getSType());

    SBoolFactory.cleanFactory();
    SBool testSBool = new SBool(boolTest);

    assertSame(SBoolFactory.checkSBool(testSBool), SBoolFactory.createSBool(boolTest));
    assertSame(SBoolFactory.checkSBool(testSBool), consBool.getSType());
  }
}