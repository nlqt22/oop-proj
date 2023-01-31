package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.ThoiKi;

import java.util.List;

public class ThoiKiService {
    private List<ThoiKi> danhSachThoiKi;

    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    public ThoiKi findThoiKiByTen(String ten) {
        for(ThoiKi thoiKi : this.danhSachThoiKi) {
            if(thoiKi.getTenThoiKi().equals(ten)) return thoiKi;
        }
        return null;
    }
}
