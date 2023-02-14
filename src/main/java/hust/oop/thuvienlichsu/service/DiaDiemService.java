package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.DiaDiem;

import java.util.List;

public class DiaDiemService {
    private List<DiaDiem> danhSachDiaDiem;

    public List<DiaDiem> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiem> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public int findDiaDiemByTen(String ten) {
        int nf = -1;
        for(int i = 0; i < this.danhSachDiaDiem.size(); i++) {
            String s1 = this.danhSachDiaDiem.get(i).getTenDiaDiem().toLowerCase();
            String s2 = ten.toLowerCase();
            if(s1.contains(s2) || s2.contains(s1)) return i;
        }
        return nf;
    }
}
