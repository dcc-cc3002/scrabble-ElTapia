package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SubTest extends CompositeTest {

  protected Sub subTest;

  @BeforeEach
  protected void setUp() {
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){
    subTest = new Sub(
        new Sub(testConsFloat,
            testConsInt),
        new Sub(testConsFloat,
            testConsBinary[0]));

    Sub expectedInsertSub = new Sub();

    expectedInsertSub.insert(new Sub());
    expectedInsertSub.insert(testConsFloat);
    expectedInsertSub.insert(testConsInt);

    expectedInsertSub.insert(new Sub());
    expectedInsertSub.insert(testConsFloat);
    expectedInsertSub.insert(testConsBinary[0]);

    Sub expectedSubTest = new Sub(
        new Sub(testConsFloat,
            testConsInt),
        new Sub(testConsFloat,
            testConsBinary[0]));

    assertEquals(subTest, expectedInsertSub);
    assertEquals(expectedSubTest, subTest);
    assertEquals(expectedInsertSub, expectedInsertSub);
    assertNotEquals(expectedInsertSub, new Sub());
    assertNotEquals(subTest, new Sub());
    assertNotEquals(subTest, testConsInt);

    assertFalse(subTest.hasNull());
    assertFalse(expectedSubTest.hasNull());
    assertFalse(expectedInsertSub.hasNull());

    Sub voidSub = new Sub();
    assertTrue(voidSub.hasNull());

    subTest = new Sub();
    subTest.insert(testConsString);
    subTest.insert(testConsInt);

    String expectedString = "Sub( \n\t" + testConsString.toString() + "\n\t" + testConsInt.toString() + "\n\t)";
    assertEquals(expectedString, subTest.toString());
  }


  @RepeatedTest(100)
  void evalIntsTest() {

    int toSubInt1 = rng.nextInt();
    ConsInt toSubConsInt1= new ConsInt(toSubInt1);

    int toSubInt2 =rng.nextInt();
    ConsInt toSubConsInt2= new ConsInt(toSubInt2);

    int toSubInt3 = rng.nextInt();
    ConsInt toSubConsInt3= new ConsInt(toSubInt3);

    // int - int
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        new Sub(toSubConsInt2,
            toSubConsInt3));

    IConstant expectedConsInt = (testConsInt.sub(toSubConsInt1)).sub(toSubConsInt2.sub(toSubConsInt3));
    assertEquals(expectedConsInt, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());


    double toSubDouble = rng.nextDouble();
    ConsFloat toSubConsFloat = new ConsFloat(toSubDouble);

    // int - float
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        new Sub(testConsFloat, toSubConsFloat));
    IConstant expectedSubFloat = (testConsInt.sub(toSubConsInt1)).sub(testConsFloat.sub(toSubConsFloat));
    assertEquals(expectedSubFloat, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toSubConsBinary = testConsBinary[1];

    // int - binary
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        new Sub(consBinary, toSubConsBinary));
    IConstant expectedSubBinary = (testConsInt.sub(toSubConsInt1)).sub(consBinary.sub(toSubConsBinary));
    assertEquals(expectedSubBinary, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());
  }

  @RepeatedTest(100)
  void evalFloatsTest() {

    int toSubInt1 = rng.nextInt();
    ConsInt toSubConsInt1= new ConsInt(toSubInt1);

    double toSubDouble1 = rng.nextDouble();
    ConsFloat toSubConsFloat1 = new ConsFloat(toSubDouble1);

    //float - int
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        new Sub(testConsInt,
            toSubConsInt1));

    IConstant expectedConsInt = (testConsFloat.sub(toSubConsFloat1)).sub(testConsInt.sub(toSubConsInt1));
    assertEquals(expectedConsInt, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());

    double toSubDouble2 =rng.nextDouble();
    ConsFloat toSubConsFloat2= new ConsFloat(toSubDouble2);

    double toSubDouble3 =rng.nextDouble();
    ConsFloat toSubConsFloat3= new ConsFloat(toSubDouble3);

    //float - float
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        new Sub(toSubConsFloat2, toSubConsFloat3));
    IConstant expectedSubFloat = (testConsFloat.sub(toSubConsFloat1)).sub(toSubConsFloat2.sub(toSubConsFloat3));
    assertEquals(expectedSubFloat, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toSubConsBinary = testConsBinary[1];

    //float - binary
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        new Sub(consBinary, toSubConsBinary));
    IConstant expectedSubBinary = (testConsFloat.sub(toSubConsFloat1)).sub(consBinary.sub(toSubConsBinary));
    assertEquals(expectedSubBinary, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());
  }

  @RepeatedTest(100)
  void evalBinaryTest() {
    int toSubInt1 = rng.nextInt();
    ConsInt toSubConsInt1= new ConsInt(toSubInt1);

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toSubConsBinary1 = testConsBinary[1];
    ConsBinary toSubConsBinary2= testConsBinary[2];

    String toSubBinary3 = "0110101";
    ConsBinary toSubConsBinary3 = new ConsBinary(toSubBinary3);

    //binary - int
    subTest = new Sub(
        new Sub(consBinary,
            toSubConsBinary1),
        new Sub(testConsInt,
            toSubConsInt1));

    IConstant expectedConsInt = (consBinary.sub(toSubConsBinary1)).sub(testConsInt.sub(toSubConsInt1));
    assertEquals(expectedConsInt, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());


    //binary - binary
    subTest = new Sub(
        new Sub(consBinary,
            toSubConsBinary1),
        new Sub(toSubConsBinary2, toSubConsBinary3));
    IConstant expectedSubBinary = (consBinary.sub(toSubConsBinary1)).sub(toSubConsBinary2.sub(toSubConsBinary3));
    assertEquals(expectedSubBinary, subTest.eval());
    assertNotSame(nullConstant, subTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    String toSubString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toSubConsString1= new ConsString(toSubString1);

    String toSubString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toSubConsString2= new ConsString(toSubString2);

    String toSubString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toSubConsString3= new ConsString(toSubString3);

    //String - String
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        new Sub(toSubConsString2,
            toSubConsString3));

    IConstant expectedConsString = (testConsString.sub(toSubConsString1)).sub(toSubConsString2.sub(toSubConsString3));
    assertEquals(expectedConsString, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    int toSubInt = rng.nextInt();
    ConsInt toSubConsInt = new ConsInt(toSubInt);
    //String - int
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        new Sub(testConsInt, toSubConsInt));
    IConstant expectedSubInt = (testConsString.sub(toSubConsString1)).sub(testConsInt.sub(toSubConsInt));
    assertEquals(expectedSubInt, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    double toSubDouble = rng.nextDouble();
    ConsFloat toSubConsFloat = new ConsFloat(toSubDouble);
    //String - float
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        new Sub(testConsFloat, toSubConsFloat));
    IConstant expectedSubFloat = (testConsString.sub(toSubConsString1)).sub(testConsFloat.sub(toSubConsFloat));
    assertEquals(expectedSubFloat, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    //String - true bool
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        testTrueConsBool);
    IConstant expectedSubTrueBool = (testConsString.sub(toSubConsString1)).sub(testTrueConsBool);
    assertEquals(expectedSubTrueBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //String - false bool
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        testFalseConsBool);
    IConstant expectedSubFalseBool = (testConsString.sub(toSubConsString1)).sub(testFalseConsBool);
    assertEquals(expectedSubFalseBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toSubConsBinary = testConsBinary[1];

    //String - binary
    subTest = new Sub(
        new Sub(testConsString,
            toSubConsString1),
        new Sub(consBinary, toSubConsBinary));
    IConstant expectedSubBinary = (testConsString.sub(toSubConsString1)).sub(consBinary.sub(toSubConsBinary));
    assertEquals(expectedSubBinary, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    int toSubInt1 = rng.nextInt();
    ConsInt toSubConsInt1= new ConsInt(toSubInt1);

    //int - true bool
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        testTrueConsBool);
    IConstant expectedSubIntTrueBool = (testConsInt.sub(toSubConsInt1)).sub(testTrueConsBool);
    assertSame(expectedSubIntTrueBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //int - false bool
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        testFalseConsBool);
    IConstant expectedSubIntFalseBool = (testConsInt.sub(toSubConsInt1)).sub(testFalseConsBool);
    assertSame(expectedSubIntFalseBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - int
    subTest = new Sub(
        new Sub(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.sub(testFalseConsBool)).sub(testConsInt);
    assertSame(expectedTrueBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - int
    subTest = new Sub(
        new Sub(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedSubBool = (testFalseConsBool.sub(testTrueConsBool)).sub(testConsInt);
    assertSame(expectedSubBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    String toSubString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toSubConsString= new ConsString(toSubString);

    //int - string
    subTest = new Sub(
        new Sub(testConsInt,
            toSubConsInt1),
        new Sub(testConsString, toSubConsString));
    IConstant expectedSubIntStr = (testConsInt.sub(toSubConsInt1)).sub(testConsString.sub(toSubConsString));
    assertSame(expectedSubIntStr, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    double toSubDouble1 = rng.nextDouble();
    ConsFloat toSubConsFloat1 = new ConsFloat(toSubDouble1);

    //float - true bool
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        testTrueConsBool);
    IConstant expectedSubFTrueBool = (testConsFloat.sub(toSubConsFloat1)).sub(testTrueConsBool);
    assertSame(expectedSubFTrueBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //float - false bool
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        testFalseConsBool);
    IConstant expectedSubFFalseBool = (testConsFloat.sub(toSubConsFloat1)).sub(testFalseConsBool);
    assertSame(expectedSubFFalseBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    // float - string
    subTest = new Sub(
        new Sub(testConsFloat,
            toSubConsFloat1),
        new Sub(testConsString, toSubConsString));
    IConstant expectedSubFString = (testConsFloat.sub(toSubConsFloat1)).sub(testConsString.sub(toSubConsString));
    assertSame(expectedSubFString, subTest.eval());
    assertSame(nullConstant, subTest.eval());


    ConsBinary toSubConsBinary1 = testConsBinary[1];

    //binary - float
    subTest = new Sub(
        new Sub(consBinary,
            toSubConsBinary1),
        new Sub(testConsFloat,
            toSubConsFloat1));

    IConstant expectedConsInt = (consBinary.sub(toSubConsBinary1)).sub(testConsFloat.sub(toSubConsFloat1));
    assertSame(expectedConsInt, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - float
    subTest = new Sub(
        new Sub(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.sub(testFalseConsBool)).sub(testConsFloat);
    assertSame(expectedTrueFBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - int
    subTest = new Sub(
        new Sub(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedSubFBool = (testFalseConsBool.sub(testTrueConsBool)).sub(testConsFloat);
    assertSame(expectedSubFBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - binary
    subTest = new Sub(
        new Sub(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.sub(testFalseConsBool)).sub(consBinary);
    assertSame(expectedTrueBinBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - binary
    subTest = new Sub(
        new Sub(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedSubBinBool = (testFalseConsBool.sub(testTrueConsBool)).sub(consBinary);
    assertSame(expectedSubBinBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - string
    subTest = new Sub(
        new Sub(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.sub(testFalseConsBool)).sub(testConsString);
    assertSame(expectedTrueStringBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - string
    subTest = new Sub(
        new Sub(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedSubStringBool = (testFalseConsBool.sub(testTrueConsBool)).sub(testConsString);
    assertSame(expectedSubStringBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - bool
    subTest = new Sub(
        new Sub(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.sub(testFalseConsBool)).sub(testTrueConsBool);
    assertSame(expectedTrueBoolBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());

    //bool - bool
    subTest = new Sub(
        new Sub(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedSubBoolBool = (testFalseConsBool.sub(testTrueConsBool)).sub(testTrueConsBool);
    assertSame(expectedSubBoolBool, subTest.eval());
    assertSame(nullConstant, subTest.eval());
  }
}