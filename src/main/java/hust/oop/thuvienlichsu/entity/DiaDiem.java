package hust.oop.thuvienlichsu.entity;

import java.util.List;

public class DiaDiem {
    private String ten;
    private String noiDung;
    private List<String> tenSuKien;
    private List<String> tenNhanVat;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<String> getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(List<String> tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }

    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }
}
