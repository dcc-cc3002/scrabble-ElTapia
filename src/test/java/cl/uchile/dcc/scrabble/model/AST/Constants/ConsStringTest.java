package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class ConsStringTest {

  protected ConsString consString;
  protected String testString;
  protected int strSize;
  protected int seed;
  protected Random rng;

  @BeforeEach
  protected void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    strSize= rng.nextInt(50);
    testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    consString = new ConsString(testString);
  }

  @RepeatedTest(50)
  void constructorTest(){
    ConsString expectedConsString = new ConsString(testString);
    SString expectedSString = new SString(testString);
    ConsString expectedConsSString = new ConsString(expectedSString);

    assertEquals(expectedConsString, consString, "ConsString don't match. Seed " + seed);
    assertEquals(expectedConsSString, consString, "ConsString don't match. Seed " + seed);
    assertEquals(expectedConsString.hashCode(), consString.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(expectedSString, consString.getSType());
    assertEquals(consString, consString.eval());
    assertNotEquals(consString, testString, "Objects match. Seed " + seed);

    String differentString;

    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));


    ConsString differentConsString = new ConsString(differentString);
    SString differentSString = new SString(differentString);
    ConsString differentConsSString = new ConsString(differentSString);

    assertNotEquals(differentConsString, consString, "ConsString match. Seed " + seed);
    assertNotEquals(differentConsSString, consString, "ConsString match. Seed " + seed);
    assertNotEquals(differentSString, consString.getSType());
    assertNotEquals(differentConsString, consString.eval());

    assertEquals(testString, consString.toString(), "ConsString don't match. Seed " + seed);
    assertNotEquals(differentString, consString.toString(), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsStringTest(){
    ConsString expectedConsString = new ConsString(testString);
    assertEquals(expectedConsString, consString.toConstantStr(), "ConsString don't match. Seed " + seed);

    String differentString;

    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    ConsString differentConsString = new ConsString(differentString);
    assertNotEquals(differentConsString, consString.toConstantStr(), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStrTest() {
    String toAddString = RandomStringUtils.random(rng.nextInt(50), 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString toAddConsString = new ConsString(toAddString);

    String expectedString = toAddString + testString;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consString.addConsStr(toAddConsString), "ConsString don't match. Seed " + seed);

    String expectedAddString = testString + toAddString;
    ConsString expectedAddConsString = new ConsString(expectedAddString);

    assertEquals(expectedAddConsString, consString.add(toAddConsString), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    String differentToAddString;
    do {
      differentToAddString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentToAddString.equals(testString));

    ConsString differentConsString = new ConsString(differentToAddString + differentString);

    assertNotEquals(differentConsString, consString.addConsStr(toAddConsString), "ConsString match. Seed " + seed);
  }
  @RepeatedTest(50)
  void addWithBinaryTest(){
    char [] binaryList = {'0', '1'};
    String toAddStringBinary = RandomStringUtils.random(rng.nextInt(50), 0,
        2, false, true, binaryList, rng);
    ConsBinary toAddConsBinary = new ConsBinary(toAddStringBinary);

    String expectedString =  testString + toAddStringBinary;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consString.add(toAddConsBinary), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    String differentToAddStringBinary;
    do {
      differentToAddStringBinary = RandomStringUtils.random(rng.nextInt(50), 0,
          2, false, true, binaryList, rng);
    } while (differentToAddStringBinary.equals(toAddStringBinary));

    ConsString differentConsString = new ConsString(differentString + differentToAddStringBinary);
    assertNotEquals(differentConsString, consString.add(toAddConsBinary), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addWithIntTest(){

    int toAddInt = rng.nextInt();
    ConsInt toAddConsInt = new ConsInt(toAddInt);
    String expectedString =  testString + toAddInt;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consString.add(toAddConsInt), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    int differentToAddInt;
    do { differentToAddInt = rng.nextInt();
    } while (differentToAddInt == toAddInt);
    ConsString differentConsString = new ConsString(differentString + differentToAddInt);

    assertNotEquals(differentConsString, consString.add(toAddConsInt), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addWithFloat(){

    double toAddDouble = rng.nextDouble();
    ConsFloat toAddConsFloat = new ConsFloat(toAddDouble);

    String expectedString = testString + toAddDouble;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consString.add(toAddConsFloat), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    double differentToAddDouble;
    do { differentToAddDouble = rng.nextDouble();
    } while (differentToAddDouble == toAddDouble);

    ConsString differentConsString = new ConsString(differentString + differentToAddDouble);
    assertNotEquals(differentConsString, consString.add(toAddConsFloat), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addWithBool() {
    boolean toAddBool = rng.nextBoolean();

    ConsBool toAddConsBool = new ConsBool(toAddBool);
    ConsBool negateToAddConsBool = new ConsBool(!toAddBool);

    String expectedStringAddConsBool =  testString + toAddBool;
    String negateExpectedStringAddConsBool =  testString + !toAddBool;

    ConsString expectedAddConsBool = new ConsString(expectedStringAddConsBool);
    ConsString negateExpectedAddConsBool = new ConsString(negateExpectedStringAddConsBool);

    assertEquals(expectedAddConsBool, consString.add(toAddConsBool), "ConsString don't match. Seed " + seed);
    assertEquals(negateExpectedAddConsBool, consString.add(negateToAddConsBool), "ConsString don't match. Seed " + seed);

    assertNotEquals(negateExpectedAddConsBool, consString.add(toAddConsBool), "ConsString match. Seed " + seed);
    assertNotEquals(expectedAddConsBool, consString.add(negateToAddConsBool), "ConsString match. Seed " + seed);
  }
  @RepeatedTest(100)
  void nullOpTests(){
    IConstant nullConstant = NullConstant.getInstance();

    assertSame(nullConstant, consString.add(nullConstant));
    assertSame(nullConstant, consString.sub(nullConstant));
    assertSame(nullConstant, consString.times(nullConstant));
    assertSame(nullConstant, consString.divide(nullConstant));
    assertSame(nullConstant, consString.and(nullConstant));
    assertSame(nullConstant, consString.or(nullConstant));

    assertSame(nullConstant, consString.addNull(nullConstant));
    assertSame(nullConstant, consString.subNull(nullConstant));
    assertSame(nullConstant, consString.timesNull(nullConstant));
    assertSame(nullConstant, consString.divideNull(nullConstant));
    assertSame(nullConstant, consString.andNull(nullConstant));
    assertSame(nullConstant, consString.orNull(nullConstant));

    int testInt = rng.nextInt();
    ConsInt consInt = new ConsInt(testInt);

    assertSame(nullConstant, consString.addConsInt(consInt));
    assertSame(nullConstant, consString.subConsInt(consInt));
    assertSame(nullConstant, consString.timesConsInt(consInt));
    assertSame(nullConstant, consString.divideConsInt(consInt));
    assertSame(nullConstant, consString.andConsInt(consInt));
    assertSame(nullConstant, consString.orConsInt(consInt));

    assertSame(nullConstant, consString.sub(consInt));
    assertSame(nullConstant, consString.times(consInt));
    assertSame(nullConstant, consString.divide(consInt));
    assertSame(nullConstant, consString.and(consInt));
    assertSame(nullConstant, consString.or(consInt));

    double testDouble = rng.nextDouble();
    ConsFloat consFloat = new ConsFloat(testDouble);

    assertSame(nullConstant, consString.addConsFloat(consFloat));
    assertSame(nullConstant, consString.subConsFloat(consFloat));
    assertSame(nullConstant, consString.timesConsFloat(consFloat));
    assertSame(nullConstant, consString.divideConsFloat(consFloat));
    assertSame(nullConstant, consString.andConsFloat(consFloat));
    assertSame(nullConstant, consString.orConsFloat(consFloat));

    assertSame(nullConstant, consString.sub(consFloat));
    assertSame(nullConstant, consString.times(consFloat));
    assertSame(nullConstant, consString.divide(consFloat));
    assertSame(nullConstant, consString.and(consFloat));
    assertSame(nullConstant, consString.or(consFloat));

    char[] binaryList = {'0', '1'};
    int binSize = rng.nextInt(32);
    String testBinary = RandomStringUtils.random(binSize, 0, 2, false, true, binaryList, rng);
    ConsBinary consBinary = new ConsBinary(testBinary);

    assertSame(nullConstant, consString.addConsBinary(consBinary));
    assertSame(nullConstant, consString.subConsBinary(consBinary));
    assertSame(nullConstant, consString.timesConsBinary(consBinary));
    assertSame(nullConstant, consString.divideConsBinary(consBinary));
    assertSame(nullConstant, consString.andConsBinary(consBinary));
    assertSame(nullConstant, consString.orConsBinary(consBinary));

    assertSame(nullConstant, consString.sub(consBinary));
    assertSame(nullConstant, consString.times(consBinary));
    assertSame(nullConstant, consString.divide(consBinary));
    assertSame(nullConstant, consString.and(consBinary));
    assertSame(nullConstant, consString.or(consBinary));

    boolean testBool = rng.nextBoolean();
    ConsBool consBool = new ConsBool(testBool);

    assertSame(nullConstant, consString.addConsBool(consBool));
    assertSame(nullConstant, consString.subConsBool(consBool));
    assertSame(nullConstant, consString.timesConsBool(consBool));
    assertSame(nullConstant, consString.divideConsBool(consBool));
    assertSame(nullConstant, consString.andConsBool(consBool));
    assertSame(nullConstant, consString.orConsBool(consBool));

    assertSame(nullConstant, consString.sub(consBool));
    assertSame(nullConstant, consString.times(consBool));
    assertSame(nullConstant, consString.divide(consBool));
    assertSame(nullConstant, consString.and(consBool));
    assertSame(nullConstant, consString.or(consBool));

    String otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString otherConsString = new ConsString(otherString);

    assertSame(nullConstant, consString.subConsStr(otherConsString));
    assertSame(nullConstant, consString.timesConsStr(otherConsString));
    assertSame(nullConstant, consString.divideConsStr(otherConsString));
    assertSame(nullConstant, consString.andConsStr(otherConsString));
    assertSame(nullConstant, consString.orConsStr(otherConsString));

    assertSame(nullConstant, consString.sub(otherConsString));
    assertSame(nullConstant, consString.times(otherConsString));
    assertSame(nullConstant, consString.divide(otherConsString));
    assertSame(nullConstant, consString.and(otherConsString));
    assertSame(nullConstant, consString.or(otherConsString));

    assertSame(nullConstant, consString.toConstantInt());
    assertSame(nullConstant, consString.toConstantFloat());
    assertSame(nullConstant, consString.toConstantBinary());
    assertSame(nullConstant, consString.toConstantBool());
    assertSame(nullConstant, consString.negateConstant());
  }

}