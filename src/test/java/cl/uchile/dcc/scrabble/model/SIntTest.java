package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

//COMPLETE: Implement test for operator add with binary
//COMPLETE: Implement test for operator minus with binary
//COMPLETE: Implement test for operator times with binary
//COMPLETE: Implement test for operator divide with binary
//COMPLETE: Implement test for toSBinary method
//TODO: Improve tests for toSBinary

import static cl.uchile.dcc.scrabble.model.SInt.positiveIntToBinaryString;
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
    @Test
    void sIntToSBinaryTest(){
        int testInt = 0;
        SInt sInt = new SInt(testInt);
        SBinary expectedSBinary = new SBinary("0");

        assertEquals(expectedSBinary, sInt.toSBinary(), "SInt don't match. Seed " + seed);
        assertEquals("0", positiveIntToBinaryString(testInt), "String don't match. Seed " + seed);

        int otherInt = 5;
        SInt sOtherInt = new SInt(otherInt);
        SBinary Other = new SBinary("0101");

        assertEquals(Other, sOtherInt.toSBinary(), "SInt don't match. Seed " + seed);
        assertEquals("0101", positiveIntToBinaryString(otherInt), "String don't match. Seed " + seed);

        int negTestInt = -5;
        SInt negSInt = new SInt(negTestInt);
        SBinary expectedNegSBinary = new SBinary("1011");

        assertEquals(expectedNegSBinary, negSInt.toSBinary(), "SInt don't match. Number " + otherInt);
        assertEquals("0101", positiveIntToBinaryString(Math.abs(otherInt)), "String don't match. Seed " + seed);

        int anotherInt = 2147483647;
        SInt anotherSInt = new SInt(anotherInt);
        SBinary expectedAnotherSBinary = new SBinary("01111111111111111111111111111111");

        assertEquals(expectedAnotherSBinary, anotherSInt.toSBinary(), "SInt don't match. Seed " + seed);
        assertEquals("01111111111111111111111111111111", positiveIntToBinaryString(Math.abs(anotherInt)), "String don't match. Seed " + seed);
    }
    @Test
    void opSBinaryTest(){
        int positiveInt = 25;
        String toOpBinary = "010011"; //19

        SInt positiveSInt = new SInt(positiveInt);
        SBinary toOpSBinary = new SBinary(toOpBinary);

        SInt expectedAddSInt = new SInt(44);
        SInt expectedMinusSInt = new SInt(6);
        SInt expectedTimesSInt = new SInt(475);
        SInt expectedDivideSInt = new SInt(1);

        assertEquals(expectedAddSInt, positiveSInt.addSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusSInt, positiveSInt.minusSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedTimesSInt, positiveSInt.timesSBinary(toOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedDivideSInt, positiveSInt.divideSBinary(toOpSBinary), "SInt don't match. Seed " + seed);

        SBinary zeroSBinary = new SBinary("0");

        assertEquals(new SInt(positiveInt), positiveSInt.addSBinary(zeroSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(positiveInt), positiveSInt.minusSBinary(zeroSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(0), positiveSInt.timesSBinary(zeroSBinary), "SInt don't match. Seed " + seed);

        SBinary minusOneSBinary = new SBinary("1");
        assertEquals(new SInt(-positiveInt), positiveSInt.timesSBinary(minusOneSBinary), "SInt don't match. Seed " + seed);
        assertEquals(new SInt(-positiveInt), positiveSInt.divideSBinary(minusOneSBinary), "SInt don't match. Seed " + seed);

        int otherInt = 9;
        String otherToOpBinaryString = "0110010";

        SInt otherSInt = new SInt(otherInt);
        SBinary otherToOpSBinary = new SBinary(otherToOpBinaryString);

        SInt expectedOtherAddSInt = new SInt(59);
        SInt expectedOtherMinusSInt = new SInt(-41);
        SInt expectedOtherTimesSInt = new SInt(450);
        SInt expectedOtherDivideSInt = new SInt(0);

        assertEquals(expectedOtherAddSInt, otherSInt.addSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherMinusSInt, otherSInt.minusSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherTimesSInt, otherSInt.timesSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedOtherDivideSInt, otherSInt.divideSBinary(otherToOpSBinary), "SInt don't match. Seed " + seed);

        int minusInt = -42;
        String anotherToOpBinary = "0100101";//37

        SInt minusSInt = new SInt(minusInt);
        SBinary anotherToOpSBinary = new SBinary(anotherToOpBinary);

        SInt expectedAnotherAddSInt = new SInt(-5);
        SInt expectedAnotherMinusSInt = new SInt(-79);
        SInt expectedAnotherTimesSInt = new SInt(-1554);
        SInt expectedAnotherDivideSInt = new SInt(-1);

        assertEquals(expectedAnotherAddSInt, minusSInt.addSBinary(anotherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherMinusSInt, minusSInt.minusSBinary(anotherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherTimesSInt, minusSInt.timesSBinary(anotherToOpSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedAnotherDivideSInt, minusSInt.divideSBinary(anotherToOpSBinary), "SInt don't match. Seed " + seed);

        int otherMinusInt = -7;
        String otherMinusBinary = "10010";//-14

        SInt otherMinusSInt = new SInt(otherMinusInt);
        SBinary otherMinusSBinary = new SBinary(otherMinusBinary);

        SInt expectedMinusAddSInt = new SInt(-21);
        SInt expectedMinusMinusSInt = new SInt(7);
        SInt expectedMinusTimesSInt = new SInt(98);
        SInt expectedMinusDivideSInt = new SInt(0);

        assertEquals(expectedMinusAddSInt, otherMinusSInt.addSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusMinusSInt, otherMinusSInt.minusSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusTimesSInt, otherMinusSInt.timesSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
        assertEquals(expectedMinusDivideSInt, otherMinusSInt.divideSBinary(otherMinusSBinary), "SInt don't match. Seed " + seed);
    }
}
