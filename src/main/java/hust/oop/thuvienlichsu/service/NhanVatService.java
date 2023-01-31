package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.utils.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVatService {
    private JsonReader jsonReader;
    private ThoiKiService thoiKiService;
    private List<NhanVat> danhSachNhanVat;

    public NhanVatService() {
        this.thoiKiService = new ThoiKiService();
        this.jsonReader = new JsonReader();
    }

    public void mapThoiKiToNhanVat() {
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            for(String tenThoiKi : nhanVat.getTenThoiKi()) {
                ThoiKi thoiKi = thoiKiService.findThoiKiByTen(tenThoiKi);
                if(thoiKi != null) {
                    nhanVat.addThoiKi(thoiKi);
                }
            }
        }
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public NhanVat findNhanVatByHoTen(String hoTen) {
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            for(String s : nhanVat.getHoTen()) {
                if(s.contains(hoTen)) return nhanVat;
            }
        }
        return null;
    }

    public List<NhanVat> searchNhanVatByHoTen(String hoTen) {
        List<NhanVat> result = new ArrayList<>();
        for(NhanVat nhanVat : this.danhSachNhanVat) {
            for(String s : nhanVat.getHoTen()) {
                if(s.contains(hoTen)) result.add(nhanVat);
                break;
            }
        }
        return result;
    }

    public List<NhanVat> readFileNhanVat() {
        List<NhanVat> list = new ArrayList<>();
        try {
            list = jsonReader.readFileNhanVat();
            this.danhSachNhanVat = list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
