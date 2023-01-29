package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.utils.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NhanVatService {
    private JsonReader jsonReader;

    public NhanVatService() {
        this.jsonReader = new JsonReader();
    }

    public List<NhanVat> getListNhanVat() {
        List<NhanVat> list = new ArrayList<>();
        try {
            list = jsonReader.readFileNhanVat();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
