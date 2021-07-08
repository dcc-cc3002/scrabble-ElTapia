package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ConsStringTest {

  private ConsString consString;
  private String testString;
  private int seed;
  private Random rng;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize= rng.nextInt(50);
    testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    consString = new ConsString(testString);
  }

  @RepeatedTest(50)
  void constructorTest(){
    ConsString expectedConsString = new ConsString(testString);
    SString expectedSString = new SString(testString);

    assertEquals(expectedConsString, consString, "ConsString don't match. Seed " + seed);
    assertEquals(expectedConsString.hashCode(), consString.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(expectedSString, consString.getSType());
    assertEquals(consString, consString.eval());
    assertNotEquals(consString, testString, "Objects match. Seed " + seed);

    String differentString;

    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));


    ConsString differentConsString = new ConsString(differentString);
    SString differentSString = new SString(differentString);
    assertNotEquals(differentConsString, consString, "ConsString match. Seed " + seed);
    assertNotEquals(differentSString, consString.getSType());
    assertNotEquals(differentConsString, consString.eval());

    assertEquals(testString, consString.toString(), "ConsString don't match. Seed " + seed);
    assertNotEquals(differentString, consString.toString(), "ConsString match. Seed " + seed);
  }

  @RepeatedTest(50)
  void addConsStrTest() {
    String toAddString = RandomStringUtils.random(rng.nextInt(50), 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString toAddConsString = new ConsString(toAddString);

    String expectedString = toAddString + testString;
    ConsString expectedConsString = new ConsString(expectedString);

    assertEquals(expectedConsString, consString.addConsStr(toAddConsString), "ConsString don't match. Seed " + seed);

    String expectedAddString = testString + toAddString;
    ConsString expectedAddConsString = new ConsString(expectedAddString);

    assertEquals(expectedAddConsString, consString.add(toAddConsString), "ConsString don't match. Seed " + seed);

    String differentString;
    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString));

    String differentToAddString;
    do {
      differentToAddString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentToAddString.equals(testString));

    ConsString differentConsString = new ConsString(differentToAddString + differentString);

    assertNotEquals(differentConsString, consString.addConsStr(toAddConsString), "ConsString match. Seed " + seed);
  }

}