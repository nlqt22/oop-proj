package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.ThoiKi;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThoiKiScraper {
    private final String URL = "https://vansu.vn/viet-nam/viet-nam-nhan-vat";
    private List<ThoiKi> danhSachThoiKi;
    public ThoiKiScraper() {
        this.danhSachThoiKi = new ArrayList<>();
        scrap();
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    private void scrap() {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements firstResult = doc.select(".menu:nth-child(4)");
            Element danhSachThoiKiHTML = firstResult.get(0);
            Elements thoiKiHTML = danhSachThoiKiHTML.select(".item");
            for(int i = 1; i < thoiKiHTML.size(); i++) {
                ThoiKi thoiKi = new ThoiKi();
                String tenThoiKi = thoiKiHTML.get(i).text();
                thoiKi.setTenThoiKi(tenThoiKi);
                this.danhSachThoiKi.add(thoiKi);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
