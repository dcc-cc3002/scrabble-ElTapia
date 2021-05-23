package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO: Implement test for operator add with int, float and binary
//TODO: Implement test for operator minus with int, float and binary
//TODO: Implement test for operator times with int, float and binary
//TODO: Implement test for operator divide with int, float and binary
//TODO: Implement test for toSBinary method

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SIntTest {
    private SInt sInt;
    private int testInt;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        testInt = rng.nextInt();
        sInt = new SInt(testInt);
    }

    @RepeatedTest(50)
    void constructorTest() {
        var expectedSInt = new SInt(testInt);

        assertEquals(expectedSInt, sInt, "SInt don't match. Seed " + seed);
        assertEquals(expectedSInt.hashCode(), sInt.hashCode(), "Hashcode don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt);

        var differentSInt = new SInt(differentInt);
        assertNotEquals(differentSInt, sInt, "SInt match. Seed " + seed);

        assertEquals(String.valueOf(testInt), sInt.toString(), "String don't match. Seed " + seed);
        assertNotEquals(String.valueOf(differentInt), sInt.toString(), "String match. Seed " + seed);

    }
    @RepeatedTest(50)
    void toSStringTest(){
        SString expectedSString = new SString(String.valueOf(testInt));
        assertEquals(expectedSString, sInt.toSString(), "SString don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt);

        SString differentSString = new SString(String.valueOf(differentInt));
        assertNotEquals(differentSString, sInt.toSString(), "SString match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSFloatTest(){
        String intString = String.valueOf(testInt);
        SFloat expectedSFloat = new SFloat(Double.parseDouble(intString));
        assertEquals(expectedSFloat, sInt.toSFloat(), "SFloat don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt);
        String differentIntString = String.valueOf(differentInt);
        SFloat differentSFloat = new SFloat(Double.parseDouble(differentIntString));
        assertNotEquals(differentSFloat, sInt.toSFloat(), "SFloat match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSIntTest(){
        SInt expectedString = new SInt(testInt);
        assertEquals(expectedString, sInt.toSInt(), "SInt don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt);
        SInt differentSInt = new SInt(differentInt);
        assertNotEquals(differentSInt, sInt.toSInt(), "SInt match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSIntTest(){
        int toAddInt = rng.nextInt();
        SInt otherSInt = new SInt(toAddInt);

        int expectedInt = testInt + toAddInt;
        SInt expectedSInt = new SInt(expectedInt);

        assertEquals(expectedSInt, sInt.addSInt(otherSInt), "SInt don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt + toAddInt);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(differentSInt, sInt.addSInt(otherSInt), "SInt match. Seed " + seed);

        SInt zeroSInt = new SInt(0);
        assertEquals(new SInt(testInt), sInt.addSInt(zeroSInt));
    }
    @RepeatedTest(50)
    void addSFloatTest(){
        double toAddDouble = rng.nextDouble();
        SFloat toAddSFloat = new SFloat(toAddDouble);

        double expectedDouble = testInt + toAddDouble;
        SFloat expectedSFloat = new SFloat(expectedDouble);

        assertEquals(expectedSFloat, sInt.addSFloat(toAddSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testInt + toAddDouble);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(differentSFloat, sInt.addSFloat(toAddSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0.0);
        assertEquals(new SFloat(testInt), sInt.addSFloat(zeroSFloat));
    }
}
