package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SStringTest {
    private SString sString;
    private String testString = "Test String";

    @BeforeEach
    void setUp(){
        sString = new SString(testString);
    }

    @Test
    void constructorTest(){
        var expectedSString = new SString(testString);

        assertEquals(expectedSString, sString);
        assertEquals(expectedSString.hashCode(), sString.hashCode());

        var differentSString = new SString("Other string");
        assertNotEquals(differentSString, sString);
    }
    @Test
    void toStringTest(){
        String expectedString = "Test String";
        String differentString = "Other string";

        assertEquals(expectedString, sString.toString());
        assertNotEquals(differentString, sString.toString());

    }
}