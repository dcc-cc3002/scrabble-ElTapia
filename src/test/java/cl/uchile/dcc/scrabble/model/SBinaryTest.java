package cl.uchile.dcc.scrabble.model;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO: Improve logic operators with binary tests with random variables
//TODO: Improve logic operators with bool tests with random variables
//TODO: Improve operators with SBinary tests
//TODO: Improve operators with SInt tests
//TODO: Make repeated tests

//COMPLETE: Implement test for operator add with int and binary
//COMPLETE: Implement test for operator minus with int and binary
//COMPLETE: Implement test for operator times with int and binary
//COMPLETE: Implement test for operator divide with int and binary
//COMPLETE: Implement test for toSInt method
//COMPLETE: Implement test for toSFloat method


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SBinaryTest {
    private final char [] binaryList = {'0', '1'};
    private SBinary sBinary;
    private String testBinary;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(32);
        testBinary = RandomStringUtils.random(strSize, 0, 2, false, true, binaryList, rng);
        sBinary = new SBinary(testBinary);
    }

    @RepeatedTest(50)
    void constructorTest(){
        var expectedSBinary = new SBinary(testBinary);

        assertEquals(expectedSBinary, sBinary, "SBinary don't match. Seed " + seed);
        assertEquals(expectedSBinary.hashCode(), sBinary.hashCode(), "Hashcode don't match. Seed " + seed);

        String differentBinary;

        do {
            differentBinary= RandomStringUtils.random(rng.nextInt(32), 0, 2,
                    false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));


        var differentSBinary = new SBinary(differentBinary);
        assertNotEquals(differentSBinary, sBinary, "SBinary match. Seed " + seed);

        assertEquals(testBinary, sBinary.toString(), "String don't match. Seed " + seed);
        assertNotEquals(differentBinary, sBinary.toString(), "String match. Seed " + seed);
    }
    @RepeatedTest(50)
    void toSStringTest(){
        SString expectedSString = new SString(testBinary);
        assertEquals(expectedSString, sBinary.toSString(), "String don't match. Seed " + seed);

        String differentBinary;
        do {
            differentBinary= RandomStringUtils.random(rng.nextInt(32), 0, 2,
                    false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));
        SString differentSString = new SString(differentBinary);

        assertNotEquals(differentSString, sBinary.toSString(), "SString match. Seed " + seed);
    }
    @Test
    void toSIntAndSFloatTest(){
        String negativeBinary = "101010";
        SBinary negativeSBinary = new SBinary(negativeBinary);
        SInt expectedNegativeSInt = new SInt(-22);
        SFloat expectedNegativeSFloat = new SFloat(-22.0);

        assertEquals(expectedNegativeSInt, negativeSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedNegativeSFloat, negativeSBinary.toSFloat(), "SFloat don't match. Seed " + seed);

        String zeroBinary = "0";
        SBinary zeroSBinary = new SBinary(zeroBinary);
        SInt expectedZeroSInt = new SInt(0);
        SFloat expectedZeroSFloat = new SFloat(0.0);

        assertEquals(expectedZeroSInt, zeroSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedZeroSFloat, zeroSBinary.toSFloat(), "SFloat don't match. Seed " + seed);

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

        assertEquals(expectedPositiveSInt, positiveSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedPositiveSFloat, positiveSBinary.toSFloat(), "SFloat don't match. Seed " + seed);

        String largestBinary = "01111111111111111111111111111111";
        SBinary largestSBinary = new SBinary(largestBinary);
        SInt expectedLargestSInt = new SInt(2147483647);
        SFloat expectedLargestSFloat = new SFloat(2147483647.0);

        assertEquals(expectedLargestSInt, largestSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedLargestSFloat, largestSBinary.toSFloat(), "SFloat don't match. Seed " + seed);

        String smallestBinary = "10000000000000000000000000000000";
        SBinary smallestSBinary = new SBinary(smallestBinary);
        SInt expectedSmallestSInt = new SInt(-2147483647);
        SFloat expectedSmallestSFloat = new SFloat(-2147483647.0);

        assertEquals(expectedSmallestSInt, smallestSBinary.toSInt(), "SInt don't match. Seed " + seed);
        assertEquals(expectedSmallestSFloat, smallestSBinary.toSFloat(), "SFloat don't match. Seed " + seed);
    }
    @RepeatedTest(50)
    void toSBinaryTest(){
        SBinary expectedSBinary = new SBinary(testBinary);
        assertEquals(expectedSBinary, sBinary.toSBinary(), "SBinary don't match. Seed " + seed);

        String differentBinary;
        do {
            differentBinary= RandomStringUtils.random(rng.nextInt(32), 0, 2,
                    false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));
        SBinary differentSBinary = new SBinary(differentBinary);
        assertNotEquals(differentSBinary, sBinary.toSBinary(), "SBinary match. Seed " + seed);

    }
    @Test
    void negateTest(){
        SBinary testBinary = new SBinary("101011");
        SBinary expectedSBinary = new SBinary("010100");

        assertEquals(expectedSBinary, testBinary.negate(), "SBinary don't match. Seed " + seed);
    }
    @Test
    void orAndSBinaryTest(){
        SBinary testSBinary = new SBinary("101011");
        SBinary toOperateSBinary = new SBinary("110010");

        SBinary expectedOrSBinary = new SBinary("111011");
        SBinary expectedAndSBinary = new SBinary("100010");

        assertEquals(expectedOrSBinary, testSBinary.orSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndSBinary, testSBinary.andSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);
    }

    @Test
    void orAndSBoolTest(){
        SBinary testSBinary = new SBinary("101011");
        SBool toOperateTrueSBool = new SBool(true);
        SBool toOperateFalseSBool = new SBool(false);

        SBinary expectedOrTrueSBool = new SBinary("111111");
        SBinary expectedAndTrueSBool = new SBinary("101011");

        SBinary expectedOrFalseSBool = new SBinary("101011");
        SBinary expectedAndFalseSBool = new SBinary("000000");

        assertEquals(expectedOrTrueSBool, testSBinary.orSBool(toOperateTrueSBool), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndTrueSBool, testSBinary.andSBool(toOperateTrueSBool), "SBinary don't match. Seed " + seed);

        assertEquals(expectedOrFalseSBool, testSBinary.orSBool(toOperateFalseSBool), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAndFalseSBool, testSBinary.andSBool(toOperateFalseSBool), "SBinary don't match. Seed " + seed);
    }
    @Test
    void addOneTest(){
        SBinary testSBinary = new SBinary("11111");
        SBinary expectedSBinary = new SBinary("100000");

        assertEquals(expectedSBinary, testSBinary.addOne());

        SBinary otherSBinary = new SBinary("1001010101");
        SBinary expectedOtherSBinary = new SBinary("1001010110");

        assertEquals(expectedOtherSBinary, otherSBinary.addOne());
    }
    @Test
    void twosComplementsTest(){
        SBinary testSBinary = new SBinary("0101011");
        SBinary expectedSBinary = new SBinary("1010101");

        assertEquals(expectedSBinary, testSBinary.twosComplements(), "SBinary don't match. Seed " + seed);

        SBinary otherSBinary = new SBinary("100000");
        SBinary expectedOtherSBinary = new SBinary("100000");
        assertEquals(expectedOtherSBinary, otherSBinary.twosComplements(), "SBinary don't match. Seed " + seed);

        SBinary anotherSBinary = new SBinary("0");
        SBinary expectedAnotherSBinary = new SBinary("10");
        assertEquals(expectedAnotherSBinary, anotherSBinary.twosComplements(), "SBinary don't match. Seed " + seed);

    }
    @Test
    void opSBinaryTest(){
        String positiveBinary = "010011";
        String toOpBinaryString = "0101001";

        SBinary positiveSBinary = new SBinary(positiveBinary);
        SBinary toOpSBinary = new SBinary(toOpBinaryString);

        SBinary expectedAddSBinary = new SBinary("0111100");
        SBinary expectedMinusSBinary = new SBinary("101010");
        SBinary expectedTimesSBinary = new SBinary("01100001011");
        SBinary expectedDivideSBinary = new SBinary("0");

        assertEquals(expectedAddSBinary, positiveSBinary.addSBinary(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusSBinary, positiveSBinary.minusSBinary(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimesSBinary, positiveSBinary.timesSBinary(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedDivideSBinary, positiveSBinary.divideSBinary(toOpSBinary), "SBinary don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SBinary(positiveBinary), positiveSBinary.addSBinary(zeroSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary(positiveBinary), positiveSBinary.minusSBinary(zeroSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), positiveSBinary.timesSBinary(zeroSBinary), "SBinary don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("11");
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.timesSBinary(minusOneSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.divideSBinary(minusOneSBinary), "SBinary don't match. Seed " + seed);

        String otherBinary = "0110110";
        String otherToOpBinaryString = "01001";

        SBinary otherSBinary = new SBinary(otherBinary);
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SBinary expectedOtherAddSBinary = new SBinary("0111111");
        SBinary expectedOtherMinusSBinary = new SBinary("0101101");
        SBinary expectedOtherTimesSBinary = new SBinary("0111100110");
        SBinary expectedOtherDivideSBinary = new SBinary("0110");

        assertEquals(expectedOtherAddSBinary, otherSBinary.addSBinary(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSBinary, otherSBinary.minusSBinary(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSBinary, otherSBinary.timesSBinary(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSBinary, otherSBinary.divideSBinary(otherToOpSBinary), "SBinary don't match. Seed " + seed);

        String minusBinary = "1110110";
        String anotherToOpBinaryString = "011001";

        SBinary minusSBinary = new SBinary(minusBinary);
        SBinary anotherToOpSBinary = new SBinary(anotherToOpBinaryString);

        SBinary expectedAnotherAddSBinary = new SBinary("01111");
        SBinary expectedAnotherMinusSBinary = new SBinary("1011101");
        SBinary expectedAnotherTimesSBinary = new SBinary("100000110");
        SBinary expectedAnotherDivideSBinary = new SBinary("0");

        assertEquals(expectedAnotherAddSBinary, minusSBinary.addSBinary(anotherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSBinary, minusSBinary.minusSBinary(anotherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSBinary, minusSBinary.timesSBinary(anotherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSBinary, minusSBinary.divideSBinary(anotherToOpSBinary), "SBinary don't match. Seed " + seed);

        String otherMinusBinary = "10010";
        String minusToOpBinaryString = "1010";

        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);
        SBinary minusToOpSBinary = new SBinary(minusToOpBinaryString);

        SBinary expectedMinusAddSBinary = new SBinary("101100");
        SBinary expectedMinusMinusSBinary = new SBinary("11000");
        SBinary expectedMinusTimesSBinary = new SBinary("01010100");
        SBinary expectedMinusDivideSBinary = new SBinary("010");

        assertEquals(expectedMinusAddSBinary, otherMinusSBinary.addSBinary(minusToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSBinary, otherMinusSBinary.minusSBinary(minusToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSBinary, otherMinusSBinary.timesSBinary(minusToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSBinary, otherMinusSBinary.divideSBinary(minusToOpSBinary), "SBinary don't match. Seed " + seed);
    }
    @Test
    void opSIntTest(){
        String positiveBinary = "010011";
        int toOpBinaryInt = 25;

        SBinary positiveSBinary = new SBinary(positiveBinary);
        SInt toOpSInt = new SInt(toOpBinaryInt);

        SBinary expectedAddSBinary = new SBinary("0101100");
        SBinary expectedMinusSBinary = new SBinary("1010");
        SBinary expectedTimesSBinary = new SBinary("0111011011");
        SBinary expectedDivideSBinary = new SBinary("0");

        assertEquals(expectedAddSBinary, positiveSBinary.addSInt(toOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusSBinary, positiveSBinary.minusSInt(toOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimesSBinary, positiveSBinary.timesSInt(toOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedDivideSBinary, positiveSBinary.divideSInt(toOpSInt), "SBinary don't match. Seed " + seed);

        SInt zeroSInt = new SInt(0);

        assertEquals(new SBinary(positiveBinary), positiveSBinary.addSInt(zeroSInt), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary(positiveBinary), positiveSBinary.minusSInt(zeroSInt), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), positiveSBinary.timesSInt(zeroSInt), "SBinary don't match. Seed " + seed);

        SInt minusOneSInt = new SInt(-1);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.timesSInt(minusOneSInt), "SBinary don't match. Seed " + seed);
        assertEquals(positiveSBinary.negate().addOne(), positiveSBinary.divideSInt(minusOneSInt), "SBinary don't match. Seed " + seed);

        String otherBinaryString = "0110010";
        int otherToOpInt = 9;

        SBinary otherSBinary = new SBinary(otherBinaryString);
        SInt otherToOpSInt = new SInt(otherToOpInt);

        SBinary expectedOtherAddSBinary = new SBinary("0111011");
        SBinary expectedOtherMinusSBinary = new SBinary("0101001");
        SBinary expectedOtherTimesSBinary = new SBinary("0111000010");
        SBinary expectedOtherDivideSBinary = new SBinary("0101");

        assertEquals(expectedOtherAddSBinary, otherSBinary.addSInt(otherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSBinary, otherSBinary.minusSInt(otherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSBinary, otherSBinary.timesSInt(otherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSBinary, otherSBinary.divideSInt(otherToOpSInt), "SBinary don't match. Seed " + seed);

        String minusBinary = "1010110";
        int anotherToOpInt = 15;

        SBinary minusSBinary = new SBinary(minusBinary);
        SInt anotherToOpSInt = new SInt(anotherToOpInt);

        SBinary expectedAnotherAddSBinary = new SBinary("100101");
        SBinary expectedAnotherMinusSBinary = new SBinary("1000111");
        SBinary expectedAnotherTimesSBinary = new SBinary("10110001010");
        SBinary expectedAnotherDivideSBinary = new SBinary("110");

        assertEquals(expectedAnotherAddSBinary, minusSBinary.addSInt(anotherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSBinary, minusSBinary.minusSInt(anotherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSBinary, minusSBinary.timesSInt(anotherToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSBinary, minusSBinary.divideSInt(anotherToOpSInt), "SBinary don't match. Seed " + seed);

        String otherMinusBinary = "10010";//-14
        int minusToOpInt = -7;

        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);
        SInt minusToOpSInt = new SInt(minusToOpInt);

        SBinary expectedMinusAddSBinary = new SBinary("101011");
        SBinary expectedMinusMinusSBinary = new SBinary("1001");
        SBinary expectedMinusTimesSBinary = new SBinary("01100010");
        SBinary expectedMinusDivideSBinary = new SBinary("010");

        assertEquals(expectedMinusAddSBinary, otherMinusSBinary.addSInt(minusToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSBinary, otherMinusSBinary.minusSInt(minusToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSBinary, otherMinusSBinary.timesSInt(minusToOpSInt), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSBinary, otherMinusSBinary.divideSInt(minusToOpSInt), "SBinary don't match. Seed " + seed);
    }
}