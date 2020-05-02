package hu.alkfejl;

import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    @FXML
    public TableColumn<Orokbefogado, Void> torlesCol;
    @FXML
    public TableColumn<Orokbefogado, Void> modositasCol;


    public ListOrokbefogadoController() {
    }


    @FXML
    public void refreshTable(){
        List<Orokbefogado> list = OrokbefogadoController.getInstance().listOrokbefogado();
        table.setItems(FXCollections.observableList(list));
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

        torlesCol.setCellFactory(param -> {
            return new TableCell<>(){
                private final Button deleteBtn = new Button("Törlés");
                private final Button editBtn = new Button("Szerkesztés");
                {
                    deleteBtn.setOnAction(event -> {
                        Orokbefogado o = getTableView().getItems().get(getIndex());
                        deleteOrokbefogado(o);
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



        modositasCol.setCellFactory(param -> {
            return new TableCell<>(){
                private final Button editBtn = new Button("Szerkesztés");
                {
                    editBtn.setOnAction(event -> {
                        Orokbefogado o = getTableView().getItems().get(getIndex());
                        editOrokbefogado(o);
                        refreshTable();
                    });
                }
                @Override
                protected void updateItem(Void item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                    }else{
                        setGraphic(editBtn);
                    }
                }
            };
        });









    }



    private void deleteOrokbefogado(Orokbefogado orokbefogado){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Biztos vagy benne hogy ki akarod törölni ezt a felhasználót: '" + orokbefogado.getFelhasznalonev() + "'", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                OrokbefogadoController.getInstance().deleteOrokbefogado(orokbefogado);
            }
        });
    }

    private void editOrokbefogado(Orokbefogado obf) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/hu/alkfejl/update_orokbefogado_dialog.fxml"));
            Parent root = loader.load();
            UpdateOrokbefogadoController controller = loader.getController();
            controller.initOrokbefogado(obf);

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public void updateOrokbefogado() throws IOException{
        App.setDialog("update_orokbefogado_dialog");
    }


}
