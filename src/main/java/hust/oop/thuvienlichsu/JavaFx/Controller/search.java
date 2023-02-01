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

import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.utils.JsonReader;

public class search extends ListCell<DiaDiem> {
    @FXML
    public Button detailButton;

    @FXML
    public TextField inputField;

    @FXML
    public ListView<DiaDiem> listViewer;

    private JsonReader jsonReader;
    ObservableList<DiaDiem> list;
    
    @FXML
    public void initialize() throws IOException {
        this.jsonReader = new JsonReader();
        list = FXCollections.observableList(jsonReader.readFileDiaDiem());
        
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
        

        detailButton.setVisible(false);

        listViewer.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<DiaDiem>() {
                @Override
                public void changed(ObservableValue<? extends DiaDiem> observable, DiaDiem oldValue,
                        DiaDiem newValue) {
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
        FilteredList<DiaDiem> new_list = new FilteredList<>(list, null);
        new_list.setPredicate(diadiem -> diadiem.filterProperty(newValue));

        if (list != null) {
            listViewer.setItems(new_list);
            listViewer.setCellFactory(new CellFactory());
        }

    }

    void displayDetailButton(DiaDiem newValue) {
        detailButton.setVisible(true);
    }

    @FXML
    public void btnDetailPressed(ActionEvent event) {
        DiaDiem name = listViewer.getSelectionModel().getSelectedItem();
        java.awt.Window win[] = java.awt.Window.getWindows();
        for (int i = 0; i < win.length; i++) {
            win[i].setVisible(false);
        }
        new detailScreen(name);
    }
}
