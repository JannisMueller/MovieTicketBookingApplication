package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class OrderConfirmation extends Application {

    @Override
    public void start(Stage stage5) {

        try (Connection conn = DriverManager.getConnection(Main.CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
            ResultSet result= statement.executeQuery("SELECT * FROM " + Main.TABLE_CUSTOMER + " WHERE " + Main.COLUMN_LASTNAME + "='Mueller'");

            String firstName = result.getString(Main.COLUMN_FIRSTNAME);
            String lastName = result.getString(Main.COLUMN_LASTNAME);
            String email = result.getString(Main.COLUMN_EMAIL);
            String phone = result.getString(Main.COLUMN_PHONE);


            Text bookingInformation = new Text("Booking Details");

            bookingInformation.setStyle("-fx-font-weight: bold");
            bookingInformation.setStyle("-fx-font: 20 arial;");

            Label bookingId = new Label("Booking number");
            bookingId.setStyle("-fx-font-weight: bold");
            Text txtBookingId = new Text("T12345");

            Label nameFilm = new Label("Movie");
            nameFilm.setStyle("-fx-font-weight: bold");

            Text txtnameFilm = new Text("Tennet");


            Label date = new Label("Date");
            date.setStyle("-fx-font-weight: bold");
            Text txtDate = new Text("21/10/2020");

            Label numberTickets = new Label("Number of Tickets");
            numberTickets.setStyle("-fx-font-weight: bold");
            Text txtNumberTickets = new Text("2");

            Label seat = new Label("Seat");
            seat.setStyle("-fx-font-weight: bold");
            Text txtSeat = new Text("Row 9, Seat 19-20");

            Label totalPrice = new Label("Total Price");
            seat.setStyle("-fx-font-weight: bold");
            Text txtTotalPrice = new Text("$ 30.00");

            Label nameCustomer = new Label("Name");
            nameCustomer.setStyle("-fx-font-weight: bold");
            Text txtNameCustomer = new Text(firstName + " " + lastName);

            Label emailCustomer = new Label("Email-Address");
            emailCustomer.setStyle("-fx-font-weight: bold");
            Text txtEmailCustomer = new Text(email);

            Text sendAsEmail = new Text("Send tickets to a friend");

            Text info = new Text("Payment successful");
            Text info2 = new Text("Tickets have been send to your E-mail");


            TextField emailFriend = new TextField();
            emailFriend.setPromptText("Email-Address");

            Button bntCloseWindow = new Button("Close");
            Button btnSend = new Button("Send");
            Text emailSent = new Text();

            Image imagePaymentSuccess = new Image("file:src/sample/success2.gif");
            ImageView imageViewPaymentSuccess = new ImageView(imagePaymentSuccess);
            imageViewPaymentSuccess.setPreserveRatio(true);
            imageViewPaymentSuccess.setFitHeight(20);
            imageViewPaymentSuccess.setFitWidth(20);

            Image imageSF = new Image("file:src/sample/logoCompany.jpg");
            ImageView imageViewSF = new ImageView(imageSF);
            imageViewSF.setPreserveRatio(true);
            imageViewSF.setFitHeight(120);
            imageViewSF.setFitWidth(120);


            GridPane gridPane5 = new GridPane();
            gridPane5.setVgap(10);
            gridPane5.setHgap(10);
            gridPane5.setAlignment(Pos.TOP_CENTER);

            gridPane5.add(bookingInformation, 1, 4);

            gridPane5.add(bookingId, 1, 6);
            gridPane5.add(txtBookingId, 2, 6);

            gridPane5.add(nameFilm, 1, 7);
            gridPane5.add(txtnameFilm, 2, 7);

            gridPane5.add(date, 1, 8);
            gridPane5.add(txtDate, 2, 8);

            gridPane5.add(numberTickets, 1, 9);
            gridPane5.add(txtNumberTickets, 2, 9);

            gridPane5.add(seat, 1, 10);
            gridPane5.add(txtSeat, 2, 10);

            gridPane5.add(totalPrice, 1, 11);
            gridPane5.add(txtTotalPrice, 2, 11);

            gridPane5.add(nameCustomer, 1, 12);
            gridPane5.add(txtNameCustomer, 2, 12);

            gridPane5.add(emailCustomer, 1, 13);
            gridPane5.add(txtEmailCustomer, 2, 13);

            gridPane5.add(info, 1, 5);
            gridPane5.add(info2, 1, 16);

            gridPane5.add(bntCloseWindow, 1, 17);

            gridPane5.add(sendAsEmail, 1, 21);
            gridPane5.add(emailFriend, 1, 22);
            gridPane5.add(btnSend, 2, 22);
            gridPane5.add(emailSent, 1, 23);

            gridPane5.add(imageViewPaymentSuccess, 2, 5);

            gridPane5.add(imageViewSF, 3, 1);

            stage5.setTitle("Thank you for Order!");
            Scene scene5 = new Scene(gridPane5, 500, 650);
            stage5.setScene(scene5);
            stage5.show();


            bntCloseWindow.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage5.close();
                }
            });

            btnSend.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    emailSent.setText("Tickets sent to: " + emailFriend.getText());


                }
            });

        } catch (
                SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
