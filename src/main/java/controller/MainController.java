package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends AbstractController {

    public static final String PAGE_URL = "/application/main.fxml";


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
            String loginInputText = login_field.getText().trim();
            String passwordInputText = password_field.getText();
            if (!loginInputText.isEmpty() && !passwordInputText.isEmpty()) {
                 if (userService.checkLogin(loginInputText, passwordInputText)){
                      showNextPage(loginButton, AppController.PAGE_URL);
                 }
            }
        });
        registrationButton.setOnAction(event -> showNextPage(registrationButton, SignUpController.PAGE_URL));
    }

}