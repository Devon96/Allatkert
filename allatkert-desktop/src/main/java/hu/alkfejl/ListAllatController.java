package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllatController implements Initializable {

    @FXML
    private TableView<Allat> table;
    @FXML
    private TableColumn<Allat, Integer> azonositoCol;
    @FXML
    private TableColumn<Allat, String> nevCol;
    @FXML
    private TableColumn<Allat, String> fajCol;
    @FXML
    private TableColumn<Allat, String> kepCol;
    @FXML
    private TableColumn<Allat, String> bemutatkozasCol;
    @FXML
    private TableColumn<Allat, Integer> szuletesCol;
    @FXML
    private TableColumn<Allat, Void> torlesCol;

    public ListAllatController(){}

    @FXML
    public void refreshTable(){
        List<Allat> list = AllatController.getInstance().listAllat();
        table.setItems(FXCollections.observableList(list));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Allat> list = AllatController.getInstance().listAllat();
        table.setItems(FXCollections.observableList(list));

        azonositoCol.setCellValueFactory(new PropertyValueFactory<>("azonosito"));
        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        fajCol.setCellValueFactory(new PropertyValueFactory<>("faj"));
        kepCol.setCellValueFactory(new PropertyValueFactory<>("kep"));
        bemutatkozasCol.setCellValueFactory(new PropertyValueFactory<>("bemutatkozas"));
        szuletesCol.setCellValueFactory(new PropertyValueFactory<>("szuletesiEv"));



        torlesCol.setCellFactory(param -> {
            return new TableCell<>(){
                private final Button deleteBtn = new Button("Törlés");
                {
                    deleteBtn.setOnAction(event -> {
                        Allat a = getTableView().getItems().get(getIndex());
                        deleteAllat(a);
                        refreshTable();
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



    }

    private void deleteAllat(Allat allat){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Biztos vagy benne hogy ki akarod törölni ezt az azonosítójú állatot: '" + allat.getAzonosito() + "'", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                AllatController.getInstance().deleteAllat(allat);
            }
        });
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
}
