package cl.uchile.dcc.scrabble.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalculatorBox {

  static String result;

  public static String display(String title) {
    result = "";

    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    //Create numbers buttons
    Button button1 = new Button("1");
    Button button2 = new Button("2");
    Button button3 = new Button("3");
    Button button4 = new Button("4");
    Button button5 = new Button("5");
    Button button6 = new Button("6");
    Button button7 = new Button("7");
    Button button8 = new Button("8");
    Button button9 = new Button("9");

    Button closeButton = new Button("Close");

    button1.setOnAction(e -> result += 1);
    button2.setOnAction(e -> result += 2);
    button3.setOnAction(e -> result += 3);
    button4.setOnAction(e -> result += 4);
    button5.setOnAction(e -> result += 5);
    button6.setOnAction(e -> result += 6);
    button7.setOnAction(e -> result += 7);
    button8.setOnAction(e -> result += 8);
    button9.setOnAction(e -> result += 9);
    closeButton.setOnAction(e->window.close());

    VBox layout = new VBox(10);
    layout.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9, closeButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();

    return result;
  }
}
