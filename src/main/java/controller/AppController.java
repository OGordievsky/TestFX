package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.User;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class AppController extends AbstractController {

    public static final String PAGE_URL = "/application/app.fxml";

    public User user;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> appTable;

    @FXML
    private TableColumn<User, String> appTable_gender;

    @FXML
    private TableColumn<User, Long> appTable_id;

    @FXML
    private TableColumn<User, String> appTable_location;

    @FXML
    private TableColumn<User, String> appTable_login;

    @FXML
    private TableColumn<User, String> appTable_name;

    @FXML
    private TableColumn<User, String> appTable_title;

    @FXML
    private Button app_create;

    @FXML
    private Button app_delete;

    @FXML
    private Button app_edit;

    @FXML
    private ImageView imageField;

    @FXML
    private Button logOutButton;

    @FXML
    void initialize() {
        initTable();

        logOutButton.setOnAction(event -> showNextPage(logOutButton, MainController.PAGE_URL));

        app_edit.setOnAction(event -> {
            User user = appTable.getFocusModel().getFocusedItem();
            Map<String, String> idNameSpace = new HashMap<>();
            idNameSpace.put("LabelId", String.valueOf(user.getId()));
            showNextPage(app_edit, EditAppController.PAGE_URL, idNameSpace);
        });

        app_create.setOnAction(event -> {
            Map<String, String> idNameSpace = new HashMap<>();
            idNameSpace.put("LabelId", "-1");
            showNextPage(app_create, EditAppController.PAGE_URL, idNameSpace);
        });

        app_delete.setOnAction(event -> {
            User user = appTable.getFocusModel().getFocusedItem();
            userService.delete(user);
            initTable();
        });
    }

    private void initTable() {
        ObservableList<User> usersData = FXCollections.observableArrayList();
        List<User> userList = userService.getAll();
        usersData.addAll(userList);
        appTable_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        appTable_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        appTable_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        appTable_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        appTable_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        appTable_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        appTable.setItems(usersData);
    }
}