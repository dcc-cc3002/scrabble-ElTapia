package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToIntTest extends CompositeTest{
  protected ToInt toIntTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    toIntTest = new ToInt(testConsInt);

    ToInt expectedInsertTest = new ToInt();
    expectedInsertTest.insert(testConsInt);

    ToInt expectedToIntTest = new ToInt(testConsInt);

    assertEquals(expectedInsertTest, this.toIntTest);
    assertEquals(expectedToIntTest, toIntTest);
    assertNotEquals(this.toIntTest, testTrueConsBool);
    assertFalse(toIntTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    ToInt voidToInt = new ToInt();
    assertTrue(voidToInt.hasNull());

  }

  @RepeatedTest(100)
  void eval(){
    //int to int
    toIntTest = new ToInt(testConsInt);

    assertEquals(toIntTest.eval(), testConsInt.toConstantInt());
    assertNotSame(nullConstant, toIntTest.eval());

    //binary to int
    toIntTest = new ToInt(testConsBinary[0]);

    assertEquals(toIntTest.eval(), testConsBinary[0].toConstantInt());
    assertNotSame(nullConstant, toIntTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //float to int
    toIntTest = new ToInt(testConsFloat);

    assertSame(toIntTest.eval(), testConsFloat.toConstantInt());
    assertSame(nullConstant, toIntTest.eval());

    //string to int
    toIntTest = new ToInt(testConsString);

    assertSame(toIntTest.eval(), testConsString.toConstantInt());
    assertSame(nullConstant, toIntTest.eval());

    // false bool to int
    toIntTest = new ToInt(testFalseConsBool);

    assertSame(toIntTest.eval(), testFalseConsBool.toConstantInt());
    assertSame(nullConstant, toIntTest.eval());

    // true bool to int
    toIntTest = new ToInt(testTrueConsBool);

    assertSame(toIntTest.eval(), testTrueConsBool.toConstantInt());
    assertSame(nullConstant, toIntTest.eval());
  }
}