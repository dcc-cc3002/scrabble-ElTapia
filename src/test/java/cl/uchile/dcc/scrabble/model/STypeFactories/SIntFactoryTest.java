package cl.uchile.dcc.scrabble.model.STypeFactories;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsIntTest;
import cl.uchile.dcc.scrabble.model.Types.SInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SIntFactoryTest extends ConsIntTest {

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(50)
  void cleanFactoryAndIsEmptyTest(){
    SIntFactory.createSInt(testInt);
    SIntFactory.cleanFactory();
    assertTrue(SIntFactory.isEmpty());

    SIntFactory.createSInt(testInt);
    assertFalse(SIntFactory.isEmpty());

  }

  @RepeatedTest(50)
  void createAndCheck() {
    SIntFactory.cleanFactory();

    assertSame(SIntFactory.createSInt(testInt), SIntFactory.createSInt(testInt));
    assertSame(SIntFactory.createSInt(testInt), consInt.getSType());

    SIntFactory.cleanFactory();
    SInt testSInt = new SInt(testInt);

    assertSame(SIntFactory.checkSInt(testSInt), SIntFactory.createSInt(testInt));
    assertSame(SIntFactory.checkSInt(testSInt), consInt.getSType());
  }
}