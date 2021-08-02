package cl.uchile.dcc.scrabble.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Box with the final result
 */
public class ResultBox {
  public static void display(String title, String message){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    //Create label with result
    Label label = new Label("AST result: " + message);

    //Create close button
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> window.close());

    //Add label and button
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, closeButton);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
  }
}
