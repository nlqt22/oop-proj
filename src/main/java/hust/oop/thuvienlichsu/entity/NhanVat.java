package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"tenThoiKi" ,"tenSuKien", "tenDiaDiem"})
public class NhanVat {
    private List<String> hoTen = new ArrayList<>();
    private String namSinh;
    private String namMat;
    private String queQuan;
    private List<ThoiKi> danhSachThoiKi = new ArrayList<>();
    private List<DiaDiemDTO> danhSachDiaDiem = new ArrayList<>();
    private List<SuKienDTO> danhSachSuKien = new ArrayList<>();
    private List<String> tenThoiKi = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();
    private List<String> tenDiaDiem = new ArrayList<>();

    public NhanVat() {
    }

    public List<String> getHoTen() {
        return hoTen;
    }

    public void setHoTen(List<String> hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getNamMat() {
        return namMat;
    }

    public void setNamMat(String namMat) {
        this.namMat = namMat;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    public void setDanhSachThoiKi(List<ThoiKi> danhSachThoiKi) {
        this.danhSachThoiKi = danhSachThoiKi;
    }

    public List<DiaDiemDTO> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiemDTO> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public List<SuKienDTO> getDanhSachSuKien() {
        return danhSachSuKien;
    }

    public void setDanhSachSuKien(List<SuKienDTO> danhSachSuKien) {
        this.danhSachSuKien = danhSachSuKien;
    }

    public List<String> getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(List<String> tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public List<String> getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(List<String> tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public List<String> getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(List<String> tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public void addHoTen(String hoTen) {
        this.hoTen.add(hoTen);
    }

    public void addThoiKi(ThoiKi thoiKi) {
        this.danhSachThoiKi.add(thoiKi);
    }

    public void addSuKien(SuKienDTO suKienDTO) {
        if(suKienDTO != null) this.danhSachSuKien.add(suKienDTO);
    }

    public void addDiaDiem(DiaDiemDTO diaDiemDTO) {
        if(diaDiemDTO != null) this.danhSachDiaDiem.add(diaDiemDTO);
    }
}
