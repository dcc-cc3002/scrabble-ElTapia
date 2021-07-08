package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.Types.SBinary;
import cl.uchile.dcc.scrabble.model.Types.SBool;
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

    assertEquals(expectedAddConsBinary, positiveConsBinary.addConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusConsBinary, positiveConsBinary.subConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimesConsBinary, positiveConsBinary.timesConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedDivideConsBinary, positiveConsBinary.divideConsBinary(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    assertEquals(expectedAddConsBinary, positiveConsBinary.add(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(expectedMinusConsBinary.getSType().negate().addOne().toString()),
        positiveConsBinary.sub(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimesConsBinary, positiveConsBinary.times(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("010"), positiveConsBinary.divide(toOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    ConsBinary zeroConsBinary = new ConsBinary("0");

    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.addConsBinary(zeroConsBinary),
        "ConsBinary don't match. Seed" + seed);
    assertEquals(new ConsBinary(positiveBinary), positiveConsBinary.subConsBinary(zeroConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), positiveConsBinary.timesConsBinary(zeroConsBinary),
        "ConsBinary don't match. Seed" + seed);

    ConsBinary minusOneConsBinary = new ConsBinary("11");
    assertEquals(new ConsBinary(positiveConsBinary.getSType().negate().addOne().toString()),
        positiveConsBinary.timesConsBinary(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(positiveConsBinary.getSType()
            .negate().addOne().toString()),
        positiveConsBinary.divideConsBinary(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherBinary = "0110110";
    String otherToOpBinaryString = "01001";

    ConsBinary otherConsBinary = new ConsBinary(otherBinary);
    ConsBinary otherToOpConsBinary = new ConsBinary(otherToOpBinaryString);

    ConsBinary expectedOtherAddSBinary = new ConsBinary("0111111");
    ConsBinary expectedOtherMinusSBinary = new ConsBinary("0101101");
    ConsBinary expectedOtherTimesSBinary = new ConsBinary("0111100110");
    ConsBinary expectedOtherDivideSBinary = new ConsBinary("0110");

    assertEquals(expectedOtherAddSBinary, otherConsBinary.addConsBinary(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherMinusSBinary, otherConsBinary.subConsBinary(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherTimesSBinary, otherConsBinary.timesConsBinary(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherDivideSBinary, otherConsBinary.divideConsBinary(otherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    String minusBinary = "1110110";
    String anotherToOpBinaryString = "011001";

    ConsBinary minusConsBinary = new ConsBinary(minusBinary);
    ConsBinary anotherToOpConsBinary = new ConsBinary(anotherToOpBinaryString);

    ConsBinary expectedAnotherAddConsBinary = new ConsBinary("01111");
    ConsBinary expectedAnotherMinusConsBinary = new ConsBinary("1011101");
    ConsBinary expectedAnotherTimesConsBinary = new ConsBinary("100000110");
    ConsBinary expectedAnotherDivideConsBinary = new ConsBinary("0");

    assertEquals(expectedAnotherAddConsBinary, minusConsBinary.addConsBinary(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherMinusConsBinary, minusConsBinary.subConsBinary(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherTimesConsBinary, minusConsBinary.timesConsBinary(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedAnotherDivideConsBinary, minusConsBinary.divideConsBinary(anotherToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);

    String otherMinusBinary = "10010";
    String minusToOpBinaryString = "1010";

    ConsBinary otherMinusConsBinary = new ConsBinary(otherMinusBinary);
    ConsBinary minusToOpConsBinary = new ConsBinary(minusToOpBinaryString);

    ConsBinary expectedMinusAddSBinary = new ConsBinary("101100");
    ConsBinary expectedMinusMinusSBinary = new ConsBinary("11000");
    ConsBinary expectedMinusTimesSBinary = new ConsBinary("01010100");
    ConsBinary expectedMinusDivideSBinary = new ConsBinary("010");

    assertEquals(expectedMinusAddSBinary, otherMinusConsBinary.addConsBinary(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusMinusSBinary, otherMinusConsBinary.subConsBinary(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusTimesSBinary, otherMinusConsBinary.timesConsBinary(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusDivideSBinary, otherMinusConsBinary.divideConsBinary(minusToOpConsBinary),
        "ConsBinary don't match. Seed " + seed);
  }
  @Test
  void opConsIntTest() {

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

    String expectedString = toAddStringBinary + testString;
    ConsString expectedSString = new ConsString(expectedString);

    assertEquals(expectedSString, toAddSBinary.addConsStr(sString), "ConsString don't match. Seed " + seed);

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