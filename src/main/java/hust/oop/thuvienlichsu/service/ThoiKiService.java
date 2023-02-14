package hust.oop.thuvienlichsu.service;

import hust.oop.thuvienlichsu.entity.ThoiKi;

import java.util.List;

public class ThoiKiService {
    private List<ThoiKi> danhSachThoiKi;

    public ThoiKiService() {
    }
    public List<ThoiKi> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }
    public void setDanhSachThoiKi(List<ThoiKi> danhSachThoiKi) {
        this.danhSachThoiKi = danhSachThoiKi;
    }

    public int findThoiKiByTen(String ten) {
        int notfound = -1;
        for(int i = 0; i < danhSachThoiKi.size(); i++) {
            if(ten.equals(danhSachThoiKi.get(i).getTenThoiKi())) return i;
        }
        return notfound;
    }

}
