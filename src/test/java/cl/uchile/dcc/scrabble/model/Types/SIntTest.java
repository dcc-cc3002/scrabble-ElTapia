package cl.uchile.dcc.scrabble.model.Types;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

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
        assertEquals(testInt, sInt.getInt(), "int don't match. Seed " + seed);
        assertNotEquals(sInt, testInt, "Objects match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt == testInt);

        var differentSInt = new SInt(differentInt);
        assertNotEquals(differentInt, sInt.getInt(), "int match. Seed " + seed);
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

        int expectedAdd = testInt + toOpInt;
        SInt expectedToAddSInt = new SInt(expectedAdd);

        int expectedMinus = toOpInt - testInt;
        SInt expectedToMinusSInt = new SInt(expectedMinus);

        int expectedTimes = testInt * toOpInt;
        SInt expectedToTimesSInt = new SInt(expectedTimes);

        int expectedDivide = toOpInt / testInt;
        SInt expectedToDivideSInt = new SInt(expectedDivide);

        assertEquals(expectedToAddSInt, sInt.add(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedToMinusSInt, sInt.minus(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedToTimesSInt, sInt.times(toOpSInt), "SInt don't match. Seed " + seed);
        assertEquals(expectedToDivideSInt, sInt.divide(toOpSInt), "SInt don't match. Seed " + seed);

        int differentInt;
        do {
            differentInt = rng.nextInt();
        } while (differentInt ==  toOpInt | differentInt == 0);
        SInt differentSInt = new SInt(differentInt);

        assertNotEquals(sInt.addSInt(differentSInt), sInt.addSInt(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.minusSInt(differentSInt), sInt.minusSInt(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.timesSInt(differentSInt), sInt.timesSInt(toOpSInt), "SInt match. Seed " + seed);

        assertNotEquals(sInt.add(differentSInt), sInt.add(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.minus(differentSInt), sInt.minus(toOpSInt), "SInt match. Seed " + seed);
        assertNotEquals(sInt.times(differentSInt), sInt.times(toOpSInt), "SInt match. Seed " + seed);

        SInt zeroSInt = new SInt(0);
        assertEquals(new SInt(testInt), sInt.addSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(testInt), sInt.minusSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, sInt.timesSInt(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, zeroSInt.timesSInt(sInt), "SInt don't match. Seed " + seed);

        assertEquals(new SInt(testInt), sInt.add(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(-testInt), sInt.minus(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, sInt.times(zeroSInt), "SInt don't match. Seed " + seed);
        assertEquals(zeroSInt, zeroSInt.times(sInt), "SInt don't match. Seed " + seed);
    }
    @RepeatedTest(50)
    void opSFloatTest(){
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

        double expectedAdd = testInt + toOpDouble;
        SFloat expectedAddFloat = new SFloat(expectedAdd);

        double expectedMinus = toOpDouble - testInt;
        SFloat expectedMinusFloat = new SFloat(expectedMinus);

        double expectedTimes = testInt * toOpDouble;
        SFloat expectedTimesFloat = new SFloat(expectedTimes);

        double expectedDivide = toOpDouble / testInt;
        SFloat expectedDivideFloat = new SFloat(expectedDivide);

        assertEquals(expectedAddFloat, sInt.add(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedMinusFloat, sInt.minus(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedTimesFloat, sInt.times(toOpSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(expectedDivideFloat, sInt.divide(toOpSFloat), "SFloat don't match. Seed " + seed);

        double differentDouble;
        do {
            differentDouble = rng.nextDouble();
        } while (differentDouble ==  toOpDouble | differentDouble == 0);
        SFloat differentSFloat = new SFloat(differentDouble);

        assertNotEquals(sInt.addSFloat(differentSFloat), sInt.addSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.minusSFloat(differentSFloat), sInt.minusSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.timesSFloat(differentSFloat), sInt.timesSFloat(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.divideSFloat(differentSFloat), sInt.divideSFloat(toOpSFloat), "SFloat match. Seed " + seed);

        assertNotEquals(sInt.add(differentSFloat), sInt.add(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.minus(differentSFloat), sInt.minus(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.times(differentSFloat), sInt.times(toOpSFloat), "SFloat match. Seed " + seed);
        assertNotEquals(sInt.divide(differentSFloat), sInt.divide(toOpSFloat), "SFloat match. Seed " + seed);

        SFloat zeroSFloat = new SFloat(0.0);
        assertEquals(new SFloat(testInt), sInt.addSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(testInt), sInt.minusSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sInt.timesSFloat(zeroSFloat), "SFloat don't match. Seed " + seed);

        assertEquals(new SFloat(testInt), sInt.add(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(new SFloat(-testInt), sInt.minus(zeroSFloat), "SFloat don't match. Seed " + seed);
        assertEquals(zeroSFloat, sInt.times(zeroSFloat), "SFloat don't match. Seed " + seed);
    }
    @Test
    void sIntToSBinaryTest(){
        int testInt = 0;
        SInt sInt = new SInt(testInt);
        SBinary expectedSBinary = new SBinary("0");

        assertEquals(expectedSBinary, sInt.toSBinary(), "SInt don't match. Seed " + seed);

        int otherInt = 5;
        SInt sOtherInt = new SInt(otherInt);
        SBinary Other = new SBinary("0101");

        assertEquals(Other, sOtherInt.toSBinary(), "SInt don't match. Seed " + seed);

        int negTestInt = -5;
        SInt negSInt = new SInt(negTestInt);
        SBinary expectedNegSBinary = new SBinary("1011");

        assertEquals(expectedNegSBinary, negSInt.toSBinary(), "SInt don't match. Number " + otherInt);

        int anotherInt = 2147483647;
        SInt anotherSInt = new SInt(anotherInt);
        SBinary expectedAnotherSBinary = new SBinary("01111111111111111111111111111111");

        assertEquals(expectedAnotherSBinary, anotherSInt.toSBinary(), "SInt don't match. Seed " + seed);
    }
    @RepeatedTest(50)
    void opSBinaryTest(){
        String toOpBinary = "010011"; //19
        SBinary toOpSBinary = new SBinary(toOpBinary);

        SInt expectedAddSInt = new SInt(testInt+19);
        SInt expectedMinusSInt = new SInt(testInt-19);
        SInt expectedTimesSInt = new SInt(testInt*19);
        SInt expectedDivideSInt = new SInt(testInt/19);

        assertEquals(expectedAddSInt, sInt.addSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusSInt, sInt.minusSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedTimesSInt, sInt.timesSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedDivideSInt, sInt.divideSBinary(toOpSBinary), "SInt don't match. Seed " + seed);


        SInt expectedAdd = new SInt(testInt+19);
        SInt expectedMinus = new SInt(19-testInt);
        SInt expectedTimes = new SInt(testInt*19);
        SInt expectedDivide = new SInt(19/testInt);

        assertEquals(expectedAdd.toSBinary(), sInt.add(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinus.toSBinary(), sInt.minus(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedTimes.toSBinary(), sInt.times(toOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedDivide.toSBinary(), sInt.divide(toOpSBinary), "SBinary don't match. Seed " + seed);


        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SInt(testInt), sInt.addSBinary(zeroSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(testInt), sInt.minusSBinary(zeroSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(0), sInt.timesSBinary(zeroSBinary), "SInt don't match. Seed " + seed);

        assertEquals(sInt.toSBinary(), sInt.add(zeroSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(sInt.toSBinary().negate().addOne(), sInt.minus(zeroSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), sInt.times(zeroSBinary), "SBinary don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("1");
        assertEquals(new SInt(-testInt), sInt.timesSBinary(minusOneSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(-testInt), sInt.divideSBinary(minusOneSBinary), "SInt don't match. Seed " + seed);

        assertEquals(sInt.toSBinary().negate().addOne(), sInt.times(minusOneSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(new SBinary("0"), sInt.divide(minusOneSBinary), "SBinary don't match. Seed " + seed);

        String otherToOpBinaryString = "0110010";//50
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SInt expectedOtherAddSInt = new SInt(testInt+50);
        SInt expectedOtherMinusSInt = new SInt(testInt-50);
        SInt expectedOtherTimesSInt = new SInt(testInt*50);
        SInt expectedOtherDivideSInt = new SInt(testInt/50);

        assertEquals(expectedOtherAddSInt, sInt.addSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSInt, sInt.minusSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSInt, sInt.timesSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSInt, sInt.divideSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);

        SInt expectedOtherAdd = new SInt(testInt+50);
        SInt expectedOtherMinus = new SInt(50-testInt);
        SInt expectedOtherTimes = new SInt(testInt*50);
        SInt expectedOtherDivide = new SInt(50/testInt);

        assertEquals(expectedOtherAdd.toSBinary(), sInt.add(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherMinus.toSBinary(), sInt.minus(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherTimes.toSBinary(), sInt.times(otherToOpSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedOtherDivide.toSBinary(), sInt.divide(otherToOpSBinary), "SBinary don't match. Seed " + seed);

        String otherMinusBinary = "10010";//-14
        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);

        SInt expectedMinusAddSInt = new SInt(testInt-14);
        SInt expectedMinusMinusSInt = new SInt(testInt+14);
        SInt expectedMinusTimesSInt = new SInt(testInt*-14);
        SInt expectedMinusDivideSInt = new SInt(testInt/-14);

        assertEquals(expectedMinusAddSInt, sInt.addSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSInt, sInt.minusSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSInt, sInt.timesSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSInt, sInt.divideSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);

        SInt expectedMinusAdd = new SInt(-14+testInt);
        SInt expectedMinusMinus = new SInt(-14-testInt);
        SInt expectedMinusTimes = new SInt(testInt*-14);
        SInt expectedMinusDivide = new SInt(-14/testInt);

        assertEquals(expectedMinusAdd.toSBinary(), sInt.add(otherMinusSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusMinus.toSBinary(), sInt.minus(otherMinusSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusTimes.toSBinary(), sInt.times(otherMinusSBinary), "SBinary don't match. Seed " + seed);
        assertEquals(expectedMinusDivide.toSBinary(), sInt.divide(otherMinusSBinary), "SBinary don't match. Seed " + seed);
    }

    @RepeatedTest(50)
    void addToSStringTest(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(50);
        String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
            true, true, null, rng);
        SString sString = new SString(testString);

        int toAddInt = rng.nextInt();
        SInt toAddSInt = new SInt(toAddInt);
        String expectedString = toAddInt + testString;
        SString expectedSString = new SString(expectedString);

        assertEquals(expectedSString, toAddSInt.addToSString(sString), "SString don't match. Seed " + seed);

        String differentString;
        do {
            differentString = RandomStringUtils.random(rng.nextInt(50), 0,
                Character.MAX_CODE_POINT, true, true, null, rng);
        } while (differentString.equals(testString));

        int differentToAddInt;
        do { differentToAddInt = rng.nextInt();
        } while (differentToAddInt == toAddInt);
        SString differentSString = new SString(differentString + differentToAddInt);

        assertNotEquals(differentSString, toAddSInt.addToSString(sString), "SString match. Seed " + seed);
    }
}
