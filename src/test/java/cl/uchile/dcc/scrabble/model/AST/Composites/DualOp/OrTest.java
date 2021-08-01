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

class OrTest extends CompositeTest {

  protected Or orTest;

  @BeforeEach
  public void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);

    Or expectedInsertOr = new Or();

    expectedInsertOr.insert(new Or());
    expectedInsertOr.insert(testTrueConsBool);
    expectedInsertOr.insert(testFalseConsBool);

    expectedInsertOr.insert(testTrueConsBool);;

    Or expectedOrTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);

    assertEquals(orTest, expectedInsertOr);
    assertEquals(expectedOrTest, orTest);
    assertEquals(expectedInsertOr, expectedInsertOr);
    assertNotEquals(expectedInsertOr, new Or());
    assertNotEquals(orTest, new Or());
    assertNotEquals(orTest, testConsInt);

    assertFalse(orTest.hasNull());
    assertFalse(expectedOrTest.hasNull());
    assertFalse(expectedInsertOr.hasNull());

    Or voidOr = new Or();
    assertTrue(voidOr.hasNull());

  }

  @RepeatedTest(100)
  void evalBooleansTest() {
    ConsBinary consBinary = testConsBinary[0];

    //bool | bool
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.or(testFalseConsBool)).or(testTrueConsBool);
    assertEquals(expectedTrueBoolBool, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

    //bool | bool
    orTest = new Or(
        new Or(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedOrBoolBool = (testFalseConsBool.or(testTrueConsBool)).or(testTrueConsBool);
    assertEquals(expectedOrBoolBool, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

    //bool | binary
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.or(testFalseConsBool)).or(consBinary);
    assertEquals(expectedTrueBinBool, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

    //bool | binary
    orTest = new Or(
        new Or(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedOrBinBool = (testFalseConsBool.or(testTrueConsBool)).or(consBinary);
    assertEquals(expectedOrBinBool, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

  }


  @RepeatedTest(100)
  void evalBinaryTest() {

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toOrConsBinary1 = testConsBinary[1];
    ConsBinary toOrConsBinary2= testConsBinary[2];

    String toOrBinary3 = "0110101";
    ConsBinary toOrConsBinary3 = new ConsBinary(toOrBinary3);


    //binary | binary
    orTest = new Or(
        new Or(consBinary,
            toOrConsBinary1),
        new Or(toOrConsBinary2, toOrConsBinary3));
    IConstant expectedOrBinary = (consBinary.or(toOrConsBinary1)).or(toOrConsBinary2.or(toOrConsBinary3));
    assertEquals(expectedOrBinary, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

    //binary | bool
    orTest = new Or(
        new Or(consBinary,
            toOrConsBinary1),
        new Or(testTrueConsBool, testFalseConsBool));
    IConstant expectedOrBinaryBool = (consBinary.or(toOrConsBinary1)).or(testTrueConsBool.or(testFalseConsBool));
    assertEquals(expectedOrBinaryBool, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());

    //binary | bool
    orTest = new Or(
        new Or(consBinary,
            toOrConsBinary1),
        new Or(testFalseConsBool, testTrueConsBool));
    IConstant expectedOrBoolBinary = (consBinary.or(toOrConsBinary1)).or(testFalseConsBool.or(testTrueConsBool));
    assertEquals(expectedOrBoolBinary, orTest.eval());
    assertNotSame(nullConstant, orTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    int toOrInt1 = rng.nextInt();
    ConsInt toOrConsInt1= new ConsInt(toOrInt1);

    double toOrDouble1 = rng.nextDouble();
    ConsFloat toOrConsFloat1 = new ConsFloat(toOrDouble1);

    //float | int
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        new Or(testConsInt,
            toOrConsInt1));

    IConstant expectedConsInt = (testConsFloat.or(toOrConsFloat1)).or(testConsInt.or(toOrConsInt1));
    assertSame(expectedConsInt, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    double toOrDouble2 =rng.nextDouble();
    ConsFloat toOrConsFloat2= new ConsFloat(toOrDouble2);

    double toOrDouble3 =rng.nextDouble();
    ConsFloat toOrConsFloat3= new ConsFloat(toOrDouble3);

    //float | float
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        new Or(toOrConsFloat2, toOrConsFloat3));
    IConstant expectedOrFloat = (testConsFloat.or(toOrConsFloat1)).or(toOrConsFloat2.or(toOrConsFloat3));
    assertSame(expectedOrFloat, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toOrConsBinary = testConsBinary[1];

    //float | binary
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        new Or(consBinary, toOrConsBinary));
    IConstant expectedOrBinary = (testConsFloat.or(toOrConsFloat1)).or(consBinary.or(toOrConsBinary));
    assertSame(expectedOrBinary, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    int toOrInt2 =rng.nextInt();
    ConsInt toOrConsInt2= new ConsInt(toOrInt2);

    int toOrInt3 = rng.nextInt();
    ConsInt toOrConsInt3= new ConsInt(toOrInt3);

    // int | int
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        new Or(toOrConsInt2,
            toOrConsInt3));

    IConstant expectedOrConsInt = (testConsInt.or(toOrConsInt1)).or(toOrConsInt2.or(toOrConsInt3));
    assertSame(expectedOrConsInt, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    double toOrDouble = rng.nextDouble();
    ConsFloat toOrConsFloat = new ConsFloat(toOrDouble);

    // int | float
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        new Or(testConsFloat, toOrConsFloat));
    IConstant expectedOrIntFloat = (testConsInt.or(toOrConsInt1)).or(testConsFloat.or(toOrConsFloat));
    assertSame(expectedOrIntFloat, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    // int | binary
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        new Or(consBinary, toOrConsBinary));
    IConstant expectedOrIntBinary = (testConsInt.or(toOrConsInt1)).or(consBinary.or(toOrConsBinary));
    assertSame(expectedOrIntBinary, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    String toOrString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toOrConsString1= new ConsString(toOrString1);

    String toOrString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toOrConsString2= new ConsString(toOrString2);

    String toOrString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toOrConsString3= new ConsString(toOrString3);

    ConsBinary toOrConsBinary1 = testConsBinary[1];

    //binary | int
    orTest = new Or(
        new Or(consBinary,
            toOrConsBinary1),
        new Or(testConsInt,
            toOrConsInt1));

    IConstant expectedConsBinInt = (consBinary.or(toOrConsBinary1)).or(testConsInt.or(toOrConsInt1));
    assertSame(expectedConsBinInt, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    //String | String
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        new Or(toOrConsString2,
            toOrConsString3));

    IConstant expectedConsString = (testConsString.or(toOrConsString1)).or(toOrConsString2.or(toOrConsString3));
    assertSame(expectedConsString, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    int toOrInt = rng.nextInt();
    ConsInt toOrConsInt = new ConsInt(toOrInt);

    //String | int
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        new Or(testConsInt, toOrConsInt));
    IConstant expectedOrInt = (testConsString.or(toOrConsString1)).or(testConsInt.or(toOrConsInt));
    assertSame(expectedOrInt, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    double toOrSDouble = rng.nextDouble();
    ConsFloat toOrConsSFloat = new ConsFloat(toOrSDouble);
    //String | float
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        new Or(testConsFloat, toOrConsSFloat));
    IConstant expectedOrStringFloat = (testConsString.or(toOrConsString1)).or(testConsFloat.or(toOrConsSFloat));
    assertSame(expectedOrStringFloat, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    //String | true bool
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        testTrueConsBool);
    IConstant expectedOrTrueBool = (testConsString.or(toOrConsString1)).or(testTrueConsBool);
    assertSame(expectedOrTrueBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //String | false bool
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        testFalseConsBool);
    IConstant expectedOrFalseBool = (testConsString.or(toOrConsString1)).or(testFalseConsBool);
    assertSame(expectedOrFalseBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());



    //String | binary
    orTest = new Or(
        new Or(testConsString,
            toOrConsString1),
        new Or(consBinary, toOrConsBinary));
    IConstant expectedOrSBinary = (testConsString.or(toOrConsString1)).or(consBinary.or(toOrConsBinary));
    assertSame(expectedOrSBinary, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    //int | true bool
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        testTrueConsBool);
    IConstant expectedOrIntTrueBool = (testConsInt.or(toOrConsInt1)).or(testTrueConsBool);
    assertSame(expectedOrIntTrueBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //int | false bool
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        testFalseConsBool);
    IConstant expectedOrIntFalseBool = (testConsInt.or(toOrConsInt1)).or(testFalseConsBool);
    assertSame(expectedOrIntFalseBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //bool | int
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.or(testFalseConsBool)).or(testConsInt);
    assertSame(expectedTrueBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //bool | int
    orTest = new Or(
        new Or(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedOrBool = (testFalseConsBool.or(testTrueConsBool)).or(testConsInt);
    assertSame(expectedOrBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    String toOrString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toOrConsString= new ConsString(toOrString);

    //int | string
    orTest = new Or(
        new Or(testConsInt,
            toOrConsInt1),
        new Or(testConsString, toOrConsString));
    IConstant expectedOrIntStr = (testConsInt.or(toOrConsInt1)).or(testConsString.or(toOrConsString));
    assertSame(expectedOrIntStr, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    //float | true bool
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        testTrueConsBool);
    IConstant expectedOrFTrueBool = (testConsFloat.or(toOrConsFloat1)).or(testTrueConsBool);
    assertSame(expectedOrFTrueBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //float | false bool
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        testFalseConsBool);
    IConstant expectedOrFFalseBool = (testConsFloat.or(toOrConsFloat1)).or(testFalseConsBool);
    assertSame(expectedOrFFalseBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    // float | string
    orTest = new Or(
        new Or(testConsFloat,
            toOrConsFloat1),
        new Or(testConsString, toOrConsString));
    IConstant expectedOrFString = (testConsFloat.or(toOrConsFloat1)).or(testConsString.or(toOrConsString));
    assertSame(expectedOrFString, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    ConsBinary toOrConsFBinary1 = testConsBinary[1];

    //binary | float
    orTest = new Or(
        new Or(consBinary,
            toOrConsFBinary1),
        new Or(testConsFloat,
            toOrConsFloat1));

    IConstant expectedConsFInt = (consBinary.or(toOrConsFBinary1)).or(testConsFloat.or(toOrConsFloat1));
    assertSame(expectedConsFInt, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //bool | float
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.or(testFalseConsBool)).or(testConsFloat);
    assertSame(expectedTrueFBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //bool | int
    orTest = new Or(
        new Or(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedOrFBool = (testFalseConsBool.or(testTrueConsBool)).or(testConsFloat);
    assertSame(expectedOrFBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());


    //bool | string
    orTest = new Or(
        new Or(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.or(testFalseConsBool)).or(testConsString);
    assertSame(expectedTrueStringBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());

    //bool | string
    orTest = new Or(
        new Or(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedOrStringBool = (testFalseConsBool.or(testTrueConsBool)).or(testConsString);
    assertSame(expectedOrStringBool, orTest.eval());
    assertSame(nullConstant, orTest.eval());
  }
}