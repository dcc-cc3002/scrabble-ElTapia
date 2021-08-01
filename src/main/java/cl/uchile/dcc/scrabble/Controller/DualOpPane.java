package cl.uchile.dcc.scrabble.Controller;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

//TODO: Agregar setter para controller

public class DualOpPane {
  static Button addButton;
  static Button subButton;
  static Button timesButton;
  static Button divideButton;
  static Button orButton;
  static Button andButton;

  static GridPane gridPane;
  static String chosenOp;

  public static GridPane getGridPane(){

    gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setVgap(8);
    gridPane.setHgap(10);

    ColumnConstraints column1 = new ColumnConstraints();
    column1.setPercentWidth(33);
    ColumnConstraints column2 = new ColumnConstraints();
    column2.setPercentWidth(33);
    ColumnConstraints column3 = new ColumnConstraints();
    column3.setPercentWidth(34);

    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(50);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(50);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2);

    addButton = new Button("+");
    addButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    addButton.setOnAction(e -> chosenOp = "Add");
    gridPane.add(addButton, 0, 0);

    subButton = new Button("-");
    subButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    subButton.setOnAction(e -> chosenOp = "Sub");
    gridPane.add(subButton, 1, 0);

    timesButton = new Button("*");
    timesButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    timesButton.setOnAction(e -> chosenOp = "Times");
    gridPane.add(timesButton, 2, 0);

    divideButton = new Button("÷");
    divideButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    divideButton.setOnAction(e -> chosenOp = "Divide");
    gridPane.add(divideButton, 0, 1);

    orButton = new Button("∨");
    orButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    orButton.setOnAction(e -> chosenOp = "Or");
    gridPane.add(orButton, 1, 1);

    andButton = new Button("∧");
    andButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    andButton.setOnAction(e -> chosenOp = "And");
    gridPane.add(andButton, 2, 1);

    return gridPane;
  }

  public static String getChosenOp(){
    return chosenOp;
  }
}
