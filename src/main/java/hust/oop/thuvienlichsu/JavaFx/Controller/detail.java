package hust.oop.thuvienlichsu.JavaFx.Controller;

import hust.oop.thuvienlichsu.entity.NhanVat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class detail {
    @FXML
    public Button backButton;

    @FXML
    public TextArea detailField;

    public NhanVat element;
    public detail(NhanVat name){
        this.element = name;
    }

    @FXML public void initialize(){
        detailField.setText(element.toString());
    }

    @FXML
    public void backToSearchScreen(ActionEvent event) {
        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=0; i<win.length; i++){
            win[i].setVisible(false);
        }
        new searchScreen();
    }
}
