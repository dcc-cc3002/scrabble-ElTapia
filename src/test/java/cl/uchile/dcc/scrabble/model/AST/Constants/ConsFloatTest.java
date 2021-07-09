package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SInt;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ConsFloatTest {
  private ConsFloat consFloat;
  private double testDouble;
  private int seed;
  private Random rng;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testDouble = rng.nextDouble();
    consFloat = new ConsFloat(testDouble);
  }

  @RepeatedTest(50)
  void constructorTest(){
    ConsFloat expectedConsFloat = new ConsFloat(testDouble);

    assertEquals(expectedConsFloat, consFloat, "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedConsFloat.hashCode(), consFloat.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(new SFloat(testDouble), consFloat.getSType(), "SFloat don't match. Seed " + seed);
    assertNotEquals(consFloat, testDouble, "Objects match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble == testDouble);

    ConsFloat differentConsFloat = new ConsFloat(differentDouble);
    assertNotEquals(new SFloat(differentDouble), consFloat.getSType(), "SFloat match. Seed " + seed);
    assertNotEquals(differentConsFloat, consFloat, "ConsFloat match. Seed " + seed);

    assertEquals(String.valueOf(testDouble), consFloat.toString(), "String don't match. Seed " + seed);
    assertNotEquals(String.valueOf(differentDouble), consFloat.toString(), "String match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opSFloatTest() {
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

    assertEquals(expectedAddConsFloat, consFloat.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consFloat.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consFloat.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consFloat.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double expectedAdd = testDouble + toOpDouble;
    ConsFloat expectedAddFloat = new ConsFloat(expectedAdd);

    double expectedMinus = toOpDouble - testDouble;
    ConsFloat expectedMinusFloat = new ConsFloat(expectedMinus);

    double expectedTimes = testDouble * toOpDouble;
    ConsFloat expectedTimesFloat = new ConsFloat(expectedTimes);

    double expectedDivide = toOpDouble / testDouble;
    ConsFloat expectedDivideFloat = new ConsFloat(expectedDivide);

    assertEquals(expectedAddFloat, consFloat.add(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusFloat, consFloat.sub(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesFloat, consFloat.times(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideFloat, consFloat.divide(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

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
    assertEquals(new ConsFloat(testDouble), consFloat.addConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), consFloat.subConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consFloat.timesConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, zeroConsFloat.timesConsFloat(consFloat), "ConsFloat don't match. Seed " + seed);

    assertEquals(new ConsFloat(testDouble), consFloat.add(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), consFloat.sub(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consFloat.times(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, zeroConsFloat.times(consFloat), "ConsFloat don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opSBinaryTest() {
    String toOpBinary = "010011"; //19
    ConsBinary toOpConsBinary = new ConsBinary(toOpBinary);

    ConsFloat expectedAddConsFloat = new ConsFloat(testDouble+19);
    ConsFloat expectedMinusConsFloat = new ConsFloat(testDouble-19);
    ConsFloat expectedTimesConsFloat = new ConsFloat(testDouble*19);
    ConsFloat expectedDivideConsFloat = new ConsFloat(testDouble/19);

    assertEquals(expectedAddConsFloat, consFloat.addConsBinary(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consFloat.subConsBinary(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consFloat.timesConsBinary(toOpConsBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consFloat.divideConsBinary(toOpConsBinary), "ConsFloat don't match. Seed " + seed);

    ConsBinary zeroSBinary = new ConsBinary("0");

    assertEquals(new ConsFloat(testDouble), consFloat.addConsBinary(zeroSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), consFloat.subConsBinary(zeroSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(0), consFloat.timesConsBinary(zeroSBinary), "ConsFloat don't match. Seed " + seed);

    ConsBinary minusOneSBinary = new ConsBinary("1");
    assertEquals(new ConsFloat(-testDouble), consFloat.timesConsBinary(minusOneSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), consFloat.divideConsBinary(minusOneSBinary), "ConsFloat don't match. Seed " + seed);

    String otherToOpBinaryString = "01101100101110101010000";//3562832
    ConsBinary otherToOpSBinary = new ConsBinary(otherToOpBinaryString);

    ConsFloat expectedOtherAddSFloat = new ConsFloat(testDouble + 3562832);
    ConsFloat expectedOtherMinusSFloat = new ConsFloat(testDouble-3562832);
    ConsFloat expectedOtherTimesSFloat = new ConsFloat(testDouble*3562832);
    ConsFloat expectedOtherDivideSFloat = new ConsFloat(testDouble/3562832);

    assertEquals(expectedOtherAddSFloat, consFloat.addConsBinary(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherMinusSFloat, consFloat.subConsBinary(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherTimesSFloat, consFloat.timesConsBinary(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherDivideSFloat, consFloat.divideConsBinary(otherToOpSBinary), "ConsFloat don't match. Seed " + seed);

    String minusToOpBinaryString = "11101100101110101010000";//-631472
    ConsBinary minusToOpSBinary = new ConsBinary(minusToOpBinaryString);

    ConsFloat expectedMinusAddSFloat = new ConsFloat(testDouble-631472);
    ConsFloat expectedMinusMinusSFloat = new ConsFloat(testDouble+631472);
    ConsFloat expectedMinusTimesSFloat = new ConsFloat(testDouble*-631472);
    ConsFloat expectedMinusDivideSFloat = new ConsFloat(testDouble/-631472);

    assertEquals(expectedMinusAddSFloat, consFloat.addConsBinary(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusMinusSFloat, consFloat.subConsBinary(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusTimesSFloat, consFloat.timesConsBinary(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusDivideSFloat, consFloat.divideConsBinary(minusToOpSBinary), "ConsFloat don't match. Seed " + seed);
  }
}