package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

import hust.oop.thuvienlichsu.entity.NhanVat;

public class CellFactory implements Callback<ListView<NhanVat>, ListCell<NhanVat>> {
    @Override
    public ListCell<NhanVat> call(ListView<NhanVat> param) {
        return new ListCell<>(){
            @Override
            public void updateItem(NhanVat person, boolean empty) {
                super.updateItem(person, empty);
                if (empty || person == null) {
                    setText(null);
                } else {
                    setText(person.getHoTen().toString().replace("[", "").replace("]", ""));
                }
            }
        };
    }
}
