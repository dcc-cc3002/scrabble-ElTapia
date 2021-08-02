package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Pane with int, binary and float buttons
 */
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

  static Label resultLabel;

  static Stage window;
  static GridPane gridPane;
  static BooleanProperty isDisabled;

  public NumbersPane(){
    window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(250);

    resultLabel = new Label();
    resultLabel.setMaxWidth(200);

    //Create confirm, dot and numbers buttons
    button1 = new Button("1");
    button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button1.setOnAction(e -> {
      result += 1;
      propResult.setValue(result);
    });

    button2 = new Button("2");
    button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button2.setOnAction(e -> {
      result += 2;
      propResult.setValue(result);
    });

    button3 = new Button("3");
    button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button3.setOnAction(e -> {
      result += 3;
      propResult.setValue(result);
    });

    button4 = new Button("4");
    button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button4.setOnAction(e -> {
      result += 4;
      propResult.setValue(result);
    });

    button5 = new Button("5");
    button5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button5.setOnAction(e -> {
      result += 5;
      propResult.setValue(result);
    });

    button6 = new Button("6");
    button6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button6.setOnAction(e -> {
      result += 6;
      propResult.setValue(result);
    });

    button7 = new Button("7");
    button7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button7.setOnAction(e -> {
      result += 7;
      propResult.setValue(result);
    });

    button8 = new Button("8");
    button8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button8.setOnAction(e -> {
      result += 8;
      propResult.setValue(result);
    });

    button9 = new Button("9");
    button9.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button9.setOnAction(e -> {
      result += 9;
      propResult.setValue(result);
    });

    button0 = new Button("0");
    button0.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    button0.setOnAction(e -> {
      result += 0;
      propResult.setValue(result);
    });

    dotButton = new Button(".");

    isDisabled = new SimpleBooleanProperty();
    dotButton.disableProperty().bind(isDisabled);

    dotButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    dotButton.setOnAction(e -> {
      result += ".";
      propResult.setValue(result);
      isDisabled.setValue(true);
    });

    confirmButton = new Button("Confirm");
    confirmButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
  }

  /**
   * Display int buttons on window
   * @return StringProperty
   */
  public StringProperty displayIntBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Int numbers pane");

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
    row1.setPercentHeight(10);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(22.5);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(22.5);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(22.5);
    RowConstraints row5 = new RowConstraints();
    row5.setPercentHeight(22.5);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5);

    //Set label insert int
    Label numberLabel = new Label("Insert Int: ");

    //Set Confirm button action
    confirmButton.setOnAction(e->{
      Controller.insertInt(Integer.parseInt(result));
      Controller.update();
      window.close();
      isDisabled.setValue(false);
    });

    //Add first label
    gridPane.add(numberLabel, 0, 0);

    //Add second label
    gridPane.add(resultLabel, 1, 0, 2, 1);
    resultLabel.textProperty().bind(propResult);

    //Button 1
    gridPane.add(button1, 0, 1);

    //Button 2
    gridPane.add(button2, 1, 1);

    //Button 3
    gridPane.add(button3, 2, 1);

    //Button 4
    gridPane.add(button4, 0, 2);

    //Button 5
    gridPane.add(button5, 1, 2);

    //Button 6
    gridPane.add(button6, 2, 2);

    //Button 7
    gridPane.add(button7, 0, 3);

    //Button 8
    gridPane.add(button8, 1, 3);

    //Button 9
    gridPane.add(button9, 2, 3);

    //Button 0
    gridPane.add(button0, 1, 4);

    //Confirm button
    gridPane.add(confirmButton, 2, 4);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return propResult;
  }

  /**
   * Display binary buttons on window
   * @return StringProperty
   */
  public StringProperty displayBinaryBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Binary numbers pane");

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
    RowConstraints row2 = new RowConstraints();
    row1.setPercentHeight(50);
    row2.setPercentHeight(50);
    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2);

    //Set label insert binary
    Label numberLabel = new Label("Insert Binary: ");

    //Set Confirm button action
    confirmButton.setOnAction(e-> {
          Controller.insertBinary(result);
          Controller.update();
          window.close();
          isDisabled.setValue(false);
        });

    //Add first label
    gridPane.add(numberLabel, 0, 0);

    //Add second label
    gridPane.add(resultLabel, 1, 0, 2, 1);
    resultLabel.textProperty().bind(propResult);

    //Button 1
    gridPane.add(button1, 0, 1);

    //Button 0
    gridPane.add(button0, 1, 1);

    //Confirm button
    gridPane.add(confirmButton, 2, 1);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return propResult;
  }

  /**
   * Display float buttons on window
   * @return StringProperty
   */
  public StringProperty displayFloatBox() {
    result = "";
    propResult = new SimpleStringProperty(this, "result", result);

    window.setTitle("Float numbers pane");

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
    row1.setPercentHeight(10);
    RowConstraints row2 = new RowConstraints();
    row2.setPercentHeight(22.5);
    RowConstraints row3 = new RowConstraints();
    row3.setPercentHeight(22.5);
    RowConstraints row4 = new RowConstraints();
    row4.setPercentHeight(22.5);
    RowConstraints row5 = new RowConstraints();
    row5.setPercentHeight(22.5);

    gridPane.getColumnConstraints().addAll(column1, column2, column3);
    gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5);

    //Set label insert float
    Label numberLabel = new Label("Insert Float: ");

    //Set Confirm button action
    confirmButton.setOnAction(e-> {
          Controller.insertFloat(Double.parseDouble(result));
          Controller.update();
          window.close();
          isDisabled.setValue(false);
        });

    //Add first label
    gridPane.add(numberLabel, 0, 0);

    //Add second label
    gridPane.add(resultLabel, 1, 0, 2, 1);
    resultLabel.textProperty().bind(propResult);

    //Button 1
    gridPane.add(button1, 0, 1);

    //Button 2
    gridPane.add(button2, 1, 1);

    //Button 3
    gridPane.add(button3, 2, 1);

    //Button 4
    gridPane.add(button4, 0, 2);

    //Button 5
    gridPane.add(button5, 1, 2);

    //Button 6
    gridPane.add(button6, 2, 2);

    //Button 7
    gridPane.add(button7, 0, 3);

    //Button 8
    gridPane.add(button8, 1, 3);

    //Button 9
    gridPane.add(button9, 2, 3);

    //Button 0
    gridPane.add(button0, 1, 4);

    //Confirm button
    gridPane.add(confirmButton, 2, 4);

    //Dot button
    gridPane.add(dotButton, 0, 4);

    Scene scene = new Scene(gridPane, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return propResult;
  }
}
