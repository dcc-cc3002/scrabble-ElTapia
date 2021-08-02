package cl.uchile.dcc.scrabble.Controller;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.model.AST.Composites.DualOp.*;
import cl.uchile.dcc.scrabble.model.AST.Composites.SingleOp.*;
import cl.uchile.dcc.scrabble.model.AST.Constants.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

class ControllerTest {

  @Test
  void evalTest() {
    Add example = new Add(
        new Or(
            new ConsBinary("01000"),
            new ToBinary(
                new Sub(
                    new ConsInt(25),
                    new ConsBinary("0101")
                ))
        )
        ,new ConsFloat(6.9)
    );

    Controller.clear();
    Controller.insertAdd();
    Controller.insertOr();
    Controller.insertBinary("01000");
    Controller.insertToBinary();
    Controller.insertSub();
    Controller.insertInt(25);
    Controller.insertBinary("0101");
    Controller.insertFloat(6.9);
    Controller.update();

    assertEquals("Syntax Error", Controller.eval());

    StringProperty expectedStringProp = new SimpleStringProperty();
    expectedStringProp.setValue(example.toString());

    assertEquals(expectedStringProp.getValue(), Controller.getTree().getValue());

    Controller.clear();

    Add example2 = new Add(
        new ConsFloat(6.9),
        new Or(
            new ConsBinary("01000"),
            new ToBinary(
                new Sub(
                    new ConsInt(25),
                    new ConsBinary("0101")
                ))
        )
    );
    Controller.clear();

    Controller.insertAdd();
    Controller.insertFloat(6.9);
    Controller.insertOr();
    Controller.insertBinary("01000");
    Controller.insertToBinary();
    Controller.insertSub();
    Controller.insertInt(25);
    Controller.insertBinary("0101");
    Controller.update();

    assertEquals("\t34.9", Controller.eval());

    StringProperty expectedStringProp2 = new SimpleStringProperty();
    expectedStringProp2.setValue(example2.toString());

    assertEquals(expectedStringProp2.getValue(), Controller.getTree().getValue());

    Controller.clear();
  }

}