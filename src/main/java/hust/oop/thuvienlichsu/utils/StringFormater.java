package hust.oop.thuvienlichsu.utils;

import java.util.ArrayList;
import java.util.List;

public class StringFormater {
    public List<String> removeMinusAtBegin(String str) {
        List<String> result = new ArrayList<>();
        for(String s : str.substring(2, str.length()).split("[()-]")) {
            result.add(s);
        }
        return result;
    }
}
