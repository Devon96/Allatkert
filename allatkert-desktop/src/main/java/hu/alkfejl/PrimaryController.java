package hu.alkfejl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {



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
