package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

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

        Double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        var differentSFloat = new SFloat(differentDouble);
        assertNotEquals(differentSFloat, sFloat, "SFloat match. Seed " + seed);

        assertEquals(String.valueOf(testDouble), sFloat.toString(), "String don't match. Seed " + seed);
        assertNotEquals(String.valueOf(differentDouble), sFloat.toString(), "String match. Seed " + seed);

    }
}
