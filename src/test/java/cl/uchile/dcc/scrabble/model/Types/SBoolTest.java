package cl.uchile.dcc.scrabble.model.Types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SBoolTest{
    private SBool testSBool;
    private SBool negateTestSBool;
    private boolean boolTest;
    private int seed;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        Random rng = new Random(seed);
        boolTest = rng.nextBoolean();

        testSBool = new SBool(boolTest);
        negateTestSBool = new SBool(!boolTest);
    }

    @RepeatedTest(10)
    void constructorTest(){

        var expectedSBool = new SBool(boolTest);
        var negateExpectedSBool = new SBool(!boolTest);

        assertEquals(expectedSBool, testSBool, "SBool don't match. Seed " + seed);
        assertEquals(negateExpectedSBool, negateTestSBool, "SBool don't match. Seed " + seed);
        assertNotEquals(testSBool, boolTest, "Objects match. Seed " + seed);
        assertNotEquals(negateTestSBool, !boolTest, "Objects match. Seed " + seed);

        assertEquals(expectedSBool.hashCode(), testSBool.hashCode(), "Hashcode don't match. Seed " + seed);
        assertEquals(negateExpectedSBool.hashCode(), negateTestSBool.hashCode(), "Hashcode don't match. Seed " + seed);
        assertEquals(!boolTest, negateTestSBool.getBool(), "Bool don't match. Seed " + seed);
        assertEquals(boolTest, testSBool.getBool(), "Bool don't match. Seed " + seed);

        assertNotEquals(expectedSBool, negateTestSBool, "SBool match. Seed " + seed);
        assertNotEquals(negateExpectedSBool, testSBool, "SBool match. Seed " + seed);
        assertNotEquals(!boolTest, testSBool.getBool(), "SBool match. Seed " + seed);
        assertNotEquals(boolTest, negateTestSBool.getBool(), "SBool match. Seed " + seed);
    }

    @RepeatedTest(10)
    void toStringTest(){
        String expectedString = String.valueOf(boolTest);
        String negateExpectedString = String.valueOf(!boolTest);

        assertEquals(expectedString, testSBool.toString(), "String don't match. Seed " + seed);
        assertEquals(negateExpectedString, negateTestSBool.toString(), "String don't match. Seed " + seed);

        assertNotEquals(expectedString, negateTestSBool.toString(), "String match. Seed " + seed);
        assertNotEquals(negateExpectedString, testSBool.toString(), "String match. Seed " + seed);

    }
    @RepeatedTest(10)
    void toSStringTest(){
        SString expectedSString = new SString(String.valueOf(boolTest));
        SString negateExpectedSString = new SString(String.valueOf(!boolTest));

        assertEquals(expectedSString, testSBool.toSString(), "SString don't match. Seed " + seed);
        assertNotEquals(negateExpectedSString, testSBool.toSString(), "String match. Seed " + seed);
    }

    @RepeatedTest(10)
    void toSBoolTest(){
        SBool expectedSBool = new SBool(boolTest);
        SBool negateExpectedSBool = new SBool(!boolTest);

        assertEquals(expectedSBool, testSBool.toSBool(), "SBool don't match. Seed " + seed);
        assertNotEquals(negateExpectedSBool, testSBool.toSBool(), "SBool match. Seed " + seed);
    }
    @RepeatedTest(10)
    void negateTest(){
        assertEquals(negateTestSBool, testSBool.negate(), "SBool don't match. Seed " + seed);
        assertNotEquals(testSBool, testSBool.negate(), "SBool match. Seed " + seed);
    }

    @Test
    void orAndSBoolTest(){
        SBool firstSBool = new SBool(true);
        SBool toOperateSBool = new SBool(false);
        SBool expectedTrueSBool = new SBool(true);
        SBool expectedFalseSBool = new SBool(false);

        assertEquals(expectedTrueSBool, firstSBool.orSBool(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.orSBool(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedTrueSBool, firstSBool.orSBool(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedTrueSBool, toOperateSBool.orSBool(firstSBool), "SBool don't match. Seed " + seed);

        assertEquals(expectedTrueSBool, firstSBool.andSBool(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, firstSBool.andSBool(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.andSBool(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.andSBool(toOperateSBool), "SBool don't match. Seed " + seed);
    }

    @Test
    void orAndBinaryTest(){
        SBool trueSBool = new SBool(true);
        SBool falseSBool = new SBool(false);
        SBinary toOperateSBinary = new SBinary("101001");

        SBinary expectedTrueOrSBinary = new SBinary("111111");
        SBinary expectedFalseOrSBinary = new SBinary("101001");

        assertEquals(expectedTrueOrSBinary, trueSBool.orSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedFalseOrSBinary, falseSBool.orSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);

        assertNotEquals(expectedFalseOrSBinary, trueSBool.orSBinary(toOperateSBinary), "SBinary match. Seed " + seed);
        assertNotEquals(expectedTrueOrSBinary, falseSBool.orSBinary(toOperateSBinary), "SBinary match. Seed " + seed);

        SBinary expectedTrueAndSBinary = new SBinary("101001");
        SBinary expectedFalseAndSBinary = new SBinary("000000");

        assertEquals(expectedTrueAndSBinary, trueSBool.andSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedFalseAndSBinary, falseSBool.andSBinary(toOperateSBinary), "SBinary don't match. Seed " + seed);

        assertNotEquals(expectedFalseAndSBinary, trueSBool.andSBinary(toOperateSBinary), "SBinary match. Seed " + seed);
        assertNotEquals(expectedTrueAndSBinary, falseSBool.andSBinary(toOperateSBinary), "SBinary match. Seed " + seed);
    }

    @Test
    void orAndTest(){
        SBool trueSBool = new SBool(true);
        SBool falseSBool = new SBool(false);
        SBinary toOperateSBinary = new SBinary("101001");

        SBinary expectedTrueOrSBinary = new SBinary("111111");
        SBinary expectedFalseOrSBinary = new SBinary("101001");

        assertEquals(expectedTrueOrSBinary, trueSBool.or(toOperateSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedFalseOrSBinary, falseSBool.or(toOperateSBinary), "SBinary don't match. Seed " + seed);

        assertNotEquals(expectedFalseOrSBinary, trueSBool.or(toOperateSBinary), "SBinary match. Seed " + seed);
        assertNotEquals(expectedTrueOrSBinary, falseSBool.or(toOperateSBinary), "SBinary match. Seed " + seed);

        SBinary expectedTrueAndSBinary = new SBinary("101001");
        SBinary expectedFalseAndSBinary = new SBinary("000000");

        assertEquals(expectedTrueAndSBinary, trueSBool.and(toOperateSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedFalseAndSBinary, falseSBool.and(toOperateSBinary), "SBinary don't match. Seed " + seed);

        assertNotEquals(expectedFalseAndSBinary, trueSBool.and(toOperateSBinary), "SBinary match. Seed " + seed);
        assertNotEquals(expectedTrueAndSBinary, falseSBool.and(toOperateSBinary), "SBinary match. Seed " + seed);


        SBool firstSBool = new SBool(true);
        SBool toOperateSBool = new SBool(false);
        SBool expectedTrueSBool = new SBool(true);
        SBool expectedFalseSBool = new SBool(false);

        assertEquals(expectedTrueSBool, firstSBool.or(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.or(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedTrueSBool, firstSBool.or(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedTrueSBool, toOperateSBool.or(firstSBool), "SBool don't match. Seed " + seed);

        assertEquals(expectedTrueSBool, firstSBool.and(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, firstSBool.and(toOperateSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.and(firstSBool), "SBool don't match. Seed " + seed);
        assertEquals(expectedFalseSBool, toOperateSBool.and(toOperateSBool), "SBool don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addToStringTest() {
        seed = new Random().nextInt();
        Random rng = new Random(seed);
        int strSize= rng.nextInt(50);
        String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
            true, true, null, rng);
        SString sString = new SString(testString);

        boolean toAddBool = rng.nextBoolean();

        SBool toAddSBool = new SBool(toAddBool);
        SBool negateToAddSBool = new SBool(!toAddBool);

        String expectedStringAddSBool = testString + toAddBool;
        String negateExpectedStringAddSBool = testString + !toAddBool;

        SString expectedAddSBool = new SString(expectedStringAddSBool);
        SString negateExpectedAddSBool = new SString(negateExpectedStringAddSBool);

        assertEquals(expectedAddSBool, toAddSBool.addToSString(sString), "SString don't match. Seed " + seed);
        assertEquals(negateExpectedAddSBool, negateToAddSBool.addToSString(sString), "SString don't match. Seed " + seed);

        assertNotEquals(negateExpectedAddSBool, toAddSBool.addToSString(sString), "SString match. Seed " + seed);
        assertNotEquals(expectedAddSBool, negateToAddSBool.addToSString(sString), "SString match. Seed " + seed);
    }
}