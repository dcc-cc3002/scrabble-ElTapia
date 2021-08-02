package cl.uchile.dcc.scrabble.view;


import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


/**
 * Pane with dual operations
 */
public class DualOpPane {
  static Button addButton;
  static Button subButton;
  static Button timesButton;
  static Button divideButton;
  static Button orButton;
  static Button andButton;

  static GridPane gridPane;

  public static GridPane getGridPane(){

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

    //Init add button
    addButton = new Button("+");
    addButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    addButton.setOnAction(e -> {
      Controller.insertAdd();
      Controller.update();
    });
    gridPane.add(addButton, 0, 0);

    //Init sub button
    subButton = new Button("-");
    subButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    subButton.setOnAction(e -> {
      Controller.insertSub();
      Controller.update();
    });
    gridPane.add(subButton, 1, 0);

    //Init times button
    timesButton = new Button("*");
    timesButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    timesButton.setOnAction(e -> {
      Controller.insertTimes();
      Controller.update();
    });
    gridPane.add(timesButton, 2, 0);

    //Init divide button
    divideButton = new Button("÷");
    divideButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    divideButton.setOnAction(e -> {
      Controller.insertDivide();
      Controller.update();
    });
    gridPane.add(divideButton, 0, 1);

    //Init or button
    orButton = new Button("∨");
    orButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    orButton.setOnAction(e -> {
      Controller.insertOr();
      Controller.update();
    });
    gridPane.add(orButton, 1, 1);

    //Init and button
    andButton = new Button("∧");
    andButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    andButton.setOnAction(e -> {
      Controller.insertAnd();
      Controller.update();
    });
    gridPane.add(andButton, 2, 1);

    return gridPane;
  }
}
