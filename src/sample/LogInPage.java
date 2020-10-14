package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInPage extends Application {

    @Override
    public void start(Stage stage2) {

        Text txtLogin = new Text("Sign In");
        txtLogin.setStyle("-fx-font-weight: bold");
        txtLogin.setStyle("-fx-font: 20 arial;");

        Text notACustomer = new Text("Not a customer yet? Register now!");

        TextField tfEmail = new TextField();
        tfEmail.setPromptText("E-Mail");

        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        Button bntLogIn = new Button("Sign In");
        Button bntCreateAccount = new Button("Create Account");

        Image imageSF = new Image("file:src/sample/logoCompany.jpg");
        ImageView imageViewSF = new ImageView(imageSF);
        imageViewSF.setPreserveRatio(true);
        imageViewSF.setFitHeight(120);
        imageViewSF.setFitWidth(120);


        GridPane gridPane2 = new GridPane();
        gridPane2.setVgap(5);
        gridPane2.setHgap(5);
        gridPane2.setAlignment(Pos.TOP_CENTER);

        gridPane2.add(txtLogin,1,3);
        gridPane2.add(imageViewSF,3,1);
        gridPane2.add(tfEmail,1,4);
        gridPane2.add(tfPassword,2,4);
        gridPane2.add(bntLogIn,1,6);
        gridPane2.add(notACustomer,1, 12,2,1);
        gridPane2.add(bntCreateAccount,1,13);

        stage2.setTitle("Log-in");
        Scene scene2 = new Scene(gridPane2, 400, 400);
        stage2.setScene(scene2);
        stage2.show();

        bntCreateAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                stage2.close();
                CreateAccount stage = new CreateAccount();
                stage.start(stage2);
            }
        });

        bntLogIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {



            }
        });





    }
}
