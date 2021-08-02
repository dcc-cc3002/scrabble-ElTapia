package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(60);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(20);

        completeLayout.getColumnConstraints().addAll(column1, column2, column3);

        //Set rows constraints
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(70);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(20);

        completeLayout.getRowConstraints().addAll(row1, row2, row3);

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
            completeLayout.add(toShowPane, 1, 2);
        });

        VBox choicePane = new VBox(10);
        choicePane.setPadding(new Insets(20));
        choicePane.getChildren().addAll(label, comboBox);

        completeLayout.add(choicePane, 1, 0);

        Label resultLabel = new Label();
        resultLabel.setMaxHeight(300);
        resultLabel.textProperty().bind(Controller.getTree());

        completeLayout.add(resultLabel, 1, 1);

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> {
            Controller.clear();
            Controller.update();
        });
        clearButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        completeLayout.add(clearButton, 0, 2);

        Button evalButton = new Button("Eval");
        evalButton.setOnAction(e -> ResultBox.display("Result", Controller.eval()));
        evalButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        completeLayout.add(evalButton, 2, 2);

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