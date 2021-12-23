package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DataBase.DBConnection;
import DataBaseController.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Profile;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane main_field;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button authSignButton;

    @FXML
    private TextField ID_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private TextField firstName_field;

    @FXML
    private DatePicker birthday_datePicker;

    @FXML
    private RadioButton men_radio;

    @FXML
    private RadioButton women_radio;

    @FXML
    void initialize() {


            authSignButton.setOnAction(event -> {
                signUpNewUser();


    });
    }

    private void signUpNewUser() {
        UserController userController = new UserController();
        String id =ID_field.getText();
        String username =login_field.getText();
        String password =password_field.getText();
        String firstName =firstName_field.getText();
        String lastName =lastName_field.getText();
        String gender ="";
        if(men_radio.isSelected())
            gender="Men";
        else
            gender="Women";

        Profile profile = new Profile(id,username,password,firstName,lastName,gender);
        userController.signUpUser(profile);
    }
}
