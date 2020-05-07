package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListKonyvelesController implements Initializable {

    @FXML
    public TableView<Konyveles> table;
    @FXML
    public TableColumn<Konyveles, Integer> konyvelesIDCol;
    @FXML
    public TableColumn<Konyveles, String> felhasznalonevCol;
    @FXML
    public TableColumn<Konyveles, Integer> azonositoCol;
    @FXML
    public TableColumn<Konyveles, String> idopontCol;
    @FXML
    public TableColumn<Konyveles, String> leirasCol;
    @FXML
    public TableColumn<Konyveles, String> tipusCol;
    @FXML
    public TableColumn<Konyveles, Integer> osszegCol;
    @FXML
    public TableColumn<Konyveles, Integer> mennyisegCol;
    @FXML
    public TableColumn<Konyveles, String> gyakorisagCol;
    @FXML
    public TableColumn<Konyveles, Void> torlesCol;
    @FXML
    public ComboBox<String> orokbefogadoCBox;
    @FXML
    public ComboBox<String> orokbefogadottCBox;
    @FXML
    public TextField evField;
    @FXML
    public ComboBox<String> tipusCBox;


    public ListKonyvelesController() {
    }


    @FXML
    public void refreshTable(){
        List<Konyveles> list = KonyvelesController.getInstance().listKonyveles();
        table.setItems(FXCollections.observableList(list));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Konyveles> list = KonyvelesController.getInstance().listKonyveles();
        table.setItems(FXCollections.observableList(list));

        konyvelesIDCol.setCellValueFactory(new PropertyValueFactory<>("konyvelesID"));
        felhasznalonevCol.setCellValueFactory(new PropertyValueFactory<>("felhasznalonev"));
        azonositoCol.setCellValueFactory(new PropertyValueFactory<>("azonosito"));
        idopontCol.setCellValueFactory(new PropertyValueFactory<>("orokbefogadasIdeje"));
        leirasCol.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("tamogatasTipusa"));
        osszegCol.setCellValueFactory(new PropertyValueFactory<>("tamogatasOsszege"));
        mennyisegCol.setCellValueFactory(new PropertyValueFactory<>("tamogatasMennyisege"));
        gyakorisagCol.setCellValueFactory(new PropertyValueFactory<>("gyakorisag"));


        torlesCol.setCellFactory(param -> {
            return new TableCell<>(){
                private final Button deleteBtn = new Button("Törlés");
                {
                    deleteBtn.setOnAction(event -> {
                        Konyveles k = getTableView().getItems().get(getIndex());
                        deleteKonyveles(k);
                    });
                }
                @Override
                protected void updateItem(Void item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                    }else{
                        setGraphic(deleteBtn);
                    }
                }
            };
        });


        orokbefogadoCBox.getItems().addAll(KonyvelesController.getInstance().listOrokbefogadok());
        orokbefogadottCBox.getItems().addAll(KonyvelesController.getInstance().listOrokbefogadottak());

        tipusCBox.getItems().addAll(KonyvelesController.getInstance().listTamogatasTipusok());














    }

    private void deleteKonyveles(Konyveles konyveles){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Biztos vagy benne hogy ki akarod törölni ezt az ID-jű könyvelést: '" + konyveles.getKonyvelesID() + "'", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                KonyvelesController.getInstance().deleteKonyveles(konyveles);
            }
        });
    }




    @FXML
    public void refreshToOrokbefogadoSzerint(){
        List<Konyveles> list = KonyvelesController.getInstance().listOrokbefogadoSzerint(orokbefogadoCBox.getValue());
        table.setItems(FXCollections.observableList(list));
    }

    @FXML
    public void refreshToOrokbefogadottSzerint(){
        List<Konyveles> list = KonyvelesController.getInstance().listOrokbefogadottSzerint(orokbefogadottCBox.getValue());
        table.setItems(FXCollections.observableList(list));
    }

    @FXML
    public void refreshToIdopontSzerint(){
        List<Konyveles> list = KonyvelesController.getInstance().listIdopontSzerint(evField.getText());
        table.setItems(FXCollections.observableList(list));
    }

    @FXML
    public void refreshToTamogatasTipusSzerint(){
        List<Konyveles> list = KonyvelesController.getInstance().listTipusSzerint(tipusCBox.getValue());
        table.setItems(FXCollections.observableList(list));
    }










    @FXML
    private void switchToListAllat() throws IOException {
        App.setRoot("list_allat");
    }
    @FXML
    private void switchToListOrokbefogado() throws IOException {
        App.setRoot("list_orokbefogado");
    }
    @FXML
    private void switchToListKonyveles() throws IOException {
        App.setRoot("list_konyveles");
    }
    @FXML
    public void addAllat() throws IOException{
        App.setDialog("add_allat_dialog");
    }
    @FXML
    public void addOrokbefogado() throws IOException{
        App.setDialog("add_orokbefogado_dialog");
    }
    @FXML
    public void addKonyveles() throws IOException{
        App.setDialog("add_konyveles_dialog");
    }
}
