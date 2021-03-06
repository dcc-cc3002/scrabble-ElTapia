package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Pane with string input
 */
public class StringPane {

  static Stage window;
  static VBox layout;

  public static StringProperty displayStringBox() {
    window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(250);

    window.setTitle("String pane");

    layout = new VBox();
    layout.setPadding(new Insets(10));

    //Set label insert string and text field
    Label stringLabel = new Label("Insert string: ");
    TextField input = new TextField();
    input.setMaxWidth(150);

    //Property bound with test field
    StringProperty propResult = new SimpleStringProperty();
    propResult.bind(input.textProperty());

    //Confirm button
    Button confirmButton = new Button("Confirm");
    confirmButton.setOnAction(e-> {
      Controller.insertString(propResult.getValue());
      Controller.update();
      window.close();});

    //Add label and user input
    layout.getChildren().addAll(stringLabel, input, confirmButton);

    Scene scene = new Scene(layout, 100, 100);
    window.setScene(scene);
    window.showAndWait();

    return propResult;
  }

}
