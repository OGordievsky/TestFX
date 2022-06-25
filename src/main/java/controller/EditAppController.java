package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.User;

public class EditAppController extends AbstractController {

    public static final String PAGE_URL = "/application/editApp.fxml";

    private User user;
    private String pass = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button edit_Cancel_Button;

    @FXML
    private Button edit_Save_Button;

    @FXML
    private RadioButton radio_Man;

    @FXML
    private RadioButton radio_Woman;

    @FXML
    private ToggleGroup register_gender_radio;

    @FXML
    private TextField signUpLocation;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpPassword;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpTitle;

    @FXML
    private Label title_edit_Page;

    @FXML
    private Label titleUserID;

    @FXML
    void initialize() {
        String index = titleUserID.getText();
        if (!index.isEmpty()) {
            user = userService.getUser(titleUserID.getText());
            title_edit_Page.setText("Edit user");
            initPage();
        } else {
//            signUpLogin.setVisible(true);
//            signUpPassword.setVisible(true);
            title_edit_Page.setText("Create user");
        }

        edit_Save_Button.setOnAction(event -> {
            String login = signUpLogin.getText();
            String password = signUpPassword.getText();
            user.setName(signUpName.getText());
            user.setTitle(signUpTitle.getText());
            user.setLocation(signUpLocation.getText());
            user.setGender(radio_Man.isSelected());
            if (!login.isEmpty() && !password.isEmpty()){
                user.setLogin(login);
                userService.addUser(user, pass);
            }  else {
                userService.updateUser(user);
            }
            showNextPage(edit_Save_Button, AppController.PAGE_URL);
        });

        edit_Cancel_Button.setOnAction(event -> showNextPage(edit_Cancel_Button, AppController.PAGE_URL));
    }

    private void initPage() {
        signUpName.setText(user.getName());
        signUpTitle.setText(user.getTitle());
        signUpLogin.setText(user.getLogin());
        signUpLocation.setText(user.getLocation());
        radio_Man.setSelected(user.isGender());
        radio_Woman.setSelected(!user.isGender());
    }

}
