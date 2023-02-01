package hust.oop.thuvienlichsu.entity;

import java.util.List;

public class DiaDiem {
    private String tenDiaDiem;
    private String noiDung;
    private List<String> tenSuKien;
    private List<String> tenNhanVat;

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String ten) {
        this.tenDiaDiem = ten;
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

    @Override
    public String toString() {
        return "DiaDiem [tenDiaDiem=" + tenDiaDiem + ", noiDung=" + noiDung + ", tenSuKien=" + tenSuKien
                + ", tenNhanVat=" + tenNhanVat + "]";
    }
}
