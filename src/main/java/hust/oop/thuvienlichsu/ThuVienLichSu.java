package hust.oop.thuvienlichsu;

import hust.oop.thuvienlichsu.JavaFx.Controller.searchScreen;
import hust.oop.thuvienlichsu.entity.LeHoi;
import hust.oop.thuvienlichsu.scraper.LeHoiScraper;

import java.io.IOException;

public class ThuVienLichSu {
    public static int totalResults = 0;
    public static void main(String[] args) throws IOException {
        // GettingData gettingData = new GettingData();
        // System.out.println("# DONE: Extract successfully " + totalResults + " results!");

        new searchScreen();

        // LeHoiScraper test = new LeHoiScraper();
        // for(LeHoi element: test.getDanhSachLeHoi()){
        //     System.out.println(element.toString());
        // }
    }
}
