package hust.oop.thuvienlichsu.entity;

import java.util.List;

public class SuKien {
    private String tenSuKien;
    private int namDienRa;
    private int namKetThuc;
    private String dienBien;
    private List<String> tenNhanVat;
    private List<String> tenDiaDiem;

    public String getTenSuKien() {
        return tenSuKien;
    }
    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }
    public int getNamDienRa() {
        return namDienRa;
    }
    public void setNamDienRa(int namDienRa) {
        this.namDienRa = namDienRa;
    }
    public int getNamKetThuc() {
        return namKetThuc;
    }
    public void setNamKetThuc(int namKetThuc) {
        this.namKetThuc = namKetThuc;
    }
    public String getDienBien() {
        return dienBien;
    }
    public void setDienBien(String dienBien) {
        this.dienBien = dienBien;
    }
    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }
    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }
    public List<String> getTenDiaDiem() {
        return tenDiaDiem;
    }
    public void setTenDiaDiem(List<String> tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }
    
    @Override
    public String toString() {
        return "SuKien [tenSuKien=" + tenSuKien + ", namDienRa=" + namDienRa + ", namKetThuc=" + namKetThuc
                + ", dienBien=" + dienBien + ", tenNhanVat=" + tenNhanVat + ", tenDiaDiem=" + tenDiaDiem + "]";
    }
    
    
}
