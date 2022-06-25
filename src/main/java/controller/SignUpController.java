package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends AbstractController {

    public static final String PAGE_URL = "/application/signUp.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radio_Man;

    @FXML
    private RadioButton radio_Woman;

    @FXML
    private ToggleGroup register_gender_radio;

    @FXML
    private Button signUpButtonRegister;

    @FXML
    private TextField signUpLocation;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpTitle;

    @FXML
    void initialize() {
        signUpButtonRegister.setOnAction(event -> {
            userService.addUser(new User(
                    signUpName.getText(),
                    signUpTitle.getText(),
                    signUpLogin.getText(),
                    signUpLocation.getText(),
                    radio_Man.isSelected()
                    ), signUpPassword.getText());
            showNextPage(signUpButtonRegister, MainController.PAGE_URL);
        });
    }
}