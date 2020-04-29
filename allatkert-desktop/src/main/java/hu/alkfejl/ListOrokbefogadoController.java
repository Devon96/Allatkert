package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
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

public class ListOrokbefogadoController implements Initializable {


    @FXML
    private TableView<Orokbefogado> table;
    @FXML
    private TableColumn<Orokbefogado, String> felhasznalonevCol;
    @FXML
    private TableColumn<Orokbefogado, String> nevCol;
    @FXML
    private TableColumn<Orokbefogado, String> telefonszamCol;
    @FXML
    private TableColumn<Orokbefogado, String> emailCol;
    @FXML
    private TableColumn<Orokbefogado, String> idopontCol;


    public ListOrokbefogadoController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Orokbefogado> list = OrokbefogadoController.getInstance().listOrokbefogado();
        table.setItems(FXCollections.observableList(list));

        felhasznalonevCol.setCellValueFactory(new PropertyValueFactory<>("felhasznalonev"));
        nevCol.setCellValueFactory(new PropertyValueFactory<>("nev"));
        telefonszamCol.setCellValueFactory(new PropertyValueFactory<>("telefonszam"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        idopontCol.setCellValueFactory(new PropertyValueFactory<>("felvetelIdeje"));


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
