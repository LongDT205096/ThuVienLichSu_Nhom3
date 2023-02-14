package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = { "tenSuKien", "tenNhanVat", "info"})
public class ThoiKi {
    private String tenThoiKi;
    private String namBatDau;
    private String namKetThuc;
    private List<String> tenNhanVat = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();
    private List<SuKienDTO> danhSachSuKien = new ArrayList<>();
    
    public List<String> info = new ArrayList<>();

    public void setTenThoiKi(String tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public void setDanhSachSuKien(List<SuKienDTO> danhSachSuKien) {
        this.danhSachSuKien = danhSachSuKien;
    }

    public void setTenSuKien(List<String> tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public void setDanhSachNhanVat(List<NhanVatDTO> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }

    public String getTenThoiKi() {
        return tenThoiKi;
    }
    public List<SuKienDTO> getDanhSachSuKien() {
        return danhSachSuKien;
    }

    public List<String> getTenSuKien() {
        return tenSuKien;
    }

    public List<NhanVatDTO> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }

    public String getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(String namBatDau) {
        this.namBatDau = namBatDau;
    }

    public String getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(String namKetThuc) {
        this.namKetThuc = namKetThuc;
    }
    public void addNhanVat(NhanVatDTO nhanVatDTO) {
        if(nhanVatDTO != null) this.danhSachNhanVat.add(nhanVatDTO);
    }
    public void addSuKien(SuKienDTO suKienDTO) {
        if(suKienDTO != null) this.danhSachSuKien.add(suKienDTO);
    }

    @Override
    public String toString() {
        return "ThoiKi [\n\ttenThoiKi=" + tenThoiKi + ",\n\tnamBatDau=" + namBatDau + ",\n\tnamKetThuc=" + namKetThuc
                + ",\n\tdanhSachSuKien=" + danhSachSuKien.toString() + ",\n\tdanhSachNhanVat=" + danhSachNhanVat.toString() + "\n]";
    }

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenThoiKi().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }

    public void addThongTinLienQuan(){
        for(NhanVatDTO element: this.danhSachNhanVat){
            info.add("Nhân vật: " + element.getHoTen());
        }
        for(SuKienDTO element: this.getDanhSachSuKien()){
            info.add("Sự kiện: " + element.getTenSuKien());
        }
    }

    public List<String> getThongTinLienQuan() {
        return info;
    }
}
