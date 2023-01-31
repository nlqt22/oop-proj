package hust.oop.thuvienlichsu.utils;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import hust.oop.thuvienlichsu.scraper.DiaDiemScraper;
import hust.oop.thuvienlichsu.scraper.ThoiKiScraper;

import java.io.IOException;
import java.nio.file.Paths;

public class JsonWriter {
    public void thoiKiFileWriter() {
        ThoiKiScraper scraper = new ThoiKiScraper();
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/json/thoiki.json").toFile(), scraper.getDanhSachThoiKi());
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void diaDiemFileWriter(){
        DiaDiemScraper scraper = new DiaDiemScraper();
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/json/diadiem.json").toFile(), scraper.getDanhSachDiaDiem());
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
