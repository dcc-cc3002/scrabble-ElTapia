package cl.uchile.dcc.scrabble.model.Types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SBinaryTest {

    private final char[] binaryList = {'0', '1'};
    private SBinary toOpSBinary;
    private String testBinary;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(32);
        testBinary = RandomStringUtils.random(strSize, 0, 2, false, true, binaryList, rng);
        toOpSBinary = new SBinary(testBinary);
    }

    @RepeatedTest(100)
    void constructorTest() {
        var expectedSBinary = new SBinary(testBinary);

        assertEquals(expectedSBinary, toOpSBinary, "SBinary don't match. Seed " + seed);
        assertNotEquals(toOpSBinary, testBinary, "Objects match. Seed " + seed);

        assertEquals(expectedSBinary.hashCode(), toOpSBinary.hashCode(),
            "Hashcode don't match. Seed " + seed);
        String differentBinary;

        do {
            differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
                false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));

        var differentSBinary = new SBinary(differentBinary);
        assertNotEquals(differentSBinary, toOpSBinary, "SBinary match. Seed " + seed);

        assertEquals(testBinary, toOpSBinary.toString(), "String don't match. Seed " + seed);
        assertNotEquals(differentBinary, toOpSBinary.toString(), "String match. Seed " + seed);

        SBinary largerBinary = new SBinary("00001101");
        SBinary shorterBinary = new SBinary("01101");
        assertEquals(largerBinary, shorterBinary);

        SBinary largerMinusBinary = new SBinary("11111101");
        SBinary shorterMinusBinary = new SBinary("101");
        assertEquals(largerMinusBinary, shorterMinusBinary);
    }

    @RepeatedTest(50)
    void toSStringTest() {
        SString expectedSString = new SString(testBinary);
        assertEquals(expectedSString, toOpSBinary.toSString(), "String don't match. Seed " + seed);

        String differentBinary;
        do {
            differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
                false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));
        SString differentSString = new SString(differentBinary);

        assertNotEquals(differentSString, toOpSBinary.toSString(), "SString match. Seed " + seed);
    }

    @Test
    void toSIntAndSFloatTest() {
        String negativeBinary = "101010";
        SBinary negativeSBinary = new SBinary(negativeBinary);
        SInt expectedNegativeSInt = new SInt(-22);
        SFloat expectedNegativeSFloat = new SFloat(-22.0);

        assertEquals(expectedNegativeSInt, negativeSBinary.toSInt(),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedNegativeSFloat, negativeSBinary.toSFloat(),
            "SFloat don't match. Seed " + seed);

        String zeroBinary = "0";
        SBinary zeroSBinary = new SBinary(zeroBinary);
        SInt expectedZeroSInt = new SInt(0);
        SFloat expectedZeroSFloat = new SFloat(0.0);

        assertEquals(expectedZeroSInt, zeroSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedZeroSFloat, zeroSBinary.toSFloat(),
            "SFloat don't match. Seed " + seed);

        String oneBinary = "01";
        SBinary oneSBinary = new SBinary(oneBinary);
        SInt expectedOneSInt = new SInt(1);
        SFloat expectedOneSFloat = new SFloat(1.0);

        assertEquals(expectedOneSInt, oneSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedOneSFloat, oneSBinary.toSFloat(), "SFloat don't match. Seed " + seed);

        String positiveBinary = "011101";
        SBinary positiveSBinary = new SBinary(positiveBinary);
        SInt expectedPositiveSInt = new SInt(29);
        SFloat expectedPositiveSFloat = new SFloat(29.0);

        assertEquals(expectedPositiveSInt, positiveSBinary.toSInt(),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedPositiveSFloat, positiveSBinary.toSFloat(),
            "SFloat don't match. Seed " + seed);

        String largestBinary = "01111111111111111111111111111111";
        SBinary largestSBinary = new SBinary(largestBinary);
        SInt expectedLargestSInt = new SInt(2147483647);
        SFloat expectedLargestSFloat = new SFloat(2147483647.0);

        assertEquals(expectedLargestSInt, largestSBinary.toSInt(),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedLargestSFloat, largestSBinary.toSFloat(),
            "SFloat don't match. Seed " + seed);

        String smallestBinary = "10000000000000000000000000000000";
        SBinary smallestSBinary = new SBinary(smallestBinary);
        SInt expectedSmallestSInt = new SInt(-2147483647);
        SFloat expectedSmallestSFloat = new SFloat(-2147483647.0);

        assertEquals(expectedSmallestSInt, smallestSBinary.toSInt(),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedSmallestSFloat, smallestSBinary.toSFloat(),
            "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSBinaryTest() {
        SBinary expectedSBinary = new SBinary(testBinary);
        assertEquals(expectedSBinary, toOpSBinary.toSBinary(), "SBinary don't match. Seed " + seed);

        String differentBinary;
        do {
            differentBinary = RandomStringUtils.random(rng.nextInt(32), 0, 2,
                false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));
        SBinary differentSBinary = new SBinary(differentBinary);
        assertNotEquals(differentSBinary, toOpSBinary.toSBinary(), "SBinary match. Seed " + seed);

    }

    @Test
    void negateTest() {
        SBinary testBinary = new SBinary("101011");
        SBinary expectedSBinary = new SBinary("010100");

        assertEquals(expectedSBinary, testBinary.negate(), "SBinary don't match. Seed " + seed);
    }

    @Test
    void orAndSBinaryTest() {
        SBinary testSBinary = new SBinary("101011");
        SBinary toOperateSBinary = new SBinary("110010");

        SBinary expectedOrSBinary = new SBinary("111011");
        SBinary expectedAndSBinary = new SBinary("100010");

        assertEquals(expectedOrSBinary, testSBinary.orSBinary(toOperateSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndSBinary, testSBinary.andSBinary(toOperateSBinary),
            "SBinary don't match. Seed " + seed);

        SBinary testLargerSBinary = new SBinary("11111101011");
        SBinary toOpSBinary = new SBinary("110010");

        SBinary expectedOrLargerSBinary = new SBinary("11111111011");
        SBinary expectedAndLargerSBinary = new SBinary("11111100010");

        assertEquals(expectedOrLargerSBinary, testLargerSBinary.orSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndLargerSBinary, testLargerSBinary.andSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);
    }

    @Test
    void orAndSBoolTest() {
        SBinary testSBinary = new SBinary("101011");
        SBool toOperateTrueSBool = new SBool(true);
        SBool toOperateFalseSBool = new SBool(false);

        SBinary expectedOrTrueSBool = new SBinary("111111");
        SBinary expectedAndTrueSBool = new SBinary("101011");

        SBinary expectedOrFalseSBool = new SBinary("101011");
        SBinary expectedAndFalseSBool = new SBinary("000000");

        assertEquals(expectedOrTrueSBool, testSBinary.orSBool(toOperateTrueSBool),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndTrueSBool, testSBinary.andSBool(toOperateTrueSBool),
            "SBinary don't match. Seed " + seed);

        assertEquals(expectedOrFalseSBool, testSBinary.orSBool(toOperateFalseSBool),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndFalseSBool, testSBinary.andSBool(toOperateFalseSBool),
            "SBinary don't match. Seed " + seed);

        SBinary toOperateSBinary = new SBinary("110010");

        SBinary expectedOrSBinary = new SBinary("111011");
        SBinary expectedAndSBinary = new SBinary("100010");

        assertEquals(expectedOrSBinary, testSBinary.or(toOperateSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndSBinary, testSBinary.and(toOperateSBinary),
            "SBinary don't match. Seed " + seed);
    }

    @Test
    void orAndTest() {
        SBinary testSBinary = new SBinary("101011");
        SBool toOperateTrueSBool = new SBool(true);
        SBool toOperateFalseSBool = new SBool(false);

        SBinary expectedOrTrueSBool = new SBinary("111111");
        SBinary expectedAndTrueSBool = new SBinary("101011");

        SBinary expectedOrFalseSBool = new SBinary("101011");
        SBinary expectedAndFalseSBool = new SBinary("000000");

        assertEquals(expectedOrTrueSBool, testSBinary.or(toOperateTrueSBool),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndTrueSBool, testSBinary.and(toOperateTrueSBool),
            "SBinary don't match. Seed " + seed);

        assertEquals(expectedOrFalseSBool, testSBinary.or(toOperateFalseSBool),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndFalseSBool, testSBinary.and(toOperateFalseSBool),
            "SBinary don't match. Seed " + seed);
    }

    @Test
    void addOneTest() {
        SBinary testSBinary = new SBinary("11111");
        SBinary expectedSBinary = new SBinary("100000");

        assertEquals(expectedSBinary, testSBinary.addOne());

        SBinary otherSBinary = new SBinary("1001010101");
        SBinary expectedOtherSBinary = new SBinary("1001010110");

        assertEquals(expectedOtherSBinary, otherSBinary.addOne());
    }

    @Test
    void twosComplementsTest() {
        SBinary testSBinary = new SBinary("0101011");
        SBinary expectedSBinary = new SBinary("1010101");

        assertEquals(expectedSBinary, testSBinary.twosComplements(),
            "SBinary don't match. Seed " + seed);

        SBinary otherSBinary = new SBinary("100000");
        SBinary expectedOtherSBinary = new SBinary("100000");
        assertEquals(expectedOtherSBinary, otherSBinary.twosComplements(),
            "SBinary don't match. Seed " + seed);

        SBinary anotherSBinary = new SBinary("0");
        SBinary expectedAnotherSBinary = new SBinary("10");
        assertEquals(expectedAnotherSBinary, anotherSBinary.twosComplements(),
            "SBinary don't match. Seed " + seed);

    }

    @Test
    void opSBinaryTest() {
        String positiveBinary = "010011"; //19
        String toOpBinaryString = "0101001";//41

        SBinary positiveSBinary = new SBinary(positiveBinary);
        SBinary toOpSBinary = new SBinary(toOpBinaryString);

        SBinary expectedAddSBinary = new SBinary("0111100");
        SBinary expectedMinusSBinary = new SBinary("101010");
        SBinary expectedTimesSBinary = new SBinary("01100001011");
        SBinary expectedDivideSBinary = new SBinary("0");

        assertEquals(expectedAddSBinary, positiveSBinary.addSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusSBinary.negate().addOne(), positiveSBinary.minusSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimesSBinary, positiveSBinary.timesSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("010"), positiveSBinary.divideSBinary(toOpSBinary),
            "SBinary don't match. Seed " + seed);


        assertEquals(expectedAddSBinary, positiveSBinary.add(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusSBinary, positiveSBinary.minus(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimesSBinary, positiveSBinary.times(toOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedDivideSBinary, positiveSBinary.divide(toOpSBinary),
            "SBinary don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SBinary(positiveBinary), positiveSBinary.addSBinary(zeroSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.minusSBinary(zeroSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), positiveSBinary.timesSBinary(zeroSBinary),
            "SBinary don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("11");
        assertEquals(positiveSBinary.negate().addOne(),
            positiveSBinary.timesSBinary(minusOneSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(positiveSBinary.negate().addOne(),
            positiveSBinary.divide(minusOneSBinary), "SBinary don't match. Seed " + seed);

        String otherBinary = "0110110"; //9
        String otherToOpBinaryString = "01001"; //54

        SBinary otherSBinary = new SBinary(otherBinary);
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SBinary expectedOtherAddSBinary = new SBinary("0111111");
        SBinary expectedOtherMinusSBinary = new SBinary("0101101");
        SBinary expectedOtherTimesSBinary = new SBinary("0111100110");
        SBinary expectedOtherDivideSBinary = new SBinary("0110");

        assertEquals(expectedOtherAddSBinary, otherSBinary.addSBinary(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSBinary.negate().addOne(), otherSBinary.minusSBinary(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSBinary, otherSBinary.timesSBinary(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), otherSBinary.divideSBinary(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);

        assertEquals(expectedOtherAddSBinary, otherSBinary.add(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSBinary, otherSBinary.minus(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSBinary, otherSBinary.times(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSBinary, otherSBinary.divide(otherToOpSBinary),
            "SBinary don't match. Seed " + seed);

        String minusBinary = "1110110";//-10
        String anotherToOpBinaryString = "011001";//25

        SBinary minusSBinary = new SBinary(minusBinary);
        SBinary anotherToOpSBinary = new SBinary(anotherToOpBinaryString);

        SBinary expectedAnotherAddSBinary = new SBinary("01111");
        SBinary expectedAnotherMinusSBinary = new SBinary("1011101");
        SBinary expectedAnotherTimesSBinary = new SBinary("100000110");
        SBinary expectedAnotherDivideSBinary = new SBinary("0");

        assertEquals(expectedAnotherAddSBinary, minusSBinary.addSBinary(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSBinary.negate().addOne(), minusSBinary.minusSBinary(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSBinary, minusSBinary.timesSBinary(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("110"), minusSBinary.divideSBinary(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);

        assertEquals(expectedAnotherAddSBinary, minusSBinary.add(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSBinary, minusSBinary.minus(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSBinary, minusSBinary.times(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSBinary, minusSBinary.divide(anotherToOpSBinary),
            "SBinary don't match. Seed " + seed);

        String otherMinusBinary = "10010";//-14
        String minusToOpBinaryString = "1010";//-6

        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);
        SBinary minusToOpSBinary = new SBinary(minusToOpBinaryString);

        SBinary expectedMinusAddSBinary = new SBinary("101100");
        SBinary expectedMinusMinusSBinary = new SBinary("11000");
        SBinary expectedMinusTimesSBinary = new SBinary("01010100");
        SBinary expectedMinusDivideSBinary = new SBinary("010");

        assertEquals(expectedMinusAddSBinary, otherMinusSBinary.addSBinary(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSBinary.negate().addOne(), otherMinusSBinary.minusSBinary(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSBinary, otherMinusSBinary.timesSBinary(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), otherMinusSBinary.divideSBinary(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);

        assertEquals(expectedMinusAddSBinary, otherMinusSBinary.add(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSBinary, otherMinusSBinary.minus(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSBinary, otherMinusSBinary.times(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSBinary, otherMinusSBinary.divide(minusToOpSBinary),
            "SBinary don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void opSFloatTest() {
        double testDouble = rng.nextDouble();

        SBinary toOpSBinary = new SBinary("010011"); //19
        SFloat toOpSFloat = new SFloat(testDouble);

        SFloat expectedAddSFloat = new SFloat(testDouble+19);
        SFloat expectedMinusSFloat = new SFloat(testDouble-19);
        SFloat expectedTimesSFloat = new SFloat(testDouble*19);
        SFloat expectedDivideSFloat = new SFloat(testDouble/19);

        assertEquals(expectedAddSFloat, toOpSBinary.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, toOpSBinary.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, toOpSBinary.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, toOpSBinary.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SFloat(testDouble), zeroSBinary.addSFloat(new SFloat(testDouble)), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), zeroSBinary.minusSFloat(new SFloat(testDouble)), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), zeroSBinary.timesSFloat(new SFloat(testDouble)), "SFloat don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("1");
        assertEquals(new SFloat(-testDouble), minusOneSBinary.timesSFloat(new SFloat(testDouble)), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testDouble), minusOneSBinary.divideSFloat(new SFloat(testDouble)), "SFloat don't match. Seed " + seed);

        String otherToOpBinaryString = "01101100101110101010000";//3562832
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SFloat expectedOtherAddSFloat = new SFloat(testDouble + 3562832);
        SFloat expectedOtherMinusSFloat = new SFloat(testDouble-3562832);
        SFloat expectedOtherTimesSFloat = new SFloat(testDouble*3562832);
        SFloat expectedOtherDivideSFloat = new SFloat(testDouble/3562832);

        assertEquals(expectedOtherAddSFloat, otherToOpSBinary.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSFloat, otherToOpSBinary.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSFloat, otherToOpSBinary.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSFloat, otherToOpSBinary.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);

        String minusToOpBinaryString = "11101100101110101010000";//-631472
        SBinary minusToOpSBinary = new SBinary(minusToOpBinaryString);

        SFloat expectedMinusAddSFloat = new SFloat(testDouble-631472);
        SFloat expectedMinusMinusSFloat = new SFloat(testDouble+631472);
        SFloat expectedMinusTimesSFloat = new SFloat(testDouble*-631472);
        SFloat expectedMinusDivideSFloat = new SFloat(testDouble/-631472);

        assertEquals(expectedMinusAddSFloat, minusToOpSBinary.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSFloat, minusToOpSBinary.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSFloat, minusToOpSBinary.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSFloat, minusToOpSBinary.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
    }

    @Test
    void opSIntTest() {
        String positiveBinary = "010011";//19
        int toOpBinaryInt = 25;

        SBinary positiveSBinary = new SBinary(positiveBinary);
        SInt toOpSInt = new SInt(toOpBinaryInt);

        SBinary expectedAddSBinary = new SBinary("0101100");
        SBinary expectedMinusSBinary = new SBinary("1010");
        SBinary expectedTimesSBinary = new SBinary("0111011011");
        SBinary expectedDivideSBinary = new SBinary("0");

        assertEquals(expectedAddSBinary, positiveSBinary.add(toOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusSBinary, positiveSBinary.minus(toOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimesSBinary, positiveSBinary.times(toOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedDivideSBinary, positiveSBinary.divide(toOpSInt),
            "SBinary don't match. Seed " + seed);

        SInt expectedAddSInt = new SInt(44);
        SInt expectedMinusSInt = new SInt(6);
        SInt expectedTimesSInt = new SInt(475);
        SInt expectedDivideSInt = new SInt(1);

        assertEquals(expectedAddSInt, positiveSBinary.addSInt(toOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusSInt, positiveSBinary.minusSInt(toOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedTimesSInt, positiveSBinary.timesSInt(toOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedDivideSInt, positiveSBinary.divideSInt(toOpSInt),
            "SInt don't match. Seed " + seed);

        SInt zeroSInt = new SInt(0);

        assertEquals(new SBinary(positiveBinary), positiveSBinary.add(zeroSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary(positiveBinary), positiveSBinary.minus(zeroSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), positiveSBinary.times(zeroSInt),
            "SBinary don't match. Seed " + seed);


        assertEquals(new SInt(19), positiveSBinary.addSInt(zeroSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(new SInt(-19), positiveSBinary.minusSInt(zeroSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(new SInt(0), positiveSBinary.timesSInt(zeroSInt),
            "SInt don't match. Seed " + seed);

        SInt minusOneSInt = new SInt(-1);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.times(minusOneSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.divide(minusOneSInt),
            "SBinary don't match. Seed " + seed);

        assertEquals(new SInt(-19), positiveSBinary.timesSInt(minusOneSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(new SInt(0), positiveSBinary.divideSInt(minusOneSInt),
            "SInt don't match. Seed " + seed);

        String otherBinaryString = "0110010";//50
        int otherToOpInt = 9;

        SBinary otherSBinary = new SBinary(otherBinaryString);
        SInt otherToOpSInt = new SInt(otherToOpInt);

        SBinary expectedOtherAddSBinary = new SBinary("0111011");
        SBinary expectedOtherMinusSBinary = new SBinary("0101001");
        SBinary expectedOtherTimesSBinary = new SBinary("0111000010");
        SBinary expectedOtherDivideSBinary = new SBinary("0101");

        assertEquals(expectedOtherAddSBinary, otherSBinary.add(otherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSBinary, otherSBinary.minus(otherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSBinary, otherSBinary.times(otherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSBinary, otherSBinary.divide(otherToOpSInt),
            "SBinary don't match. Seed " + seed);

        SInt expectedOtherAddSInt = new SInt(59);
        SInt expectedOtherMinusSInt = new SInt(-41);
        SInt expectedOtherTimesSInt = new SInt(450);
        SInt expectedOtherDivideSInt = new SInt(0);

        assertEquals(expectedOtherAddSInt, otherSBinary.addSInt(otherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSInt, otherSBinary.minusSInt(otherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSInt, otherSBinary.timesSInt(otherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSInt, otherSBinary.divideSInt(otherToOpSInt),
            "SInt don't match. Seed " + seed);

        String minusBinary = "1010110";//-42
        int anotherToOpInt = 15;

        SBinary minusSBinary = new SBinary(minusBinary);
        SInt anotherToOpSInt = new SInt(anotherToOpInt);

        SBinary expectedAnotherAddSBinary = new SBinary("100101");
        SBinary expectedAnotherMinusSBinary = new SBinary("1000111");
        SBinary expectedAnotherTimesSBinary = new SBinary("10110001010");
        SBinary expectedAnotherDivideSBinary = new SBinary("110");

        assertEquals(expectedAnotherAddSBinary, minusSBinary.add(anotherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSBinary, minusSBinary.minus(anotherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSBinary, minusSBinary.times(anotherToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSBinary, minusSBinary.divide(anotherToOpSInt),
            "SBinary don't match. Seed " + seed);

        SInt expectedAnotherAddSInt = new SInt(-27);
        SInt expectedAnotherMinusSInt = new SInt(57);
        SInt expectedAnotherTimesSInt = new SInt(-630);
        SInt expectedAnotherDivideSInt = new SInt(0);

        assertEquals(expectedAnotherAddSInt, minusSBinary.addSInt(anotherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSInt, minusSBinary.minusSInt(anotherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSInt, minusSBinary.timesSInt(anotherToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSInt, minusSBinary.divideSInt(anotherToOpSInt),
            "SInt don't match. Seed " + seed);

        String otherMinusBinary = "10010";//-14
        int minusToOpInt = -7;

        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);
        SInt minusToOpSInt = new SInt(minusToOpInt);

        SBinary expectedMinusAddSBinary = new SBinary("101011");
        SBinary expectedMinusMinusSBinary = new SBinary("1001");
        SBinary expectedMinusTimesSBinary = new SBinary("01100010");
        SBinary expectedMinusDivideSBinary = new SBinary("010");

        assertEquals(expectedMinusAddSBinary, otherMinusSBinary.add(minusToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSBinary, otherMinusSBinary.minus(minusToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSBinary, otherMinusSBinary.times(minusToOpSInt),
            "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSBinary, otherMinusSBinary.divide(minusToOpSInt),
            "SBinary don't match. Seed " + seed);

        SInt expectedMinusAddSInt = new SInt(-21);
        SInt expectedMinusMinusSInt = new SInt(7);
        SInt expectedMinusTimesSInt = new SInt(98);
        SInt expectedMinusDivideSInt = new SInt(0);

        assertEquals(expectedMinusAddSInt, otherMinusSBinary.addSInt(minusToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSInt, otherMinusSBinary.minusSInt(minusToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSInt, otherMinusSBinary.timesSInt(minusToOpSInt),
            "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSInt, otherMinusSBinary.divideSInt(minusToOpSInt),
            "SInt don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addToSStringTest(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(50);
        String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
            true, true, null, rng);
        SString sString = new SString(testString);

        char [] binaryList = {'0', '1'};
        String toAddStringBinary = RandomStringUtils.random(rng.nextInt(50), 0,
            2, false, true, binaryList, rng);
        SBinary toAddSBinary = new SBinary(toAddStringBinary);

        String expectedString = testString + toAddStringBinary;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, toAddSBinary.addToSString(sString), "SString don't match. Seed " + seed);

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

        SString differentSString = new SString(differentString + differentToAddStringBinary);
        assertNotEquals(differentSString, toAddSBinary.addToSString(sString), "SString match. Seed " + seed);
    }
}