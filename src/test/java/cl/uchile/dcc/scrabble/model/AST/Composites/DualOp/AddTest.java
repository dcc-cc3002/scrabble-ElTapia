package cl.uchile.dcc.scrabble.model.AST.Composites.DualOp;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.CompositeTest;
import cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp.*;
import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import cl.uchile.dcc.scrabble.model.AST.IComponent;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AddTest extends CompositeTest {
  protected Add addTest;

  @BeforeEach
  protected void setUp() {
    super.setUp();
  }


  @RepeatedTest(100)
  void constructorsTest(){
    addTest = new Add(
        new Add(testConsString,
            testConsInt),
        new Add(testConsFloat,
            testConsBinary[0]));

    Add expectedInsertAdd = new Add();

    expectedInsertAdd.insert(new Add());
    expectedInsertAdd.insert(testConsString);
    expectedInsertAdd.insert(testConsInt);

    expectedInsertAdd.insert(new Add());
    expectedInsertAdd.insert(testConsFloat);
    expectedInsertAdd.insert(testConsBinary[0]);

    Add expectedAddTest = new Add(
        new Add(testConsString,
            testConsInt),
        new Add(testConsFloat,
            testConsBinary[0]));

    assertEquals(addTest, expectedInsertAdd);
    assertEquals(expectedAddTest, addTest);
    assertEquals(expectedInsertAdd, expectedInsertAdd);
    assertNotEquals(expectedInsertAdd, new Add());
    assertNotEquals(addTest, new Add());
    assertNotEquals(addTest, testConsInt);

    assertFalse(addTest.hasNull());
    assertFalse(expectedAddTest.hasNull());
    assertFalse(expectedInsertAdd.hasNull());

    Add voidAdd = new Add();
    assertTrue(voidAdd.hasNull());

  }

  @RepeatedTest(100)
  void evalStringsTest() {

    String toAddString1 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAddConsString1= new ConsString(toAddString1);

    String toAddString2 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAddConsString2= new ConsString(toAddString2);

    String toAddString3 = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAddConsString3= new ConsString(toAddString3);

    //String + String
    addTest = new Add(
                new Add(testConsString,
                        toAddConsString1),
                new Add(toAddConsString2,
                        toAddConsString3));

    IConstant expectedConsString = (testConsString.add(toAddConsString1)).add(toAddConsString2.add(toAddConsString3));
    assertEquals(expectedConsString, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    int toAddInt = rng.nextInt();
    ConsInt toAddConsInt = new ConsInt(toAddInt);
    //String + int
    addTest = new Add(
                new Add(testConsString,
                        toAddConsString1),
                new Add(testConsInt, toAddConsInt));
    IConstant expectedAddInt = (testConsString.add(toAddConsString1)).add(testConsInt.add(toAddConsInt));
    assertEquals(expectedAddInt, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    double toAddDouble = rng.nextDouble();
    ConsFloat toAddConsFloat = new ConsFloat(toAddDouble);
    //String + float
    addTest = new Add(
        new Add(testConsString,
            toAddConsString1),
        new Add(testConsFloat, toAddConsFloat));
    IConstant expectedAddFloat = (testConsString.add(toAddConsString1)).add(testConsFloat.add(toAddConsFloat));
    assertEquals(expectedAddFloat, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    //String + true bool
    addTest = new Add(
                new Add(testConsString,
                    toAddConsString1),
                testTrueConsBool);
    IConstant expectedAddTrueBool = (testConsString.add(toAddConsString1)).add(testTrueConsBool);
    assertEquals(expectedAddTrueBool, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());

    //String + false bool
    addTest = new Add(
        new Add(testConsString,
            toAddConsString1),
        testFalseConsBool);
    IConstant expectedAddFalseBool = (testConsString.add(toAddConsString1)).add(testFalseConsBool);
    assertEquals(expectedAddFalseBool, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAddConsBinary = testConsBinary[1];
    //String + binary
    addTest = new Add(
        new Add(testConsString,
            toAddConsString1),
        new Add(consBinary, toAddConsBinary));
    IConstant expectedAddBinary = (testConsString.add(toAddConsString1)).add(consBinary.add(toAddConsBinary));
    assertEquals(expectedAddBinary, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());
  }

  @RepeatedTest(100)
  void evalIntsTest() {

    int toAddInt1 = rng.nextInt();
    ConsInt toAddConsInt1= new ConsInt(toAddInt1);

    int toAddInt2 =rng.nextInt();
    ConsInt toAddConsInt2= new ConsInt(toAddInt2);

    int toAddInt3 = rng.nextInt();
    ConsInt toAddConsInt3= new ConsInt(toAddInt3);

    // int + int
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        new Add(toAddConsInt2,
            toAddConsInt3));

    IConstant expectedConsInt = (testConsInt.add(toAddConsInt1)).add(toAddConsInt2.add(toAddConsInt3));
    assertEquals(expectedConsInt, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    double toAddDouble = rng.nextDouble();
    ConsFloat toAddConsFloat = new ConsFloat(toAddDouble);

    // int + float
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        new Add(testConsFloat, toAddConsFloat));
    IConstant expectedAddFloat = (testConsInt.add(toAddConsInt1)).add(testConsFloat.add(toAddConsFloat));
    assertEquals(expectedAddFloat, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAddConsBinary = testConsBinary[1];

    // int + binary
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        new Add(consBinary, toAddConsBinary));
    IConstant expectedAddBinary = (testConsInt.add(toAddConsInt1)).add(consBinary.add(toAddConsBinary));
    assertEquals(expectedAddBinary, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());
  }

  @RepeatedTest(100)
  void evalFloatsTest() {

    int toAddInt1 = rng.nextInt();
    ConsInt toAddConsInt1= new ConsInt(toAddInt1);

    double toAddDouble1 = rng.nextDouble();
    ConsFloat toAddConsFloat1 = new ConsFloat(toAddDouble1);

    //float + int
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        new Add(testConsInt,
            toAddConsInt1));

    IConstant expectedConsInt = (testConsFloat.add(toAddConsFloat1)).add(testConsInt.add(toAddConsInt1));
    assertEquals(expectedConsInt, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());

    double toAddDouble2 =rng.nextDouble();
    ConsFloat toAddConsFloat2= new ConsFloat(toAddDouble2);

    double toAddDouble3 =rng.nextDouble();
    ConsFloat toAddConsFloat3= new ConsFloat(toAddDouble3);

    //float + float
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        new Add(toAddConsFloat2, toAddConsFloat3));
    IConstant expectedAddFloat = (testConsFloat.add(toAddConsFloat1)).add(toAddConsFloat2.add(toAddConsFloat3));
    assertEquals(expectedAddFloat, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAddConsBinary = testConsBinary[1];

    //float + binary
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        new Add(consBinary, toAddConsBinary));
    IConstant expectedAddBinary = (testConsFloat.add(toAddConsFloat1)).add(consBinary.add(toAddConsBinary));
    assertEquals(expectedAddBinary, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());
  }

  @RepeatedTest(100)
  void evalBinaryTest() {
    int toAddInt1 = rng.nextInt();
    ConsInt toAddConsInt1= new ConsInt(toAddInt1);

    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAddConsBinary1 = testConsBinary[1];
    ConsBinary toAddConsBinary2= testConsBinary[2];

    String toAddBinary3 = "0110101";
    ConsBinary toAddConsBinary3 = new ConsBinary(toAddBinary3);

    //binary + int
    addTest = new Add(
        new Add(consBinary,
            toAddConsBinary1),
        new Add(testConsInt,
            toAddConsInt1));

    IConstant expectedConsInt = (consBinary.add(toAddConsBinary1)).add(testConsInt.add(toAddConsInt1));
    assertEquals(expectedConsInt, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());


    //binary + binary
    addTest = new Add(
        new Add(consBinary,
            toAddConsBinary1),
        new Add(toAddConsBinary2, toAddConsBinary3));
    IConstant expectedAddBinary = (consBinary.add(toAddConsBinary1)).add(toAddConsBinary2.add(toAddConsBinary3));
    assertEquals(expectedAddBinary, addTest.eval());
    assertNotSame(nullConstant, addTest.eval());
  }

  @RepeatedTest(200)
  void nullOps(){
    int toAddInt1 = rng.nextInt();
    ConsInt toAddConsInt1= new ConsInt(toAddInt1);

    //int + true bool
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        testTrueConsBool);
    IConstant expectedAddTrueBool = (testConsInt.add(toAddConsInt1)).add(testTrueConsBool);
    assertSame(expectedAddTrueBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //int + false bool
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        testFalseConsBool);
    IConstant expectedAddFalseBool = (testConsInt.add(toAddConsInt1)).add(testFalseConsBool);
    assertSame(expectedAddFalseBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + int
    addTest = new Add(
        new Add(testTrueConsBool,
            testFalseConsBool),
        testConsInt);
    IConstant expectedTrueBool = (testTrueConsBool.add(testFalseConsBool)).add(testConsInt);
    assertSame(expectedTrueBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + int
    addTest = new Add(
        new Add(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedAddBool = (testFalseConsBool.add(testTrueConsBool)).add(testConsInt);
    assertSame(expectedAddBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    String toAddString = RandomStringUtils.random(rng.nextInt(15), 0,
        Character.MAX_CODE_POINT, true, true, null, rng);
    ConsString toAddConsString= new ConsString(toAddString);

    //int + string
    addTest = new Add(
        new Add(testConsInt,
            toAddConsInt1),
        new Add(testConsString, toAddConsString));
    IConstant expectedAddInt = (testConsInt.add(toAddConsInt1)).add(testConsString.add(toAddConsString));
    assertSame(expectedAddInt, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    double toAddDouble1 = rng.nextDouble();
    ConsFloat toAddConsFloat1 = new ConsFloat(toAddDouble1);

    //float + true bool
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        testTrueConsBool);
    IConstant expectedAddFTrueBool = (testConsFloat.add(toAddConsFloat1)).add(testTrueConsBool);
    assertSame(expectedAddFTrueBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //float + false bool
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        testFalseConsBool);
    IConstant expectedAddFFalseBool = (testConsFloat.add(toAddConsFloat1)).add(testFalseConsBool);
    assertSame(expectedAddFFalseBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    // float + string
    addTest = new Add(
        new Add(testConsFloat,
            toAddConsFloat1),
        new Add(testConsString, toAddConsString));
    IConstant expectedAddFString = (testConsFloat.add(toAddConsFloat1)).add(testConsString.add(toAddConsString));
    assertSame(expectedAddFString, addTest.eval());
    assertSame(nullConstant, addTest.eval());


    ConsBinary consBinary = testConsBinary[0];
    ConsBinary toAddConsBinary1 = testConsBinary[1];

    //binary + float
    addTest = new Add(
        new Add(consBinary,
            toAddConsBinary1),
        new Add(testConsFloat,
            toAddConsFloat1));

    IConstant expectedConsInt = (consBinary.add(toAddConsBinary1)).add(testConsFloat.add(toAddConsFloat1));
    assertSame(expectedConsInt, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + float
    addTest = new Add(
        new Add(testTrueConsBool,
            testFalseConsBool),
        testConsFloat);
    IConstant expectedTrueFBool = (testTrueConsBool.add(testFalseConsBool)).add(testConsFloat);
    assertSame(expectedTrueFBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + int
    addTest = new Add(
        new Add(testFalseConsBool,
            testTrueConsBool),
        testConsInt);
    IConstant expectedAddFBool = (testFalseConsBool.add(testTrueConsBool)).add(testConsFloat);
    assertSame(expectedAddFBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + binary
    addTest = new Add(
        new Add(testTrueConsBool,
            testFalseConsBool),
        consBinary);
    IConstant expectedTrueBinBool = (testTrueConsBool.add(testFalseConsBool)).add(consBinary);
    assertSame(expectedTrueBinBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + binary
    addTest = new Add(
        new Add(testFalseConsBool,
            testTrueConsBool),
        consBinary);
    IConstant expectedAddBinBool = (testFalseConsBool.add(testTrueConsBool)).add(consBinary);
    assertSame(expectedAddBinBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + string
    addTest = new Add(
        new Add(testTrueConsBool,
            testFalseConsBool),
        testConsString);
    IConstant expectedTrueStringBool = (testTrueConsBool.add(testFalseConsBool)).add(testConsString);
    assertSame(expectedTrueStringBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + string
    addTest = new Add(
        new Add(testFalseConsBool,
            testTrueConsBool),
        testConsString);
    IConstant expectedAddStringBool = (testFalseConsBool.add(testTrueConsBool)).add(testConsString);
    assertSame(expectedAddStringBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + bool
    addTest = new Add(
        new Add(testTrueConsBool,
            testFalseConsBool),
        testTrueConsBool);
    IConstant expectedTrueBoolBool = (testTrueConsBool.add(testFalseConsBool)).add(testTrueConsBool);
    assertSame(expectedTrueBoolBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());

    //bool + bool
    addTest = new Add(
        new Add(testFalseConsBool,
            testTrueConsBool),
        testTrueConsBool);
    IConstant expectedAddBoolBool = (testFalseConsBool.add(testTrueConsBool)).add(testTrueConsBool);
    assertSame(expectedAddBoolBool, addTest.eval());
    assertSame(nullConstant, addTest.eval());
  }

  @Test
  void hi(){
    addTest = new Add();
    addTest.insert(new Add());
    addTest.insert(new Add());
    addTest.insert(new ConsInt(25));
    addTest.insert(new ConsFloat(12.5));
    addTest.insert(new ConsFloat(-5.1));
    addTest.insert(new ConsInt(15));

    System.out.println(addTest);
  }

  @Test
  void examples() {
    Add example = new Add(
        new Or(
            new ConsBinary("01000"),
            new ToBinary(
                new Sub(
                    new ConsInt(25),
                    new ConsBinary("0101")
                ))
        )
        ,new ConsFloat(6.9)
    );
    assertSame(NullConstant.getInstance(), example.eval());

    Add example2 = new Add(
        new ConsFloat(6.9),
        new Or(
            new ConsBinary("01000"),
            new ToBinary(
                new Sub(
                    new ConsInt(25),
                    new ConsBinary("0101")
                ))
        )
    );
    assertEquals(new ConsFloat(34.9), example2.eval());
    System.out.println(example2);
  }
}