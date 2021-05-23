package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

//TODO: Implement test for operator add with int, float and binary
//TODO: Implement test for operator minus with int, float and binary
//TODO: Implement test for operator times with int, float and binary
//TODO: Implement test for operator divide with int, float and binary

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SFloatTest {
    private SFloat sFloat;
    private double testDouble;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        testDouble = rng.nextDouble();
        sFloat = new SFloat(testDouble);
    }

    @RepeatedTest(50)
    void constructorTest(){
        var expectedSFloat = new SFloat(testDouble);

        assertEquals(expectedSFloat, sFloat, "SFloat don't match. Seed " + seed);
        assertEquals(expectedSFloat.hashCode(), sFloat.hashCode(), "Hashcode don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        var differentSFloat = new SFloat(differentDouble);
        assertNotEquals(differentSFloat, sFloat, "SFloat match. Seed " + seed);

        assertEquals(String.valueOf(testDouble), sFloat.toString(), "String don't match. Seed " + seed);
        assertNotEquals(String.valueOf(differentDouble), sFloat.toString(), "String match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSStringTest(){
        SString expectedSString = new SString(String.valueOf(testDouble));
        assertEquals(expectedSString, sFloat.toSString(), "SString don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        SString differentSString = new SString(String.valueOf(differentDouble));
        assertNotEquals(differentSString, sFloat.toSString(), "SString match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSFloatTest(){
        SFloat expectedSFloat = new SFloat(testDouble);
        assertEquals(expectedSFloat, sFloat.toSFloat(), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        SFloat differentSFloat = new SFloat(differentDouble);
        assertNotEquals(differentSFloat, sFloat.toSFloat(), "SFloat match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addSInTest() {
        int toAddInt = rng.nextInt();
        SInt toAddSInt = new SInt(toAddInt);
        double expectedDouble = testDouble + toAddInt;
        SFloat expectedSFloat = new SFloat(expectedDouble);

        assertEquals(expectedSFloat, sFloat.addSInt(toAddSInt), "SFloat don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt ==  toAddInt);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(sFloat.addSInt(differentSInt), sFloat.addSInt(toAddSInt), "SFloat match. Seed " + seed);

        SInt zeroSInt = new SInt(0);
        assertEquals(new SFloat(testDouble), sFloat.addSInt(zeroSInt), "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addSFloatTest() {
        double toAddDouble = rng.nextDouble();
        SFloat toAddSFloat = new SFloat(toAddDouble);

        double expectedDouble = testDouble + toAddDouble;
        SFloat expectedSFloat = new SFloat(expectedDouble);

        assertEquals(expectedSFloat, sFloat.addSFloat(toAddSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextInt();
        } while (differentDouble ==  toAddDouble);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(sFloat.addSFloat(differentSFloat), sFloat.addSFloat(toAddSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0);
        assertEquals(new SFloat(testDouble), sFloat.addSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
    }

    @Test
    void addSBinaryTest() {
    }
}
