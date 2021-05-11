package cl.uchile.dcc.scrabble.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SBinaryTest {
    private SBinary sBinary;
    private String testBinary ="110";

    @BeforeEach
    void setUp(){
        sBinary = new SBinary(testBinary);
    }

    @Test
    void constructorTest(){
        var expectedSBinary = new SBinary(testBinary);

        assertEquals(expectedSBinary, sBinary);
        assertEquals(expectedSBinary.hashCode(), sBinary.hashCode());

        var differentSBinary = new SBinary("101");
        assertNotEquals(differentSBinary, sBinary);
    }

    @Test
    void toStringTest(){
        String expectedString = "110";
        String differentString = "101";

        assertEquals(expectedString, sBinary.toString());
        assertNotEquals(differentString, sBinary.toString());
    }
}