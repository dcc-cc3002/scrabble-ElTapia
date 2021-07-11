package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.AST.Wrapper.IConstant;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class ConsFloatTest {
  protected ConsFloat consFloat;
  protected double testDouble;
  protected int seed;
  protected Random rng;

  @BeforeEach
  protected void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testDouble = rng.nextDouble();
    consFloat = new ConsFloat(testDouble);
  }

  @RepeatedTest(50)
  void constructorTest(){
    ConsFloat expectedConsFloat = new ConsFloat(testDouble);
    SFloat expectedSFloat = new SFloat(testDouble);
    ConsFloat expectedConsSFloat = new ConsFloat(expectedSFloat);

    assertEquals(expectedConsFloat, consFloat, "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedConsSFloat, consFloat, "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedConsFloat.hashCode(), consFloat.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(expectedSFloat, consFloat.getSType(), "SFloat don't match. Seed " + seed);
    assertNotEquals(consFloat, testDouble, "Objects match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble == testDouble);

    ConsFloat differentConsFloat = new ConsFloat(differentDouble);
    SFloat differentSFloat = new SFloat(differentDouble);
    ConsFloat differentConsSFloat = new ConsFloat(differentSFloat);

    assertNotEquals(differentSFloat, consFloat.getSType(), "SFloat match. Seed " + seed);
    assertNotEquals(differentConsFloat, consFloat, "ConsFloat match. Seed " + seed);
    assertNotEquals(differentConsSFloat, consFloat, "ConsFloat match. Seed " + seed);

    assertEquals(String.valueOf(testDouble), consFloat.toString(), "String don't match. Seed " + seed);
    assertNotEquals(String.valueOf(differentDouble), consFloat.toString(), "String match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsStringTest(){
    ConsString expectedConsString = new ConsString(String.valueOf(testDouble));
    assertEquals(expectedConsString, consFloat.toConstantStr(), "ConsString don't match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble == testDouble);

    ConsString differentConsString = new ConsString(String.valueOf(differentDouble));
    assertNotEquals(differentConsString, consFloat.toConstantStr(), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsFloatTest(){
    ConsFloat expectedConsFloat = new ConsFloat(testDouble);
    assertEquals(expectedConsFloat, consFloat.toConstantFloat(), "ConsFloat don't match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble == testDouble);

    ConsFloat differentConsFloat = new ConsFloat(differentDouble);
    assertNotEquals(differentConsFloat, consFloat.toConstantFloat(), "ConsFloat match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opConsFloatTest() {
    double toOpDouble;
    do {
      toOpDouble = rng.nextDouble();
    }while (toOpDouble == 0);

    ConsFloat toOpConsFloat = new ConsFloat(toOpDouble);

    double expectedAddDouble = testDouble + toOpDouble;
    ConsFloat expectedAddConsFloat = new ConsFloat(expectedAddDouble);

    double expectedMinusDouble = testDouble - toOpDouble;
    ConsFloat expectedMinusConsFloat = new ConsFloat(expectedMinusDouble);

    double expectedTimesDouble = testDouble * toOpDouble;
    ConsFloat expectedTimesConsFloat = new ConsFloat(expectedTimesDouble);

    double expectedDivideDouble = testDouble / toOpDouble;
    ConsFloat expectedDivideConsFloat = new ConsFloat(expectedDivideDouble);

    assertEquals(expectedAddConsFloat, consFloat.add(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consFloat.sub(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consFloat.times(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consFloat.divide(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double expectedAdd = testDouble + toOpDouble;
    ConsFloat expectedAddFloat = new ConsFloat(expectedAdd);

    double expectedMinus = toOpDouble - testDouble;
    ConsFloat expectedMinusFloat = new ConsFloat(expectedMinus);

    double expectedTimes = testDouble * toOpDouble;
    ConsFloat expectedTimesFloat = new ConsFloat(expectedTimes);

    double expectedDivide = toOpDouble / testDouble;
    ConsFloat expectedDivideFloat = new ConsFloat(expectedDivide);

    assertEquals(expectedAddFloat, consFloat.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusFloat, consFloat.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesFloat, consFloat.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideFloat, consFloat.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble ==  toOpDouble | differentDouble == 0);
    ConsFloat differentConsFloat = new ConsFloat(differentDouble);

    assertNotEquals(consFloat.addConsFloat(differentConsFloat), consFloat.addConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.subConsFloat(differentConsFloat), consFloat.subConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.timesConsFloat(differentConsFloat), consFloat.timesConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.divideConsFloat(differentConsFloat), consFloat.divideConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);

    assertNotEquals(consFloat.add(differentConsFloat), consFloat.add(toOpConsFloat), "SFloat match. Seed " + seed);
    assertNotEquals(consFloat.sub(differentConsFloat), consFloat.sub(toOpConsFloat), "SFloat match. Seed " + seed);
    assertNotEquals(consFloat.times(differentConsFloat), consFloat.times(toOpConsFloat), "SFloat match. Seed " + seed);
    assertNotEquals(consFloat.divide(differentConsFloat), consFloat.divide(toOpConsFloat), "SFloat match. Seed " + seed);

    ConsFloat zeroConsFloat = new ConsFloat(0.0);
    assertEquals(new ConsFloat(testDouble), consFloat.add(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), consFloat.sub(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consFloat.times(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, zeroConsFloat.times(consFloat), "ConsFloat don't match. Seed " + seed);

    assertEquals(new ConsFloat(testDouble), consFloat.addConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), consFloat.subConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consFloat.timesConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consFloat.divideConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opConsBinaryTest() {
    String toOpBinary = "010011"; //19
    ConsBinary toOpConsBinary = new ConsBinary(toOpBinary);

    ConsFloat expectedAddConsFloat = new ConsFloat(testDouble+19);
    ConsFloat expectedMinusConsFloat = new ConsFloat(testDouble-19);
    ConsFloat expectedTimesConsFloat = new ConsFloat(testDouble*19);
    ConsFloat expectedDivideConsFloat = new ConsFloat(testDouble/19);

    assertEquals(expectedAddConsFloat, consFloat.add(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consFloat.sub(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consFloat.times(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consFloat.divide(toOpConsBinary), "ConsFloat don't match. Seed " + seed);

    ConsBinary zeroSBinary = new ConsBinary("0");

    assertEquals(new ConsFloat(testDouble), consFloat.add(zeroSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), consFloat.sub(zeroSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(0), consFloat.times(zeroSBinary), "ConsFloat don't match. Seed " + seed);

    ConsBinary minusOneSBinary = new ConsBinary("1");
    assertEquals(new ConsFloat(-testDouble), consFloat.times(minusOneSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), consFloat.divide(minusOneSBinary), "ConsFloat don't match. Seed " + seed);

    String otherToOpBinaryString = "01101100101110101010000";//3562832
    ConsBinary otherToOpSBinary = new ConsBinary(otherToOpBinaryString);

    ConsFloat expectedOtherAddSFloat = new ConsFloat(testDouble + 3562832);
    ConsFloat expectedOtherMinusSFloat = new ConsFloat(testDouble-3562832);
    ConsFloat expectedOtherTimesSFloat = new ConsFloat(testDouble*3562832);
    ConsFloat expectedOtherDivideSFloat = new ConsFloat(testDouble/3562832);

    assertEquals(expectedOtherAddSFloat, consFloat.add(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherMinusSFloat, consFloat.sub(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherTimesSFloat, consFloat.times(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherDivideSFloat, consFloat.divide(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);

    String minusToOpBinaryString = "11101100101110101010000";//-631472
    ConsBinary minusToOpSBinary = new ConsBinary(minusToOpBinaryString);

    ConsFloat expectedMinusAddSFloat = new ConsFloat(testDouble-631472);
    ConsFloat expectedMinusMinusSFloat = new ConsFloat(testDouble+631472);
    ConsFloat expectedMinusTimesSFloat = new ConsFloat(testDouble*-631472);
    ConsFloat expectedMinusDivideSFloat = new ConsFloat(testDouble/-631472);

    assertEquals(expectedMinusAddSFloat, consFloat.add(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusMinusSFloat, consFloat.sub(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusTimesSFloat, consFloat.times(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusDivideSFloat, consFloat.divide(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
  }
  @RepeatedTest(50)
  void opConsInTest() {
    int toOpInt;
    do {
      toOpInt = rng.nextInt();
    }while (toOpInt == 0);

    ConsInt toOpConsInt = new ConsInt(toOpInt);

    double expectedAddDouble = testDouble + toOpInt;
    ConsFloat expectedAddConsFloat = new ConsFloat(expectedAddDouble);

    double expectedMinusDouble = toOpInt - testDouble;
    ConsFloat expectedMinusConsFloat = new ConsFloat(expectedMinusDouble);

    double expectedTimesDouble = testDouble * toOpInt;
    ConsFloat expectedTimesConsFloat = new ConsFloat(expectedTimesDouble);

    double expectedDivideDouble = toOpInt / testDouble;
    ConsFloat expectedDivideConsFloat = new ConsFloat(expectedDivideDouble);

    assertEquals(expectedAddConsFloat, consFloat.addConsInt(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consFloat.subConsInt(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consFloat.timesConsInt(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consFloat.divideConsInt(toOpConsInt), "ConsFloat don't match. Seed " + seed);

    double expectedAdd = testDouble + toOpInt;
    ConsFloat expectedAddFloat = new ConsFloat(expectedAdd);

    double expectedMinus = testDouble - toOpInt;
    ConsFloat expectedMinusFloat = new ConsFloat(expectedMinus);

    double expectedTimes = testDouble * toOpInt;
    ConsFloat expectedTimesFloat = new ConsFloat(expectedTimes);

    double expectedDivide = testDouble / toOpInt;
    ConsFloat expectedDivideFloat = new ConsFloat(expectedDivide);

    assertEquals(expectedAddFloat, consFloat.add(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusFloat, consFloat.sub(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesFloat, consFloat.times(toOpConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideFloat, consFloat.divide(toOpConsInt), "ConsFloat don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt ==  toOpInt | differentInt == 0);
    ConsInt differentConsInt = new ConsInt(differentInt);

    assertNotEquals(consFloat.addConsInt(differentConsInt), consFloat.addConsInt(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.subConsInt(differentConsInt), consFloat.subConsInt(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.timesConsInt(differentConsInt), consFloat.timesConsInt(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.divideConsInt(differentConsInt), consFloat.divideConsInt(toOpConsInt), "ConsFloat match. Seed " + seed);

    assertNotEquals(consFloat.add(differentConsInt), consFloat.add(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.sub(differentConsInt), consFloat.sub(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.times(differentConsInt), consFloat.times(toOpConsInt), "ConsFloat match. Seed " + seed);
    assertNotEquals(consFloat.divide(differentConsInt), consFloat.divide(toOpConsInt), "ConsFloat match. Seed " + seed);


    ConsInt zeroConsInt = new ConsInt(0);
    assertEquals(new ConsFloat(testDouble), consFloat.addConsInt(zeroConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), consFloat.subConsInt(zeroConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(0), consFloat.timesConsInt(zeroConsInt), "ConsFloat don't match. Seed " + seed);

    assertEquals(new ConsFloat(testDouble), consFloat.add(zeroConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), consFloat.sub(zeroConsInt), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(0), consFloat.times(zeroConsInt), "ConsFloat don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStringTest(){
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize= rng.nextInt(50);
    String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString ConsString = new ConsString(testString);

    String expectedString = testString + testDouble;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consFloat.addConsStr(ConsString), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    double differentToAddDouble;
    do { differentToAddDouble = rng.nextDouble();
    } while (differentToAddDouble == testDouble);
    ConsString differentConsString = new ConsString(differentString + differentToAddDouble);

    assertNotEquals(differentConsString, consFloat.addConsStr(ConsString), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(100)
  void nullOpTests(){
    IConstant nullConstant = NullConstant.getInstance();

    assertSame(nullConstant, consFloat.add(nullConstant));
    assertSame(nullConstant, consFloat.sub(nullConstant));
    assertSame(nullConstant, consFloat.times(nullConstant));
    assertSame(nullConstant, consFloat.divide(nullConstant));
    assertSame(nullConstant, consFloat.and(nullConstant));
    assertSame(nullConstant, consFloat.or(nullConstant));

    assertSame(nullConstant, consFloat.addNull(nullConstant));
    assertSame(nullConstant, consFloat.subNull(nullConstant));
    assertSame(nullConstant, consFloat.timesNull(nullConstant));
    assertSame(nullConstant, consFloat.divideNull(nullConstant));
    assertSame(nullConstant, consFloat.andNull(nullConstant));
    assertSame(nullConstant, consFloat.orNull(nullConstant));

    int testInt = rng.nextInt();
    ConsInt consInt = new ConsInt(testInt);

    assertSame(nullConstant, consFloat.andConsInt(consInt));
    assertSame(nullConstant, consFloat.orConsInt(consInt));

    assertSame(nullConstant, consFloat.and(consInt));
    assertSame(nullConstant, consFloat.or(consInt));

    double testOtherDouble = rng.nextDouble();
    ConsFloat otherConsFloat = new ConsFloat(testOtherDouble);

    assertSame(nullConstant, consFloat.andConsFloat(otherConsFloat));
    assertSame(nullConstant, consFloat.orConsFloat(otherConsFloat));

    assertSame(nullConstant, consFloat.and(otherConsFloat));
    assertSame(nullConstant, consFloat.or(otherConsFloat));

    char[] binaryList = {'0', '1'};
    int binSize = rng.nextInt(32);
    String testBinary = RandomStringUtils.random(binSize, 0, 2, false, true, binaryList, rng);
    ConsBinary consBinary = new ConsBinary(testBinary);

    assertSame(nullConstant, consFloat.addConsBinary(consBinary));
    assertSame(nullConstant, consFloat.subConsBinary(consBinary));
    assertSame(nullConstant, consFloat.timesConsBinary(consBinary));
    assertSame(nullConstant, consFloat.divideConsBinary(consBinary));
    assertSame(nullConstant, consFloat.andConsBinary(consBinary));
    assertSame(nullConstant, consFloat.orConsBinary(consBinary));

    assertSame(nullConstant, consFloat.and(consBinary));
    assertSame(nullConstant, consFloat.or(consBinary));

    boolean testBool = rng.nextBoolean();
    ConsBool consBool = new ConsBool(testBool);

    assertSame(nullConstant, consFloat.addConsBool(consBool));
    assertSame(nullConstant, consFloat.subConsBool(consBool));
    assertSame(nullConstant, consFloat.timesConsBool(consBool));
    assertSame(nullConstant, consFloat.divideConsBool(consBool));
    assertSame(nullConstant, consFloat.andConsBool(consBool));
    assertSame(nullConstant, consFloat.orConsBool(consBool));

    assertSame(nullConstant, consFloat.sub(consBool));
    assertSame(nullConstant, consFloat.times(consBool));
    assertSame(nullConstant, consFloat.divide(consBool));
    assertSame(nullConstant, consFloat.and(consBool));
    assertSame(nullConstant, consFloat.or(consBool));

    int strSize = rng.nextInt(50);
    String otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString otherConsString = new ConsString(otherString);

    assertSame(nullConstant, consFloat.subConsStr(otherConsString));
    assertSame(nullConstant, consFloat.timesConsStr(otherConsString));
    assertSame(nullConstant, consFloat.divideConsStr(otherConsString));
    assertSame(nullConstant, consFloat.andConsStr(otherConsString));
    assertSame(nullConstant, consFloat.orConsStr(otherConsString));

    assertSame(nullConstant, consFloat.add(otherConsString));
    assertSame(nullConstant, consFloat.sub(otherConsString));
    assertSame(nullConstant, consFloat.times(otherConsString));
    assertSame(nullConstant, consFloat.divide(otherConsString));
    assertSame(nullConstant, consFloat.and(otherConsString));
    assertSame(nullConstant, consFloat.or(otherConsString));

    assertSame(nullConstant, consFloat.toConstantInt());
    assertSame(nullConstant, consFloat.toConstantBinary());
    assertSame(nullConstant, consFloat.toConstantBool());
    assertSame(nullConstant, consFloat.negateConstant());

  }
}