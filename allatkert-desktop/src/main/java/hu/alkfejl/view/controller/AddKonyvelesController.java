package hu.alkfejl.view.controller;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddKonyvelesController implements Initializable {


    private Konyveles k = new Konyveles();

    @FXML
    public ComboBox<String> felhasznalonevField;
    @FXML
    public ComboBox<String> azonositoField;
    @FXML
    public TextField leirasField;
    @FXML
    public ComboBox<String> tipusField;
    @FXML
    public TextField osszegField;
    @FXML
    public TextField mennyisegField;
    @FXML
    public ComboBox<String> gyakorisagField;
    @FXML
    public Label errorMsg;
    @FXML
    public Button addButton;



    public AddKonyvelesController() {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        felhasznalonevField.getItems().addAll(OrokbefogadoController.getInstance().listFelhasznalonev());
        felhasznalonevField.valueProperty().bindBidirectional(k.felhasznalonevProperty());
        azonositoField.getItems().addAll(AllatController.getInstance().listAzonosito());
        azonositoField.valueProperty().bindBidirectional(k.azonositoProperty());
        leirasField.textProperty().bindBidirectional(k.leirasProperty());
        tipusField.getItems().addAll("pénzösszeg","állateledel");
        tipusField.valueProperty().bindBidirectional(k.tamogatasTipusaProperty());
        osszegField.textProperty().bindBidirectional(k.tamogatasOsszegeProperty());
        mennyisegField.textProperty().bindBidirectional(k.tamogatasMennyisegeProperty());
        gyakorisagField.getItems().addAll("egyszeri","ismétlődő");
        gyakorisagField.valueProperty().bindBidirectional(k.gyakorisagProperty());



        tipusField.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if(newValue.matches("pénzösszeg")){
               osszegField.setVisible(true);
               mennyisegField.setVisible(false);
               mennyisegField.setText("");
            }else{
                osszegField.setVisible(false);
                osszegField.setText("");
                mennyisegField.setVisible(true);
            }
        });


        addButton.disableProperty().bind(azonositoField.valueProperty().isNull().or(felhasznalonevField.valueProperty().isNull())
                .or(tipusField.valueProperty().isNull().or(gyakorisagField.valueProperty().isNull())));
        addButton.disableProperty().bind(osszegField.textProperty().isEmpty().and(mennyisegField.textProperty().isEmpty()));





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
