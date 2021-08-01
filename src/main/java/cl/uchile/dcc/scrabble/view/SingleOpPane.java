package cl.uchile.dcc.scrabble.view;

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

    negateButton = new Button("Negate");
    negateButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    negateButton.setOnAction(e -> chosenOp = "Negate");
    gridPane.add(negateButton, 0, 0);

    toStrButton = new Button("To String");
    toStrButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toStrButton.setOnAction(e -> chosenOp = "ToString");
    gridPane.add(toStrButton, 1, 0);

    toIntButton = new Button("To Int");
    toIntButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toIntButton.setOnAction(e -> chosenOp = "ToInt");
    gridPane.add(toIntButton, 2, 0);

    toFloatButton = new Button("To Float");
    toFloatButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toFloatButton.setOnAction(e -> chosenOp = "ToFloat");
    gridPane.add(toFloatButton, 0, 1);

    toBinaryButton = new Button("To Binary");
    toBinaryButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toBinaryButton.setOnAction(e -> chosenOp = "ToBinary");
    gridPane.add(toBinaryButton, 1, 1);

    toBoolButton = new Button("To Bool");
    toBoolButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    toBoolButton.setOnAction(e -> chosenOp = "ToBool");
    gridPane.add(toBoolButton, 2, 1);

    return gridPane;
  }

  public static String getChosenOp(){
    return chosenOp;
  }

}
