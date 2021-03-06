package cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ToBoolTest extends CompositeTest {
  protected ToBool toBoolTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){

    toBoolTest = new ToBool(testFalseConsBool);

    ToBool expectedInsertTest = new ToBool();
    expectedInsertTest.insert(testFalseConsBool);

    ToBool expectedToBoolTest = new ToBool(testFalseConsBool);

    assertEquals(expectedInsertTest, this.toBoolTest);
    assertEquals(expectedToBoolTest, toBoolTest);
    assertNotEquals(this.toBoolTest, testTrueConsBool);
    assertFalse(toBoolTest.hasNull());
    assertFalse(expectedInsertTest.hasNull());

    ToBool voidToBool = new ToBool();
    assertTrue(voidToBool.hasNull());

    toBoolTest = new ToBool(new ToBool(testFalseConsBool));

    ToBool expectedInsertToBoolTest = new ToBool();
    expectedInsertToBoolTest.insert(new ToBool());
    expectedInsertToBoolTest.insert(testFalseConsBool);

    assertEquals(expectedInsertToBoolTest, toBoolTest);
    assertFalse(expectedInsertToBoolTest.hasNull());

    toBoolTest = new ToBool();
    toBoolTest.insert(testConsString);

    String expectedString = "ToBool( \n\t" + testConsString.toString() + "\n\t)";
    assertEquals(expectedString, toBoolTest.toString());
  }

  @RepeatedTest(100)
  void eval(){
    // false bool to bool
    toBoolTest = new ToBool(testFalseConsBool);

    assertEquals(toBoolTest.eval(), testFalseConsBool.toConstantBool());
    assertNotSame(nullConstant, toBoolTest.eval());

    // true bool to bool
    toBoolTest = new ToBool(testTrueConsBool);

    assertEquals(toBoolTest.eval(), testTrueConsBool.toConstantBool());
    assertNotSame(nullConstant, toBoolTest.eval());
  }

  @RepeatedTest(100)
  void nullOps(){
    //float to bool
    toBoolTest = new ToBool(testConsFloat);

    assertSame(toBoolTest.eval(), testConsFloat.toConstantBool());
    assertSame(nullConstant, toBoolTest.eval());

    //string to bool
    toBoolTest = new ToBool(testConsString);

    assertSame(toBoolTest.eval(), testConsString.toConstantBool());
    assertSame(nullConstant, toBoolTest.eval());

    //int to bool
    toBoolTest = new ToBool(testConsInt);

    assertSame(toBoolTest.eval(), testConsInt.toConstantBool());
    assertSame(nullConstant, toBoolTest.eval());

    //binary to bool
    toBoolTest = new ToBool(testConsBinary[0]);

    assertSame(toBoolTest.eval(), testConsBinary[0].toConstantBool());
    assertSame(nullConstant, toBoolTest.eval());
  }


}