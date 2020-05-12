package hu.alkfejl.view.controller;

import hu.alkfejl.App;
import hu.alkfejl.allatkert.controller.AllatController;
import hu.alkfejl.allatkert.model.bean.Allat;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllatController implements Initializable {


    @FXML
    private TableView<Allat> table;
    @FXML
    private TableColumn<Allat, String> azonositoCol;
    @FXML
    private TableColumn<Allat, String> nevCol;
    @FXML
    private TableColumn<Allat, String> fajCol;
    @FXML
    private TableColumn<Allat, String> kepCol;
    @FXML
    private TableColumn<Allat, String> bemutatkozasCol;
    @FXML
    private TableColumn<Allat, String> szuletesCol;
    @FXML
    private TableColumn<Allat, Void> torlesCol;
    @FXML
    public TableColumn<Allat, Void> modositasCol;

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
        bemutatkozasCol.setCellValueFactory(new PropertyValueFactory<>("bemutatkozas"));
        szuletesCol.setCellValueFactory(new PropertyValueFactory<>("szuletesiEv"));
        kepCol.setCellValueFactory(new PropertyValueFactory<>("kep"));

        kepCol.setCellFactory(new Callback<TableColumn<Allat, String>, TableCell<Allat, String>>() {
            @Override
            public TableCell<Allat, String> call(TableColumn<Allat, String> param) {
                return new KepCell<>();
            }
        });


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



        modositasCol.setCellFactory(param -> {
            return new TableCell<>(){
                private final Button editBtn = new Button("Szerkesztés");
                {
                    editBtn.setOnAction(event -> {
                        Allat a = getTableView().getItems().get(getIndex());
                        editAllat(a);
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



    public Image StringbolFxImage(String p_string){
        byte[] decodedBytes = Base64
                .getDecoder()
                .decode(p_string);
        ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);
        BufferedImage image = null;
        Image img = null;
        try {
            image = ImageIO.read(bais);
            img = convertToFxImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    //bufferedimagebol fxmlimage keszitese
    public Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr).getImage();
    }



    class KepCell<T> extends TableCell<T,String>{
        private final ImageView image;

        public KepCell(){
            image = new ImageView();
            image.setFitWidth(100);
            image.setFitHeight(100);
            image.setPreserveRatio(true);
            setGraphic(image);
            setMinHeight(70);
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if(empty || item == null){
                image.setImage(null);
            }else{
                image.setImage(StringbolFxImage(itemProperty().getValue()));
            }
        }
    }





    @FXML
    public void refreshToOrokbefogadott(){
        List<Allat> list = AllatController.getInstance().listOrokbefogadottAllat();
        table.setItems(FXCollections.observableList(list));
    }

    @FXML
    public void refreshToOrokbefogadatlan(){
        List<Allat> list = AllatController.getInstance().listOrokbefogadatlanAllat();
        table.setItems(FXCollections.observableList(list));
    }




    private void deleteAllat(Allat allat){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Biztos vagy benne hogy ki akarod törölni ezt az azonosítójú állatot: '" + allat.getAzonosito() + "'", ButtonType.YES, ButtonType.NO);
        alert.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals(ButtonType.YES)){
                AllatController.getInstance().deleteAllat(allat);
            }
        });
    }


    private void editAllat(Allat allat) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/hu/alkfejl/view/update_allat_dialog.fxml"));
            Parent root = loader.load();
            UpdateAllatController controller = loader.getController();

            controller.initAllat(allat);

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
    public void addKonyveles() throws IOException{
        App.setDialog("add_konyveles_dialog");
    }
}
