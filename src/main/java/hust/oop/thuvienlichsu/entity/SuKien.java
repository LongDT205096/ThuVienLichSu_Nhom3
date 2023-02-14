package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.ThoiKiDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"tenNhanVat", "tenDiaDiem", "tenThoiKi", "info"})
public class SuKien {
    private String tenSuKien;
    private String namDienRa;
    private String namKetThuc;
    private String dienBien;
    private List<String> tenNhanVat = new ArrayList<>();
    private List<String> tenDiaDiem = new ArrayList<>();
    private List<String> tenThoiKi = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();
    private List<DiaDiemDTO> danhSachDiaDiem = new ArrayList<>();
    private List<ThoiKiDTO> danhSachThoiKi = new ArrayList<>();

    public List<String> info = new ArrayList<>();

    public List<String> getTenThoiKi() {
        return tenThoiKi;
    }

    public List<ThoiKiDTO> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    public void setDanhSachThoiKi(List<ThoiKiDTO> danhSachThoiKi) {
        this.danhSachThoiKi = danhSachThoiKi;
    }

    public void setTenThoiKi(List<String> tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public String getTenSuKien() {
        return tenSuKien;
    }
    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }
    public String getNamDienRa() {
        return namDienRa;
    }
    public void setNamDienRa(String namDienRa) {
        this.namDienRa = namDienRa;
    }
    public String getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(String namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    public String getDienBien() {
        return dienBien;
    }
    public void setDienBien(String dienBien) {
        this.dienBien = dienBien;
    }
    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }
    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }
    public List<String> getTenDiaDiem() {
        return tenDiaDiem;
    }
    public void setTenDiaDiem(List<String> tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public List<NhanVatDTO> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVatDTO> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public List<DiaDiemDTO> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiemDTO> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public void addNhanVat(NhanVatDTO nhanVatDTO) {
        if(nhanVatDTO != null) this.danhSachNhanVat.add(nhanVatDTO);
    }

    public void addDiaDiem(DiaDiemDTO diaDiemDTO) {
        if(diaDiemDTO != null) this.danhSachDiaDiem.add(diaDiemDTO);
    }

    public void addDThoiKi(ThoiKiDTO thoiKiDTO) {
        if(thoiKiDTO != null) danhSachThoiKi.add(thoiKiDTO);
    }

    @Override
    public String toString() {
        return "SuKien [\n\ttenSuKien=" + tenSuKien + ",\n\tnamDienRa=" + namDienRa + ",\n\tnamKetThuc=" + namKetThuc
                + ",\n\tdienBien=" + dienBien + ",\n\ttenNhanVat=" + tenNhanVat + ",\n\ttenDiaDiem=" + tenDiaDiem
                + ",\n\tdanhSachNhanVat=" + danhSachNhanVat + ",\n\tdanhSachDiaDiem=" + danhSachDiaDiem + "\n]";
    }

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenSuKien().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }

    public void addThongTinLienQuan(){
        for(NhanVatDTO element: this.danhSachNhanVat){
            info.add("Nhân vật: " + element.getHoTen());
        }
        for(DiaDiemDTO element: this.getDanhSachDiaDiem()){
            info.add("Địa điểm: " + element.getTenDiaDiem());
        }
        for(ThoiKiDTO element: this.getDanhSachThoiKi()){
            info.add("Thời kỳ: " + element.getTenThoiKi());
        }
    }

    public List<String> getThongTinLienQuan() {
        return info;
    }
}
