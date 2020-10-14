package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectMovie extends Application {

    public void start(Stage stage) {

        // Header text
        Text tHeader = new Text("Book tickets");
        tHeader.setFont(Font.font("", FontWeight.BOLD, 14));

        // Seperator
        Separator separator1 = new Separator();

        // Select movie
        Text tMovie = new Text("Select movie: ");
        ObservableList<String> optionsMovies =
                FXCollections.observableArrayList(
                        "Batman",
                        "Goodfellas",
                        "Beck"
                );
        ComboBox cbMovie = new ComboBox(optionsMovies);
        cbMovie.setPromptText("Select Movie");

        // Select seats
        Text tSeats = new Text("Number of tickets: ");
        ObservableList<String> optionsTickets =
                FXCollections.observableArrayList(
                        "1",
                        "2",
                        "3",
                        "4",
                        "5"
                );
        ComboBox cbTickets = new ComboBox(optionsTickets);
        cbTickets.setPromptText("Select tickets");

        // Next button
        Button btNext = new Button("Next");

        btNext.setOnAction(actionEvent -> {

            UserDetails userDetailsStage = new UserDetails();

            userDetailsStage.start(stage);


        });

        // Creating gridpane
        GridPane gridPane1 = new GridPane();

        // Formatting gridpane
        gridPane1.setMinSize(300,400);
        gridPane1.setPadding(new Insets(10,10,10,10));
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.setAlignment(Pos.CENTER);

        // Creating grid-pane layout
        gridPane1.add(tHeader,0,0);
        gridPane1.add(separator1,0,1);
        gridPane1.add(tMovie,0,2);
        gridPane1.add(cbMovie,1,2);
        gridPane1.add(tSeats, 0,3);
        gridPane1.add(cbTickets,1,3);
        gridPane1.add(btNext,1,4);

        // Creating stage etc
        Scene scene1 = new Scene(gridPane1);
        stage.setScene(scene1);
        stage.show();
    }
}
