package hu.alkfejl;

import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddKonyvelesController implements Initializable {

    private Konyveles k = new Konyveles();

    @FXML
    public TextField felhasznalonevField;
    @FXML
    public TextField azonositoField;
    @FXML
    public TextField leirasField;
    @FXML
    public TextField tipusField;
    @FXML
    public TextField osszegField;
    @FXML
    public TextField mennyisegField;
    @FXML
    public TextField gyakorisagField;
    @FXML
    public Label errorMsg;


    public AddKonyvelesController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





    }



    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        boolean result = false;
        result = KonyvelesController.getInstance().addKonyveles(k);
        if (result) {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            System.err.println("MEGINT EGY ADATBÁZIS HIBA");
        }
    }





}
