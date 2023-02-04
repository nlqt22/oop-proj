package hust.oop.thuvienlichsu.mapping;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;
import hust.oop.thuvienlichsu.scraper.DiaDiemScraper;
import hust.oop.thuvienlichsu.scraper.NhanVatScraper;
import hust.oop.thuvienlichsu.scraper.SuKienScraper;
import hust.oop.thuvienlichsu.scraper.ThoiKiScraper;
import hust.oop.thuvienlichsu.service.DiaDiemService;
import hust.oop.thuvienlichsu.service.NhanVatService;
import hust.oop.thuvienlichsu.service.ThoiKiService;

import java.util.List;

public class DataMapping {
    private NhanVatScraper nhanVatScraper;
    private ThoiKiScraper thoiKiScraper;
    private SuKienScraper suKienScraper;
    private DiaDiemScraper diaDiemScraper;

    private ThoiKiService thoiKiService;
    private NhanVatService nhanVatService;
    private DiaDiemService diaDiemService;

    private List<NhanVat> danhSachNhanVat;
    private List<ThoiKi> danhSachThoiKi;
    private List<SuKien> danhSachSuKien;
    private List<DiaDiem> danhSachDiaDiem;
    
    public DataMapping() {

        thoiKiScraper = new ThoiKiScraper();
        suKienScraper = new SuKienScraper();
        diaDiemScraper = new DiaDiemScraper();
        nhanVatScraper = new NhanVatScraper();

        this.danhSachThoiKi = thoiKiScraper.getDanhSachThoiKi();
        this.danhSachNhanVat = nhanVatScraper.getDanhSachNhanVat();
        this.danhSachSuKien = suKienScraper.getDanhSachSuKien();
        this.danhSachDiaDiem = diaDiemScraper.getDanhSachDiaDiem();

        thoiKiService = new ThoiKiService();
        nhanVatService = new NhanVatService();
        diaDiemService = new DiaDiemService();

        thoiKiService.setDanhSachThoiKi(this.danhSachThoiKi);
        diaDiemService.setDanhSachDiaDiem(this.danhSachDiaDiem);
        nhanVatService.setDanhSachNhanVat(this.danhSachNhanVat);

        mappingThoiKiToNhanVat();
        mappingSuKienToNhanVat();
        mappingDiaDiemToNhanVat();
        mappingNhanVatToDiaDiem();
        mappingSuKienToDiaDiem();
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return this.danhSachNhanVat;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return this.danhSachThoiKi;
    }

    public List<SuKien> getDanhSachSuKien() { return danhSachSuKien; }

    public List<DiaDiem> getDanhSachDiaDiem() { return danhSachDiaDiem; }

    public void mappingThoiKiToNhanVat() {
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
                    suKien.addNhanVat(new NhanVatDTO(
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

    public void mappingNhanVatToDiaDiem() {
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            String queQuan = nhanVat.getQueQuan();
            int f = diaDiemService.findDiaDiemByTen(queQuan);
            if(f != -1) {
                DiaDiem diaDiem = this.danhSachDiaDiem.get(f);
                nhanVat.addDiaDiem(new DiaDiemDTO(
                        diaDiem.getTenDiaDiem()
                ));
                this.danhSachDiaDiem.get(f).addNhanVat(new NhanVatDTO(
                        nhanVat.getHoTen().get(0),
                        nhanVat.getHoTen(),
                        nhanVat.getNamSinh(),
                        nhanVat.getNamMat(),
                        nhanVat.getQueQuan()
                ));
            }
        }
    }

    public void mappingDiaDiemToNhanVat() {
        for(DiaDiem diaDiem : this.danhSachDiaDiem) {
            List<String> tenNhanVat = diaDiem.getTenNhanVat();
            for(String ten : tenNhanVat) {
                int f = nhanVatService.findNhanVatByHoTen(ten);
                if(f != -1) {
                    NhanVat foundNhanVat = this.danhSachNhanVat.get(f);
                    diaDiem.addNhanVat(new NhanVatDTO(
                            ten,
                            foundNhanVat.getHoTen(),
                            foundNhanVat.getNamSinh(),
                            foundNhanVat.getNamMat(),
                            foundNhanVat.getQueQuan()
                    ));
                    this.danhSachNhanVat.get(f).addDiaDiem(new DiaDiemDTO(
                            diaDiem.getTenDiaDiem()
                    ));
                }
            }
        }
    }

    public void mappingSuKienToDiaDiem() {
        for(SuKien suKien : this.danhSachSuKien) {
            List<String> tenDiaDiem = suKien.getTenDiaDiem();
            for(String dd : tenDiaDiem) {
                int f = diaDiemService.findDiaDiemByTen(dd);
                if(f != -1) {
                    DiaDiem diaDiem = this.danhSachDiaDiem.get(f);
                    suKien.addDiaDiem(new DiaDiemDTO(
                            diaDiem.getTenDiaDiem()
                    ));
                    this.danhSachDiaDiem.get(f).addSuKien(new SuKienDTO(
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
