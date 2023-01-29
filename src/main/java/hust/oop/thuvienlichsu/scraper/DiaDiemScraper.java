package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiaDiemScraper {
    private final String URL = "https://thuvienlichsu.com/dia-diem";
    private final String ROOT = "https://thuvienlichsu.com";
    private Document web;
    private List<DiaDiem> danhSachDiaDiem;

    public DiaDiemScraper() {
        this.danhSachDiaDiem = new ArrayList<>();
        scrap();
    }

    private DiaDiem scrapInSubUrl(String subUrl) {
        List<String> listEv = new ArrayList<String>();  
        List<String> listChar = new ArrayList<String>(); 
        DiaDiem diaDiem = new DiaDiem();

        try {
            Document doc = Jsoup.connect(subUrl).get();
            Elements result = doc.select(".divide-tag");
            for(int i = 0; i < result.size(); i++) {
                Elements header = result.get(i).select("h3.header-edge");
                String title = header.text();
                // Code tiep tu day nhe !
                if(i == 0) diaDiem.setTenDiaDiem(title);
                if(title.equals("Diễn biễn lịch sử")) {
                    for(Element element: result.select("p")){
                        element.remove();
                    }
                    diaDiem.setNoiDung(result.get(i).select(".card-body").text());
                }
                if(title.equals("Sự kiện liên quan")) {
                    Elements suKienLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : suKienLienQuanHTML) {
                        listEv.add(element.text());
                    }
                    diaDiem.setTenSuKien(listEv);
                }
                if(title.equals("Nhân vật liên quan")) {
                    Elements nhanVatLienQuanHTML = result.get(i).select(".card-body h4.card-title");
                    for(Element element : nhanVatLienQuanHTML) {
                        listChar.add(element.text());
                    }
                    diaDiem.setTenNhanVat(listChar);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return diaDiem;
    }

    private void scrap() {
        int start = 1, end = 1;
        try {
            Document doc = Jsoup.connect(URL).get();
            for(int i = start; i <= end; i++) {
                Elements result = doc.select(".divide-content .card-body a.click");
                for(int j = 0; j < result.size(); j++) {
                    System.out.println(ROOT+ result.get(j).attr("href"));
                    this.danhSachDiaDiem.add(scrapInSubUrl(ROOT + result.get(j).attr("href")));
                    System.out.println("--> EXTRACT-DONE (V)");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printListDiaDiem() {
        for(DiaDiem diaDiem : danhSachDiaDiem) {
            System.out.println(diaDiem.getTenDiaDiemString());
        }
    }
}
