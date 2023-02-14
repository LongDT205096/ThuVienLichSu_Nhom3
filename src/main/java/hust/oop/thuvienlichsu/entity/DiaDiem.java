package hust.oop.thuvienlichsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"tenNhanVat", "tenSuKien","info"})
public class DiaDiem {
    private String tenDiaDiem;
    private String noiDung;
    private List<String> tenSuKien = new ArrayList<>();
    private List<String> tenNhanVat = new ArrayList<>();
    private List<SuKienDTO> danhSachSuKien = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();
    
    public List<String> info = new ArrayList<>();

    public DiaDiem(){
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String ten) {
        this.tenDiaDiem = ten;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<String> getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(List<String> tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }

    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
    }

    public List<SuKienDTO> getDanhSachSuKien() {
        return danhSachSuKien;
    }

    public void setDanhSachSuKien(List<SuKienDTO> danhSachSuKien) {
        this.danhSachSuKien = danhSachSuKien;
    }

    public List<NhanVatDTO> getDanhSachNhanVat() {
        return danhSachNhanVat;
    }

    public void setDanhSachNhanVat(List<NhanVatDTO> danhSachNhanVat) {
        this.danhSachNhanVat = danhSachNhanVat;
    }

    public void addNhanVat(NhanVatDTO nhanVatDTO) {
        if(nhanVatDTO != null) this.danhSachNhanVat.add(nhanVatDTO);
    }

    public void addSuKien(SuKienDTO suKienDTO) {
        if(suKienDTO != null) this.danhSachSuKien.add(suKienDTO);
    }

    

    @Override
    public String toString() {
        return "DiaDiem [\n\ttenDiaDiem=" + tenDiaDiem + ",\n\tnoiDung=" + noiDung + ",\n\ttenSuKien=" + tenSuKien
                + ",\n\ttenNhanVat=" + tenNhanVat + ",\n\tdanhSachSuKien=" + danhSachSuKien + ",\n\tdanhSachNhanVat="
                + danhSachNhanVat + "\n]";
    }

    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenDiaDiem().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    		return true;
        }
        return false;
    }
    
    public void addThongTinLienQuan(){
        for(SuKienDTO element: this.danhSachSuKien){
            info.add("Sự kiện: " + element.getTenSuKien());
        }
        for(NhanVatDTO element: this.getDanhSachNhanVat()){
            info.add("Nhân vật: " + element.getHoTen());
        }
    }

    public List<String> getThongTinLienQuan() {
        return info;
    }
}
