package hust.oop.thuvienlichsu.mapping;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.scraper.NhanVatScraper;
import hust.oop.thuvienlichsu.scraper.ThoiKiScraper;
import hust.oop.thuvienlichsu.service.ThoiKiService;

import java.util.List;

public class DataMapping {
    private NhanVatScraper nhanVatScraper;
    private ThoiKiScraper thoiKiScraper;
    private ThoiKiService thoiKiService;
    private List<NhanVat> danhSachNhanVat;
    private List<ThoiKi> danhSachThoiKi;
    public DataMapping() {
        nhanVatScraper = new NhanVatScraper();
        thoiKiScraper = new ThoiKiScraper();

        this.danhSachNhanVat = nhanVatScraper.getDanhSachNhanVat();
        this.danhSachThoiKi = thoiKiScraper.getDanhSachThoiKi();

        thoiKiService = new ThoiKiService(this.danhSachThoiKi);

        mappingNhanVatToThoiKi();
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return this.danhSachNhanVat;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return this.danhSachThoiKi;
    }

    public void mappingNhanVatToThoiKi() {
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            List<String> danhSachTenThoiKi = nhanVat.getTenThoiKi();
            for(String tenThoiKi : danhSachTenThoiKi) {
                ThoiKi find = thoiKiService.findThoiKiByTen(tenThoiKi);
                if(find != null) nhanVat.addThoiKi(find);
            }
        }
    }

    public void printDanhSachThoiKi() {
        for (ThoiKi thoiKi: danhSachThoiKi) {
            System.out.println(thoiKi.toString());
        }
    }

    public void printDanhSachNhanVat() {
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            System.out.println(nhanVat.toString());
        }
    }
}
