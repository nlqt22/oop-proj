package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.utils.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVatService {
    private JsonReader jsonReader;
    private List<NhanVat> danhSachNhanVat;

    public NhanVatService() {
        this.jsonReader = new JsonReader();
    }

    public List<NhanVat> readFileNhanVat() {
        List<NhanVat> list = new ArrayList<>();
        try {
            list = jsonReader.readFileNhanVat();
            this.danhSachNhanVat = list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
