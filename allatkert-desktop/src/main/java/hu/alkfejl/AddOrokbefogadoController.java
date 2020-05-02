package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
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





    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        boolean result = false;
        result = OrokbefogadoController.getInstance().addOrokbefogado(orokbefogado);
        if (result) {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            System.err.println("MEGINT EGY ADATBÁZIS HIBA");
        }
    }








}
