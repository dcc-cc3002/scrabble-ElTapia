package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NullConstantTest {
  IConstant nullConstant = NullConstant.getInstance();
  int seed;
  Random rng;

  @BeforeEach
  void setUp(){
    nullConstant = NullConstant.getInstance();
    seed = new Random().nextInt();
    rng = new Random(seed);
  }

  @Test
  void constructorTest() {
    assertSame(nullConstant, NullConstant.getInstance());
    assertSame(nullConstant, nullConstant.eval());
  }

  @RepeatedTest(50)
  void testToString() {
    String expectedString = "null";
    assertEquals(expectedString, nullConstant.toString());

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(expectedString));
    assertNotEquals(differentString, nullConstant.toString());
  }
  @RepeatedTest(100)
  void nullOpTests(){
    IConstant toOpNullConstant = NullConstant.getInstance();
    IConstant expectedNullConstant = NullConstant.getInstance();

    assertSame(expectedNullConstant, nullConstant.add(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.sub(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.times(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.divide(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.and(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.or(toOpNullConstant));

    assertSame(expectedNullConstant, nullConstant.addNull(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.subNull(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.timesNull(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.divideNull(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.andNull(toOpNullConstant));
    assertSame(expectedNullConstant, nullConstant.orNull(toOpNullConstant));

    int testInt = rng.nextInt();
    ConsInt consInt = new ConsInt(testInt);

    assertSame(expectedNullConstant, nullConstant.addConsInt(consInt));
    assertSame(expectedNullConstant, nullConstant.subConsInt(consInt));
    assertSame(expectedNullConstant, nullConstant.timesConsInt(consInt));
    assertSame(expectedNullConstant, nullConstant.divideConsInt(consInt));
    assertSame(expectedNullConstant, nullConstant.andConsInt(consInt));
    assertSame(expectedNullConstant, nullConstant.orConsInt(consInt));

    assertSame(expectedNullConstant, nullConstant.add(consInt));
    assertSame(expectedNullConstant, nullConstant.sub(consInt));
    assertSame(expectedNullConstant, nullConstant.times(consInt));
    assertSame(expectedNullConstant, nullConstant.divide(consInt));
    assertSame(expectedNullConstant, nullConstant.and(consInt));
    assertSame(expectedNullConstant, nullConstant.or(consInt));

    double testDouble = rng.nextDouble();
    ConsFloat consFloat = new ConsFloat(testDouble);

    assertSame(expectedNullConstant, nullConstant.addConsFloat(consFloat));
    assertSame(expectedNullConstant, nullConstant.subConsFloat(consFloat));
    assertSame(expectedNullConstant, nullConstant.timesConsFloat(consFloat));
    assertSame(expectedNullConstant, nullConstant.divideConsFloat(consFloat));
    assertSame(expectedNullConstant, nullConstant.andConsFloat(consFloat));
    assertSame(expectedNullConstant, nullConstant.orConsFloat(consFloat));

    assertSame(expectedNullConstant, nullConstant.add(consFloat));
    assertSame(expectedNullConstant, nullConstant.sub(consFloat));
    assertSame(expectedNullConstant, nullConstant.times(consFloat));
    assertSame(expectedNullConstant, nullConstant.divide(consFloat));
    assertSame(expectedNullConstant, nullConstant.and(consFloat));
    assertSame(expectedNullConstant, nullConstant.or(consFloat));

    char[] binaryList = {'0', '1'};
    int binSize = rng.nextInt(32);
    String testBinary = RandomStringUtils.random(binSize, 0, 2, false, true, binaryList, rng);
    ConsBinary consBinary = new ConsBinary(testBinary);

    assertSame(expectedNullConstant, nullConstant.addConsBinary(consBinary));
    assertSame(expectedNullConstant, nullConstant.subConsBinary(consBinary));
    assertSame(expectedNullConstant, nullConstant.timesConsBinary(consBinary));
    assertSame(expectedNullConstant, nullConstant.divideConsBinary(consBinary));
    assertSame(expectedNullConstant, nullConstant.andConsBinary(consBinary));
    assertSame(expectedNullConstant, nullConstant.orConsBinary(consBinary));

    assertSame(expectedNullConstant, nullConstant.add(consBinary));
    assertSame(expectedNullConstant, nullConstant.sub(consBinary));
    assertSame(expectedNullConstant, nullConstant.times(consBinary));
    assertSame(expectedNullConstant, nullConstant.divide(consBinary));
    assertSame(expectedNullConstant, nullConstant.and(consBinary));
    assertSame(expectedNullConstant, nullConstant.or(consBinary));

    boolean testBool = rng.nextBoolean();
    ConsBool consBool = new ConsBool(testBool);

    assertSame(expectedNullConstant, nullConstant.addConsBool(consBool));
    assertSame(expectedNullConstant, nullConstant.subConsBool(consBool));
    assertSame(expectedNullConstant, nullConstant.timesConsBool(consBool));
    assertSame(expectedNullConstant, nullConstant.divideConsBool(consBool));
    assertSame(expectedNullConstant, nullConstant.andConsBool(consBool));
    assertSame(expectedNullConstant, nullConstant.orConsBool(consBool));

    assertSame(expectedNullConstant, nullConstant.add(consBool));
    assertSame(expectedNullConstant, nullConstant.sub(consBool));
    assertSame(expectedNullConstant, nullConstant.times(consBool));
    assertSame(expectedNullConstant, nullConstant.divide(consBool));
    assertSame(expectedNullConstant, nullConstant.and(consBool));
    assertSame(expectedNullConstant, nullConstant.or(consBool));

    int strSize= rng.nextInt(50);
    String otherString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString otherConsString = new ConsString(otherString);

    assertSame(expectedNullConstant, nullConstant.addConsStr(otherConsString));
    assertSame(expectedNullConstant, nullConstant.subConsStr(otherConsString));
    assertSame(expectedNullConstant, nullConstant.timesConsStr(otherConsString));
    assertSame(expectedNullConstant, nullConstant.divideConsStr(otherConsString));
    assertSame(expectedNullConstant, nullConstant.andConsStr(otherConsString));
    assertSame(expectedNullConstant, nullConstant.orConsStr(otherConsString));

    assertSame(expectedNullConstant, nullConstant.add(otherConsString));
    assertSame(expectedNullConstant, nullConstant.sub(otherConsString));
    assertSame(expectedNullConstant, nullConstant.times(otherConsString));
    assertSame(expectedNullConstant, nullConstant.divide(otherConsString));
    assertSame(expectedNullConstant, nullConstant.and(otherConsString));
    assertSame(expectedNullConstant, nullConstant.or(otherConsString));

    assertSame(expectedNullConstant, nullConstant.toConstantStr());
    assertSame(expectedNullConstant, nullConstant.toConstantInt());
    assertSame(expectedNullConstant, nullConstant.toConstantFloat());
    assertSame(expectedNullConstant, nullConstant.toConstantBinary());
    assertSame(expectedNullConstant, nullConstant.toConstantBool());
    assertSame(expectedNullConstant, nullConstant.negateConstant());

  }
}