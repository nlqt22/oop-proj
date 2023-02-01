package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

import hust.oop.thuvienlichsu.entity.DiaDiem;

public class CellFactory implements Callback<ListView<DiaDiem>, ListCell<DiaDiem>> {
    @Override
    public ListCell<DiaDiem> call(ListView<DiaDiem> param) {
        return new ListCell<>(){
            @Override
            public void updateItem(DiaDiem person, boolean empty) {
                super.updateItem(person, empty);
                if (empty || person == null) {
                    setText(null);
                } else {
                    setText(person.getTenDiaDiem());
                }
            }
        };
    }
}
