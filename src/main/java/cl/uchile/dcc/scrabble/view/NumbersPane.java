package cl.uchile.dcc.scrabble.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NumbersPane {

  private String result;
  private StringProperty propResult;

  //Init buttons
  static Button button1;
  static Button button2;
  static Button button3;
  static Button button4;
  static Button button5;
  static Button button6;
  static Button button7;
  static Button button8;
  static Button button9;
  static Button button0;
  static Button dotButton;
  static Button confirmButton;

  static Stage window;
  static GridPane gridPane;

  public NumbersPane(){
    window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(250);

    //Create numbers buttons
    button1 = new Button("1");
    button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button1.setOnAction(e -> {
      result += 1;
      propResult.concat(1);
    });

    button2 = new Button("2");
    button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button2.setOnAction(e -> {
      result += 2;
      propResult.concat(2);
    });

    button3 = new Button("3");
    button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button3.setOnAction(e -> {
      result += 3;
      propResult.concat(3);
    });

    button4 = new Button("4");
    button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button4.setOnAction(e -> {
      result += 4;
      propResult.concat(4);
    });

    button5 = new Button("5");
    button5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button5.setOnAction(e -> {
      result += 5;
      propResult.concat(5);
    });

    button6 = new Button("6");
    button6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button6.setOnAction(e -> {
      result += 6;
      propResult.concat(6);
    });

    button7 = new Button("7");
    button7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button7.setOnAction(e -> {
      result += 7;
      propResult.concat(7);
    });

    button8 = new Button("8");
    button8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button8.setOnAction(e -> {
      result += 8;
      propResult.concat(8);
    });

    button9 = new Button("9");
    button9.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button9.setOnAction(e -> {
      result += 9;
      propResult.concat(9);
    });

    button0 = new Button("0");
    button0.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button0.setOnAction(e -> {
      result += 0;
      propResult.concat(0);
    });

    dotButton = new Button(".");

    BooleanProperty isDisabled = new SimpleBooleanProperty();
    dotButton.disableProperty().bind(isDisabled);

    dotButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    dotButton.setOnAction(e -> {
      result += ".";
      propResult.concat(".");
      isDisabled.setValue(true);
    });

    confirmButton = new Button("Confirm");
    confirmButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    confirmButton.setOnAction(e->{
      window.close();
      isDisabled.setValue(false);
    });
  }

  public String displayIntBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Int numbers pane");

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
    row1.setPercentHeight(25);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(25);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(25);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(25);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2, row3, row4);

    //Button 1
    gridPane.add(button1, 0, 0);

    //Button 2
    gridPane.add(button2, 1, 0);

    //Button 3
    gridPane.add(button3, 2, 0);

    //Button 4
    gridPane.add(button4, 0, 1);

    //Button 5
    gridPane.add(button5, 1, 1);

    //Button 6
    gridPane.add(button6, 2, 1);

    //Button 7
    gridPane.add(button7, 0, 2);

    //Button 8
    gridPane.add(button8, 1, 2);

    //Button 9
    gridPane.add(button9, 2, 2);

    //Button 0
    gridPane.add(button0, 1, 3);

    //Confirm button
    gridPane.add(confirmButton, 2, 3);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return result;
  }

  public String displayBinaryBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Binary numbers pane");

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
    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1);

    //Button 1
    gridPane.add(button1, 0, 0);

    //Button 0
    gridPane.add(button0, 1, 0);

    //Confirm button
    gridPane.add(confirmButton, 2, 0);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return result;
  }

  public String displayFloatBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Float numbers pane");

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
    row1.setPercentHeight(25);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(25);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(25);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(25);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2, row3, row4);

    //Button 1
    gridPane.add(button1, 0, 0);

    //Button 2
    gridPane.add(button2, 1, 0);

    //Button 3
    gridPane.add(button3, 2, 0);

    //Button 4
    gridPane.add(button4, 0, 1);

    //Button 5
    gridPane.add(button5, 1, 1);

    //Button 6
    gridPane.add(button6, 2, 1);

    //Button 7
    gridPane.add(button7, 0, 2);

    //Button 8
    gridPane.add(button8, 1, 2);

    //Button 9
    gridPane.add(button9, 2, 2);

    //Button 0
    gridPane.add(button0, 1, 3);

    //Confirm button
    gridPane.add(confirmButton, 2, 3);

    //Dot button
    gridPane.add(dotButton, 0, 3);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return result;
  }
}
