package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SFloatTest {
    private SFloat sFloat;
    private double testFloat = 3.14;

    @BeforeEach
    void setUp(){
        sFloat = new SFloat(testFloat);
    }

    @Test
    void constructorTest(){
        var expectedSFloat = new SFloat(testFloat);

        assertEquals(expectedSFloat, sFloat);
        assertEquals(expectedSFloat.hashCode(), sFloat.hashCode());

        var differentSFloat = new SFloat(2.56);
        assertNotEquals(differentSFloat, sFloat);
    }

    @Test
    void toStringTest(){
        String expectedString = "3.14";
        String differentString = "2.56";

        assertEquals(expectedString, sFloat.toString());
        assertNotEquals(differentString, sFloat.toString());
    }
}
