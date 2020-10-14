package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateAccount extends Application {

    public void start(Stage stage) {

        Text tHeader = new Text("Create account");
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

        // Buttons
        Button btnCreateAccount = new Button("Create Account");
        Button btnBack = new Button("Back");


        // Password
        Label lblPassword = new Label("Password: ");
        PasswordField pfPassword = new PasswordField();

        // Creating and formatting gridpane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(tHeader, 0, 0, 2, 1);

        gridPane.add(lblFirstName, 0, 1);
        gridPane.add(tfFirstName, 1, 1);

        gridPane.add(lblLastName, 0, 2);
        gridPane.add(tfLastName, 1, 2);

        gridPane.add(lblEmail, 0, 3);
        gridPane.add(tfEmail, 1, 3);

        gridPane.add(lblPhone, 0, 4);
        gridPane.add(tfPhone, 1, 4);

        gridPane.add(lblPassword, 0, 5);
        gridPane.add(pfPassword, 1, 5);

        gridPane.add(btnCreateAccount, 1, 6);
        gridPane.add(btnBack, 0, 6);



        btnCreateAccount.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                try (Connection conn = DriverManager.getConnection(Main.CONNECTION_STRING);
                     Statement statement = conn.createStatement()) {
                    String firstname = tfFirstName.getText();
                    String lastname = tfLastName.getText();
                    String email = tfEmail.getText();
                    String phone = tfPhone.getText();
                    String password = pfPassword.getText();

                    Main.createCustomer(statement, firstname, lastname, email, phone, password);

                } catch (
                        SQLException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                    e.printStackTrace();
                }


                Alert alertAccountCreated = new Alert(Alert.AlertType.INFORMATION);
                alertAccountCreated.setTitle("Information Dialog");
                alertAccountCreated.setHeaderText("Account created!");
                alertAccountCreated.setContentText("Log in with your details on next page");
                alertAccountCreated.showAndWait();

                LogInPage logInPageStage = new LogInPage();
                logInPageStage.start(stage);

            }
        });

        Scene scene2 = new Scene(gridPane, 400, 400);
        stage.setScene(scene2);
        stage.show();


    }

}
