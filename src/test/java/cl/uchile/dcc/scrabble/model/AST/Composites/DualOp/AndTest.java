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

class AndTest extends CompositeTest {
  protected And andTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);

    And expectedInsertAnd = new And();

    expectedInsertAnd.insert(new And());
    expectedInsertAnd.insert(testTrueConsBool);
    expectedInsertAnd.insert(testFalseConsBool);

    expectedInsertAnd.insert(testTrueConsBool);;

    And expectedAndTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);

    assertEquals(andTest, expectedInsertAnd);
    assertEquals(expectedAndTest, andTest);
    assertEquals(expectedInsertAnd, expectedInsertAnd);
    assertNotEquals(expectedInsertAnd, new And());
    assertNotEquals(andTest, new And());
    assertNotEquals(andTest, testConsInt);

    assertFalse(andTest.hasNull());
    assertFalse(expectedAndTest.hasNull());
    assertFalse(expectedInsertAnd.hasNull());

    And voidAnd = new And();
    assertTrue(voidAnd.hasNull());

  }

  @RepeatedTest(100)
  void evalBooleansTest() {
    ConsBinary consBinary = testConsBinary[0];

    //bool | bool
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.and(testFalseConsBool)).and(testTrueConsBool);
    assertEquals(expectedTrueBoolBool, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

    //bool | bool
    andTest = new And(
        new And(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedAndBoolBool = (testFalseConsBool.and(testTrueConsBool)).and(testTrueConsBool);
    assertEquals(expectedAndBoolBool, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

    //bool | binary
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.and(testFalseConsBool)).and(consBinary);
    assertEquals(expectedTrueBinBool, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

    //bool | binary
    andTest = new And(
        new And(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedAndBinBool = (testFalseConsBool.and(testTrueConsBool)).and(consBinary);
    assertEquals(expectedAndBinBool, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

  }


  @RepeatedTest(100)
  void evalBinaryTest() {

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAndConsBinary1 = testConsBinary[1];
    ConsBinary toAndConsBinary2= testConsBinary[2];

    String toAndBinary3 = "0110101";
    ConsBinary toAndConsBinary3 = new ConsBinary(toAndBinary3);


    //binary | binary
    andTest = new And(
        new And(consBinary,
            toAndConsBinary1),
        new And(toAndConsBinary2, toAndConsBinary3));
    IConstant expectedAndBinary = (consBinary.and(toAndConsBinary1)).and(toAndConsBinary2.and(toAndConsBinary3));
    assertEquals(expectedAndBinary, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

    //binary | bool
    andTest = new And(
        new And(consBinary,
            toAndConsBinary1),
        new And(testTrueConsBool, testFalseConsBool));
    IConstant expectedAndBinaryBool = (consBinary.and(toAndConsBinary1)).and(testTrueConsBool.and(testFalseConsBool));
    assertEquals(expectedAndBinaryBool, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());

    //binary | bool
    andTest = new And(
        new And(consBinary,
            toAndConsBinary1),
        new And(testFalseConsBool, testTrueConsBool));
    IConstant expectedAndBoolBinary = (consBinary.and(toAndConsBinary1)).and(testFalseConsBool.and(testTrueConsBool));
    assertEquals(expectedAndBoolBinary, andTest.eval());
    assertNotSame(nullConstant, andTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    int toAndInt1 = rng.nextInt();
    ConsInt toAndConsInt1= new ConsInt(toAndInt1);

    double toAndDouble1 = rng.nextDouble();
    ConsFloat toAndConsFloat1 = new ConsFloat(toAndDouble1);

    //float | int
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        new And(testConsInt,
            toAndConsInt1));

    IConstant expectedConsInt = (testConsFloat.and(toAndConsFloat1)).and(testConsInt.and(toAndConsInt1));
    assertSame(expectedConsInt, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    double toAndDouble2 =rng.nextDouble();
    ConsFloat toAndConsFloat2= new ConsFloat(toAndDouble2);

    double toAndDouble3 =rng.nextDouble();
    ConsFloat toAndConsFloat3= new ConsFloat(toAndDouble3);

    //float | float
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        new And(toAndConsFloat2, toAndConsFloat3));
    IConstant expectedAndFloat = (testConsFloat.and(toAndConsFloat1)).and(toAndConsFloat2.and(toAndConsFloat3));
    assertSame(expectedAndFloat, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAndConsBinary = testConsBinary[1];

    //float | binary
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        new And(consBinary, toAndConsBinary));
    IConstant expectedAndBinary = (testConsFloat.and(toAndConsFloat1)).and(consBinary.and(toAndConsBinary));
    assertSame(expectedAndBinary, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    int toAndInt2 =rng.nextInt();
    ConsInt toAndConsInt2= new ConsInt(toAndInt2);

    int toAndInt3 = rng.nextInt();
    ConsInt toAndConsInt3= new ConsInt(toAndInt3);

    // int | int
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        new And(toAndConsInt2,
            toAndConsInt3));

    IConstant expectedAndConsInt = (testConsInt.and(toAndConsInt1)).and(toAndConsInt2.and(toAndConsInt3));
    assertSame(expectedAndConsInt, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    double toAndDouble = rng.nextDouble();
    ConsFloat toAndConsFloat = new ConsFloat(toAndDouble);

    // int | float
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        new And(testConsFloat, toAndConsFloat));
    IConstant expectedAndIntFloat = (testConsInt.and(toAndConsInt1)).and(testConsFloat.and(toAndConsFloat));
    assertSame(expectedAndIntFloat, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    // int | binary
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        new And(consBinary, toAndConsBinary));
    IConstant expectedAndIntBinary = (testConsInt.and(toAndConsInt1)).and(consBinary.and(toAndConsBinary));
    assertSame(expectedAndIntBinary, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    String toAndString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAndConsString1= new ConsString(toAndString1);

    String toAndString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAndConsString2= new ConsString(toAndString2);

    String toAndString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAndConsString3= new ConsString(toAndString3);

    ConsBinary toAndConsBinary1 = testConsBinary[1];

    //binary | int
    andTest = new And(
        new And(consBinary,
            toAndConsBinary1),
        new And(testConsInt,
            toAndConsInt1));

    IConstant expectedConsBinInt = (consBinary.and(toAndConsBinary1)).and(testConsInt.and(toAndConsInt1));
    assertSame(expectedConsBinInt, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    //String | String
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        new And(toAndConsString2,
            toAndConsString3));

    IConstant expectedConsString = (testConsString.and(toAndConsString1)).and(toAndConsString2.and(toAndConsString3));
    assertSame(expectedConsString, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    int toAndInt = rng.nextInt();
    ConsInt toAndConsInt = new ConsInt(toAndInt);

    //String | int
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        new And(testConsInt, toAndConsInt));
    IConstant expectedAndInt = (testConsString.and(toAndConsString1)).and(testConsInt.and(toAndConsInt));
    assertSame(expectedAndInt, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    double toAndSDouble = rng.nextDouble();
    ConsFloat toAndConsSFloat = new ConsFloat(toAndSDouble);
    //String | float
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        new And(testConsFloat, toAndConsSFloat));
    IConstant expectedAndStringFloat = (testConsString.and(toAndConsString1)).and(testConsFloat.and(toAndConsSFloat));
    assertSame(expectedAndStringFloat, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    //String | true bool
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        testTrueConsBool);
    IConstant expectedAndTrueBool = (testConsString.and(toAndConsString1)).and(testTrueConsBool);
    assertSame(expectedAndTrueBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //String | false bool
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        testFalseConsBool);
    IConstant expectedAndFalseBool = (testConsString.and(toAndConsString1)).and(testFalseConsBool);
    assertSame(expectedAndFalseBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());



    //String | binary
    andTest = new And(
        new And(testConsString,
            toAndConsString1),
        new And(consBinary, toAndConsBinary));
    IConstant expectedAndSBinary = (testConsString.and(toAndConsString1)).and(consBinary.and(toAndConsBinary));
    assertSame(expectedAndSBinary, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    //int | true bool
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        testTrueConsBool);
    IConstant expectedAndIntTrueBool = (testConsInt.and(toAndConsInt1)).and(testTrueConsBool);
    assertSame(expectedAndIntTrueBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //int | false bool
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        testFalseConsBool);
    IConstant expectedAndIntFalseBool = (testConsInt.and(toAndConsInt1)).and(testFalseConsBool);
    assertSame(expectedAndIntFalseBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //bool | int
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.and(testFalseConsBool)).and(testConsInt);
    assertSame(expectedTrueBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //bool | int
    andTest = new And(
        new And(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedAndBool = (testFalseConsBool.and(testTrueConsBool)).and(testConsInt);
    assertSame(expectedAndBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    String toAndString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAndConsString= new ConsString(toAndString);

    //int | string
    andTest = new And(
        new And(testConsInt,
            toAndConsInt1),
        new And(testConsString, toAndConsString));
    IConstant expectedAndIntStr = (testConsInt.and(toAndConsInt1)).and(testConsString.and(toAndConsString));
    assertSame(expectedAndIntStr, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    //float | true bool
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        testTrueConsBool);
    IConstant expectedAndFTrueBool = (testConsFloat.and(toAndConsFloat1)).and(testTrueConsBool);
    assertSame(expectedAndFTrueBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //float | false bool
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        testFalseConsBool);
    IConstant expectedAndFFalseBool = (testConsFloat.and(toAndConsFloat1)).and(testFalseConsBool);
    assertSame(expectedAndFFalseBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    // float | string
    andTest = new And(
        new And(testConsFloat,
            toAndConsFloat1),
        new And(testConsString, toAndConsString));
    IConstant expectedAndFString = (testConsFloat.and(toAndConsFloat1)).and(testConsString.and(toAndConsString));
    assertSame(expectedAndFString, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    ConsBinary toAndConsFBinary1 = testConsBinary[1];

    //binary | float
    andTest = new And(
        new And(consBinary,
            toAndConsFBinary1),
        new And(testConsFloat,
            toAndConsFloat1));

    IConstant expectedConsFInt = (consBinary.and(toAndConsFBinary1)).and(testConsFloat.and(toAndConsFloat1));
    assertSame(expectedConsFInt, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //bool | float
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.and(testFalseConsBool)).and(testConsFloat);
    assertSame(expectedTrueFBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //bool | int
    andTest = new And(
        new And(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedAndFBool = (testFalseConsBool.and(testTrueConsBool)).and(testConsFloat);
    assertSame(expectedAndFBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());


    //bool | string
    andTest = new And(
        new And(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.and(testFalseConsBool)).and(testConsString);
    assertSame(expectedTrueStringBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());

    //bool | string
    andTest = new And(
        new And(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedAndStringBool = (testFalseConsBool.and(testTrueConsBool)).and(testConsString);
    assertSame(expectedAndStringBool, andTest.eval());
    assertSame(nullConstant, andTest.eval());
  }
}