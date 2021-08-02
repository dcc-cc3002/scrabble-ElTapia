package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO: Arreglar cambio de layouts

/**
 * JavaFX App
 */
public class App extends Application {

    static GridPane toShowPane;
    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Scrabble");

        //Create layout
        GridPane completeLayout = new GridPane();

        //Set columns constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(10);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(80);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);

        completeLayout.getColumnConstraints().addAll(column1, column2, column3);

        //Set rows constraints
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);

        completeLayout.getRowConstraints().addAll(row1, row2);

        //ComboBox to choose node to add
        Label label = new Label("Select expression: ");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Dual operations",
            "Single operations",
            "Type"
        );
        comboBox.setPromptText("Dual operations");
        comboBox.setOnAction(e -> {
            selectPane(comboBox);
            completeLayout.getChildren().remove(toShowPane);
            completeLayout.add(toShowPane, 1, 1);
        });

        VBox choicePane = new VBox(10);
        choicePane.setPadding(new Insets(20));
        choicePane.getChildren().addAll(label, comboBox);

        completeLayout.add(choicePane, 1, 0);


        Scene scene = new Scene(completeLayout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static void selectPane(ComboBox<String> comboBox){
        toShowPane = DualOpPane.getGridPane();

        if (comboBox.getValue().equals("Single operations"))
            toShowPane = SingleOpPane.getGridPane();

        if (comboBox.getValue().equals("Type"))
            toShowPane =  TypesPane.getGridPane();
    }



}