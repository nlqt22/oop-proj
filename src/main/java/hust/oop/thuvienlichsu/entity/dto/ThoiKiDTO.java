package hust.oop.thuvienlichsu.entity.dto;

public class ThoiKiDTO {
    private String tenThoiKi;
    private String namBatDau;
    private String namKetThuc;
    ThoiKiDTO(){

    }
    public ThoiKiDTO(String tenThoiKi, String namBatDau, String namKetThuc) {
        this.tenThoiKi = tenThoiKi;
        this.namBatDau = namBatDau;
        this.namKetThuc = namKetThuc;
    }
}
