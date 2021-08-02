package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

//TODO: Agregar setter para controller

public class SingleOpPane {
  static Button negateButton;
  static Button toStrButton;
  static Button toIntButton;
  static Button toFloatButton;
  static Button toBinaryButton;
  static Button toBoolButton;

  static GridPane gridPane;

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

    negateButton = new Button("Negate");
    negateButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    negateButton.setOnAction(e -> {
      Controller.insertNegate();
      Controller.update();
    });
    gridPane.add(negateButton, 0, 0);

    toStrButton = new Button("To String");
    toStrButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toStrButton.setOnAction(e -> {
      Controller.insertToString();
      Controller.update();
    });
    gridPane.add(toStrButton, 1, 0);

    toIntButton = new Button("To Int");
    toIntButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toIntButton.setOnAction(e -> {
      Controller.insertToInt();
      Controller.update();
    });
    gridPane.add(toIntButton, 2, 0);

    toFloatButton = new Button("To Float");
    toFloatButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toFloatButton.setOnAction(e -> {
      Controller.insertToFloat();
      Controller.update();
    });
    gridPane.add(toFloatButton, 0, 1);

    toBinaryButton = new Button("To Binary");
    toBinaryButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toBinaryButton.setOnAction(e -> {
      Controller.insertToBinary();
      Controller.update();
    });
    gridPane.add(toBinaryButton, 1, 1);

    toBoolButton = new Button("To Bool");
    toBoolButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toBoolButton.setOnAction(e -> {
      Controller.insertToBool();
      Controller.update();
    });
    gridPane.add(toBoolButton, 2, 1);

    return gridPane;
  }


}
