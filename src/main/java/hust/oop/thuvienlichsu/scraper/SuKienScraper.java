package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.SuKien;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuKienScraper {
    private final String URL = "https://thuvienlichsu.com/su-kien";
    private final String ROOT = "https://thuvienlichsu.com";
    private Document web;
    private List<SuKien> danhSachSuKien;

    public SuKienScraper() {
        this.danhSachSuKien = new ArrayList<>();
        scrap();
    }

    private SuKien scrapInSubUrl(String subUrl) {
        List<String> listPlaces = new ArrayList<String>();  
        List<String> listChar = new ArrayList<String>(); 
        SuKien suKien = new SuKien();

        try {
            Document doc = Jsoup.connect(subUrl).get();
            Elements result = doc.select(".divide-tag");
            for(int i = 0; i < result.size(); i++) {
                Elements header = result.get(i).select("h3.header-edge");
                String title = header.text();
                // Code tiep tu day nhe !
                if(i == 0){
                    suKien.setTenSuKien(title);
                }
                if(title.equals("Diễn biễn lịch sử")) {
                    for(Element element: result.select("p")){
                        element.remove();
                    }
                    suKien.setDienBien(result.get(i).select(".card-body").text());
                }
                if(title.equals("Địa điểm liên quan")) {
                    Elements suKienLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : suKienLienQuanHTML) {
                        listPlaces.add(element.text());
                    }
                    suKien.setTenDiaDiem(listPlaces);
                }
                if(title.equals("Nhân vật liên quan")) {
                    Elements nhanVatLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : nhanVatLienQuanHTML) {
                        listChar.add(element.text());
                    }
                    suKien.setTenNhanVat(listChar);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return suKien;
    }

    private void scrap() {
        int start = 1, end = 1;
        try {
            Document doc = Jsoup.connect(URL).get();
            for(int i = start; i <= end; i++) {
                Elements result = doc.select(".divide-content .card-body a.click");
                for(int j = 0; j < result.size(); j++) {
                    System.out.println(ROOT+ result.get(j).attr("href"));
                    this.danhSachSuKien.add(scrapInSubUrl(ROOT + result.get(j).attr("href")));
                    System.out.println("--> EXTRACT-DONE (V)");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printListSuKien() {
        for(SuKien suKien : danhSachSuKien) {
            System.out.println(suKien.getTenSuKien());
        }
    }
}

