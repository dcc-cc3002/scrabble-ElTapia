package cl.uchile.dcc.scrabble.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
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

public class BoolPane {

  static Stage window;
  static GridPane layout;
  static String result;

  public static StringProperty displayBoolBox() {
    result = "";
    StringProperty propResult = new SimpleStringProperty();

    window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(250);

    window.setTitle("Bool pane");

    layout = new GridPane();
    layout.setPadding(new Insets(10));
    layout.setVgap(8);
    layout.setHgap(10);

    ColumnConstraints column1 = new ColumnConstraints();
    column1.setPercentWidth(33);
    ColumnConstraints column2 = new ColumnConstraints();
    column2.setPercentWidth(33);
    ColumnConstraints column3 = new ColumnConstraints();
    column3.setPercentWidth(34);

    RowConstraints row1 = new RowConstraints();
    RowConstraints row2 = new RowConstraints();
    row1.setPercentHeight(50);
    row2.setPercentHeight(50);
    layout.getColumnConstraints().addAll(column1, column2, column3);
    layout.getRowConstraints().addAll(row1, row2);


    Label boolLabel = new Label("Insert Bool: ");
    Label resultLabel = new Label();
    resultLabel.setMaxWidth(200);

    Button trueButton = new Button("True");
    trueButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    trueButton.setOnAction(e -> {
      result = "True";
      propResult.setValue(result);
    });

    Button falseButton = new Button("False");
    falseButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    falseButton.setOnAction(e -> {
      result = "False";
      propResult.setValue(result);
    });

    Button confirmButton = new Button("Confirm");
    confirmButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    confirmButton.setOnAction(e-> window.close());

    //Add first label
    layout.add(boolLabel, 0, 0);

    //Add second label
    layout.add(resultLabel, 1, 0, 2, 1);
    resultLabel.textProperty().bind(propResult);

    //Button 1
    layout.add(trueButton, 0, 1);

    //Button 0
    layout.add(falseButton, 1, 1);

    //Confirm button
    layout.add(confirmButton, 2, 1);

    Scene scene = new Scene(layout, 400, 400);
    window.setScene(scene);
    window.showAndWait();

    return propResult;
  }

}