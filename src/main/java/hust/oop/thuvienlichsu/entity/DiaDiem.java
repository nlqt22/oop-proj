package hust.oop.thuvienlichsu.entity;

import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;

import java.util.ArrayList;
import java.util.List;

public class DiaDiem {
    private String tenDiaDiem;
    private String noiDung;
    private List<String> tenSuKien = new ArrayList<>();
    private List<String> tenNhanVat = new ArrayList<>();
    private List<SuKienDTO> danhSachSuKien = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();

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

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenDiaDiem().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }
}
