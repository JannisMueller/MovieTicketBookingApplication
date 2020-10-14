package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class UserDetails extends Application {
    public void start(Stage stage) {

        Text hText = new Text("Enter your user details");

        // First name
        Text tFirstName = new Text("First name: ");
        TextField tfFirstName = new TextField("First Name");

        // Last name
        Text tLastName = new Text("Last name");
        TextField tfLastName = new TextField("Last name");

        // E-Mail
        Text tEmail = new Text("E-Mail: ");
        TextField tfEmail = new TextField("E-Mail");

        // Phone number

        //


        GridPane gridPane2 = new GridPane();

        gridPane2.add(hText,0,0);




        Scene scene2 = new Scene(gridPane2);
        stage.setScene(scene2);
        stage.show();


    }

}
