package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.NhanVat;

import java.util.ArrayList;
import java.util.List;

public class NhanVatService {
    private List<NhanVat> danhSachNhanVat = new ArrayList<>();

    public NhanVatService() {
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVat> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public int findNhanVatByHoTen(String tenNhanVat) {
        int nf = -1;
        for(int i = 0; i < this.danhSachNhanVat.size(); i++) {
            List<String> hoTen = this.danhSachNhanVat.get(i).getHoTen();
            for(String t : hoTen) {
                if(t.contains(tenNhanVat)) return i;
            }
        }
        return nf;
    }

}
