package hust.oop.thuvienlichsu;

import hust.oop.thuvienlichsu.scraper.DiaDiemScraper;
import hust.oop.thuvienlichsu.scraper.NhanVatScraper;
import hust.oop.thuvienlichsu.scraper.SuKienScraper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        String str = "- Trưng Nữ Vương (40-43)";
        for(String s : str.substring(2, str.length()).split("[()-]")) {
            System.out.println(s);
        }
        // NhanVatScraper scraper = new NhanVatScraper();
        // launch();
        SuKienScraper test = new SuKienScraper();
        test.printListSuKien();
    }
}
