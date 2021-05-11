package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SIntTest {
    private SInt sInt;
    private int testInt = 5;

    @BeforeEach
    void setUp(){
        sInt = new SInt(testInt);
    }

    @Test
    void constructorTest(){
        var expectedSInt = new SInt(testInt);

        assertEquals(expectedSInt, sInt);
        assertEquals(expectedSInt.hashCode(), sInt.hashCode());

        var differentSInt = new SInt(2);
        assertNotEquals(differentSInt, sInt);

    }

    @Test
    void toStringTest(){
        String expectedString = "5";
        String differentString = "2";

        assertEquals(expectedString, sInt.toString());
        assertNotEquals(differentString, sInt.toString());
    }
}
