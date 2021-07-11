package cl.uchile.dcc.scrabble.model.STypeFactories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsFloatTest;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SFloatFactoryTest extends ConsFloatTest {

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(50)
  void cleanFactoryAndIsEmptyTest(){
    SFloatFactory.createSFloat(testDouble);
    SFloatFactory.cleanFactory();
    assertTrue(SFloatFactory.isEmpty());

    SFloatFactory.createSFloat(testDouble);
    assertFalse(SFloatFactory.isEmpty());

  }

  @RepeatedTest(50)
  void createAndCheck() {
    SFloatFactory.cleanFactory();

    assertSame(SFloatFactory.createSFloat(testDouble), SFloatFactory.createSFloat(testDouble));
    assertSame(SFloatFactory.createSFloat(testDouble), consFloat.getSType());

    SFloatFactory.cleanFactory();
    SFloat testSFloat = new SFloat(testDouble);

    assertSame(SFloatFactory.checkSFloat(testSFloat), SFloatFactory.createSFloat(testDouble));
    assertSame(SFloatFactory.checkSFloat(testSFloat), consFloat.getSType());
  }
}