package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO: Implement test for operator add with binary
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
    void opSIntTest(){
        int toOpInt;
        do {
            toOpInt = rng.nextInt();
        }while (toOpInt == 0);

        SInt toOpSInt = new SInt(toOpInt);

        int expectedAddInt = testInt + toOpInt;
        SInt expectedAddSInt = new SInt(expectedAddInt);

        int expectedMinusInt = testInt - toOpInt;
        SInt expectedMinusSInt = new SInt(expectedMinusInt);

        int expectedTimesInt = testInt * toOpInt;
        SInt expectedTimesSInt = new SInt(expectedTimesInt);

        int expectedDivideInt = testInt / toOpInt;
        SInt expectedDivideSInt = new SInt(expectedDivideInt);

        assertEquals(expectedAddSInt, sInt.addSInt(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusSInt, sInt.minusSInt(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedTimesSInt, sInt.timesSInt(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedDivideSInt, sInt.divideSInt(toOpSInt), "SInt don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt ==  toOpInt | differentInt == 0);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(sInt.addSInt(differentSInt), sInt.addSInt(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.minusSInt(differentSInt), sInt.minusSInt(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.timesSInt(differentSInt), sInt.timesSInt(toOpSInt), "SInt match. Seed " + seed);

        SInt zeroSInt = new SInt(0);
        assertEquals(new SInt(testInt), sInt.addSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(testInt), sInt.minusSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, sInt.timesSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, zeroSInt.timesSInt(sInt), "SInt don't match. Seed " + seed);
    }
    @RepeatedTest(50)
    void addSFloatTest(){
        double toOpDouble;
        do {
            toOpDouble = rng.nextDouble();
        }while (toOpDouble == 0);

        SFloat toOpSFloat = new SFloat(toOpDouble);

        double expectedAddDouble = testInt + toOpDouble;
        SFloat expectedAddSInt = new SFloat(expectedAddDouble);

        double expectedMinusDouble = testInt - toOpDouble;
        SFloat expectedMinusSFloat = new SFloat(expectedMinusDouble);

        double expectedTimesDouble = testInt * toOpDouble;
        SFloat expectedTimesSFloat = new SFloat(expectedTimesDouble);

        double expectedDivideDouble = testInt / toOpDouble;
        SFloat expectedDivideSFloat = new SFloat(expectedDivideDouble);

        assertEquals(expectedAddSInt, sInt.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sInt.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sInt.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sInt.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble ==  toOpDouble | differentDouble == 0);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(sInt.addSFloat(differentSFloat), sInt.addSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.minusSFloat(differentSFloat), sInt.minusSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.timesSFloat(differentSFloat), sInt.timesSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.divideSFloat(differentSFloat), sInt.divideSFloat(toOpSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0.0);
        assertEquals(new SFloat(testInt), sInt.addSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testInt), sInt.minusSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sInt.timesSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
    }
}
