package hust.oop.thuvienlichsu;

import hust.oop.thuvienlichsu.JavaFx.Controller.searchScreen;
import java.io.IOException;

public class ThuVienLichSu{
    // @Override
    // public void start(Stage stage) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(ThuVienLichSu.class.getResource("search.fxml"));
    //     Scene scene = new Scene(fxmlLoader.load());
    //     stage.setTitle("Thư viện lịch sử");
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public static void main(String[] args) throws IOException {
        // GettingData gettingData = new GettingData();
        // System.out.println("DONE (V)");
        // launch();
        new searchScreen();
    }
}
