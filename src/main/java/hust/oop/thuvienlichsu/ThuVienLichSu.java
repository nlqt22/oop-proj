package hust.oop.thuvienlichsu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ThuVienLichSu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ThuVienLichSu.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Thư viện lịch sử");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}