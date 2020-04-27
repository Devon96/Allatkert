package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public ListAllatController(){}



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
