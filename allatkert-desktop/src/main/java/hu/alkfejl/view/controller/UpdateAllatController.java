package hu.alkfejl.view.controller;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.utils.Utils;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.ResourceBundle;

public class UpdateAllatController implements Initializable {

    private Allat allat = new Allat();

    @FXML
    public TextField azonositoField;
    @FXML
    public TextField nevField;
    @FXML
    public TextField fajField;
    @FXML
    public Button photoUpload;
    @FXML
    public TextField bemutatkozasField;
    @FXML
    public TextField szuletesField;
    @FXML
    public Label errorMsg;



    public UpdateAllatController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        azonositoField.textProperty().bindBidirectional(allat.azonositoProperty());
        nevField.textProperty().bindBidirectional(allat.nevProperty());
        fajField.textProperty().bindBidirectional(allat.fajProperty());
        bemutatkozasField.textProperty().bindBidirectional(allat.bemutatkozasProperty());
        szuletesField.textProperty().bindBidirectional(allat.szuletesiEvProperty());


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
            allat.setKep(encodedString);
        } );



    }





    public void initAllat(Allat allat) {
        allat.copyTo(this.allat);
    }



    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        Task<Boolean> task = new Task<>(){
            @Override
            protected Boolean call() throws Exception {
                return AllatController.getInstance().updateAllat(allat);
            }
        };

        Thread updateThread = new Thread(task);
        updateThread.start();

        task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, event1 -> {
            Boolean result = task.getValue();
            if (result) {
                ((Node) event.getSource()).getScene().getWindow().hide();
            } else {
                Utils.showWarning("Nem sikerült az update");
            }
        });
    }



}
