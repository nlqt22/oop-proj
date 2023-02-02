package hust.oop.thuvienlichsu.mapping;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;
import hust.oop.thuvienlichsu.scraper.NhanVatScraper;
import hust.oop.thuvienlichsu.scraper.SuKienScraper;
import hust.oop.thuvienlichsu.scraper.ThoiKiScraper;
import hust.oop.thuvienlichsu.service.NhanVatService;
import hust.oop.thuvienlichsu.service.ThoiKiService;

import java.util.List;

public class DataMapping {
    private NhanVatScraper nhanVatScraper;
    private ThoiKiScraper thoiKiScraper;
    private SuKienScraper suKienScraper;

    private ThoiKiService thoiKiService;
    private NhanVatService nhanVatService;

    private List<NhanVat> danhSachNhanVat;
    private List<ThoiKi> danhSachThoiKi;
    private List<SuKien> danhSachSuKien;
    public DataMapping() {
        nhanVatScraper = new NhanVatScraper();
        thoiKiScraper = new ThoiKiScraper();
        suKienScraper = new SuKienScraper();

        this.danhSachThoiKi = thoiKiScraper.getDanhSachThoiKi();
        this.danhSachNhanVat = nhanVatScraper.getDanhSachNhanVat();
        this.danhSachSuKien = suKienScraper.getDanhSachSuKien();

        thoiKiService = new ThoiKiService();
        nhanVatService = new NhanVatService();

        thoiKiService.setDanhSachThoiKi(this.danhSachThoiKi);
        mappingNhanVatToThoiKi();
        nhanVatService.setDanhSachNhanVat(this.danhSachNhanVat);
        mappingSuKienToNhanVat();
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return this.danhSachNhanVat;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return this.danhSachThoiKi;
    }

    public List<SuKien> getDanhSachSuKien() {
        return danhSachSuKien;
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

    public void mappingSuKienToNhanVat() {
        for(SuKien suKien : this.danhSachSuKien) {
            List<String> tenNhanVat = suKien.getTenNhanVat();
            for(String ten : tenNhanVat) {
                int f = nhanVatService.findNhanVatByHoTen(ten);
                if(f != -1) {
                    NhanVat foundNhanVat = this.danhSachNhanVat.get(f);
                    suKien.addNhanVatDTO(new NhanVatDTO(
                            ten,
                            foundNhanVat.getHoTen(),
                            foundNhanVat.getNamSinh(),
                            foundNhanVat.getNamMat(),
                            foundNhanVat.getQueQuan()
                    ));
                    this.danhSachNhanVat.get(f).addSuKien(new SuKienDTO(
                            suKien.getTenSuKien(),
                            suKien.getNamDienRa(),
                            suKien.getNamKetThuc()
                    ));
                }
            }
        }
    }
    public void printDanhSachSuKien() {
        for (SuKien sukien: this.danhSachSuKien
             ) {
            System.out.println(sukien.toString());
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
