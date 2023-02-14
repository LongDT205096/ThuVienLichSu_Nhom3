package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;
import hust.oop.thuvienlichsu.entity.dto.ThoiKiDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"tenThoiKi" ,"tenSuKien", "tenDiaDiem", "info"})
public class NhanVat {
    private List<String> hoTen = new ArrayList<>();
    private String namSinh;
    private String namMat;
    private String queQuan;
    private List<ThoiKiDTO> danhSachThoiKi = new ArrayList<>();
    private List<DiaDiemDTO> danhSachDiaDiem = new ArrayList<>();
    private List<SuKienDTO> danhSachSuKien = new ArrayList<>();
    private List<String> tenThoiKi = new ArrayList<>();
    private List<String> tenSuKien = new ArrayList<>();
    private List<String> tenDiaDiem = new ArrayList<>();

    public List<String> info = new ArrayList<>();

    public NhanVat(){
    }

    public List<String> getHoTen() {
        return hoTen;
    }

    public void setHoTen(List<String> hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getNamMat() {
        return namMat;
    }

    public void setNamMat(String namMat) {
        this.namMat = namMat;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public List<ThoiKiDTO> getDanhSachThoiKi() {
        return danhSachThoiKi;
    }

    public void setDanhSachThoiKi(List<ThoiKiDTO> danhSachThoiKi) {
        this.danhSachThoiKi = danhSachThoiKi;
    }

    public List<DiaDiemDTO> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiemDTO> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public List<SuKienDTO> getDanhSachSuKien() {
        return danhSachSuKien;
    }

    public void setDanhSachSuKien(List<SuKienDTO> danhSachSuKien) {
        this.danhSachSuKien = danhSachSuKien;
    }

    public List<String> getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(List<String> tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
    }

    public List<String> getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(List<String> tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public List<String> getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(List<String> tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public void addHoTen(String hoTen) {
        this.hoTen.add(hoTen);
    }

    public void addThoiKi(ThoiKiDTO thoiKiDTO) {
        if(thoiKiDTO != null) this.danhSachThoiKi.add(thoiKiDTO);
    }

    public void addSuKien(SuKienDTO suKienDTO) {
        if(suKienDTO != null) this.danhSachSuKien.add(suKienDTO);
    }

    public void addDiaDiem(DiaDiemDTO diaDiemDTO) {
        if(diaDiemDTO != null) this.danhSachDiaDiem.add(diaDiemDTO);
    }

    @Override
    public String toString() {
        return "NhanVat [\n\thoTen=" + hoTen + ",\n\tnamSinh=" + namSinh + ",\n\tnamMat=" + namMat + ",\n\tqueQuan=" + queQuan
                + ",\n\tdanhSachThoiKi=" + danhSachThoiKi.toString() + ",\n\tdanhSachDiaDiem=" + danhSachDiaDiem.toString() + ",\n\tdanhSachSuKien="
                + danhSachSuKien.toString() + "\n]";
    }

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getHoTen().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }

    public void addThongTinLienQuan(){
        for(SuKienDTO element: this.danhSachSuKien){
            info.add("Sự kiện: " + element.getTenSuKien());
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
