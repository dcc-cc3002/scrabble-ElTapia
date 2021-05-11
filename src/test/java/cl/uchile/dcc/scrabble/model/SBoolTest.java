package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SBoolTest{
    private SBool trueSBool;
    private SBool falseSBool;

    @BeforeEach
    void setUp(){
        trueSBool = new SBool(true);
        falseSBool = new SBool(false);
    }

    @Test
    void constructorTest(){
        var trueExpectedSBool = new SBool(true);
        var falseExpectedSBool = new SBool(false);

        assertEquals(trueExpectedSBool, trueSBool);
        assertEquals(falseExpectedSBool, falseSBool);

        assertEquals(trueExpectedSBool.hashCode(), trueSBool.hashCode());
        assertEquals(falseExpectedSBool.hashCode(), falseSBool.hashCode());

        assertNotEquals(trueExpectedSBool, falseSBool);
        assertNotEquals(falseExpectedSBool, trueSBool);
    }

    @Test
    void toStringTest(){
        String trueExpectedString = "true";
        String falseExpectedString = "false";

        assertEquals(trueExpectedString, trueSBool.toString());
        assertEquals(falseExpectedString, falseSBool.toString());

        assertNotEquals(trueExpectedString, falseSBool.toString());
        assertNotEquals(falseExpectedString, trueSBool.toString());

    }
}