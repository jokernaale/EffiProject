package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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


    }
}
