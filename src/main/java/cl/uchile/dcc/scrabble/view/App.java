package cl.uchile.dcc.scrabble.view;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    StringProperty calcResult;
    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Display panes");

        NumbersPane numberPane = new NumbersPane();

        Button intButton = new Button("Display int pane");
        intButton.setOnAction(e -> {
            calcResult = numberPane.displayIntBox();
            System.out.println(calcResult.getValue());
        });

        Button binaryButton = new Button("Display binary pane");
        binaryButton.setOnAction(e -> {
            calcResult = numberPane.displayBinaryBox();
            System.out.println(calcResult.getValue());
        });

        Button floatButton = new Button("Display float pane");
        floatButton.setOnAction(e -> {
            calcResult = numberPane.displayFloatBox();
            System.out.println(calcResult.getValue());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(intButton, binaryButton, floatButton);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }



}