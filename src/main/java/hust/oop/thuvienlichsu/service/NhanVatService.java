package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.NhanVat;

import java.util.ArrayList;
import java.util.List;

public class NhanVatService {
    private List<NhanVat> danhSachNhanVat = new ArrayList<>();

    public NhanVatService() {
    }

    public List<NhanVat> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVat> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public int findNhanVatByHoTen(String tenNhanVat) {
        int nf = -1;
        for(int i = 0; i < this.danhSachNhanVat.size(); i++) {
            List<String> hoTen = this.danhSachNhanVat.get(i).getHoTen();
            for(String t : hoTen) {
                String s1 = t.toLowerCase();
                String s2 = tenNhanVat.toLowerCase();
                if(s1.contains(s2) || s2.contains(s1)) return i;
            }
        }
        return nf;
    }

}
