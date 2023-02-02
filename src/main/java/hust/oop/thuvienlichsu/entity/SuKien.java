package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"tenNhanVat", "tenDiaDiem"})
public class SuKien {
    private String tenSuKien;
    private String namDienRa;
    private String namKetThuc;
    private String dienBien;
    private List<String> tenNhanVat = new ArrayList<>();
    private List<String> tenDiaDiem = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();
    private List<DiaDiemDTO> danhSachDiaDiem = new ArrayList<>();

    public String getTenSuKien() {
        return tenSuKien;
    }
    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }
    public String getNamDienRa() {
        return namDienRa;
    }
    public void setNamDienRa(String namDienRa) {
        this.namDienRa = namDienRa;
    }
    public String getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(String namKetThuc) {
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

    public List<NhanVatDTO> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVatDTO> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public List<DiaDiemDTO> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiemDTO> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public void addNhanVat(NhanVatDTO nhanVatDTO) {
        if(nhanVatDTO != null) this.danhSachNhanVat.add(nhanVatDTO);
    }

    public void addDiaDiem(DiaDiemDTO diaDiemDTO) {
        if(diaDiemDTO != null) this.danhSachDiaDiem.add(diaDiemDTO);
    }
    @Override
    public String toString() {
        return "SuKien{" +
                "tenSuKien='" + tenSuKien + '\'' +
                ", namDienRa=" + namDienRa +
                ", namKetThuc=" + namKetThuc +
                ", tenNhanVat=" + tenNhanVat +
                ", tenDiaDiem=" + tenDiaDiem +
                ", danhSachNhanVat=" + danhSachNhanVat +
                ", danhSachDiaDiem=" + danhSachDiaDiem +
                '}';
    }
}
