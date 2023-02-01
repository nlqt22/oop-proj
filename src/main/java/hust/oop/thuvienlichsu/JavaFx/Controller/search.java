package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.IOException;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.utils.JsonReader;

public class search extends ListCell<NhanVat> {
    @FXML
    public Button detailButton;

    @FXML
    public TextField inputField;

    @FXML
    public ListView<NhanVat> listViewer;

    private JsonReader jsonReader;
    ObservableList<NhanVat> list;
    
    @FXML
    public void initialize() throws IOException {
        this.jsonReader = new JsonReader();
        list = FXCollections.observableList(jsonReader.readFileNhanVat());
        
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
        

        detailButton.setVisible(false);

        listViewer.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<NhanVat>() {
                @Override
                public void changed(ObservableValue<? extends NhanVat> observable, NhanVat oldValue,
                        NhanVat newValue) {
                    if (newValue != null) {
                        displayDetailButton(newValue);
                    }
                }
            });

        inputField.textProperty().addListener(
            new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                        String newValue) {
                    showFilteredString(newValue);
                }
            });
    }

    void showFilteredString(String newValue) {
        FilteredList<NhanVat> new_list = new FilteredList<>(list, null);
        new_list.setPredicate(NhanVat -> NhanVat.filterProperty(newValue));

        if (list != null) {
            listViewer.setItems(new_list);
            listViewer.setCellFactory(new CellFactory());
        }

    }

    void displayDetailButton(NhanVat newValue) {
        detailButton.setVisible(true);
    }

    @FXML
    public void btnDetailPressed(ActionEvent event) {
        NhanVat name = listViewer.getSelectionModel().getSelectedItem();
        java.awt.Window win[] = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].setVisible(false);
        }
        new detailScreen(name);
    }
}
