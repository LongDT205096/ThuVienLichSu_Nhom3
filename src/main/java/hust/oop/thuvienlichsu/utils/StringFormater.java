package hust.oop.thuvienlichsu.utils;

import java.util.ArrayList;
import java.util.List;

public class StringFormater {
    // "- Dựng nước (2000 - 258 trCN)"
    public static String removeMinusAtBegin(String str) {
        return str.substring(2, str.length()).strip();
    }

    // Hồ Chí Minh - Nguyễn Sinh Cung - Nguyễn Ái Quốc
    // --> List<String> = {"Hồ Chí Minh", "Nguyễn Sinh Cung", "Nguyễn Ái Quốc"}
    public static List<String> removeMinusAtMiddle(String str, String root) {
        List<String> result = new ArrayList<>();
        if(str.charAt(0) == '-') result.add("Không rõ");
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
        int trcn = 0;
        if(str.equals("...") || str.equals("…")) return "Không rõ";
        if(str.toLowerCase().contains("trcn")) trcn = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') result += str.charAt(i);
        }
        if(trcn == 1) result += " TrCN";
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
            if(tmp.indexOf('(') > 0) tmp = tmp.substring(0, tmp.indexOf('(')-1);
            result.add(tmp.strip());
        }
        return result;
    }

    public static List<String> splitStringInTitle(String title) {
        List<String> resultTmp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(String s : title.split("[()]")) {
            resultTmp.add(s.strip());
        }
        result.add(resultTmp.get(0));
        if(resultTmp.size() > 1) {
            for(String s : resultTmp.get(1).split("[-]")) {
                result.add(s.strip());
            }
        }
        return result;
    }
}
