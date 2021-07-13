package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import cl.uchile.dcc.scrabble.model.Types.SInt;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ConsIntTest {
  protected ConsInt consInt;
  protected int testInt;
  protected int seed;
  protected Random rng;

  @BeforeEach
  protected void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    testInt = rng.nextInt();
    consInt = new ConsInt(testInt);
  }
  @RepeatedTest(50)
  void constructorTest() {
    ConsInt expectedConsInt = new ConsInt(testInt);
    SInt expectedSInt = new SInt(testInt);
    ConsInt expectedConsSInt = new ConsInt(expectedSInt);

    assertEquals(expectedConsInt, consInt, "ConsInt don't match. Seed " + seed);
    assertEquals(expectedConsSInt, consInt, "ConsInt don't match. Seed " + seed);
    assertEquals(expectedConsInt.hashCode(), consInt.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(expectedSInt, consInt.getSType(), "SInt don't match. Seed " + seed);
    assertNotEquals(consInt, testInt, "Objects match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt == testInt);

    ConsInt differentConsInt = new ConsInt(differentInt);
    SInt differentSInt = new SInt(differentInt);
    ConsInt differentConsSInt = new ConsInt(differentSInt);

    assertNotEquals(differentSInt, consInt.getSType(), "SInt match. Seed " + seed);
    assertNotEquals(differentConsSInt, consInt, "ConsInt match. Seed " + seed);
    assertNotEquals(differentConsInt, consInt, "ConsInt match. Seed " + seed);

    assertEquals(String.valueOf(testInt), consInt.toString(), "String don't match. Seed " + seed);
    assertNotEquals(String.valueOf(differentInt), consInt.toString(), "String match. Seed " + seed);
  }
  @RepeatedTest(50)
  void toConsStringTest(){
    ConsString expectedConsString = new ConsString(String.valueOf(testInt));
    assertEquals(expectedConsString, consInt.toConstantStr(), "ConsString don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt == testInt);

    ConsString differentConsString = new ConsString(String.valueOf(differentInt));
    assertNotEquals(differentConsString, consInt.toConstantStr(), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsFloatTest(){
    String intString = String.valueOf(testInt);
    ConsFloat expectedConsFloat = new ConsFloat(Double.parseDouble(intString));
    assertEquals(expectedConsFloat, consInt.toConstantFloat(), "ConsFloat don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt == testInt);
    String differentIntString = String.valueOf(differentInt);
    ConsFloat differentConsFloat = new ConsFloat(Double.parseDouble(differentIntString));
    assertNotEquals(differentConsFloat, consInt.toConstantFloat(), "ConsFloat match. Seed " + seed);
  }

  @RepeatedTest(50)
  void toConsIntTest(){
    ConsInt expectedConsInt = new ConsInt(testInt);
    assertEquals(expectedConsInt, consInt.toConstantInt(), "ConsInt don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt == testInt);
    ConsInt differentConsInt = new ConsInt(differentInt);
    assertNotEquals(differentConsInt, consInt.toConstantInt(), "ConsInt match. Seed " + seed);
  }

  @Test
  void toConsBinaryTest(){
    int testInt = 0;
    ConsInt ConsInt = new ConsInt(testInt);
    ConsBinary expectedConsBinary = new ConsBinary("0");

    assertEquals(expectedConsBinary, ConsInt.toConstantBinary(), "ConsBinary don't match. Seed " + seed);

    int otherInt = 5;
    ConsInt ConsOtherInt = new ConsInt(otherInt);
    ConsBinary Other = new ConsBinary("0101");

    assertEquals(Other, ConsOtherInt.toConstantBinary(), "ConsBinary don't match. Seed " + seed);

    int negTestInt = -5;
    ConsInt negConsInt = new ConsInt(negTestInt);
    ConsBinary expectedNegConsBinary = new ConsBinary("1011");

    assertEquals(expectedNegConsBinary, negConsInt.toConstantBinary(), "ConsBinary don't match. Number " + otherInt);

    int anotherInt = 2147483647;
    ConsInt anotherConsInt = new ConsInt(anotherInt);
    ConsBinary expectedAnotherConsBinary = new ConsBinary("01111111111111111111111111111111");

    assertEquals(expectedAnotherConsBinary, anotherConsInt.toConstantBinary(), "ConsBinary don't match. Seed " + seed);
  }


  @RepeatedTest(50)
  void opConsIntTest(){
    int toOpInt;
    do {
      toOpInt = rng.nextInt();
    }while (toOpInt == 0);

    ConsInt toOpConsInt = new ConsInt(toOpInt);

    int expectedAddInt = testInt + toOpInt;
    ConsInt expectedAddConsInt = new ConsInt(expectedAddInt);

    int expectedMinusInt = testInt - toOpInt;
    ConsInt expectedMinusConsInt = new ConsInt(expectedMinusInt);

    int expectedTimesInt = testInt * toOpInt;
    ConsInt expectedTimesConsInt = new ConsInt(expectedTimesInt);

    int expectedDivideInt = testInt / toOpInt;
    ConsInt expectedDivideConsInt = new ConsInt(expectedDivideInt);

    assertEquals(expectedAddConsInt, consInt.add(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusConsInt, consInt.sub(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedTimesConsInt, consInt.times(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedDivideConsInt, consInt.divide(toOpConsInt), "ConsInt don't match. Seed " + seed);

    int expectedAdd = testInt + toOpInt;
    ConsInt expectedToAddConsInt = new ConsInt(expectedAdd);

    int expectedMinus = toOpInt - testInt;
    ConsInt expectedToMinusConsInt = new ConsInt(expectedMinus);

    int expectedTimes = testInt * toOpInt;
    ConsInt expectedToTimesConsInt = new ConsInt(expectedTimes);

    int expectedDivide = toOpInt / testInt;
    ConsInt expectedToDivideConsInt = new ConsInt(expectedDivide);

    assertEquals(expectedToAddConsInt, consInt.addConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToMinusConsInt, consInt.subConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToTimesConsInt, consInt.timesConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedToDivideConsInt, consInt.divideConsInt(toOpConsInt), "ConsInt don't match. Seed " + seed);

    int differentInt;
    do {
      differentInt = rng.nextInt();
    } while (differentInt ==  toOpInt | differentInt == 0);
    ConsInt differentConsInt = new ConsInt(differentInt);

    assertNotEquals(consInt.addConsInt(differentConsInt), consInt.addConsInt(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.subConsInt(differentConsInt), consInt.subConsInt(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.timesConsInt(differentConsInt), consInt.timesConsInt(toOpConsInt), "ConsInt match. Seed " + seed);

    assertNotEquals(consInt.add(differentConsInt), consInt.add(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.sub(differentConsInt), consInt.sub(toOpConsInt), "ConsInt match. Seed " + seed);
    assertNotEquals(consInt.times(differentConsInt), consInt.times(toOpConsInt), "ConsInt match. Seed " + seed);

    ConsInt zeroConsInt = new ConsInt(0);
    assertEquals(new ConsInt(testInt), consInt.add(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(testInt), consInt.sub(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, consInt.times(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, zeroConsInt.divide(consInt), "ConsInt don't match. Seed " + seed);

    assertEquals(new ConsInt(testInt), consInt.addConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(-testInt), consInt.subConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, consInt.timesConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
    assertEquals(zeroConsInt, consInt.divideConsInt(zeroConsInt), "ConsInt don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void opConsFloatTest(){
    double toOpDouble;
    do {
      toOpDouble = rng.nextDouble();
    }while (toOpDouble == 0);

    ConsFloat toOpConsFloat = new ConsFloat(toOpDouble);

    double expectedAddDouble = testInt + toOpDouble;
    ConsFloat expectedAddConsFloat = new ConsFloat(expectedAddDouble);

    double expectedMinusDouble = testInt - toOpDouble;
    ConsFloat expectedMinusConsFloat = new ConsFloat(expectedMinusDouble);

    double expectedTimesDouble = testInt * toOpDouble;
    ConsFloat expectedTimesConsFloat = new ConsFloat(expectedTimesDouble);

    double expectedDivideDouble = testInt / toOpDouble;
    ConsFloat expectedDivideConsFloat = new ConsFloat(expectedDivideDouble);

    assertEquals(expectedAddConsFloat, consInt.add(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusConsFloat, consInt.sub(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesConsFloat, consInt.times(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideConsFloat, consInt.divide(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double expectedAdd = testInt + toOpDouble;
    ConsFloat expectedAddFloat = new ConsFloat(expectedAdd);

    double expectedMinus = toOpDouble - testInt;
    ConsFloat expectedMinusFloat = new ConsFloat(expectedMinus);

    double expectedTimes = testInt * toOpDouble;
    ConsFloat expectedTimesFloat = new ConsFloat(expectedTimes);

    double expectedDivide = toOpDouble / testInt;
    ConsFloat expectedDivideFloat = new ConsFloat(expectedDivide);

    assertEquals(expectedAddFloat, consInt.addConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedMinusFloat, consInt.subConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedTimesFloat, consInt.timesConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(expectedDivideFloat, consInt.divideConsFloat(toOpConsFloat), "ConsFloat don't match. Seed " + seed);

    double differentDouble;
    do {
      differentDouble = rng.nextDouble();
    } while (differentDouble ==  toOpDouble | differentDouble == 0);
    ConsFloat differentConsFloat = new ConsFloat(differentDouble);

    assertNotEquals(consInt.addConsFloat(differentConsFloat), consInt.addConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.subConsFloat(differentConsFloat), consInt.subConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.timesConsFloat(differentConsFloat), consInt.timesConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.divideConsFloat(differentConsFloat), consInt.divideConsFloat(toOpConsFloat), "ConsFloat match. Seed " + seed);

    assertNotEquals(consInt.add(differentConsFloat), consInt.add(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.sub(differentConsFloat), consInt.sub(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.times(differentConsFloat), consInt.times(toOpConsFloat), "ConsFloat match. Seed " + seed);
    assertNotEquals(consInt.divide(differentConsFloat), consInt.divide(toOpConsFloat), "ConsFloat match. Seed " + seed);

    ConsFloat zeroConsFloat = new ConsFloat(0.0);
    assertEquals(new ConsFloat(testInt), consInt.add(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(testInt), consInt.sub(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consInt.times(zeroConsFloat), "ConsFloat don't match. Seed " + seed);

    assertEquals(new ConsFloat(testInt), consInt.addConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(new ConsFloat(-testInt), consInt.subConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
    assertEquals(zeroConsFloat, consInt.timesConsFloat(zeroConsFloat), "ConsFloat don't match. Seed " + seed);
  }
  @RepeatedTest(50)
  void opConsBinaryTest(){
    String toOpBinary = "010011"; //19
    ConsBinary toOpConsBinary = new ConsBinary(toOpBinary);

    ConsInt expectedAddConsInt = new ConsInt(testInt+19);
    ConsInt expectedMinusConsInt = new ConsInt(testInt-19);
    ConsInt expectedTimesConsInt = new ConsInt(testInt*19);
    ConsInt expectedDivideConsInt = new ConsInt(testInt/19);

    assertEquals(expectedAddConsInt, consInt.add(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusConsInt, consInt.sub(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedTimesConsInt, consInt.times(toOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedDivideConsInt, consInt.divide(toOpConsBinary), "ConsInt don't match. Seed " + seed);


    ConsInt expectedAdd = new ConsInt(testInt+19);
    ConsInt expectedMinus = new ConsInt(19-testInt);
    ConsInt expectedTimes = new ConsInt(testInt*19);
    ConsInt expectedDivide = new ConsInt(19/testInt);

    assertEquals(expectedAdd.toConstantBinary(), consInt.addConsBinary(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinus.toConstantBinary(), consInt.subConsBinary(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedTimes.toConstantBinary(), consInt.timesConsBinary(toOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedDivide.toConstantBinary(), consInt.divideConsBinary(toOpConsBinary), "ConsBinary don't match. Seed " + seed);


    ConsBinary zeroConsBinary = new ConsBinary("0");

    assertEquals(new ConsInt(testInt), consInt.add(zeroConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(testInt), consInt.sub(zeroConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(0), consInt.times(zeroConsBinary), "ConsInt don't match. Seed " + seed);

    assertEquals(consInt.toConstantBinary(), consInt.addConsBinary(zeroConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary(consInt.getSType().toSBinary().negate().addOne().toString()), consInt.subConsBinary(zeroConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), consInt.timesConsBinary(zeroConsBinary), "ConsBinary don't match. Seed " + seed);

    ConsBinary minusOneConsBinary = new ConsBinary("1");
    assertEquals(new ConsInt(-testInt), consInt.times(minusOneConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(new ConsInt(-testInt), consInt.divide(minusOneConsBinary), "ConsInt don't match. Seed " + seed);

    assertEquals(new ConsBinary(consInt.getSType().toSBinary().negate().addOne().toString()), consInt.timesConsBinary(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(new ConsBinary("0"), consInt.divideConsBinary(minusOneConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherToOpBinaryString = "0110010";//50
    ConsBinary otherToOpConsBinary = new ConsBinary(otherToOpBinaryString);

    ConsInt expectedOtherAddConsInt = new ConsInt(testInt+50);
    ConsInt expectedOtherMinusConsInt = new ConsInt(testInt-50);
    ConsInt expectedOtherTimesConsInt = new ConsInt(testInt*50);
    ConsInt expectedOtherDivideConsInt = new ConsInt(testInt/50);

    assertEquals(expectedOtherAddConsInt, consInt.add(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherMinusConsInt, consInt.sub(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherTimesConsInt, consInt.times(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedOtherDivideConsInt, consInt.divide(otherToOpConsBinary), "ConsInt don't match. Seed " + seed);

    ConsInt expectedOtherAdd = new ConsInt(testInt+50);
    ConsInt expectedOtherMinus = new ConsInt(50-testInt);
    ConsInt expectedOtherTimes = new ConsInt(testInt*50);
    ConsInt expectedOtherDivide = new ConsInt(50/testInt);

    assertEquals(expectedOtherAdd.toConstantBinary(), consInt.addConsBinary(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherMinus.toConstantBinary(), consInt.subConsBinary(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherTimes.toConstantBinary(), consInt.timesConsBinary(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedOtherDivide.toConstantBinary(), consInt.divideConsBinary(otherToOpConsBinary), "ConsBinary don't match. Seed " + seed);

    String otherMinusBinary = "10010";//-14
    ConsBinary otherMinusConsBinary = new ConsBinary(otherMinusBinary);

    ConsInt expectedMinusAddConsInt = new ConsInt(testInt-14);
    ConsInt expectedMinusMinusConsInt = new ConsInt(testInt+14);
    ConsInt expectedMinusTimesConsInt = new ConsInt(testInt*-14);
    ConsInt expectedMinusDivideConsInt = new ConsInt(testInt/-14);

    assertEquals(expectedMinusAddConsInt, consInt.add(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusMinusConsInt, consInt.sub(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusTimesConsInt, consInt.times(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);
    assertEquals(expectedMinusDivideConsInt, consInt.divide(otherMinusConsBinary), "ConsInt don't match. Seed " + seed);

    ConsInt expectedMinusAdd = new ConsInt(-14+testInt);
    ConsInt expectedMinusMinus = new ConsInt(-14-testInt);
    ConsInt expectedMinusTimes = new ConsInt(testInt*-14);
    ConsInt expectedMinusDivide = new ConsInt(-14/testInt);

    assertEquals(expectedMinusAdd.toConstantBinary(), consInt.addConsBinary(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusMinus.toConstantBinary(), consInt.subConsBinary(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusTimes.toConstantBinary(), consInt.timesConsBinary(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
    assertEquals(expectedMinusDivide.toConstantBinary(), consInt.divideConsBinary(otherMinusConsBinary), "ConsBinary don't match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStringTest(){
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize= rng.nextInt(50);
    String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString sString = new ConsString(testString);

    int toAddInt = rng.nextInt();
    ConsInt toAddConsInt = new ConsInt(toAddInt);
    String expectedString = testString + toAddInt;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, toAddConsInt.addConsStr(sString), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    int differentToAddInt;
    do { differentToAddInt = rng.nextInt();
    } while (differentToAddInt == toAddInt);
    ConsString differentConsString = new ConsString(differentString + differentToAddInt);

    assertNotEquals(differentConsString, toAddConsInt.addConsStr(sString), "ConsString match. Seed " + seed);
  }
  @RepeatedTest(100)
  void nullOpTests(){
    IConstant nullConstant = NullConstant.getInstance();

    assertSame(nullConstant, consInt.add(nullConstant));
    assertSame(nullConstant, consInt.sub(nullConstant));
    assertSame(nullConstant, consInt.times(nullConstant));
    assertSame(nullConstant, consInt.divide(nullConstant));
    assertSame(nullConstant, consInt.and(nullConstant));
    assertSame(nullConstant, consInt.or(nullConstant));

    assertSame(nullConstant, consInt.addNull(nullConstant));
    assertSame(nullConstant, consInt.subNull(nullConstant));
    assertSame(nullConstant, consInt.timesNull(nullConstant));
    assertSame(nullConstant, consInt.divideNull(nullConstant));
    assertSame(nullConstant, consInt.andNull(nullConstant));
    assertSame(nullConstant, consInt.orNull(nullConstant));

    int testOtherInt = rng.nextInt();
    ConsInt otherConsInt = new ConsInt(testOtherInt);

    assertSame(nullConstant, consInt.andConsInt(otherConsInt));
    assertSame(nullConstant, consInt.orConsInt(otherConsInt));

    assertSame(nullConstant, consInt.and(otherConsInt));
    assertSame(nullConstant, consInt.or(otherConsInt));

    double testDouble = rng.nextDouble();
    ConsFloat consFloat = new ConsFloat(testDouble);

    assertSame(nullConstant, consInt.andConsFloat(consFloat));
    assertSame(nullConstant, consInt.orConsFloat(consFloat));

    assertSame(nullConstant, consInt.and(consFloat));
    assertSame(nullConstant, consInt.or(consFloat));

    char[] binaryList = {'0', '1'};
    int binSize = rng.nextInt(32);
    String testBinary = RandomStringUtils.random(binSize, 0, 2, false, true, binaryList, rng);
    ConsBinary consBinary = new ConsBinary(testBinary);

    assertSame(nullConstant, consInt.andConsBinary(consBinary));
    assertSame(nullConstant, consInt.orConsBinary(consBinary));

    assertSame(nullConstant, consInt.and(consBinary));
    assertSame(nullConstant, consInt.or(consBinary));

    boolean testBool = rng.nextBoolean();
    ConsBool consBool = new ConsBool(testBool);

    assertSame(nullConstant, consInt.addConsBool(consBool));
    assertSame(nullConstant, consInt.subConsBool(consBool));
    assertSame(nullConstant, consInt.timesConsBool(consBool));
    assertSame(nullConstant, consInt.divideConsBool(consBool));
    assertSame(nullConstant, consInt.andConsBool(consBool));
    assertSame(nullConstant, consInt.orConsBool(consBool));

    assertSame(nullConstant, consInt.add(consBool));
    assertSame(nullConstant, consInt.sub(consBool));
    assertSame(nullConstant, consInt.times(consBool));
    assertSame(nullConstant, consInt.divide(consBool));
    assertSame(nullConstant, consInt.and(consBool));
    assertSame(nullConstant, consInt.or(consBool));

    int strSize = rng.nextInt(50);
    String otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString otherConsString = new ConsString(otherString);

    assertSame(nullConstant, consInt.subConsStr(otherConsString));
    assertSame(nullConstant, consInt.timesConsStr(otherConsString));
    assertSame(nullConstant, consInt.divideConsStr(otherConsString));
    assertSame(nullConstant, consInt.andConsStr(otherConsString));
    assertSame(nullConstant, consInt.orConsStr(otherConsString));

    assertSame(nullConstant, consInt.add(otherConsString));
    assertSame(nullConstant, consInt.sub(otherConsString));
    assertSame(nullConstant, consInt.times(otherConsString));
    assertSame(nullConstant, consInt.divide(otherConsString));
    assertSame(nullConstant, consInt.and(otherConsString));
    assertSame(nullConstant, consInt.or(otherConsString));

    assertSame(nullConstant, consInt.toConstantBool());
    assertSame(nullConstant, consInt.negateConstant());

  }
}