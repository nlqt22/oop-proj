package hust.oop.thuvienlichsu;

import hust.oop.thuvienlichsu.utils.JsonWriter;

public class GettingData {
    public GettingData() {
        JsonWriter writer = new JsonWriter();
        writer.nhanVatFileWriter();
        writer.thoiKiFileWriter();
    }
}
