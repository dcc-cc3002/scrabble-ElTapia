package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.Types.SInt;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ConsIntTest {
  private ConsInt consInt;
  private int testInt;
  private int seed;
  private Random rng;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = rng.nextInt();
    consInt = new ConsInt(testInt);
  }
  @RepeatedTest(50)
  void constructorTest() {
    ConsInt expectedConsInt = new ConsInt(testInt);

    assertEquals(expectedConsInt, consInt, "ConsInt don't match. Seed " + seed);
    assertEquals(expectedConsInt.hashCode(), consInt.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(new SInt(testInt), consInt.getSType(), "SInt don't match. Seed " + seed);
    assertNotEquals(consInt, testInt, "Objects match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt == testInt);

    ConsInt differentConsInt = new ConsInt(differentInt);
    assertNotEquals(new SInt(differentInt), consInt.getSType(), "SInt match. Seed " + seed);
    assertNotEquals(differentConsInt, consInt, "ConsInt match. Seed " + seed);

    assertEquals(String.valueOf(testInt), consInt.toString(), "String don't match. Seed " + seed);
    assertNotEquals(String.valueOf(differentInt), consInt.toString(), "String match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opConsIntTest(){
    int toOpInt;
    do {
      toOpInt = rng.nextInt();
    }while (toOpInt == 0);

    ConsInt toOpConsInt = new ConsInt(toOpInt);

    int expectedAddInt = testInt + toOpInt;
    ConsInt expectedAddConsInt = new ConsInt(expectedAddInt);

    int expectedMinusInt = testInt - toOpInt;
    ConsInt expectedMinusConsInt = new ConsInt(expectedMinusInt);

    int expectedTimesInt = testInt * toOpInt;
    ConsInt expectedTimesConsInt = new ConsInt(expectedTimesInt);

    int expectedDivideInt = testInt / toOpInt;
    ConsInt expectedDivideConsInt = new ConsInt(expectedDivideInt);

    assertEquals(expectedAddConsInt, consInt.addConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusConsInt, consInt.subConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedTimesConsInt, consInt.timesConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedDivideConsInt, consInt.divideConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);

    int expectedAdd = testInt + toOpInt;
    ConsInt expectedToAddConsInt = new ConsInt(expectedAdd);

    int expectedMinus = toOpInt - testInt;
    ConsInt expectedToMinusConsInt = new ConsInt(expectedMinus);

    int expectedTimes = testInt * toOpInt;
    ConsInt expectedToTimesConsInt = new ConsInt(expectedTimes);

    int expectedDivide = toOpInt / testInt;
    ConsInt expectedToDivideConsInt = new ConsInt(expectedDivide);

    assertEquals(expectedToAddConsInt, consInt.add(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToMinusConsInt, consInt.sub(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToTimesConsInt, consInt.times(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToDivideConsInt, consInt.divide(toOpConsInt), "ConsInt don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt ==  toOpInt | differentInt == 0);
    ConsInt differentConsInt = new ConsInt(differentInt);

    assertNotEquals(consInt.addConsInt(differentConsInt), consInt.addConsInt(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.subConsInt(differentConsInt), consInt.subConsInt(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.timesConsInt(differentConsInt), consInt.timesConsInt(toOpConsInt), "ConsInt match. Seed " + seed);

    assertNotEquals(consInt.add(differentConsInt), consInt.add(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.sub(differentConsInt), consInt.sub(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.times(differentConsInt), consInt.times(toOpConsInt), "ConsInt match. Seed " + seed);

    ConsInt zeroConsInt = new ConsInt(0);
    assertEquals(new ConsInt(testInt), consInt.addConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(testInt), consInt.subConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, consInt.timesConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, zeroConsInt.timesConsInt(consInt), "ConsInt don't match. Seed " + seed);

    assertEquals(new ConsInt(testInt), consInt.add(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(-testInt), consInt.sub(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, consInt.times(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, zeroConsInt.times(consInt), "ConsInt don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opConsFloatTest(){
    double toOpDouble;
    do {
      toOpDouble = rng.nextDouble();
    }while (toOpDouble == 0);

    ConsFloat toOpConsFloat = new ConsFloat(toOpDouble);

    double expectedAddDouble = testInt + toOpDouble;
    ConsFloat expectedAddConsFloat = new ConsFloat(expectedAddDouble);

    double expectedMinusDouble = testInt - toOpDouble;
    ConsFloat expectedMinusConsFloat = new ConsFloat(expectedMinusDouble);

    double expectedTimesDouble = testInt * toOpDouble;
    ConsFloat expectedTimesConsFloat = new ConsFloat(expectedTimesDouble);

    double expectedDivideDouble = testInt / toOpDouble;
    ConsFloat expectedDivideConsFloat = new ConsFloat(expectedDivideDouble);

    assertEquals(expectedAddConsFloat, consInt.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consInt.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consInt.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consInt.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double expectedAdd = testInt + toOpDouble;
    ConsFloat expectedAddFloat = new ConsFloat(expectedAdd);

    double expectedMinus = toOpDouble - testInt;
    ConsFloat expectedMinusFloat = new ConsFloat(expectedMinus);

    double expectedTimes = testInt * toOpDouble;
    ConsFloat expectedTimesFloat = new ConsFloat(expectedTimes);

    double expectedDivide = toOpDouble / testInt;
    ConsFloat expectedDivideFloat = new ConsFloat(expectedDivide);

    assertEquals(expectedAddFloat, consInt.add(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusFloat, consInt.sub(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesFloat, consInt.times(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideFloat, consInt.divide(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble ==  toOpDouble | differentDouble == 0);
    ConsFloat differentConsFloat = new ConsFloat(differentDouble);

    assertNotEquals(consInt.addConsFloat(differentConsFloat), consInt.addConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.subConsFloat(differentConsFloat), consInt.subConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.timesConsFloat(differentConsFloat), consInt.timesConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.divideConsFloat(differentConsFloat), consInt.divideConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);

    assertNotEquals(consInt.add(differentConsFloat), consInt.add(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.sub(differentConsFloat), consInt.sub(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.times(differentConsFloat), consInt.times(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.divide(differentConsFloat), consInt.divide(toOpConsFloat), "ConsFloat match. Seed " + seed);

    ConsFloat zeroConsFloat = new ConsFloat(0.0);
    assertEquals(new ConsFloat(testInt), consInt.addConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testInt), consInt.subConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consInt.timesConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);

    assertEquals(new ConsFloat(testInt), consInt.add(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testInt), consInt.sub(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consInt.times(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
  }
  @RepeatedTest(50)
  void opConsBinaryTest(){
    String toOpBinary = "010011"; //19
    ConsBinary toOpConsBinary = new ConsBinary(toOpBinary);

    ConsInt expectedAddConsInt = new ConsInt(testInt+19);
    ConsInt expectedMinusConsInt = new ConsInt(testInt-19);
    ConsInt expectedTimesConsInt = new ConsInt(testInt*19);
    ConsInt expectedDivideConsInt = new ConsInt(testInt/19);

    assertEquals(expectedAddConsInt, consInt.addConsBinary(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusConsInt, consInt.subConsBinary(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedTimesConsInt, consInt.timesConsBinary(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedDivideConsInt, consInt.divideConsBinary(toOpConsBinary), "ConsInt don't match. Seed " + seed);


    ConsInt expectedAdd = new ConsInt(testInt+19);
    ConsInt expectedMinus = new ConsInt(19-testInt);
    ConsInt expectedTimes = new ConsInt(testInt*19);
    ConsInt expectedDivide = new ConsInt(19/testInt);

    assertEquals(expectedAdd.toConstantBinary(), consInt.add(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinus.toConstantBinary(), consInt.sub(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimes.toConstantBinary(), consInt.times(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedDivide.toConstantBinary(), consInt.divide(toOpConsBinary), "ConsBinary don't match. Seed " + seed);


    ConsBinary zeroConsBinary = new ConsBinary("0");

    assertEquals(new ConsInt(testInt), consInt.addConsBinary(zeroConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(testInt), consInt.subConsBinary(zeroConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(0), consInt.timesConsBinary(zeroConsBinary), "ConsInt don't match. Seed " + seed);

    assertEquals(consInt.toConstantBinary(), consInt.add(zeroConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(consInt.getSType().toSBinary().negate().addOne().toString()), consInt.sub(zeroConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), consInt.times(zeroConsBinary), "ConsBinary don't match. Seed " + seed);

    ConsBinary minusOneConsBinary = new ConsBinary("1");
    assertEquals(new ConsInt(-testInt), consInt.timesConsBinary(minusOneConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(-testInt), consInt.divideConsBinary(minusOneConsBinary), "ConsInt don't match. Seed " + seed);

    assertEquals(new ConsBinary(consInt.getSType().toSBinary().negate().addOne().toString()), consInt.times(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), consInt.divide(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherToOpBinaryString = "0110010";//50
    ConsBinary otherToOpConsBinary = new ConsBinary(otherToOpBinaryString);

    ConsInt expectedOtherAddConsInt = new ConsInt(testInt+50);
    ConsInt expectedOtherMinusConsInt = new ConsInt(testInt-50);
    ConsInt expectedOtherTimesConsInt = new ConsInt(testInt*50);
    ConsInt expectedOtherDivideConsInt = new ConsInt(testInt/50);

    assertEquals(expectedOtherAddConsInt, consInt.addConsBinary(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherMinusConsInt, consInt.subConsBinary(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherTimesConsInt, consInt.timesConsBinary(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherDivideConsInt, consInt.divideConsBinary(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);

    ConsInt expectedOtherAdd = new ConsInt(testInt+50);
    ConsInt expectedOtherMinus = new ConsInt(50-testInt);
    ConsInt expectedOtherTimes = new ConsInt(testInt*50);
    ConsInt expectedOtherDivide = new ConsInt(50/testInt);

    assertEquals(expectedOtherAdd.toConstantBinary(), consInt.add(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherMinus.toConstantBinary(), consInt.sub(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherTimes.toConstantBinary(), consInt.times(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherDivide.toConstantBinary(), consInt.divide(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherMinusBinary = "10010";//-14
    ConsBinary otherMinusConsBinary = new ConsBinary(otherMinusBinary);

    ConsInt expectedMinusAddConsInt = new ConsInt(testInt-14);
    ConsInt expectedMinusMinusConsInt = new ConsInt(testInt+14);
    ConsInt expectedMinusTimesConsInt = new ConsInt(testInt*-14);
    ConsInt expectedMinusDivideConsInt = new ConsInt(testInt/-14);

    assertEquals(expectedMinusAddConsInt, consInt.addConsBinary(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusMinusConsInt, consInt.subConsBinary(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusTimesConsInt, consInt.timesConsBinary(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusDivideConsInt, consInt.divideConsBinary(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);

    ConsInt expectedMinusAdd = new ConsInt(-14+testInt);
    ConsInt expectedMinusMinus = new ConsInt(-14-testInt);
    ConsInt expectedMinusTimes = new ConsInt(testInt*-14);
    ConsInt expectedMinusDivide = new ConsInt(-14/testInt);

    assertEquals(expectedMinusAdd.toConstantBinary(), consInt.add(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusMinus.toConstantBinary(), consInt.sub(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusTimes.toConstantBinary(), consInt.times(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusDivide.toConstantBinary(), consInt.divide(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStringTest(){
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize= rng.nextInt(50);
    String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString sString = new ConsString(testString);

    int toAddInt = rng.nextInt();
    ConsInt toAddConsInt = new ConsInt(toAddInt);
    String expectedString = toAddInt + testString;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, toAddConsInt.addConsStr(sString), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    int differentToAddInt;
    do { differentToAddInt = rng.nextInt();
    } while (differentToAddInt == toAddInt);
    ConsString differentConsString = new ConsString(differentString + differentToAddInt);

    assertNotEquals(differentConsString, toAddConsInt.addConsStr(sString), "ConsString match. Seed " + seed);
  }
}