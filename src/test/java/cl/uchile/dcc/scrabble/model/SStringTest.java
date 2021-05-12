package cl.uchile.dcc.scrabble.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
        assertEquals(testString, sString.toString(), "String don't match. Seed" + seed);

        var expectedSString = new SString(testString);

        assertEquals(expectedSString, sString, "SString don't match. Seed" + seed);
        assertEquals(expectedSString.hashCode(), sString.hashCode(), "Hashcode don't match. Seed" + seed);

        String differentString;

        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                    Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        assertNotEquals(differentString, sString.toString(), "String match. Seed" + seed);

        var differentSString = new SString(differentString);
        assertNotEquals(differentSString, sString, "SString match. Seed" + seed);
    }
}