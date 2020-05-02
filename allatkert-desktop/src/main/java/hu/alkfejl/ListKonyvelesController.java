package hu.alkfejl;

import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Konyveles;
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
    public TableColumn<Konyveles, Void> modositasCol;


    public ListKonyvelesController() {
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
