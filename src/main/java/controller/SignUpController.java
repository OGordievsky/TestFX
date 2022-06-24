package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButtonRegister;

    @FXML
    private CheckBox signUpCheckBoxMan;

    @FXML
    private CheckBox signUpCheckBoxWoman;

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
    }

}