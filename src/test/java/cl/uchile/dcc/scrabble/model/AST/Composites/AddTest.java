package cl.uchile.dcc.scrabble.model.AST.Composites;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Constants.ConsString;
import cl.uchile.dcc.scrabble.model.Types.SString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AddTest {
  private Add addTest;
  private String testString1;
  private ConsString testConstring1;

  private String testString2;
  private ConsString testConstring2;

  private String testString3;
  private ConsString testConstring3;
  private int seed;
  private Random rng;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);

    int strSize= rng.nextInt(50);
    testString1 = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);;
    testConstring1 = new ConsString(testString1);

    testString2 = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);;
    testConstring2 = new ConsString(testString2);

    testString3 = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);;
    testConstring3 = new ConsString(testString3);
  }

  @RepeatedTest(50)
  void evalTest() {
    addTest = new Add(
                new Add(testConstring1,
                    testConstring2
                ),
                testConstring3);

    ConsString expectedConsString = new ConsString(testString1 + testString2 + testString3);
    assertEquals(expectedConsString, addTest.eval());

    String differentString;

    do {
      differentString = RandomStringUtils.random(rng.nextInt(50), 0,
          Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentString.equals(testString1)|differentString.equals(testString2)|differentString.equals(testString3));

    ConsString differentConsString = new ConsString(differentString);
    assertNotEquals(differentConsString, addTest.eval());
  }
}