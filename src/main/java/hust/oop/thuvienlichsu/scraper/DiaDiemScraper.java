package hust.oop.thuvienlichsu.scraper;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    private void scrapInSubUrl(String subUrl) {
        DiaDiem diaDiem = new DiaDiem();
        try {
            Document doc = Jsoup.connect(subUrl).get();
            Elements result = doc.select(".divide-tag");
            for(int i = 0; i < result.size(); i++) {
                Elements header = result.get(i).select("h3.header-edge");
                String title = header.text();
                // Code tiep tu day nhe !
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void scrap() {
        int start = 1, end = 1;
        try {
            Document doc = Jsoup.connect(URL).get();
            for(int i = start; i <= end; i++) {
                Elements result = doc.select(".divide-content .card-body a.click");
                for(int j = 0; j < result.size(); j++) {

                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
