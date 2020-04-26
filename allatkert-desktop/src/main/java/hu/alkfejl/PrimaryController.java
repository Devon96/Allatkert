package hu.alkfejl;

import javafx.fxml.FXML;

import java.io.IOException;

public class PrimaryController {


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
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

}
