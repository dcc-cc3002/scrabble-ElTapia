package cl.uchile.dcc.scrabble.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    String calcResult;
    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Display calculator");

        Button calculatorButton = new Button("Display Calculator");
        calculatorButton.setOnAction(e -> {
            calcResult = CalculatorBox.display("Hi, I am a calculator");
            System.out.println(calcResult);
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(calculatorButton);

        Scene scene = new Scene(stackPane, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}