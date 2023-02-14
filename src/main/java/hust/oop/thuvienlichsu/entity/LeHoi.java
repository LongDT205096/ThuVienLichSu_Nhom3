package hust.oop.thuvienlichsu.entity;

import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"tenDiaDiem", "tenNhanVat", "nhanVatLienQuan", "info"})
public class LeHoi {
    private String tenLeHoi;
    private String ngayToChuc;
    private String diaDiemToChuc;
    private String ngayThanhLap;
    private List<String> tenDiaDiem = new ArrayList<>();
    private List<String> tenNhanVat = new ArrayList<>();
    private List<String> nhanVatLienQuan = new ArrayList<>();
    private List<NhanVatDTO> danhSachNhanVat = new ArrayList<>();
    private List<DiaDiemDTO> danhSachDiaDiem = new ArrayList<>();
    
    public List<String> info = new ArrayList<>();

    public List<String> getTenNhanVat() {
        return tenNhanVat;
    }

    public List<DiaDiemDTO> getDanhSachDiaDiem() {
        return danhSachDiaDiem;
    }

    public void setDanhSachDiaDiem(List<DiaDiemDTO> danhSachDiaDiem) {
        this.danhSachDiaDiem = danhSachDiaDiem;
    }

    public List<String> getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(List<String> tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public void setTenNhanVat(List<String> tenNhanVat) {
        this.tenNhanVat = tenNhanVat;
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
    public void addDiaDiem(DiaDiemDTO diaDiemDTO) {
        if(diaDiemDTO != null) this.danhSachDiaDiem.add(diaDiemDTO);
    }

    public String getTenLeHoi() {
        return tenLeHoi;
    }

    public void setTenLeHoi(String tenLeHoi) {
        this.tenLeHoi = tenLeHoi;
    }

    public List<String> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void setNhanVatLienQuan(List<String> nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan;
    }

    public void addNhanVatLienQuan(String nhanVat) {
        this.nhanVatLienQuan.add(nhanVat);
    }

    public String getDiaDiemToChuc() {
        return diaDiemToChuc;
    }

    public void setDiaDiemToChuc(String diaDiemToChuc) {
        this.diaDiemToChuc = diaDiemToChuc;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public LeHoi() {
    }

    @Override
    public String toString() {
        return "LeHoi [\n\ttenLeHoi=" + tenLeHoi + ",\n\tngayToChuc=" + ngayToChuc + ",\n\tdiaDiemToChuc=" + diaDiemToChuc
                + ",\n\tngayThanhLap=" + ngayThanhLap + ",\n\tnhanVatLienQuan=" + nhanVatLienQuan + "\n]";
    }


    public boolean filterProperty(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else if (this.getTenLeHoi().toString().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
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
    }

    public List<String> getThongTinLienQuan() {
        return info;
    }
}
