package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ScrblStringTest {
    private ScrblString scrblString;
    private String testString = "Test String";

    @BeforeEach
    void setUp(){
        scrblString = new ScrblString(testString);
    }

    @Test
    void constructorTest(){
        var expectedScrblString = new ScrblString(testString);

        assertEquals(expectedScrblString, scrblString);
        assertEquals(expectedScrblString.hashCode(), scrblString.hashCode());

        var differentScrblString = new ScrblString("Other string");
        assertNotEquals(differentScrblString, scrblString);
    }
}
