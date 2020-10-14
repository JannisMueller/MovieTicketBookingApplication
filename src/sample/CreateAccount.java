package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreateAccount extends Application {
    public void start(Stage stage) {

        Text tHeader = new Text("Enter your user details");
        tHeader.setFont(Font.font("", FontWeight.BOLD, 20));

        // First name
        Label lblFirstName = new Label("First name: ");
        TextField tfFirstName = new TextField();
        tfFirstName.setPromptText("First name");


        // Last name
        Label lblLastName = new Label("Last name");
        TextField tfLastName = new TextField();
        tfLastName.setPromptText("Last name");

        // E-Mail
        Label lblEmail = new Label("E-Mail: ");
        TextField tfEmail = new TextField();
        tfEmail.setPromptText("E-Mail");

        // Phone number
        Label lblPhone = new Label("Phone: ");
        TextField tfPhone = new TextField();
        tfPhone.setPromptText("Phone");

        // Creating and formatting gridpane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(tHeader, 0, 0, 2, 1);

        gridPane.add(lblFirstName, 0, 1);
        gridPane.add(tfFirstName, 1, 1);

        gridPane.add(lblLastName, 0,2);
        gridPane.add(tfLastName,1,2);








        Scene scene2 = new Scene(gridPane, 400, 400);
        stage.setScene(scene2);
        stage.show();


    }

}
