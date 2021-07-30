package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.Controller.DualOpPane;
import cl.uchile.dcc.scrabble.Controller.NumbersPane;
import cl.uchile.dcc.scrabble.Controller.SingleOpPane;
import cl.uchile.dcc.scrabble.Controller.TypesPane;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Display panes");


        GridPane completeLayout = new GridPane();

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(10);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(80);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);

        completeLayout.getColumnConstraints().addAll(column1, column2, column3);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);
        completeLayout.getRowConstraints().addAll(row1, row2);

        GridPane dualOp = DualOpPane.getGridPane();
        GridPane singleOp = SingleOpPane.getGridPane();
        GridPane types = TypesPane.getGridPane();

        completeLayout.add(types, 1, 1);

        Scene scene = new Scene(completeLayout, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }



}