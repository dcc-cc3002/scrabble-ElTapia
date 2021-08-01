package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToBinaryTest extends CompositeTest {
  protected ToBinary toBinaryTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    toBinaryTest = new ToBinary(testConsInt);

    ToBinary expectedInsertTest = new ToBinary();
    expectedInsertTest.insert(testConsInt);

    ToBinary expectedToBinaryTest = new ToBinary(testConsInt);

    assertEquals(expectedInsertTest, this.toBinaryTest);
    assertEquals(expectedToBinaryTest, toBinaryTest);
    assertNotEquals(this.toBinaryTest, testTrueConsBool);
    assertFalse(toBinaryTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    ToBinary voidToBinary = new ToBinary();
    assertTrue(voidToBinary.hasNull());

    toBinaryTest = new ToBinary(new ToBinary(testConsInt));

    ToBinary expectedInsertToBinaryTest = new ToBinary();
    expectedInsertToBinaryTest.insert(new ToBinary());
    expectedInsertToBinaryTest.insert(testConsInt);

    assertEquals(expectedInsertToBinaryTest, toBinaryTest);
    assertFalse(expectedInsertToBinaryTest.hasNull());

  }

  @RepeatedTest(100)
  void eval(){
    //int to binary
    toBinaryTest = new ToBinary(testConsInt);

    assertEquals(toBinaryTest.eval(), testConsInt.toConstantBinary());
    assertNotSame(nullConstant, toBinaryTest.eval());

    //binary to binary
    toBinaryTest = new ToBinary(testConsBinary[0]);

    assertEquals(toBinaryTest.eval(), testConsBinary[0].toConstantBinary());
    assertNotSame(nullConstant, toBinaryTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //float to binary
    toBinaryTest = new ToBinary(testConsFloat);

    assertSame(toBinaryTest.eval(), testConsFloat.toConstantBinary());
    assertSame(nullConstant, toBinaryTest.eval());

    //string to binary
    toBinaryTest = new ToBinary(testConsString);

    assertSame(toBinaryTest.eval(), testConsString.toConstantBinary());
    assertSame(nullConstant, toBinaryTest.eval());

    // false bool to binary
    toBinaryTest = new ToBinary(testFalseConsBool);

    assertSame(toBinaryTest.eval(), testFalseConsBool.toConstantBinary());
    assertSame(nullConstant, toBinaryTest.eval());

    // true bool to binary
    toBinaryTest = new ToBinary(testTrueConsBool);

    assertSame(toBinaryTest.eval(), testTrueConsBool.toConstantBinary());
    assertSame(nullConstant, toBinaryTest.eval());
  }
}