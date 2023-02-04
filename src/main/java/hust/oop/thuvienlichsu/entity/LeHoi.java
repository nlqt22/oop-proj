package hust.oop.thuvienlichsu.entity;

import java.util.ArrayList;
import java.util.List;

public class LeHoi {
    private String tenLeHoi;
    private String ngayToChuc;
    private String diaDiemToChuc;
    private String ngayThanhLap;
    private List<String> nhanVatLienQuan = new ArrayList<>();
    
    public String getTenLeHoi() {
        return tenLeHoi;
    }

    public void setTenLeHoi(String tenLeHoi) {
        this.tenLeHoi = tenLeHoi;
    }

    public List<String> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void setNhanVatLienQuan(List<String> nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan;
    }

    public void addNhanVatLienQuan(String nhanVat) {
        this.nhanVatLienQuan.add(nhanVat);
    }

    public String getDiaDiemToChuc() {
        return diaDiemToChuc;
    }

    public void setDiaDiemToChuc(String diaDiemToChuc) {
        this.diaDiemToChuc = diaDiemToChuc;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public LeHoi() {
    }

    @Override
    public String toString() {
        return "LeHoi [tenLeHoi=" + tenLeHoi + ", ngayToChuc=" + ngayToChuc + ", diaDiemToChuc=" + diaDiemToChuc
                + ", ngayThanhLap=" + ngayThanhLap + ", nhanVatLienQuan=" + nhanVatLienQuan + "]";
    }


    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenLeHoi().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
            return true;
        }
        return false;
    }
}
