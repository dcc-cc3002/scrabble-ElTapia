package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsBinary;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsFloat;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsInt;
import cl.uchile.dcc.scrabble.model.AST.Constants.ConsString;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TimesTest extends CompositeTest {
  protected Times timesTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){
    timesTest = new Times(
        new Times(testConsFloat,
            testConsInt),
        new Times(testConsFloat,
            testConsBinary[0]));

    Times expectedInsertTimes = new Times();

    expectedInsertTimes.insert(new Times());
    expectedInsertTimes.insert(testConsFloat);
    expectedInsertTimes.insert(testConsInt);

    expectedInsertTimes.insert(new Times());
    expectedInsertTimes.insert(testConsFloat);
    expectedInsertTimes.insert(testConsBinary[0]);

    Times expectedTimesTest = new Times(
        new Times(testConsFloat,
            testConsInt),
        new Times(testConsFloat,
            testConsBinary[0]));

    assertEquals(timesTest, expectedInsertTimes);
    assertEquals(expectedTimesTest, timesTest);
    assertEquals(expectedInsertTimes, expectedInsertTimes);
    assertNotEquals(expectedInsertTimes, new Times());
    assertNotEquals(timesTest, new Times());
    assertNotEquals(timesTest, testConsInt);

    assertFalse(timesTest.hasNull());
    assertFalse(expectedTimesTest.hasNull());
    assertFalse(expectedInsertTimes.hasNull());

    Times voidTimes = new Times();
    assertTrue(voidTimes.hasNull());

    timesTest = new Times();
    timesTest.insert(testConsString);
    timesTest.insert(testConsInt);

    String expectedString = "Times( \n\t" + testConsString.toString() + "\n\t" + testConsInt.toString() + "\n\t)";
    assertEquals(expectedString, timesTest.toString());

  }

  @RepeatedTest(100)
  void evalIntsTest() {

    int toTimesInt1 = rng.nextInt();
    ConsInt toTimesConsInt1= new ConsInt(toTimesInt1);

    int toTimesInt2 =rng.nextInt();
    ConsInt toTimesConsInt2= new ConsInt(toTimesInt2);

    int toTimesInt3 = rng.nextInt();
    ConsInt toTimesConsInt3= new ConsInt(toTimesInt3);

    // int * int
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        new Times(toTimesConsInt2,
            toTimesConsInt3));

    IConstant expectedConsInt = (testConsInt.times(toTimesConsInt1)).times(toTimesConsInt2.times(toTimesConsInt3));
    assertEquals(expectedConsInt, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());


    double toTimesDouble = rng.nextDouble();
    ConsFloat toTimesConsFloat = new ConsFloat(toTimesDouble);

    // int * float
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        new Times(testConsFloat, toTimesConsFloat));
    IConstant expectedTimesFloat = (testConsInt.times(toTimesConsInt1)).times(testConsFloat.times(toTimesConsFloat));
    assertEquals(expectedTimesFloat, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toTimesConsBinary = testConsBinary[1];

    // int * binary
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        new Times(consBinary, toTimesConsBinary));
    IConstant expectedTimesBinary = (testConsInt.times(toTimesConsInt1)).times(consBinary.times(toTimesConsBinary));
    assertEquals(expectedTimesBinary, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());
  }

  @RepeatedTest(100)
  void evalFloatsTest() {

    int toTimesInt1 = rng.nextInt();
    ConsInt toTimesConsInt1= new ConsInt(toTimesInt1);

    double toTimesDouble1 = rng.nextDouble();
    ConsFloat toTimesConsFloat1 = new ConsFloat(toTimesDouble1);

    //float * int
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        new Times(testConsInt,
            toTimesConsInt1));

    IConstant expectedConsInt = (testConsFloat.times(toTimesConsFloat1)).times(testConsInt.times(toTimesConsInt1));
    assertEquals(expectedConsInt, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());

    double toTimesDouble2 =rng.nextDouble();
    ConsFloat toTimesConsFloat2= new ConsFloat(toTimesDouble2);

    double toTimesDouble3 =rng.nextDouble();
    ConsFloat toTimesConsFloat3= new ConsFloat(toTimesDouble3);

    //float * float
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        new Times(toTimesConsFloat2, toTimesConsFloat3));
    IConstant expectedTimesFloat = (testConsFloat.times(toTimesConsFloat1)).times(toTimesConsFloat2.times(toTimesConsFloat3));
    assertEquals(expectedTimesFloat, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toTimesConsBinary = testConsBinary[1];

    //float * binary
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        new Times(consBinary, toTimesConsBinary));
    IConstant expectedTimesBinary = (testConsFloat.times(toTimesConsFloat1)).times(consBinary.times(toTimesConsBinary));
    assertEquals(expectedTimesBinary, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());
  }

  @RepeatedTest(100)
  void evalBinaryTest() {
    int toTimesInt1 = rng.nextInt();
    ConsInt toTimesConsInt1= new ConsInt(toTimesInt1);

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toTimesConsBinary1 = testConsBinary[1];
    ConsBinary toTimesConsBinary2= testConsBinary[2];

    String toTimesBinary3 = "0110101";
    ConsBinary toTimesConsBinary3 = new ConsBinary(toTimesBinary3);

    //binary * int
    timesTest = new Times(
        new Times(consBinary,
            toTimesConsBinary1),
        new Times(testConsInt,
            toTimesConsInt1));

    IConstant expectedConsInt = (consBinary.times(toTimesConsBinary1)).times(testConsInt.times(toTimesConsInt1));
    assertEquals(expectedConsInt, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());


    //binary * binary
    timesTest = new Times(
        new Times(consBinary,
            toTimesConsBinary1),
        new Times(toTimesConsBinary2, toTimesConsBinary3));
    IConstant expectedTimesBinary = (consBinary.times(toTimesConsBinary1)).times(toTimesConsBinary2.times(toTimesConsBinary3));
    assertEquals(expectedTimesBinary, timesTest.eval());
    assertNotSame(nullConstant, timesTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    String toTimesString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toTimesConsString1= new ConsString(toTimesString1);

    String toTimesString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toTimesConsString2= new ConsString(toTimesString2);

    String toTimesString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toTimesConsString3= new ConsString(toTimesString3);

    //String * String
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        new Times(toTimesConsString2,
            toTimesConsString3));

    IConstant expectedConsString = (testConsString.times(toTimesConsString1)).times(toTimesConsString2.times(toTimesConsString3));
    assertEquals(expectedConsString, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    int toTimesInt = rng.nextInt();
    ConsInt toTimesConsInt = new ConsInt(toTimesInt);
    //String * int
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        new Times(testConsInt, toTimesConsInt));
    IConstant expectedTimesInt = (testConsString.times(toTimesConsString1)).times(testConsInt.times(toTimesConsInt));
    assertEquals(expectedTimesInt, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    double toTimesDouble = rng.nextDouble();
    ConsFloat toTimesConsFloat = new ConsFloat(toTimesDouble);
    //String * float
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        new Times(testConsFloat, toTimesConsFloat));
    IConstant expectedTimesFloat = (testConsString.times(toTimesConsString1)).times(testConsFloat.times(toTimesConsFloat));
    assertEquals(expectedTimesFloat, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    //String * true bool
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        testTrueConsBool);
    IConstant expectedTimesTrueBool = (testConsString.times(toTimesConsString1)).times(testTrueConsBool);
    assertEquals(expectedTimesTrueBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //String * false bool
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        testFalseConsBool);
    IConstant expectedTimesFalseBool = (testConsString.times(toTimesConsString1)).times(testFalseConsBool);
    assertEquals(expectedTimesFalseBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toTimesConsBinary = testConsBinary[1];

    //String * binary
    timesTest = new Times(
        new Times(testConsString,
            toTimesConsString1),
        new Times(consBinary, toTimesConsBinary));
    IConstant expectedTimesBinary = (testConsString.times(toTimesConsString1)).times(consBinary.times(toTimesConsBinary));
    assertEquals(expectedTimesBinary, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    int toTimesInt1 = rng.nextInt();
    ConsInt toTimesConsInt1= new ConsInt(toTimesInt1);

    //int * true bool
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        testTrueConsBool);
    IConstant expectedTimesIntTrueBool = (testConsInt.times(toTimesConsInt1)).times(testTrueConsBool);
    assertSame(expectedTimesIntTrueBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //int * false bool
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        testFalseConsBool);
    IConstant expectedTimesIntFalseBool = (testConsInt.times(toTimesConsInt1)).times(testFalseConsBool);
    assertSame(expectedTimesIntFalseBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * int
    timesTest = new Times(
        new Times(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.times(testFalseConsBool)).times(testConsInt);
    assertSame(expectedTrueBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * int
    timesTest = new Times(
        new Times(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedTimesBool = (testFalseConsBool.times(testTrueConsBool)).times(testConsInt);
    assertSame(expectedTimesBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    String toTimesString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toTimesConsString= new ConsString(toTimesString);

    //int * string
    timesTest = new Times(
        new Times(testConsInt,
            toTimesConsInt1),
        new Times(testConsString, toTimesConsString));
    IConstant expectedTimesIntStr = (testConsInt.times(toTimesConsInt1)).times(testConsString.times(toTimesConsString));
    assertSame(expectedTimesIntStr, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    double toTimesDouble1 = rng.nextDouble();
    ConsFloat toTimesConsFloat1 = new ConsFloat(toTimesDouble1);

    //float * true bool
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        testTrueConsBool);
    IConstant expectedTimesFTrueBool = (testConsFloat.times(toTimesConsFloat1)).times(testTrueConsBool);
    assertSame(expectedTimesFTrueBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //float * false bool
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        testFalseConsBool);
    IConstant expectedTimesFFalseBool = (testConsFloat.times(toTimesConsFloat1)).times(testFalseConsBool);
    assertSame(expectedTimesFFalseBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    // float * string
    timesTest = new Times(
        new Times(testConsFloat,
            toTimesConsFloat1),
        new Times(testConsString, toTimesConsString));
    IConstant expectedTimesFString = (testConsFloat.times(toTimesConsFloat1)).times(testConsString.times(toTimesConsString));
    assertSame(expectedTimesFString, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());


    ConsBinary toTimesConsBinary1 = testConsBinary[1];

    //binary * float
    timesTest = new Times(
        new Times(consBinary,
            toTimesConsBinary1),
        new Times(testConsFloat,
            toTimesConsFloat1));

    IConstant expectedConsInt = (consBinary.times(toTimesConsBinary1)).times(testConsFloat.times(toTimesConsFloat1));
    assertSame(expectedConsInt, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * float
    timesTest = new Times(
        new Times(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.times(testFalseConsBool)).times(testConsFloat);
    assertSame(expectedTrueFBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * int
    timesTest = new Times(
        new Times(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedTimesFBool = (testFalseConsBool.times(testTrueConsBool)).times(testConsFloat);
    assertSame(expectedTimesFBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * binary
    timesTest = new Times(
        new Times(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.times(testFalseConsBool)).times(consBinary);
    assertSame(expectedTrueBinBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * binary
    timesTest = new Times(
        new Times(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedTimesBinBool = (testFalseConsBool.times(testTrueConsBool)).times(consBinary);
    assertSame(expectedTimesBinBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * string
    timesTest = new Times(
        new Times(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.times(testFalseConsBool)).times(testConsString);
    assertSame(expectedTrueStringBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * string
    timesTest = new Times(
        new Times(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedTimesStringBool = (testFalseConsBool.times(testTrueConsBool)).times(testConsString);
    assertSame(expectedTimesStringBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * bool
    timesTest = new Times(
        new Times(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.times(testFalseConsBool)).times(testTrueConsBool);
    assertSame(expectedTrueBoolBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());

    //bool * bool
    timesTest = new Times(
        new Times(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedTimesBoolBool = (testFalseConsBool.times(testTrueConsBool)).times(testTrueConsBool);
    assertSame(expectedTimesBoolBool, timesTest.eval());
    assertSame(nullConstant, timesTest.eval());
  }
}