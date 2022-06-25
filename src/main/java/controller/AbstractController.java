package controller;

import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import service.UserService;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractController {
    protected UserService userService = new UserService();

    public void showNextPage(Button button, String pageUrl, Map<String, String>... params) {
        button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        for (Map<String, String> paramPair : params){
            loader.getNamespace().putAll(paramPair);
        }
        loader.setLocation(getClass().getResource(pageUrl));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.setResizable(false);
        stage.show();
    }
}
