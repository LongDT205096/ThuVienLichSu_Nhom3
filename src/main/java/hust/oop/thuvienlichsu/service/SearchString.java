
package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.entity.LeHoi;
import hust.oop.thuvienlichsu.utils.JsonReader;

import java.io.IOException;

public class SearchString {
    private JsonReader jsonReader;
    
    public Object filterProperty1(String filter) throws IOException {
        this.jsonReader = new JsonReader();
        if (filter.charAt(0) == 'Đ') {
            for (DiaDiem diaDiem : jsonReader.readFileDiaDiem())
                if (filter.contains(diaDiem.getTenDiaDiem())) {
                    return diaDiem;
                }
        }
        if (filter.charAt(0) == 'N') {
            for (NhanVat nhanVat : jsonReader.readFileNhanVat())
                if (filter.contains(nhanVat.getHoTen().get(0))) {
                    return nhanVat;
                }
        }
        if (filter.charAt(0) == 'S') {
            for (SuKien suKien : jsonReader.readFileSuKien())
                if (filter.contains(suKien.getTenSuKien())) {
                    return suKien;
                }
        }
        if (filter.charAt(0) == 'T') {
            for (ThoiKi thoiKi : jsonReader.readFileThoiKi())
                if (filter.contains(thoiKi.getTenThoiKi())) {
                    return thoiKi;
                }
        }
        if (filter.charAt(0) == 'L') {
            for (LeHoi leHoi : jsonReader.readFileLeHoi())
                if (filter.contains(leHoi.getTenLeHoi())) {
                    return leHoi;
                }
        }
        return "Không tìm thấy";
    }
}
