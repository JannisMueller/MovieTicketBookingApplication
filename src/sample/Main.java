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
    public static final String DB_NAME = "customer.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:file:src\\" + DB_NAME;
    public static final String TABLE_CUSTOMER = "customer";

    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PASSWORD = "password";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    public static void main(String[] args) {



        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);

             Statement statement = conn.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CUSTOMER +
                    " (" + COLUMN_FIRSTNAME + " text, " +
                    COLUMN_LASTNAME + " text, " +
                    COLUMN_EMAIL + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_PASSWORD + " text" +
                    ")");

            String firstname = "Jannis";
            String lastname = "Muller";
            String email = "mail@.com";
            int phone = 12313;
            String password = "hehe";


            createCustomer(statement, firstname, lastname, email, phone, password);

        } catch(
                SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }

        launch(args);


    }
    private static void createCustomer(Statement statement, String firstname, String lastname, String email, int phone, String password) throws SQLException {

        statement.execute("INSERT INTO " + TABLE_CUSTOMER +
                " (" +  COLUMN_FIRSTNAME + ", " +
                COLUMN_LASTNAME + ", " +
                COLUMN_EMAIL + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_PASSWORD +
                " ) " +
                "VALUES('" + firstname + "', " + lastname + "', " + phone + "', " + email + ", '" + password + "')");
    }


}
