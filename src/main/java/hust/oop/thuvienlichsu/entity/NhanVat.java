package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class NhanVat {
    private List<String> hoTen = new ArrayList<>();
    private int namSinh;
    private int namMat;
    private String queQuan;
    private String chiTiet;
    private List<ThoiKi> danhSachThoiKi = new ArrayList<>();
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<String> tenThoiKi = new ArrayList<>();

    public NhanVat() {
    }

    public List<String> getHoTen() {
        return hoTen;
    }

    public void setHoTen(List<String> hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getNamMat() {
        return namMat;
    }

    public void setNamMat(int namMat) {
        this.namMat = namMat;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public List<String> getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(List<String> tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    public void setDanhSachThoiKi(List<ThoiKi> danhSachThoiKi) {
        this.danhSachThoiKi = danhSachThoiKi;
    }

    public void addHoTen(String hoTen) {
        this.hoTen.add(hoTen);
    }

    public void addTenThoiKi(String tenThoiKi) {
        this.tenThoiKi.add(tenThoiKi);
    }

    @Override
    public String toString() {
        return "NhanVat{" +
                "hoTen=" + hoTen +
                ", namSinh=" + namSinh +
                ", namMat=" + namMat +
                ", queQuan='" + queQuan + '\'' +
                ", chiTiet='" + chiTiet + '\'' +
                ", tenThoiKi=" + tenThoiKi +
                '}';
    }
}
