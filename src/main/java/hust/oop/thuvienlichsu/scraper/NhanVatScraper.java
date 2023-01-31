package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.NhanVat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVatScraper {
    private final String URL = "https://vansu.vn/viet-nam/viet-nam-nhan-vat?page=";
    private final String ROOT = "https://vansu.vn";

    private List<NhanVat> danhSachNhanVat;

    public NhanVatScraper() {
        this.danhSachNhanVat = new ArrayList<>();
        scrap();
    }

    private void scrapInSubUrl(String subUrl) {
        try {
            NhanVat nhanVat = new NhanVat();
            Document doc = Jsoup.connect(subUrl).get();

            List<String> hoTen = new ArrayList<>();
            nhanVat.addHoTen(doc.select(".breadcrumb .active").text());

            Elements result = doc.select("table.table tbody tr");
            nhanVat.setChiTiet(result.last().text());

            for(int i = 0; i < result.size()-1; i++) {
                Elements tmp = result.get(i).select("td");
                if(tmp.get(0).text().equals("Tên khác")) nhanVat.addHoTen(tmp.get(1).text());
                if(tmp.get(0).text().equals("Tỉnh thành")) nhanVat.setQueQuan(tmp.get(1).text());
                if(tmp.get(0).text().equals("Thời kì")) nhanVat.addTenThoiKi(tmp.get(1).text());
                if(tmp.get(0).text().equals("Năm sinh")) {
                    nhanVat.setNamSinh(0);
                    nhanVat.setNamMat(1);
                }
            }
            this.danhSachNhanVat.add(nhanVat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scrap() {
        for(int i = 0; i <= 0; i++) {
            String page = URL + String.valueOf(i);
            try {
                Document doc = Jsoup.connect(page).get();
                Elements result = doc.select("table.table tr td a");
                for(int j = 0; j < result.size(); j += 2) {
                    System.out.println(ROOT + result.get(j).attr("href"));
                    scrapInSubUrl(ROOT + result.get(j).attr("href"));
                }
                for(NhanVat nhanVat : this.danhSachNhanVat) {
                    System.out.println(nhanVat.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
