package cl.uchile.dcc.scrabble.model.Types;

import org.apache.commons.lang3.RandomStringUtils;
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

        double expectedMinusDouble = toOpInt - testDouble;
        SFloat expectedMinusSFloat = new SFloat(expectedMinusDouble);

        double expectedTimesDouble = testDouble * toOpInt;
        SFloat expectedTimesSFloat = new SFloat(expectedTimesDouble);

        double expectedDivideDouble = toOpInt / testDouble;
        SFloat expectedDivideSFloat = new SFloat(expectedDivideDouble);

        assertEquals(expectedAddSFloat, sFloat.addSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minusSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.timesSInt(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divideSInt(toOpSInt), "SFloat don't match. Seed " + seed);

        double expectedAdd = testDouble + toOpInt;
        SFloat expectedAddFloat = new SFloat(expectedAdd);

        double expectedMinus = testDouble - toOpInt;
        SFloat expectedMinusFloat = new SFloat(expectedMinus);

        double expectedTimes = testDouble * toOpInt;
        SFloat expectedTimesFloat = new SFloat(expectedTimes);

        double expectedDivide = testDouble / toOpInt;
        SFloat expectedDivideFloat = new SFloat(expectedDivide);

        assertEquals(expectedAddFloat, sFloat.add(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusFloat, sFloat.minus(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesFloat, sFloat.times(toOpSInt), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideFloat, sFloat.divide(toOpSInt), "SFloat don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt ==  toOpInt | differentInt == 0);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(sFloat.addSInt(differentSInt), sFloat.addSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minusSInt(differentSInt), sFloat.minusSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.timesSInt(differentSInt), sFloat.timesSInt(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divideSInt(differentSInt), sFloat.divideSInt(toOpSInt), "SFloat match. Seed " + seed);

        assertNotEquals(sFloat.add(differentSInt), sFloat.add(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minus(differentSInt), sFloat.minus(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.times(differentSInt), sFloat.times(toOpSInt), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divide(differentSInt), sFloat.divide(toOpSInt), "SFloat match. Seed " + seed);


        SInt zeroSInt = new SInt(0);
        assertEquals(new SFloat(testDouble), sFloat.addSInt(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testDouble), sFloat.minusSInt(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), sFloat.timesSInt(zeroSInt), "SFloat don't match. Seed " + seed);

        assertEquals(new SFloat(testDouble), sFloat.add(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minus(zeroSInt), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), sFloat.times(zeroSInt), "SFloat don't match. Seed " + seed);
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

        double expectedMinusDouble = toOpDouble - testDouble;
        SFloat expectedMinusSFloat = new SFloat(expectedMinusDouble);

        double expectedTimesDouble = testDouble * toOpDouble;
        SFloat expectedTimesSFloat = new SFloat(expectedTimesDouble);

        double expectedDivideDouble = toOpDouble / testDouble;
        SFloat expectedDivideSFloat = new SFloat(expectedDivideDouble);

        assertEquals(expectedAddSFloat, sFloat.addSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minusSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.timesSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divideSFloat(toOpSFloat), "SFloat don't match. Seed " + seed);

        double expectedAdd = testDouble + toOpDouble;
        SFloat expectedAddFloat = new SFloat(expectedAdd);

        double expectedMinus = testDouble - toOpDouble;
        SFloat expectedMinusFloat = new SFloat(expectedMinus);

        double expectedTimes = testDouble * toOpDouble;
        SFloat expectedTimesFloat = new SFloat(expectedTimes);

        double expectedDivide = testDouble / toOpDouble;
        SFloat expectedDivideFloat = new SFloat(expectedDivide);

        assertEquals(expectedAddFloat, sFloat.add(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusFloat, sFloat.minus(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesFloat, sFloat.times(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideFloat, sFloat.divide(toOpSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble ==  toOpDouble | differentDouble == 0);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(sFloat.addSFloat(differentSFloat), sFloat.addSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minusSFloat(differentSFloat), sFloat.minusSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.timesSFloat(differentSFloat), sFloat.timesSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divideSFloat(differentSFloat), sFloat.divideSFloat(toOpSFloat), "SFloat match. Seed " + seed);

        assertNotEquals(sFloat.add(differentSFloat), sFloat.add(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.minus(differentSFloat), sFloat.minus(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.times(differentSFloat), sFloat.times(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sFloat.divide(differentSFloat), sFloat.divide(toOpSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0.0);
        assertEquals(new SFloat(testDouble), sFloat.addSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testDouble), sFloat.minusSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sFloat.timesSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, zeroSFloat.timesSFloat(sFloat), "SFloat don't match. Seed " + seed);

        assertEquals(new SFloat(testDouble), sFloat.add(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minus(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sFloat.times(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, zeroSFloat.times(sFloat), "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void opSBinaryTest() {
        String toOpBinary = "010011"; //19
        SBinary toOpSBinary = new SBinary(toOpBinary);

        SFloat expectedAddSFloat = new SFloat(19+testDouble);
        SFloat expectedMinusSFloat = new SFloat(testDouble-19);
        SFloat expectedTimesSFloat = new SFloat(testDouble*19);
        SFloat expectedDivideSFloat = new SFloat(testDouble/19);

        assertEquals(expectedAddSFloat, sFloat.add(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusSFloat, sFloat.minus(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesSFloat, sFloat.times(toOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideSFloat, sFloat.divide(toOpSBinary), "SFloat don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SFloat(testDouble), sFloat.add(zeroSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testDouble), sFloat.minus(zeroSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(0), sFloat.times(zeroSBinary), "SFloat don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("1");
        assertEquals(new SFloat(-testDouble), sFloat.times(minusOneSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testDouble), sFloat.divide(minusOneSBinary), "SFloat don't match. Seed " + seed);

        String otherToOpBinaryString = "01101100101110101010000";//3562832
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SFloat expectedOtherAddSFloat = new SFloat(testDouble + 3562832);
        SFloat expectedOtherMinusSFloat = new SFloat(testDouble-3562832);
        SFloat expectedOtherTimesSFloat = new SFloat(testDouble*3562832);
        SFloat expectedOtherDivideSFloat = new SFloat(testDouble/3562832);

        assertEquals(expectedOtherAddSFloat, sFloat.add(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSFloat, sFloat.minus(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSFloat, sFloat.times(otherToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSFloat, sFloat.divide(otherToOpSBinary), "SFloat don't match. Seed " + seed);

        String minusToOpBinaryString = "11101100101110101010000";//-631472
        SBinary minusToOpSBinary = new SBinary(minusToOpBinaryString);

        SFloat expectedMinusAddSFloat = new SFloat(testDouble-631472);
        SFloat expectedMinusMinusSFloat = new SFloat(testDouble+631472);
        SFloat expectedMinusTimesSFloat = new SFloat(testDouble*-631472);
        SFloat expectedMinusDivideSFloat = new SFloat(testDouble/-631472);

        assertEquals(expectedMinusAddSFloat, sFloat.add(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSFloat, sFloat.minus(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSFloat, sFloat.times(minusToOpSBinary), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSFloat, sFloat.divide(minusToOpSBinary), "SFloat don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addToSStringTest(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(50);
        String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
            true, true, null, rng);
        SString sString = new SString(testString);

        double toAddDouble = rng.nextDouble();
        SFloat toAddSFloat = new SFloat(toAddDouble);

        String expectedString = testString + toAddDouble;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, toAddSFloat.addToSString(sString), "SString don't match. Seed " + seed);

        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        double differentToAddDouble;
        do { differentToAddDouble = rng.nextDouble();
        } while (differentToAddDouble == toAddDouble);

        SString differentSString = new SString(differentString + differentToAddDouble);
        assertNotEquals(differentSString, toAddSFloat.addToSString(sString), "SString match. Seed " + seed);
    }
}
