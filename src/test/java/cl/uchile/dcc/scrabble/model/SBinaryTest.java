package cl.uchile.dcc.scrabble.model;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO: Improve logic operators with binary tests with random variables
//TODO: Improve logic operators with bool tests with random variables
//TODO: Make repeated tests

//TODO: Implement test for operator add with int and binary
//TODO: Implement test for operator minus with int and binary
//TODO: Implement test for operator times with int and binary
//TODO: Implement test for operator divide with int and binary
//TODO: Implement test for toSInt method


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
    void toSFloatTest(){
    }
    @Test
    void toSIntTest(){

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
}