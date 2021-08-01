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

class DivideTest extends CompositeTest {

  protected Divide divideTest;

  @BeforeEach
  public void setUp(){
    super.setUp();
  }

  @RepeatedTest(100)
  void constructorsTest(){
    int toDivideInt1;
    do {toDivideInt1 = rng.nextInt();}
    while(toDivideInt1 == 0);

    ConsInt toDivideConsInt1= new ConsInt(toDivideInt1);

    int toDivideInt3;
    do {toDivideInt3 = rng.nextInt();}
    while(toDivideInt3 == 0);

    ConsInt toDivideConsInt3= new ConsInt(toDivideInt3);

    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        toDivideConsInt3);

    Divide expectedInsertDivide = new Divide();

    expectedInsertDivide.insert(new Divide());
    expectedInsertDivide.insert(testConsInt);
    expectedInsertDivide.insert(toDivideConsInt1);

    expectedInsertDivide.insert(toDivideConsInt3);

    Divide expectedDivideTest =new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        toDivideConsInt3);

    assertEquals(divideTest, expectedInsertDivide);
    assertEquals(expectedDivideTest, divideTest);
    assertEquals(expectedInsertDivide, expectedInsertDivide);
    assertNotEquals(expectedInsertDivide, new Divide());
    assertNotEquals(divideTest, new Divide());
    assertNotEquals(divideTest, testConsInt);

    assertFalse(divideTest.hasNull());
    assertFalse(expectedDivideTest.hasNull());
    assertFalse(expectedInsertDivide.hasNull());

    Divide voidDivide = new Divide();
    assertTrue(voidDivide.hasNull());

  }

  @RepeatedTest(100)
  void evalIntsTest() {

    int toDivideInt1;
    do {toDivideInt1 = rng.nextInt();}
    while(toDivideInt1 == 0);

    ConsInt toDivideConsInt1= new ConsInt(toDivideInt1);


    int toDivideInt3;
    do {toDivideInt3 = rng.nextInt();}
    while(toDivideInt3 == 0);

    ConsInt toDivideConsInt3= new ConsInt(toDivideInt3);

    // int / int
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        toDivideConsInt3);

    IConstant expectedConsInt = (testConsInt.divide(toDivideConsInt1)).divide(toDivideConsInt3);
    assertEquals(expectedConsInt, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());


    double toDivideDouble;
    do{toDivideDouble = rng.nextDouble();}
    while(toDivideDouble == 0.0);

    ConsFloat toDivideConsFloat = new ConsFloat(toDivideDouble);

    // int / float
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        toDivideConsFloat);
    IConstant expectedDivideFloat = (testConsInt.divide(toDivideConsInt1)).divide(toDivideConsFloat);
    assertEquals(expectedDivideFloat, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());


    ConsBinary toDivideConsBinary = testConsBinary[1];

    // int / binary
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        toDivideConsBinary);
    IConstant expectedDivideBinary = (testConsInt.divide(toDivideConsInt1)).divide(toDivideConsBinary);
    assertEquals(expectedDivideBinary, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());
  }

  @RepeatedTest(100)
  void evalFloatsTest() {

    int toDivideInt1;
    do{toDivideInt1= rng.nextInt();}
    while(toDivideInt1 == 0);
    ConsInt toDivideConsInt1= new ConsInt(toDivideInt1);

    double toDivideDouble1;
    do{toDivideDouble1 = rng.nextDouble();}
    while(toDivideDouble1 == 0.0);

    ConsFloat toDivideConsFloat1 = new ConsFloat(toDivideDouble1);

    //float / int
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        toDivideConsInt1);

    IConstant expectedConsInt = (testConsFloat.divide(toDivideConsFloat1)).divide(toDivideConsInt1);
    assertEquals(expectedConsInt, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());


    double toDivideDouble3;
    do{toDivideDouble3 =rng.nextDouble();}
    while(toDivideDouble3 == 0.0);

    ConsFloat toDivideConsFloat3= new ConsFloat(toDivideDouble3);

    //float / float
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        toDivideConsFloat3);
    IConstant expectedDivideFloat = (testConsFloat.divide(toDivideConsFloat1)).divide(toDivideConsFloat3);
    assertEquals(expectedDivideFloat, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());


    ConsBinary toDivideConsBinary = testConsBinary[1];

    //float / binary
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        toDivideConsBinary);
    IConstant expectedDivideBinary = (testConsFloat.divide(toDivideConsFloat1)).divide(toDivideConsBinary);
    assertEquals(expectedDivideBinary, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());
  }

  @RepeatedTest(100)
  void evalBinaryTest() {
    int toDivideInt1;
    do{toDivideInt1 = rng.nextInt();}
    while(toDivideInt1 == 0);

    ConsInt toDivideConsInt1= new ConsInt(toDivideInt1);

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toDivideConsBinary1 = testConsBinary[1];

    String toDivideBinary3 = "0110101";
    ConsBinary toDivideConsBinary3 = new ConsBinary(toDivideBinary3);

    //binary / int
    divideTest = new Divide(
        new Divide(consBinary,
            toDivideConsBinary1),
        toDivideConsInt1);

    IConstant expectedConsInt = (consBinary.divide(toDivideConsBinary1)).divide(toDivideConsInt1);
    assertEquals(expectedConsInt, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());


    //binary / binary
    divideTest = new Divide(
        new Divide(consBinary,
            toDivideConsBinary1),
        toDivideConsBinary3);
    IConstant expectedDivideBinary = (consBinary.divide(toDivideConsBinary1)).divide(toDivideConsBinary3);
    assertEquals(expectedDivideBinary, divideTest.eval());
    assertNotSame(nullConstant, divideTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    String toDivideString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toDivideConsString1= new ConsString(toDivideString1);

    String toDivideString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toDivideConsString2= new ConsString(toDivideString2);

    String toDivideString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toDivideConsString3= new ConsString(toDivideString3);

    //String / String
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        new Divide(toDivideConsString2,
            toDivideConsString3));

    IConstant expectedConsString = (testConsString.divide(toDivideConsString1)).divide(toDivideConsString2.divide(toDivideConsString3));
    assertEquals(expectedConsString, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    int toDivideInt = rng.nextInt();
    ConsInt toDivideConsInt = new ConsInt(toDivideInt);
    //String / int
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        new Divide(testConsInt, toDivideConsInt));
    IConstant expectedDivideInt = (testConsString.divide(toDivideConsString1)).divide(testConsInt.divide(toDivideConsInt));
    assertEquals(expectedDivideInt, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    double toDivideDouble = rng.nextDouble();
    ConsFloat toDivideConsFloat = new ConsFloat(toDivideDouble);
    //String / float
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        new Divide(testConsFloat, toDivideConsFloat));
    IConstant expectedDivideFloat = (testConsString.divide(toDivideConsString1)).divide(testConsFloat.divide(toDivideConsFloat));
    assertEquals(expectedDivideFloat, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    //String / true bool
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        testTrueConsBool);
    IConstant expectedDivideTrueBool = (testConsString.divide(toDivideConsString1)).divide(testTrueConsBool);
    assertEquals(expectedDivideTrueBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //String / false bool
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        testFalseConsBool);
    IConstant expectedDivideFalseBool = (testConsString.divide(toDivideConsString1)).divide(testFalseConsBool);
    assertEquals(expectedDivideFalseBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toDivideConsBinary = testConsBinary[1];

    //String / binary
    divideTest = new Divide(
        new Divide(testConsString,
            toDivideConsString1),
        new Divide(consBinary, toDivideConsBinary));
    IConstant expectedDivideBinary = (testConsString.divide(toDivideConsString1)).divide(consBinary.divide(toDivideConsBinary));
    assertEquals(expectedDivideBinary, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    int toDivideInt1 = rng.nextInt();
    ConsInt toDivideConsInt1= new ConsInt(toDivideInt1);

    //int / true bool
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        testTrueConsBool);
    IConstant expectedDivideIntTrueBool = (testConsInt.divide(toDivideConsInt1)).divide(testTrueConsBool);
    assertSame(expectedDivideIntTrueBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //int / false bool
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        testFalseConsBool);
    IConstant expectedDivideIntFalseBool = (testConsInt.divide(toDivideConsInt1)).divide(testFalseConsBool);
    assertSame(expectedDivideIntFalseBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / int
    divideTest = new Divide(
        new Divide(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.divide(testFalseConsBool)).divide(testConsInt);
    assertSame(expectedTrueBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / int
    divideTest = new Divide(
        new Divide(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedDivideBool = (testFalseConsBool.divide(testTrueConsBool)).divide(testConsInt);
    assertSame(expectedDivideBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    String toDivideString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toDivideConsString= new ConsString(toDivideString);

    //int / string
    divideTest = new Divide(
        new Divide(testConsInt,
            toDivideConsInt1),
        new Divide(testConsString, toDivideConsString));
    IConstant expectedDivideIntStr = (testConsInt.divide(toDivideConsInt1)).divide(testConsString.divide(toDivideConsString));
    assertSame(expectedDivideIntStr, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    double toDivideDouble1 = rng.nextDouble();
    ConsFloat toDivideConsFloat1 = new ConsFloat(toDivideDouble1);

    //float / true bool
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        testTrueConsBool);
    IConstant expectedDivideFTrueBool = (testConsFloat.divide(toDivideConsFloat1)).divide(testTrueConsBool);
    assertSame(expectedDivideFTrueBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //float / false bool
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        testFalseConsBool);
    IConstant expectedDivideFFalseBool = (testConsFloat.divide(toDivideConsFloat1)).divide(testFalseConsBool);
    assertSame(expectedDivideFFalseBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    // float / string
    divideTest = new Divide(
        new Divide(testConsFloat,
            toDivideConsFloat1),
        new Divide(testConsString, toDivideConsString));
    IConstant expectedDivideFString = (testConsFloat.divide(toDivideConsFloat1)).divide(testConsString.divide(toDivideConsString));
    assertSame(expectedDivideFString, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());


    ConsBinary toDivideConsBinary1 = testConsBinary[1];

    //binary / float
    divideTest = new Divide(
        new Divide(consBinary,
            toDivideConsBinary1),
        new Divide(testConsFloat,
            toDivideConsFloat1));

    IConstant expectedConsInt = (consBinary.divide(toDivideConsBinary1)).divide(testConsFloat.divide(toDivideConsFloat1));
    assertSame(expectedConsInt, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / float
    divideTest = new Divide(
        new Divide(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.divide(testFalseConsBool)).divide(testConsFloat);
    assertSame(expectedTrueFBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / int
    divideTest = new Divide(
        new Divide(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedDivideFBool = (testFalseConsBool.divide(testTrueConsBool)).divide(testConsFloat);
    assertSame(expectedDivideFBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / binary
    divideTest = new Divide(
        new Divide(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.divide(testFalseConsBool)).divide(consBinary);
    assertSame(expectedTrueBinBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / binary
    divideTest = new Divide(
        new Divide(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedDivideBinBool = (testFalseConsBool.divide(testTrueConsBool)).divide(consBinary);
    assertSame(expectedDivideBinBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / string
    divideTest = new Divide(
        new Divide(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.divide(testFalseConsBool)).divide(testConsString);
    assertSame(expectedTrueStringBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / string
    divideTest = new Divide(
        new Divide(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedDivideStringBool = (testFalseConsBool.divide(testTrueConsBool)).divide(testConsString);
    assertSame(expectedDivideStringBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / bool
    divideTest = new Divide(
        new Divide(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.divide(testFalseConsBool)).divide(testTrueConsBool);
    assertSame(expectedTrueBoolBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());

    //bool / bool
    divideTest = new Divide(
        new Divide(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedDivideBoolBool = (testFalseConsBool.divide(testTrueConsBool)).divide(testTrueConsBool);
    assertSame(expectedDivideBoolBool, divideTest.eval());
    assertSame(nullConstant, divideTest.eval());
  }
}