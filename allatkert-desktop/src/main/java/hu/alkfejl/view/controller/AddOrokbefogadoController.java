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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrokbefogadoController implements Initializable {

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
    @FXML
    private Button addButton;

    private Orokbefogado orokbefogado = new Orokbefogado();

    public AddOrokbefogadoController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        felhasznalonevField.textProperty().bindBidirectional(orokbefogado.felhasznalonevProperty());
        jelszoField.textProperty().bindBidirectional(orokbefogado.jelszoProperty());
        nevField.textProperty().bindBidirectional(orokbefogado.nevProperty());
        telefonszamField.textProperty().bindBidirectional(orokbefogado.telefonszamProperty());
        emailField.textProperty().bindBidirectional(orokbefogado.emailProperty());


        //email validacio
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.matches("\\S+@\\S+\\.\\S+")){
                errorMsg.setText("");
            }
            else{
                errorMsg.setText("Nem megfelelő a beírt email cím formátuma");
            }

        });


        addButton.disableProperty().bind(
                (nevField.textProperty().isNull().or(nevField.textProperty().isEmpty()))
                        .or(
                                (emailField.textProperty().isEmpty().or(emailField.textProperty().isNull())).and
                                (telefonszamField.textProperty().isNull().or(telefonszamField.textProperty().isEmpty()))
                ).or(jelszoField.textProperty().isNull().or(jelszoField.textProperty().isEmpty()))
        );


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
                return OrokbefogadoController.getInstance().addOrokbefogado(orokbefogado);
            }
        };

        Thread updateThread = new Thread(task);
        updateThread.start();

        task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, event1 -> {
            Boolean result = task.getValue();
            if (result) {
                ((Node) event.getSource()).getScene().getWindow().hide();
            } else {
                Utils.showWarning("Nem sikerült a beszúrás");
            }
        });
    }








}
