package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SBool;
import cl.uchile.dcc.scrabble.model.Types.SFloat;
import cl.uchile.dcc.scrabble.model.Types.SInt;
import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ConsBinaryTest {
  private final char[] binaryList = {'0', '1'};
  private ConsBinary consBinary;
  private String testBinary;
  private int seed;
  private Random rng;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize = rng.nextInt(32);
    testBinary = RandomStringUtils.random(strSize, 0, 2, false, true, binaryList, rng);
    consBinary = new ConsBinary(testBinary);
  }

  @RepeatedTest(50)
  void constructorTest() {
    ConsBinary expectedConsBinary = new ConsBinary(testBinary);
    SBinary expectedSBinary = new SBinary(testBinary);

    assertEquals(expectedConsBinary, consBinary, "ConsBinary don't match. Seed " + seed);
    assertNotEquals(consBinary, testBinary, "Objects match. Seed " + seed);

    assertEquals(expectedConsBinary.hashCode(), consBinary.hashCode(),
        "Hashcode don't match. Seed " + seed);
    assertEquals(expectedSBinary, expectedConsBinary.getSType());
    String differentBinary;

    do {
      differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
          false, true, binaryList, rng);
    } while (differentBinary.equals(testBinary));

    ConsBinary differentConsBinary = new ConsBinary(differentBinary);
    SBinary differentSBinary = new SBinary(differentBinary);
    assertNotEquals(differentConsBinary, consBinary, "ConsBinary match. Seed " + seed);
    assertNotEquals(differentSBinary, consBinary.getSType());

    assertEquals(testBinary, consBinary.toString(), "String don't match. Seed " + seed);
    assertNotEquals(differentBinary, consBinary.toString(), "String match. Seed " + seed);
  }
  @Test
  void toConsIntAndConsFloatTest() {
    String negativeBinary = "101010";
    ConsBinary negativeConsBinary = new ConsBinary(negativeBinary);
    ConsInt expectedNegativeConsInt = new ConsInt(-22);
    ConsFloat expectedNegativeConsFloat = new ConsFloat(-22.0);

    assertEquals(expectedNegativeConsInt, negativeConsBinary.toConstantInt(),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedNegativeConsFloat, negativeConsBinary.toConstantFloat(),
        "ConsFloat don't match. Seed " + seed);

    String zeroBinary = "0";
    ConsBinary zeroConsBinary = new ConsBinary(zeroBinary);
    ConsInt expectedZeroConsInt = new ConsInt(0);
    ConsFloat expectedZeroConsFloat = new ConsFloat(0.0);

    assertEquals(expectedZeroConsInt, zeroConsBinary.toConstantInt(), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedZeroConsFloat, zeroConsBinary.toConstantFloat(),  "ConsFloat don't match. Seed " + seed);

    String oneBinary = "01";
    ConsBinary oneConsBinary = new ConsBinary(oneBinary);
    ConsInt expectedOneConsInt = new ConsInt(1);
    ConsFloat expectedOneConsFloat = new ConsFloat(1.0);

    assertEquals(expectedOneConsInt, oneConsBinary.toConstantInt(), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOneConsFloat, oneConsBinary.toConstantFloat(), "ConsFloat don't match. Seed " + seed);

    String positiveBinary = "011101";
    ConsBinary positiveConsBinary = new ConsBinary(positiveBinary);
    ConsInt expectedPositiveConsInt = new ConsInt(29);
    ConsFloat expectedPositiveConsFloat = new ConsFloat(29.0);

    assertEquals(expectedPositiveConsInt, positiveConsBinary.toConstantInt(),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedPositiveConsFloat, positiveConsBinary.toConstantFloat(),
        "ConsFloat don't match. Seed " + seed);

    String largestBinary = "01111111111111111111111111111111";
    ConsBinary largestConsBinary = new ConsBinary(largestBinary);
    ConsInt expectedLargestConsInt = new ConsInt(2147483647);
    ConsFloat expectedLargestConsFloat = new ConsFloat(2147483647.0);

    assertEquals(expectedLargestConsInt, largestConsBinary.toConstantInt(),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedLargestConsFloat, largestConsBinary.toConstantFloat(),
        "ConsFloat don't match. Seed " + seed);

    String smallestBinary = "10000000000000000000000000000000";
    ConsBinary smallestConsBinary = new ConsBinary(smallestBinary);
    ConsInt expectedSmallestConsInt = new ConsInt(-2147483647);
    ConsFloat expectedSmallestConsFloat = new ConsFloat(-2147483647.0);

    assertEquals(expectedSmallestConsInt, smallestConsBinary.toConstantInt(),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedSmallestConsFloat, smallestConsBinary.toConstantFloat(),
        "ConsFloat don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsBinaryTest() {
    ConsBinary expectedConsBinary = new ConsBinary(testBinary);
    assertEquals(expectedConsBinary, consBinary.toConstantBinary(), "ConsBinary don't match. Seed " + seed);

    String differentBinary;
    do {
      differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
          false, true, binaryList, rng);
    } while (differentBinary.equals(testBinary));
    ConsBinary differentConsBinary = new ConsBinary(differentBinary);
    assertNotEquals(differentConsBinary, consBinary.toConstantBinary(), "ConsBinary match. Seed " + seed);

  }

  @RepeatedTest(50)
  void toSStringTest() {
    ConsString expectedConsString = new ConsString(testBinary);
    assertEquals(expectedConsString, consBinary.toConstantStr(), "ConsString don't match. Seed " + seed);

    String differentBinary;
    do {
      differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
          false, true, binaryList, rng);
    } while (differentBinary.equals(testBinary));
    ConsString differentConsString = new ConsString(differentBinary);

    assertNotEquals(differentConsString, consBinary.toConstantStr(), "ConsString match. Seed " + seed);
  }

  @Test
  void negateConstantTest() {
    ConsBinary testConsBinary = new ConsBinary("101011");
    ConsBinary expectedConsSBinary = new ConsBinary("010100");

    assertEquals(expectedConsSBinary, testConsBinary.negateConstant(), "ConsBinary don't match. Seed " + seed);
  }

  @Test
  void orAndConsBinaryTest() {
    ConsBinary testConsBinary = new ConsBinary("101011");
    ConsBinary toOperateConsBinary = new ConsBinary("110010");

    ConsBinary expectedOrConsBinary = new ConsBinary("111011");
    ConsBinary expectedAndConsBinary = new ConsBinary("100010");

    assertEquals(expectedOrConsBinary, testConsBinary.orConsBinary(toOperateConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndConsBinary, testConsBinary.andConsBinary(toOperateConsBinary),
        "ConsBinary don't match. Seed " + seed);
  }
  @Test
  void orAndConsBoolTest() {
    ConsBinary testConsBinary = new ConsBinary("101011");
    ConsBool toOperateTrueConsBool = new ConsBool(true);
    ConsBool toOperateFalseConsBool = new ConsBool(false);

    ConsBinary expectedOrTrueConsBool = new ConsBinary("111111");
    ConsBinary expectedAndTrueConsBool = new ConsBinary("101011");

    ConsBinary expectedOrFalseSBool = new ConsBinary("101011");
    ConsBinary expectedAndFalseSBool = new ConsBinary("000000");

    assertEquals(expectedOrTrueConsBool, testConsBinary.orConsBool(toOperateTrueConsBool),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndTrueConsBool, testConsBinary.andConsBool(toOperateTrueConsBool),
        "ConsBinary don't match. Seed " + seed);

    assertEquals(expectedOrFalseSBool, testConsBinary.orConsBool(toOperateFalseConsBool),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndFalseSBool, testConsBinary.andConsBool(toOperateFalseConsBool),
        "ConsBinary don't match. Seed " + seed);

    ConsBinary toOperateConsBinary = new ConsBinary("110010");

    ConsBinary expectedOrConsBinary = new ConsBinary("111011");
    ConsBinary expectedAndConsBinary = new ConsBinary("100010");

    assertEquals(expectedOrConsBinary, testConsBinary.or(toOperateConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndConsBinary, testConsBinary.and(toOperateConsBinary),
        "ConsBinary don't match. Seed " + seed);
  }
  @Test
  void orAndTest() {
    ConsBinary testConsBinary = new ConsBinary("101011");
    ConsBool toOperateTrueConsBool = new ConsBool(true);
    ConsBool toOperateFalseConsBool = new ConsBool(false);

    ConsBinary expectedOrTrueConsBool = new ConsBinary("111111");
    ConsBinary expectedAndTrueConsBool = new ConsBinary("101011");

    ConsBinary expectedOrFalseConsBool = new ConsBinary("101011");
    ConsBinary expectedAndFalseConsBool = new ConsBinary("000000");

    assertEquals(expectedOrTrueConsBool, testConsBinary.or(toOperateTrueConsBool),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndTrueConsBool, testConsBinary.and(toOperateTrueConsBool),
        "ConsBinary don't match. Seed " + seed);

    assertEquals(expectedOrFalseConsBool, testConsBinary.or(toOperateFalseConsBool),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAndFalseConsBool, testConsBinary.and(toOperateFalseConsBool),
        "ConsBinary don't match. Seed " + seed);
  }
  @Test
  void opConsBinaryTest() {
    String positiveBinary = "010011"; //19
    String toOpBinaryString = "0101001";//41

    ConsBinary positiveConsBinary = new ConsBinary(positiveBinary);
    ConsBinary toOpConsBinary = new ConsBinary(toOpBinaryString);

    ConsBinary expectedAddConsBinary = new ConsBinary("0111100");
    ConsBinary expectedMinusConsBinary = new ConsBinary("101010");
    ConsBinary expectedTimesConsBinary = new ConsBinary("01100001011");
    ConsBinary expectedDivideConsBinary = new ConsBinary("0");

    assertEquals(expectedAddConsBinary, positiveConsBinary.add(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusConsBinary, positiveConsBinary.sub(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimesConsBinary, positiveConsBinary.times(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedDivideConsBinary, positiveConsBinary.divide(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    assertEquals(expectedAddConsBinary, positiveConsBinary.addConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(expectedMinusConsBinary.getSType().negate().addOne().toString()),
        positiveConsBinary.subConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimesConsBinary, positiveConsBinary.timesConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("010"), positiveConsBinary.divideConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    ConsBinary zeroConsBinary = new ConsBinary("0");

    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.add(zeroConsBinary),
        "ConsBinary don't match. Seed" + seed);
    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.sub(zeroConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), positiveConsBinary.times(zeroConsBinary),
        "ConsBinary don't match. Seed" + seed);

    ConsBinary minusOneConsBinary = new ConsBinary("11");
    assertEquals(new ConsBinary(positiveConsBinary.getSType().negate().addOne().toString()),
        positiveConsBinary.times(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(positiveConsBinary.getSType()
            .negate().addOne().toString()),
        positiveConsBinary.divide(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherBinary = "0110110";
    String otherToOpBinaryString = "01001";

    ConsBinary otherConsBinary = new ConsBinary(otherBinary);
    ConsBinary otherToOpConsBinary = new ConsBinary(otherToOpBinaryString);

    ConsBinary expectedOtherAddSBinary = new ConsBinary("0111111");
    ConsBinary expectedOtherMinusSBinary = new ConsBinary("0101101");
    ConsBinary expectedOtherTimesSBinary = new ConsBinary("0111100110");
    ConsBinary expectedOtherDivideSBinary = new ConsBinary("0110");

    assertEquals(expectedOtherAddSBinary, otherConsBinary.add(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherMinusSBinary, otherConsBinary.sub(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherTimesSBinary, otherConsBinary.times(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherDivideSBinary, otherConsBinary.divide(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    String minusBinary = "1110110";
    String anotherToOpBinaryString = "011001";

    ConsBinary minusConsBinary = new ConsBinary(minusBinary);
    ConsBinary anotherToOpConsBinary = new ConsBinary(anotherToOpBinaryString);

    ConsBinary expectedAnotherAddConsBinary = new ConsBinary("01111");
    ConsBinary expectedAnotherMinusConsBinary = new ConsBinary("1011101");
    ConsBinary expectedAnotherTimesConsBinary = new ConsBinary("100000110");
    ConsBinary expectedAnotherDivideConsBinary = new ConsBinary("0");

    assertEquals(expectedAnotherAddConsBinary, minusConsBinary.add(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherMinusConsBinary, minusConsBinary.sub(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherTimesConsBinary, minusConsBinary.times(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherDivideConsBinary, minusConsBinary.divide(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    String otherMinusBinary = "10010";
    String minusToOpBinaryString = "1010";

    ConsBinary otherMinusConsBinary = new ConsBinary(otherMinusBinary);
    ConsBinary minusToOpConsBinary = new ConsBinary(minusToOpBinaryString);

    ConsBinary expectedMinusAddSBinary = new ConsBinary("101100");
    ConsBinary expectedMinusMinusSBinary = new ConsBinary("11000");
    ConsBinary expectedMinusTimesSBinary = new ConsBinary("01010100");
    ConsBinary expectedMinusDivideSBinary = new ConsBinary("010");

    assertEquals(expectedMinusAddSBinary, otherMinusConsBinary.add(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusMinusSBinary, otherMinusConsBinary.sub(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusTimesSBinary, otherMinusConsBinary.times(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusDivideSBinary, otherMinusConsBinary.divide(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
  }
  @RepeatedTest(50)
  void opConsFloatTest() {
    double testDouble = rng.nextDouble();

    ConsBinary toOpConsBinary = new ConsBinary("010011"); //19
    ConsFloat toOpConsFloat = new ConsFloat(testDouble);

    ConsFloat expectedAddConsFloat = new ConsFloat(testDouble+19);
    ConsFloat expectedMinusConsFloat = new ConsFloat(testDouble-19);
    ConsFloat expectedTimesConsFloat = new ConsFloat(testDouble*19);
    ConsFloat expectedDivideConsFloat = new ConsFloat(testDouble/19);

    assertEquals(expectedAddConsFloat, toOpConsBinary.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, toOpConsBinary.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, toOpConsBinary.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, toOpConsBinary.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    ConsBinary zeroConsBinary = new ConsBinary("0");

    assertEquals(new ConsFloat(testDouble), zeroConsBinary.addConsFloat(new ConsFloat(testDouble)), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testDouble), zeroConsBinary.subConsFloat(new ConsFloat(testDouble)), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(0), zeroConsBinary.timesConsFloat(new ConsFloat(testDouble)), "ConsFloat don't match. Seed " + seed);

    ConsBinary minusOneConsBinary = new ConsBinary("1");
    assertEquals(new ConsFloat(-testDouble), minusOneConsBinary.timesConsFloat(new ConsFloat(testDouble)), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testDouble), minusOneConsBinary.divideConsFloat(new ConsFloat(testDouble)), "ConsFloat don't match. Seed " + seed);

    String otherToOpBinaryString = "01101100101110101010000";//3562832
    ConsBinary otherToOpConsBinary = new ConsBinary(otherToOpBinaryString);

    ConsFloat expectedOtherAddConsFloat = new ConsFloat(testDouble + 3562832);
    ConsFloat expectedOtherMinusConsFloat = new ConsFloat(testDouble-3562832);
    ConsFloat expectedOtherTimesConsFloat = new ConsFloat(testDouble*3562832);
    ConsFloat expectedOtherDivideConsFloat = new ConsFloat(testDouble/3562832);

    assertEquals(expectedOtherAddConsFloat, otherToOpConsBinary.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherMinusConsFloat, otherToOpConsBinary.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherTimesConsFloat, otherToOpConsBinary.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedOtherDivideConsFloat, otherToOpConsBinary.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    String minusToOpBinaryString = "11101100101110101010000";//-631472
    ConsBinary minusToOpConsBinary = new ConsBinary(minusToOpBinaryString);

    ConsFloat expectedMinusAddConsFloat = new ConsFloat(testDouble-631472);
    ConsFloat expectedMinusMinusConsFloat = new ConsFloat(testDouble+631472);
    ConsFloat expectedMinusTimesConsFloat = new ConsFloat(testDouble*-631472);
    ConsFloat expectedMinusDivideConsFloat = new ConsFloat(testDouble/-631472);

    assertEquals(expectedMinusAddConsFloat, minusToOpConsBinary.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusMinusConsFloat, minusToOpConsBinary.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusTimesConsFloat, minusToOpConsBinary.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusDivideConsFloat, minusToOpConsBinary.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
  }
  @Test
  void opConsIntTest() {
    String positiveBinary = "010011";//19
    int toOpBinaryInt = 25;

    ConsBinary positiveConsBinary = new ConsBinary(positiveBinary);
    ConsInt toOpConsInt = new ConsInt(toOpBinaryInt);

    ConsBinary expectedAddConsBinary = new ConsBinary("0101100");
    ConsBinary expectedMinusConsBinary = new ConsBinary("1010");
    ConsBinary expectedTimesConsBinary = new ConsBinary("0111011011");
    ConsBinary expectedDivideConsBinary = new ConsBinary("0");

    assertEquals(expectedAddConsBinary, positiveConsBinary.add(toOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusConsBinary, positiveConsBinary.sub(toOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimesConsBinary, positiveConsBinary.times(toOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedDivideConsBinary, positiveConsBinary.divide(toOpConsInt),
        "ConsBinary don't match. Seed " + seed);

    ConsInt expectedAddConsInt = new ConsInt(44);
    ConsInt expectedMinusConsInt = new ConsInt(6);
    ConsInt expectedTimesConsInt = new ConsInt(475);
    ConsInt expectedDivideConsInt = new ConsInt(1);

    assertEquals(expectedAddConsInt, positiveConsBinary.addConsInt(toOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusConsInt, positiveConsBinary.subConsInt(toOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedTimesConsInt, positiveConsBinary.timesConsInt(toOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedDivideConsInt, positiveConsBinary.divideConsInt(toOpConsInt),
        "ConsInt don't match. Seed " + seed);

    ConsInt zeroConsInt = new ConsInt(0);

    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.add(zeroConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.sub(zeroConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), positiveConsBinary.times(zeroConsInt),
        "ConsBinary don't match. Seed " + seed);


    assertEquals(new ConsInt(19), positiveConsBinary.addConsInt(zeroConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(-19), positiveConsBinary.subConsInt(zeroConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(0), positiveConsBinary.timesConsInt(zeroConsInt),
        "ConsInt don't match. Seed " + seed);

    ConsInt minusOneConsInt = new ConsInt(-1);
    assertEquals(new ConsBinary(positiveConsBinary.getSType().negate().addOne().toString()), positiveConsBinary.times(minusOneConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(positiveConsBinary.getSType().negate().addOne().toString()), positiveConsBinary.divide(minusOneConsInt),
        "ConsBinary don't match. Seed " + seed);

    assertEquals(new ConsInt(-19), positiveConsBinary.timesConsInt(minusOneConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(0), positiveConsBinary.divideConsInt(minusOneConsInt),
        "ConsInt don't match. Seed " + seed);

    String otherBinaryString = "0110010";//50
    int otherToOpInt = 9;

    ConsBinary otherConsBinary = new ConsBinary(otherBinaryString);
    ConsInt otherToOpConsInt = new ConsInt(otherToOpInt);

    ConsBinary expectedOtherAddConsBinary = new ConsBinary("0111011");
    ConsBinary expectedOtherMinusConsBinary = new ConsBinary("0101001");
    ConsBinary expectedOtherTimesConsBinary = new ConsBinary("0111000010");
    ConsBinary expectedOtherDivideConsBinary = new ConsBinary("0101");

    assertEquals(expectedOtherAddConsBinary, otherConsBinary.add(otherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherMinusConsBinary, otherConsBinary.sub(otherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherTimesConsBinary, otherConsBinary.times(otherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherDivideConsBinary, otherConsBinary.divide(otherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);

    ConsInt expectedOtherAddConsInt = new ConsInt(59);
    ConsInt expectedOtherMinusConsInt = new ConsInt(-41);
    ConsInt expectedOtherTimesConsInt = new ConsInt(450);
    ConsInt expectedOtherDivideConsInt = new ConsInt(0);

    assertEquals(expectedOtherAddConsInt, otherConsBinary.addConsInt(otherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherMinusConsInt, otherConsBinary.subConsInt(otherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherTimesConsInt, otherConsBinary.timesConsInt(otherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherDivideConsInt, otherConsBinary.divideConsInt(otherToOpConsInt),
        "ConsInt don't match. Seed " + seed);

    String minusBinary = "1010110";//-42
    int anotherToOpInt = 15;

    ConsBinary minusConsBinary = new ConsBinary(minusBinary);
    ConsInt anotherToOpConsInt = new ConsInt(anotherToOpInt);

    ConsBinary expectedAnotherAddConsBinary = new ConsBinary("100101");
    ConsBinary expectedAnotherMinusConsBinary = new ConsBinary("1000111");
    ConsBinary expectedAnotherTimesConsBinary = new ConsBinary("10110001010");
    ConsBinary expectedAnotherDivideConsBinary = new ConsBinary("110");

    assertEquals(expectedAnotherAddConsBinary, minusConsBinary.add(anotherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherMinusConsBinary, minusConsBinary.sub(anotherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherTimesConsBinary, minusConsBinary.times(anotherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherDivideConsBinary, minusConsBinary.divide(anotherToOpConsInt),
        "ConsBinary don't match. Seed " + seed);

    ConsInt expectedAnotherAddConsInt = new ConsInt(-27);
    ConsInt expectedAnotherMinusConsInt = new ConsInt(57);
    ConsInt expectedAnotherTimesConsInt = new ConsInt(-630);
    ConsInt expectedAnotherDivideConsInt = new ConsInt(0);

    assertEquals(expectedAnotherAddConsInt, minusConsBinary.addConsInt(anotherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedAnotherMinusConsInt, minusConsBinary.subConsInt(anotherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedAnotherTimesConsInt, minusConsBinary.timesConsInt(anotherToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedAnotherDivideConsInt, minusConsBinary.divideConsInt(anotherToOpConsInt),
        "ConsInt don't match. Seed " + seed);

    String otherMinusBinary = "10010";//-14
    int minusToOpInt = -7;

    ConsBinary otherMinusConsBinary = new ConsBinary(otherMinusBinary);
    ConsInt minusToOpConsInt = new ConsInt(minusToOpInt);

    ConsBinary expectedMinusAddConsBinary = new ConsBinary("101011");
    ConsBinary expectedMinusMinusConsBinary = new ConsBinary("1001");
    ConsBinary expectedMinusTimesConsBinary = new ConsBinary("01100010");
    ConsBinary expectedMinusDivideConsBinary = new ConsBinary("010");

    assertEquals(expectedMinusAddConsBinary, otherMinusConsBinary.add(minusToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusMinusConsBinary, otherMinusConsBinary.sub(minusToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusTimesConsBinary, otherMinusConsBinary.times(minusToOpConsInt),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusDivideConsBinary, otherMinusConsBinary.divide(minusToOpConsInt),
        "ConsBinary don't match. Seed " + seed);

    ConsInt expectedMinusAddConsInt = new ConsInt(-21);
    ConsInt expectedMinusMinusConsInt = new ConsInt(7);
    ConsInt expectedMinusTimesConsInt = new ConsInt(98);
    ConsInt expectedMinusDivideConsInt = new ConsInt(0);

    assertEquals(expectedMinusAddConsInt, otherMinusConsBinary.addConsInt(minusToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusMinusConsInt, otherMinusConsBinary.subConsInt(minusToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusTimesConsInt, otherMinusConsBinary.timesConsInt(minusToOpConsInt),
        "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusDivideConsInt, otherMinusConsBinary.divideConsInt(minusToOpConsInt),
        "ConsInt don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStrTest() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize= rng.nextInt(50);
    String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString sString = new ConsString(testString);

    char [] binaryList = {'0', '1'};
    String toAddStringBinary = RandomStringUtils.random(rng.nextInt(50), 0,
        2, false, true, binaryList, rng);
    ConsBinary toAddSBinary = new ConsBinary(toAddStringBinary);

    String expectedString = testString + toAddStringBinary;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, toAddSBinary.addConsStr(sString), "ConsString don't match. Seed " + seed);

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

    ConsString differentSString = new ConsString(differentString + differentToAddStringBinary);
    assertNotEquals(differentSString, toAddSBinary.addConsStr(sString), "ConsString match. Seed " + seed);
  }

}