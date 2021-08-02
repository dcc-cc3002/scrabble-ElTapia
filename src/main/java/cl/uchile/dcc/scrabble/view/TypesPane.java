package cl.uchile.dcc.scrabble.view;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


/**
 * Pane with all types panes
 */
public class TypesPane {

  static Button intButton;
  static Button stringButton;
  static Button floatButton;
  static Button binaryButton;
  static Button boolButton;

  static GridPane gridPane;
  static String chosenType;

  static StringProperty input;

  public static GridPane getGridPane(){

    NumbersPane numberPane = new NumbersPane();

    gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setVgap(8);
    gridPane.setHgap(10);

    //Set columns constraints
    ColumnConstraints column1 = new ColumnConstraints();
    column1.setPercentWidth(33);
    ColumnConstraints column2 = new ColumnConstraints();
    column2.setPercentWidth(33);
    ColumnConstraints column3 = new ColumnConstraints();
    column3.setPercentWidth(34);

    //Set rows constraints
    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(50);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(50);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2);

    //Init int button to select int pane
    intButton = new Button("Int");
    intButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    intButton.setOnAction(e -> {
      chosenType = "Int";
      input = numberPane.displayIntBox();
    });
    gridPane.add(intButton, 0, 0);


    //Init string button to select string pane
    stringButton = new Button("String");
    stringButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    stringButton.setOnAction(e -> {
      chosenType = "String";
      input = StringPane.displayStringBox();
    });
    gridPane.add(stringButton, 1, 0);


    //Init float button to select float pane
    floatButton = new Button("Float");
    floatButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    floatButton.setOnAction(e -> {
      chosenType = "Float";
      input = numberPane.displayFloatBox();
    });
    gridPane.add(floatButton, 2, 0);


    //Init binary button to select binary pane
    binaryButton = new Button("Binary");
    binaryButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    binaryButton.setOnAction(e -> {
      chosenType = "Binary";
      input = numberPane.displayBinaryBox();
    });
    gridPane.add(binaryButton, 0, 1);


    //Init bool button to select bool pane
    boolButton = new Button("Bool");
    boolButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    boolButton.setOnAction(e -> {
      chosenType = "Bool";
      input = BoolPane.displayBoolBox();
    });
    gridPane.add(boolButton, 2, 1);

    return gridPane;
  }
}
