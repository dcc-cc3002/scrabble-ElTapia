package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
}
