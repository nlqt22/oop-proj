package hust.oop.thuvienlichsu.JavaFx.Controller;

import hust.oop.thuvienlichsu.entity.NhanVat;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
 
public class detailScreen extends JFrame {
    private Object name;
    
    public detailScreen(Object name){
        this.name = name;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Detail");
        this.setSize(1280, 768);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{           
                    FXMLLoader loader = new FXMLLoader(getClass()
                                            .getResource("/hust/oop/thuvienlichsu/JavaFx/FXML/detailScreen.fxml"));
                    loader.setController(new detail(name));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }   
}
