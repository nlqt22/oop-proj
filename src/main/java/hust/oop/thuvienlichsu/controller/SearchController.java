package hust.oop.thuvienlichsu.controller;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.service.NhanVatService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    public TextField tfSearch;
    @FXML
    public Button btnSearch;
    @FXML
    public ListView<String> lvResults;
    @FXML
    public Label lbNumsOfResult;
    private NhanVatService nhanVatService;
    private List<NhanVat> listNhanVat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nhanVatService = new NhanVatService();
        listNhanVat = nhanVatService.getDanhSachNhanVat();
        for(NhanVat nhanVat : listNhanVat) {
            String nhanVatTitle = nhanVat.getHoTen().get(0);
            for(int i = 1; i < nhanVat.getHoTen().size(); ++i) nhanVatTitle += " - " + nhanVat.getHoTen().get(i);
            lvResults.getItems().add(nhanVatTitle);
        }
        lvResults.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String currentTitle = lvResults.getSelectionModel().getSelectedItem();
                lbNumsOfResult.setText("Current pick: " + currentTitle);
            }
        });
    }
}
