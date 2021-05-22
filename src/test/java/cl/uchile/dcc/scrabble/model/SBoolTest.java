package cl.uchile.dcc.scrabble.model;

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

        assertEquals(expectedSBool.hashCode(), testSBool.hashCode(), "Hashcode don't match. Seed " + seed);
        assertEquals(negateExpectedSBool.hashCode(), negateTestSBool.hashCode(), "Hashcode don't match. Seed " + seed);

        assertNotEquals(expectedSBool, negateTestSBool, "SBool match. Seed " + seed);
        assertNotEquals(negateExpectedSBool, testSBool, "SBool match. Seed " + seed);
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
    void negateSBoolTest(){
        assertEquals(negateTestSBool, testSBool.negation(), "SBool don't match. Seed " + seed);
        assertNotEquals(testSBool, testSBool.negation(), "SBool match. Seed " + seed);
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
}