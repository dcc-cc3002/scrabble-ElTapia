package cl.uchile.dcc.scrabble.model;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
        int strSize= rng.nextInt(50);
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
            differentBinary= RandomStringUtils.random(rng.nextInt(50), 0, 2,
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
            differentBinary= RandomStringUtils.random(rng.nextInt(50), 0, 2,
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
            differentBinary= RandomStringUtils.random(rng.nextInt(50), 0, 2,
                    false, true, binaryList, rng);
        } while (differentBinary.equals(testBinary));
        SBinary differentSBinary = new SBinary(differentBinary);
        assertNotEquals(differentSBinary, sBinary.toSBinary(), "SBinary match. Seed " + seed);

    }
}