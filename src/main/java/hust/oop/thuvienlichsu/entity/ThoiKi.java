package hust.oop.thuvienlichsu.entity;

public class ThoiKi {
    private String tenThoiKi;
    private String namBatDau;
    private String namKetThuc;

    public String getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(String tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public String getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(String namBatDau) {
        this.namBatDau = namBatDau;
    }

    public String getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(String namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    @Override
    public String toString() {
        return this.tenThoiKi + "(" + this.namBatDau + "-" + this.namKetThuc + ")";
    }

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenThoiKi().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }
}
