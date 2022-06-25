package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            System.out.println("Вы нажали на кнопку войти");
        });

        registrationButton.setOnAction(event -> {
            registrationButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/signUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


//        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'main.fxml'.";
//        assert RegistrationButton != null : "fx:id=\"RegistrationButton\" was not injected: check your FXML file 'main.fxml'.";
//        assert login_field != null : "fx:id=\"login_field\" was not injected: check your FXML file 'main.fxml'.";
//        assert password_field != null : "fx:id=\"password_field\" was not injected: check your FXML file 'main.fxml'.";
    }
}