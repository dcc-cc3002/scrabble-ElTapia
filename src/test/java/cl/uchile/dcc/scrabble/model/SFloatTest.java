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
        assertEquals(testDouble, sFloat.getDouble(), "double don't match. Seed " + seed);
        assertNotEquals(sFloat, testDouble, "Objects match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        var differentSFloat = new SFloat(differentDouble);
        assertNotEquals(differentDouble, sFloat.getDouble(), "double match. Seed " + seed);
        assertNotEquals(differentSFloat, sFloat, "SFloat match. Seed " + seed);

        assertEquals(String.valueOf(testDouble), sFloat.toString(), "String don't match. Seed " + seed);
        assertNotEquals(String.valueOf(differentDouble), sFloat.toString(), "String match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSStringTest(){
        SString expectedSString = new SString(String.valueOf(testDouble));
        assertEquals(expectedSString, sFloat.toSString(), "SString don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        SString differentSString = new SString(String.valueOf(differentDouble));
        assertNotEquals(differentSString, sFloat.toSString(), "SString match. Seed " + seed);
    }

    @RepeatedTest(50)
    void toSFloatTest(){
        SFloat expectedSFloat = new SFloat(testDouble);
        assertEquals(expectedSFloat, sFloat.toSFloat(), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble == testDouble);

        SFloat differentSFloat = new SFloat(differentDouble);
        assertNotEquals(differentSFloat, sFloat.toSFloat(), "SFloat match. Seed " + seed);
    }

    @RepeatedTest(50)
    void opSInTest() {
        int toOpInt;
        do {
            toOpInt = rng.nextInt();
        }while (toOpInt == 0);

        SInt toOpSInt = new SInt(toOpInt);

        double expectedAddDouble = testDouble + toOpInt;
        SFloat expectedAddSFloat = new SFloat(expectedAddDouble);

        double expectedMinusDouble = testDouble - toOpInt;
        SFloat expectedMinusSFloat = new SFloat(expectedMinusDouble);

        double expectedTimesDouble = testDouble * toOpInt;
        SFloat expectedTimesSFloat = new SFloat(expectedTimesDouble);

        double expectedDivideDouble = testDouble / toOpInt;
        SFloat expectedDivideSFloat = new SFloat(expectedDivideDouble);

        assertEquals(expectedAddSFloat, sFloat.addSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minusSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.timesSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divideSInt(toOpSInt), "SFloat don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt ==  toOpInt | differentInt == 0);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(sFloat.addSInt(differentSInt), sFloat.addSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minusSInt(differentSInt), sFloat.minusSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.timesSInt(differentSInt), sFloat.timesSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divideSInt(differentSInt), sFloat.divideSInt(toOpSInt), "SFloat match. Seed " + seed);

        SInt zeroSInt = new SInt(0);
        assertEquals(new SFloat(testDouble), sFloat.addSInt(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minusSInt(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), sFloat.timesSInt(zeroSInt), "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void opSFloatTest() {
        double toOpDouble;
        do {
            toOpDouble = rng.nextDouble();
        }while (toOpDouble == 0);

        SFloat toOpSFloat = new SFloat(toOpDouble);

        double expectedAddDouble = testDouble + toOpDouble;
        SFloat expectedAddSFloat = new SFloat(expectedAddDouble);

        double expectedMinusDouble = testDouble - toOpDouble;
        SFloat expectedMinusSFloat = new SFloat(expectedMinusDouble);

        double expectedTimesDouble = testDouble * toOpDouble;
        SFloat expectedTimesSFloat = new SFloat(expectedTimesDouble);

        double expectedDivideDouble = testDouble / toOpDouble;
        SFloat expectedDivideSFloat = new SFloat(expectedDivideDouble);

        assertEquals(expectedAddSFloat, sFloat.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble ==  toOpDouble | differentDouble == 0);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(sFloat.addSFloat(differentSFloat), sFloat.addSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minusSFloat(differentSFloat), sFloat.minusSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.timesSFloat(differentSFloat), sFloat.timesSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divideSFloat(differentSFloat), sFloat.divideSFloat(toOpSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0.0);
        assertEquals(new SFloat(testDouble), sFloat.addSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minusSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sFloat.timesSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, zeroSFloat.timesSFloat(sFloat), "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void opSBinaryTest() {
        String toOpBinary = "010011"; //19
        SBinary toOpSBinary = new SBinary(toOpBinary);

        SFloat expectedAddSFloat = new SFloat(testDouble+19);
        SFloat expectedMinusSFloat = new SFloat(testDouble-19);
        SFloat expectedTimesSFloat = new SFloat(testDouble*19);
        SFloat expectedDivideSFloat = new SFloat(testDouble/19);

        assertEquals(expectedAddSFloat, sFloat.addSBinary(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minusSBinary(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.timesSBinary(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divideSBinary(toOpSBinary), "SFloat don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SFloat(testDouble), sFloat.addSBinary(zeroSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minusSBinary(zeroSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), sFloat.timesSBinary(zeroSBinary), "SFloat don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("1");
        assertEquals(new SFloat(-testDouble), sFloat.timesSBinary(minusOneSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testDouble), sFloat.divideSBinary(minusOneSBinary), "SFloat don't match. Seed " + seed);

        String otherToOpBinaryString = "01101100101110101010000";//3562832
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SFloat expectedOtherAddSFloat = new SFloat(testDouble + 3562832);
        SFloat expectedOtherMinusSFloat = new SFloat(testDouble-3562832);
        SFloat expectedOtherTimesSFloat = new SFloat(testDouble*3562832);
        SFloat expectedOtherDivideSFloat = new SFloat(testDouble/3562832);

        assertEquals(expectedOtherAddSFloat, sFloat.addSBinary(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSFloat, sFloat.minusSBinary(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSFloat, sFloat.timesSBinary(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSFloat, sFloat.divideSBinary(otherToOpSBinary), "SFloat don't match. Seed " + seed);

        String minusToOpBinaryString = "11101100101110101010000";//-631472
        SBinary minusToOpSBinary = new SBinary(minusToOpBinaryString);

        SFloat expectedMinusAddSFloat = new SFloat(testDouble-631472);
        SFloat expectedMinusMinusSFloat = new SFloat(testDouble+631472);
        SFloat expectedMinusTimesSFloat = new SFloat(testDouble*-631472);
        SFloat expectedMinusDivideSFloat = new SFloat(testDouble/-631472);

        assertEquals(expectedMinusAddSFloat, sFloat.addSBinary(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSFloat, sFloat.minusSBinary(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSFloat, sFloat.timesSBinary(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSFloat, sFloat.divideSBinary(minusToOpSBinary), "SFloat don't match. Seed " + seed);
    }
}
