package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {
    public static final String DB_NAME = "customer.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:file:src\\" + DB_NAME;
    public static final String TABLE_CUSTOMER = "customer";

    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_PASSWORD = "password";



    public static void createCustomerDatabase() {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);

             Statement statement = conn.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS " + Datasource.TABLE_CUSTOMER +
                    " (" + COLUMN_FIRSTNAME + " text, " +
                    COLUMN_LASTNAME + " text, " +
                    COLUMN_EMAIL + " text, " +
                    COLUMN_PHONE + " text, " +
                    COLUMN_PASSWORD + " text" +
                    ")");

        } catch (
                SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCustomer(Statement statement, String firstname, String lastname, String email, String phone, String password) throws SQLException {

        statement.execute("INSERT INTO " + TABLE_CUSTOMER +
                " (" + COLUMN_FIRSTNAME + ", " +
                COLUMN_LASTNAME + ", " +
                COLUMN_EMAIL + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_PASSWORD +
                " ) " +
                "VALUES('" + firstname + "', '" + lastname + "', '" + email + "', '" + phone + "' , '" + password + "')");
    }

}
