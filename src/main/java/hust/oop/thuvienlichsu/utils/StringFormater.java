package hust.oop.thuvienlichsu.utils;

import java.util.ArrayList;
import java.util.List;

public class StringFormater {
    // "- Dựng nước (2000 - 258 trCN) "
    public static String removeMinusAtBegin(String str) {
        return str.substring(2, str.length()).strip();
    }

    // Hồ Chí Minh - Nguyễn Sinh Cung - Nguyễn Ái Quốc
    // --> List<String> = {"Hồ Chí Minh", "Nguyễn Sinh Cung", "Nguyễn Ái Quốc"}
    public static List<String> removeMinusAtMiddle(String str, String root) {
        List<String> result = new ArrayList<>();
        for(String s : str.split("[-]")) {
            if(!s.strip().equals(root)) result.add(s.strip());
        }
        return result;
    }


    public static List<String> removeMinusAtMiddleAndRoundBrackets(String str) {
        List<String> result = new ArrayList<>();
        for(String s : str.split("[()-]")) {
            result.add(s.strip());
        }
        return result;
    }

    // { "Canh Dần 1890", "Kỉ Dậu 1969" }
    // --> { "1989", "1969" }
    public static String findNumbersInString(String str) {
        String result = "";
        if(str.equals("...")) return "Không rõ";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') result += str.charAt(i);
        }
        return result;
    }

    public static List<String> specForTenKhacNhanVat(String tenKhacNhanVat, String tenChinhNhanVat) {
        return removeMinusAtMiddle(tenKhacNhanVat, tenChinhNhanVat);
    }

    public static List<String> specForTenThoiKiString(String tenThoiKiString) {
        List<String> result = new ArrayList<>();
        for(String sp : tenThoiKiString.split("[)]")) {
            String tmp = sp.strip();
            tmp = removeMinusAtBegin(tmp);
            tmp = tmp.substring(0, tmp.indexOf('(')-1);
            result.add(tmp.strip());
        }
        return result;
    }

    public static List<String> specForTenThoiKiObject(String tenThoiKiString) {
        List<String> result = new ArrayList<>();
        for(String sp : tenThoiKiString.split("[()-]")) {
            result.add(sp.strip());
        }
        return result;
    }
}
