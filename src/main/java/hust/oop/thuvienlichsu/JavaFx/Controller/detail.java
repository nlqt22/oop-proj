package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class detail {
    @FXML
    public Button backButton;

    @FXML
    public TextArea detailField;

    private Object obj;
    public detail(Object obj){
        this.obj = obj;
    }

    @FXML public void initialize(){
        detailField.setText(obj.toString());
    }

    @FXML
    public void backToSearchScreen(ActionEvent event) {
        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=1; i<win.length; i++){
            win[i].setVisible(false);
        }
    }
}
