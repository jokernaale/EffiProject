package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import DataBase.DBConnection;
import DataBaseController.UserController;
import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Profile;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button authSignButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {

        authSignButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();

            if(!loginText.equals("") &&!passwordText.equals("")){
                loginUser(loginText,passwordText);
            }
            else{
                System.out.println("Login and Password is Empty");//TODO: Сделать всплывающее окно
            }
        });
        loginSignUpButton.setOnAction(event -> {
            openNewScene("/sample/signUp.fxml");

    });
    }
    private void loginUser(String loginText, String passwordText) {
        UserController userController = new UserController();
        Profile profile = new Profile();
        profile.setUserName(loginText);
        profile.setPassword(passwordText);
        ResultSet result =userController.getProfile(profile);

        int counter = 0;
        try {
            while (result.next()) {
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(counter>=1){
            openNewScene("/sample/app.fxml");
        }
        else {
            Shake profileLoginAnim = new Shake(login_field);
            Shake profilePassAnim = new Shake(password_field);
            profileLoginAnim.playAnim();
            profilePassAnim.playAnim();
        }

    }
    public void openNewScene(String window) {

            loginSignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }


}


