package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.utils.StringFormater;
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
        StringFormater formater = new StringFormater();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements firstResult = doc.select(".menu:nth-child(4)");
            Element danhSachThoiKiHTML = firstResult.get(0);
            Elements thoiKiHTML = danhSachThoiKiHTML.select(".item");
            for(int i = 1; i < thoiKiHTML.size(); i++) {
                ThoiKi thoiKi = new ThoiKi();
                String tenThoiKi = thoiKiHTML.get(i).text();
                thoiKi.setTenThoiKi(tenThoiKi);
                List<String> nam = formater.removeMinusAtBegin(tenThoiKi);
                thoiKi.setTenThoiKi(tenThoiKi);
                int namBatDau = 0, namKetThuc = 0;
                if(nam.size() > 1) {
                    if(nam.get(1).contains("trCN")) namBatDau = Integer.parseInt(nam.get(1).replace(" trCN", "")) * (-1);
                    else namBatDau = Integer.parseInt(nam.get(1));
                    if(nam.get(2).contains("trCN")) namKetThuc = Integer.parseInt(nam.get(2).replace(" trCN", "")) * (-1);
                    else namKetThuc = Integer.parseInt(nam.get(2));

                }
                this.danhSachThoiKi.add(thoiKi);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
