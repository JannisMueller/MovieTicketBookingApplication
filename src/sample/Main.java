package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    public static void main(String[] args) {

        final String DB_NAME = "customer.db";
        final String CONNECTION_STRING = "jdbc:sqlite:file:src\\" + DB_NAME;
        final String TABLE_CUSTOMER = "customer";

        final String COLUMN_FIRSTNAME = "firstname";
        final String COLUMN_LASTNAME = "lastname";
        final String COLUMN_EMAIL = "email";
        final String COLUMN_PHONE = "phone";

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);

             Statement statement = conn.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMER +
                    " (" + COLUMN_FIRSTNAME + " text, " +
                    COLUMN_LASTNAME + " text, " +
                    COLUMN_EMAIL + " text, " +
                    COLUMN_PHONE + " text" +
                    ")");

        } catch(
                SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }

        launch(args);
    }
}
