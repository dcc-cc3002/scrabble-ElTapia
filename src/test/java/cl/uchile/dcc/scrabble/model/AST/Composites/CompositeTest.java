package cl.uchile.dcc.scrabble.model.AST.Composites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import cl.uchile.dcc.scrabble.model.AST.Wrappers.IConstant;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;

public class CompositeTest {
  protected int strSize;
  protected String testString;
  protected ConsString testConsString;

  protected int testInt;
  protected ConsInt testConsInt;

  protected float testFloat;
  protected ConsFloat testConsFloat;

  protected ConsBool testTrueConsBool;
  protected ConsBool testFalseConsBool;

  protected String testBinary1;
  protected String testBinary2;
  protected String testBinary3;
  protected ConsBinary[] testConsBinary;

  protected int seed;
  protected Random rng;

  protected IConstant nullConstant;

  @BeforeEach
  protected void setUp() {
    seed = new Random().nextInt();
    rng = new Random(seed);

    strSize= rng.nextInt(50);
    testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);;
    testConsString = new ConsString(testString);

    testInt = rng.nextInt();
    testConsInt = new ConsInt(testInt);

    testFloat = rng.nextFloat();
    testConsFloat = new ConsFloat(testFloat);

    testBinary1 = "001101011";
    testBinary2 = "110100";
    testBinary3 = "01";
    testConsBinary = new ConsBinary[]{new ConsBinary(testBinary1),
        new ConsBinary(testBinary2), new ConsBinary(testBinary3)};

    testTrueConsBool = new ConsBool(true);
    testFalseConsBool = new ConsBool(false);

    nullConstant = NullConstant.getInstance();
  }
}