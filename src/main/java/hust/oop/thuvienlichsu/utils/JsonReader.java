package hust.oop.thuvienlichsu.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hust.oop.thuvienlichsu.entity.NhanVat;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    public List<NhanVat> readFileNhanVat() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<NhanVat> list = mapper.readValue(new File("src/main/resources/json/nhanvat.json"),
                new TypeReference<List<NhanVat>>() {
                });

        return list;
    }
}
