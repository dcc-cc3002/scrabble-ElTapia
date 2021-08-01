package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToFloatTest extends CompositeTest {
  protected ToFloat toFloatTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    toFloatTest = new ToFloat(testConsInt);

    ToFloat expectedInsertTest = new ToFloat();
    expectedInsertTest.insert(testConsInt);

    ToFloat expectedToFloatTest = new ToFloat(testConsInt);

    assertEquals(expectedInsertTest, this.toFloatTest);
    assertEquals(expectedToFloatTest, toFloatTest);
    assertNotEquals(this.toFloatTest, testTrueConsBool);
    assertFalse(toFloatTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    ToFloat voidToFloat = new ToFloat();
    assertTrue(voidToFloat.hasNull());

  }

  @RepeatedTest(100)
  void eval(){
    //int to float
    toFloatTest = new ToFloat(testConsInt);

    assertEquals(toFloatTest.eval(), testConsInt.toConstantFloat());
    assertNotSame(nullConstant, toFloatTest.eval());

    //binary to float
    toFloatTest = new ToFloat(testConsBinary[0]);

    assertEquals(toFloatTest.eval(), testConsBinary[0].toConstantFloat());
    assertNotSame(nullConstant, toFloatTest.eval());

    //float to float
    toFloatTest = new ToFloat(testConsFloat);

    assertEquals(toFloatTest.eval(), testConsFloat.toConstantFloat());
    assertNotSame(nullConstant, toFloatTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //string to float
    toFloatTest = new ToFloat(testConsString);

    assertSame(toFloatTest.eval(), testConsString.toConstantFloat());
    assertSame(nullConstant, toFloatTest.eval());

    // false bool to float
    toFloatTest = new ToFloat(testFalseConsBool);

    assertSame(toFloatTest.eval(), testFalseConsBool.toConstantFloat());
    assertSame(nullConstant, toFloatTest.eval());

    // true bool to float
    toFloatTest = new ToFloat(testTrueConsBool);

    assertSame(toFloatTest.eval(), testTrueConsBool.toConstantFloat());
    assertSame(nullConstant, toFloatTest.eval());
  }
}