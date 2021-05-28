package cl.uchile.dcc.scrabble.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SStringTest {
    private SString sString;
    private String testString;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(50);
        testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        sString = new SString(testString);
    }

    @RepeatedTest(50)
    void constructorTest(){
        var expectedSString = new SString(testString);

        assertEquals(expectedSString, sString, "SString don't match. Seed " + seed);
        assertEquals(expectedSString.hashCode(), sString.hashCode(), "Hashcode don't match. Seed " + seed);
        assertNotEquals(sString, testString, "Objects match. Seed " + seed);

        String differentString;

        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                    Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));


        SString differentSString = new SString(differentString);
        assertNotEquals(differentSString, sString, "SString match. Seed " + seed);

        assertEquals(testString, sString.toString(), "String don't match. Seed " + seed);
        assertNotEquals(differentString, sString.toString(), "String match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSStringTest(){
        var expectedSString = new SString(testString);
        assertEquals(expectedSString, sString.toSString(), "String don't match. Seed " + seed);

        String differentString;

        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                    Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        SString differentSString = new SString(differentString);
        assertNotEquals(differentSString, sString.toSString(), "SString match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSStringTest(){
        String toAddString = RandomStringUtils.random(rng.nextInt(50), 0, Character.MAX_CODE_POINT,
                true, true, null, rng);
        SString toAddSString = new SString(toAddString);

        String expectedString = testString + toAddString;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, sString.addSString(toAddSString), "SString don't match. Seed " + seed);

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

        SString differentSString = new SString(differentString + differentToAddString);

        assertNotEquals(differentSString, sString.addSString(toAddSString), "SString match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addSBoolTest() {
        boolean toAddBool = rng.nextBoolean();

        SBool toAddSBool = new SBool(toAddBool);
        SBool negateToAddSBool = new SBool(!toAddBool);

        String expectedStringAddSBool = testString + toAddBool;
        String negateExpectedStringAddSBool = testString + !toAddBool;

        SString expectedAddSBool = new SString(expectedStringAddSBool);
        SString negateExpectedAddSBool = new SString(negateExpectedStringAddSBool);

        assertEquals(expectedAddSBool, sString.addSBool(toAddSBool), "SString don't match. Seed " + seed);
        assertEquals(negateExpectedAddSBool, sString.addSBool(negateToAddSBool), "SString don't match. Seed " + seed);

        assertNotEquals(negateExpectedAddSBool, sString.addSBool(toAddSBool), "SString match. Seed " + seed);
        assertNotEquals(expectedAddSBool, sString.addSBool(negateToAddSBool), "SString match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSFloatTest(){
        double toAddDouble = rng.nextDouble();
        SFloat toAddSFloat = new SFloat(toAddDouble);

        String expectedString = testString + toAddDouble;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, sString.addSFloat(toAddSFloat), "SString don't match. Seed " + seed);

        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                    Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        double differentToAddDouble;
        do { differentToAddDouble = rng.nextDouble();
        } while (differentToAddDouble == toAddDouble);

        SString differentSString = new SString(differentString + differentToAddDouble);
        assertNotEquals(differentSString, sString.addSFloat(toAddSFloat), "SString match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSIntTest(){
        int toAddInt = rng.nextInt();
        SInt toAddSInt = new SInt(toAddInt);
        String expectedString = testString + toAddInt;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, sString.addSInt(toAddSInt), "SString don't match. Seed " + seed);

        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                    Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        int differentToAddInt;
        do { differentToAddInt = rng.nextInt();
        } while (differentToAddInt == toAddInt);
        SString differentSString = new SString(differentString + differentToAddInt);

        assertNotEquals(differentSString, sString.addSInt(toAddSInt), "SString match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSBinaryTest(){
        char [] binaryList = {'0', '1'};
        String toAddStringBinary = RandomStringUtils.random(rng.nextInt(50), 0,
                2, false, true, binaryList, rng);
        SBinary toAddSBinary = new SBinary(toAddStringBinary);

        String expectedString = testString + toAddStringBinary;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, sString.addSBinary(toAddSBinary), "SString don't match. Seed " + seed);

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
        assertNotEquals(differentSString, sString.addSBinary(toAddSBinary), "SString match. Seed " + seed);
    }
}