package hust.oop.thuvienlichsu.entity;

import java.util.ArrayList;
import java.util.List;

public class ThoiKi {
    private String tenThoiKi;
    private int namBatDau;
    private int namKetThuc;
    private List<NhanVat> danhSachNhanVat;

    public ThoiKi() {
        this.danhSachNhanVat = new ArrayList<NhanVat>();
    }

    public String getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(String tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public int getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(int namBatDau) {
        this.namBatDau = namBatDau;
    }

    public int getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(int namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVat> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }
}
