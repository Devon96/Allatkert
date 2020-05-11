package hu.alkfejl.view.controller;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AddAllatController implements Initializable {

    @FXML
    public TextField nevField;
    @FXML
    public TextField fajField;
    @FXML
    public TextField bemutatkozasField;
    @FXML
    public Spinner<Integer> birthYearSpinner;
    @FXML
    public Button photoUpload;

    private Allat a = new Allat();

    public AddAllatController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nevField.textProperty().bindBidirectional(a.nevProperty());
        fajField.textProperty().bindBidirectional(a.fajProperty());
        bemutatkozasField.textProperty().bindBidirectional(a.bemutatkozasProperty());
        birthYearSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                1900, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.YEAR)
        ));
        birthYearSpinner.getValueFactory().valueProperty().bindBidirectional(a.szuletesiEvProperty().asObject());




        photoUpload.setOnAction( ( ActionEvent event ) ->
        {
            Stage ablak = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Válassz egy képet");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*jpg"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*png"));

            File file = fileChooser.showOpenDialog(ablak);

            byte[] fileContent = new byte[0];
            try {
                fileContent = FileUtils.readFileToByteArray(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String encodedString = Base64
                    .getEncoder()
                    .encodeToString(fileContent);
            a.setKep(encodedString);
        } );











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
