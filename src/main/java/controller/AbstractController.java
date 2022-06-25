package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import service.UserService;

import java.io.IOException;

public abstract class AbstractController {
    public UserService userService = new UserService();

    public void showNextPage(Button button, String pageUrl) {
        button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pageUrl));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
