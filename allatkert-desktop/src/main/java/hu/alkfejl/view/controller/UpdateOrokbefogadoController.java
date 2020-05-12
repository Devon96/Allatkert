package hu.alkfejl.view.controller;

import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
import hu.alkfejl.allatkert.utils.Utils;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateOrokbefogadoController implements Initializable {


    @FXML
    public TextField felhasznalonevField;
    @FXML
    public TextField nevField;
    @FXML
    public TextField telefonszamField;
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField jelszoField;
    @FXML
    public Label errorMsg;

    private Orokbefogado obf = new Orokbefogado();

    public UpdateOrokbefogadoController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        felhasznalonevField.textProperty().bindBidirectional(obf.felhasznalonevProperty());
        jelszoField.textProperty().bindBidirectional(obf.jelszoProperty());
        nevField.textProperty().bindBidirectional(obf.nevProperty());
        telefonszamField.textProperty().bindBidirectional(obf.telefonszamProperty());
        emailField.textProperty().bindBidirectional(obf.emailProperty());


        //email validacio
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.matches("\\S+@\\S+\\.\\S+")){
                errorMsg.setText("");
            }
            else{
                errorMsg.setText("Nem megfelelő a beírt email cím formátuma");
            }

        });





    }





    public void initOrokbefogado(Orokbefogado orokbefogado) {
        orokbefogado.copyTo(this.obf);

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
                return OrokbefogadoController.getInstance().updateOrokbefogado(obf);
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
