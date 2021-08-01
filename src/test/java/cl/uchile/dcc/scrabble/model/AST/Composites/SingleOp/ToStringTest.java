package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToStringTest extends CompositeTest {
  protected ToString toStringTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    toStringTest = new ToString(testConsInt);

    ToString expectedInsertTest = new ToString();
    expectedInsertTest.insert(testConsInt);

    ToString expectedToStringTest = new ToString(testConsInt);

    assertEquals(expectedInsertTest, this.toStringTest);
    assertEquals(expectedToStringTest, toStringTest);
    assertNotEquals(this.toStringTest, testTrueConsBool);
    assertFalse(toStringTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    ToString voidToString = new ToString();
    assertTrue(voidToString.hasNull());

  }

  @RepeatedTest(100)
  void eval(){

    //string to string
    toStringTest = new ToString(testConsString);

    assertEquals(toStringTest.eval(), testConsString.toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());

    //int to string
    toStringTest = new ToString(testConsInt);

    assertEquals(toStringTest.eval(), testConsInt.toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());

    //float to string
    toStringTest = new ToString(testConsFloat);

    assertEquals(toStringTest.eval(), testConsFloat.toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());

    //binary to string
    toStringTest = new ToString(testConsBinary[0]);

    assertEquals(toStringTest.eval(), testConsBinary[0].toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());

    //false bool to string
    toStringTest = new ToString(testFalseConsBool);

    assertEquals(toStringTest.eval(), testFalseConsBool.toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());

    //true bool to string
    toStringTest = new ToString(testTrueConsBool);

    assertEquals(toStringTest.eval(), testTrueConsBool.toConstantStr());
    assertNotSame(nullConstant, toStringTest.eval());
  }
}