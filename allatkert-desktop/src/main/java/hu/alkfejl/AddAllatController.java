package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddAllatController implements Initializable {

    @FXML
    public TextField nevField;
    @FXML
    public TextField fajField;
    @FXML
    public TextField kepField;
    @FXML
    public TextField bemutatkozasField;
    @FXML
    public Spinner<Integer> birthYearSpinner;

    private Allat a = new Allat();

    public AddAllatController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nevField.textProperty().bindBidirectional(a.nevProperty());
        fajField.textProperty().bindBidirectional(a.fajProperty());
        kepField.textProperty().bindBidirectional(a.kepProperty());
        bemutatkozasField.textProperty().bindBidirectional(a.bemutatkozasProperty());
        birthYearSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                1900, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.YEAR)
        ));

    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        boolean result = false;

        System.out.println(a.toString());

        result = AllatController.getInstance().addAllat(a);
        if (result) {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            System.err.println("MEGINT EGY ADATBÁZIS HIBA");
        }
    }

}
