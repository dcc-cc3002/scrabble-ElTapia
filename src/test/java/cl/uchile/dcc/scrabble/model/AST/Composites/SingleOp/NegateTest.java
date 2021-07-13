package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class NegateTest extends CompositeTest {
  protected Negate toBinaryTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void eval(){
    //negate binary
    toBinaryTest = new Negate(testConsBinary[0]);

    assertEquals(toBinaryTest.eval(), testConsBinary[0].negateConstant());
    assertNotSame(nullConstant, toBinaryTest.eval());

    //negate false bool
    toBinaryTest = new Negate(testFalseConsBool);

    assertEquals(toBinaryTest.eval(), testFalseConsBool.negateConstant());
    assertNotSame(nullConstant, toBinaryTest.eval());

    //negate true bool
    toBinaryTest = new Negate(testTrueConsBool);

    assertEquals(toBinaryTest.eval(), testTrueConsBool.negateConstant());
    assertNotSame(nullConstant, toBinaryTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //negate int
    toBinaryTest = new Negate(testConsInt);

    assertSame(toBinaryTest.eval(), testConsInt.negateConstant());
    assertSame(nullConstant, toBinaryTest.eval());

    //negate float
    toBinaryTest = new Negate(testConsFloat);

    assertSame(toBinaryTest.eval(), testConsFloat.negateConstant());
    assertSame(nullConstant, toBinaryTest.eval());

    //negate string
    toBinaryTest = new Negate(testConsString);

    assertSame(toBinaryTest.eval(), testConsString.negateConstant());
    assertSame(nullConstant, toBinaryTest.eval());
  }
}