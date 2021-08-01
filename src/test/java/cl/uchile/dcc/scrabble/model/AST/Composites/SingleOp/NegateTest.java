package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class NegateTest extends CompositeTest {
  protected Negate negateTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    negateTest = new Negate(testConsBinary[0]);

    Negate expectedInsertTest = new Negate();
    expectedInsertTest.insert(testConsBinary[0]);

    Negate expectedNegateTest = new Negate(testConsBinary[0]);

    assertEquals(expectedInsertTest, this.negateTest);
    assertEquals(expectedNegateTest, negateTest);
    assertNotEquals(this.negateTest, testTrueConsBool);
    assertFalse(negateTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    Negate voidNegate = new Negate();
    assertTrue(voidNegate.hasNull());

  }

  @RepeatedTest(100)
  void eval(){
    //negate binary
    negateTest = new Negate(testConsBinary[0]);

    assertEquals(negateTest.eval(), testConsBinary[0].negateConstant());
    assertNotSame(nullConstant, negateTest.eval());

    //negate false bool
    negateTest = new Negate(testFalseConsBool);

    assertEquals(negateTest.eval(), testFalseConsBool.negateConstant());
    assertNotSame(nullConstant, negateTest.eval());

    //negate true bool
    negateTest = new Negate(testTrueConsBool);

    assertEquals(negateTest.eval(), testTrueConsBool.negateConstant());
    assertNotSame(nullConstant, negateTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //negate int
    negateTest = new Negate(testConsInt);

    assertSame(negateTest.eval(), testConsInt.negateConstant());
    assertSame(nullConstant, negateTest.eval());

    //negate float
    negateTest = new Negate(testConsFloat);

    assertSame(negateTest.eval(), testConsFloat.negateConstant());
    assertSame(nullConstant, negateTest.eval());

    //negate string
    negateTest = new Negate(testConsString);

    assertSame(negateTest.eval(), testConsString.negateConstant());
    assertSame(nullConstant, negateTest.eval());
  }
}