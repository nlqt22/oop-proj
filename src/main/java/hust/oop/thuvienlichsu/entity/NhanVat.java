package hust.oop.thuvienlichsu.entity;

import java.util.List;

public class NhanVat {
    private List<String> hoTen;
    private int namSinh;
    private int namMat;
    private String queQuan;
    private String chiTiet;
    private String thoiKi;

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

    public String getThoiKi() {
        return thoiKi;
    }

    public void setThoiKi(String thoiKi) {
        this.thoiKi = thoiKi;
    }

    @Override
    public String toString() {
        return "NhanVat{" +
                "hoTen=" + hoTen +
                ", namSinh=" + namSinh +
                ", namMat=" + namMat +
                ", queQuan='" + queQuan + '\'' +
                ", chiTiet='" + chiTiet + '\'' +
                ", thoiKi='" + thoiKi + '\'' +
                '}';
    }
}
