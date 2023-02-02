package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.ThoiKi;

public class CellFactory implements Callback<ListView<Object>, ListCell<Object>> {
    @Override
    public ListCell<Object> call(ListView<Object> param) {
        return new ListCell<>(){
            @Override
            public void updateItem(Object element, boolean empty) {
                super.updateItem(element, empty);
                if (empty || element == null) {
                    setText(null);
                } else if(element instanceof NhanVat){
                    setText(((NhanVat) element).getHoTen().toString().replace("[", "").replace("]", ""));
                } else if(element instanceof ThoiKi){
                    setText(((ThoiKi) element).getTenThoiKi().toString().replace("[", "").replace("]", ""));
                }
            }
        };
    }
}
