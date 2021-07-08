package cl.uchile.dcc.scrabble.model.AST.Constants;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.Types.SBool;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ConsBoolTest {
  private ConsBool consBool;
  private ConsBool negateTestConsBool;
  private boolean boolTest;
  private int seed;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    Random rng = new Random(seed);
    boolTest = rng.nextBoolean();

    consBool = new ConsBool(boolTest);
    negateTestConsBool = new ConsBool(!boolTest);
  }

  @RepeatedTest(10)
  void constructorTest(){

    var expectedConsBool = new ConsBool(boolTest);
    var negateExpectedConsBool = new ConsBool(!boolTest);

    assertEquals(expectedConsBool, consBool, "ConsBool don't match. Seed " + seed);
    assertEquals(negateExpectedConsBool, negateTestConsBool, "ConsBool don't match. Seed " + seed);
    assertEquals(consBool, consBool.eval(), "ConsBool don't match. Seed " + seed);
    assertEquals(negateTestConsBool, negateTestConsBool.eval(), "ConsBool don't match. Seed " + seed);
    assertNotEquals(consBool, boolTest, "Objects match. Seed " + seed);
    assertNotEquals(negateTestConsBool, !boolTest, "Objects match. Seed " + seed);

    assertEquals(expectedConsBool.hashCode(), consBool.hashCode(), "Hashcode don't match. Seed " + seed);
    assertEquals(negateExpectedConsBool.hashCode(), negateTestConsBool.hashCode(), "Hashcode don't match. Seed " + seed);

    assertEquals(new SBool(!boolTest), negateTestConsBool.getSType(), "SBool don't match. Seed " + seed);
    assertEquals(new SBool(boolTest), consBool.getSType(), "SBool don't match. Seed " + seed);

    assertNotEquals(expectedConsBool, negateTestConsBool, "ConsBool match. Seed " + seed);
    assertNotEquals(negateExpectedConsBool, consBool, "ConsBool match. Seed " + seed);
    assertNotEquals(expectedConsBool, negateTestConsBool.eval(), "ConsBool match. Seed " + seed);
    assertNotEquals(negateExpectedConsBool, consBool.eval(), "ConsBool match. Seed " + seed);
    assertNotEquals(new SBool(!boolTest), consBool.getSType(), "ConsBool match. Seed " + seed);
    assertNotEquals(new SBool(boolTest), negateTestConsBool.getSType(), "SBool match. Seed " + seed);
  }

  @RepeatedTest(10)
  void toStringTest() {
    String expectedString = String.valueOf(boolTest);
    String negateExpectedString = String.valueOf(!boolTest);

    assertEquals(expectedString, consBool.toString(), "String don't match. Seed " + seed);
    assertEquals(negateExpectedString, negateTestConsBool.toString(),
        "String don't match. Seed " + seed);

    assertNotEquals(expectedString, negateTestConsBool.toString(), "String match. Seed " + seed);
    assertNotEquals(negateExpectedString, consBool.toString(), "String match. Seed " + seed);
  }
  @RepeatedTest(10)
  void negateConstantTest(){
    assertEquals(negateTestConsBool, consBool.negateConstant(), "ConsBool don't match. Seed " + seed);
    assertNotEquals(consBool, consBool.negateConstant(), "ConsBool match. Seed " + seed);
  }


  @RepeatedTest(10)
  void addConsStrTest() {
    seed = new Random().nextInt();
    Random rng = new Random(seed);
    int strSize= rng.nextInt(50);
    String testString = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT,
        true, true, null, rng);
    ConsString consString = new ConsString(testString);

    boolean toAddBool = rng.nextBoolean();

    ConsBool toAddSBool = new ConsBool(toAddBool);
    ConsBool negateToAddSBool = new ConsBool(!toAddBool);

    String expectedStringAddSBool = testString + toAddBool;
    String negateExpectedStringAddSBool = testString + !toAddBool;

    ConsString expectedAddSBool = new ConsString(expectedStringAddSBool);
    ConsString negateExpectedAddSBool = new ConsString(negateExpectedStringAddSBool);

    assertEquals(expectedAddSBool, toAddSBool.addConsStr(consString), "SString don't match. Seed " + seed);
    assertEquals(negateExpectedAddSBool, negateToAddSBool.addConsStr(consString), "SString don't match. Seed " + seed);

    assertNotEquals(negateExpectedAddSBool, toAddSBool.addConsStr(consString), "SString match. Seed " + seed);
    assertNotEquals(expectedAddSBool, negateToAddSBool.addConsStr(consString), "SString match. Seed " + seed);
  }
  @Test
  void orAndConsBoolTest(){
    ConsBool firstConsBool = new ConsBool(true);
    ConsBool toOperateConsBool = new ConsBool(false);
    ConsBool expectedTrueConsBool = new ConsBool(true);
    ConsBool expectedFalseConsBool = new ConsBool(false);

    assertEquals(expectedTrueConsBool, firstConsBool.orConsBool(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.orConsBool(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedTrueConsBool, firstConsBool.orConsBool(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedTrueConsBool, toOperateConsBool.orConsBool(firstConsBool), "ConsBool don't match. Seed " + seed);

    assertEquals(expectedTrueConsBool, firstConsBool.or(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.or(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedTrueConsBool, firstConsBool.or(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedTrueConsBool, toOperateConsBool.or(firstConsBool), "ConsBool don't match. Seed " + seed);

    assertEquals(expectedTrueConsBool, firstConsBool.andConsBool(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, firstConsBool.andConsBool(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.andConsBool(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.andConsBool(toOperateConsBool), "ConsBool don't match. Seed " + seed);

    assertEquals(expectedTrueConsBool, firstConsBool.and(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, firstConsBool.and(toOperateConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.and(firstConsBool), "ConsBool don't match. Seed " + seed);
    assertEquals(expectedFalseConsBool, toOperateConsBool.and(toOperateConsBool), "ConsBool don't match. Seed " + seed);
  }
}