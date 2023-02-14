package hust.oop.thuvienlichsu.entity.dto;

public class SuKienDTO {
    private String tenSuKien;
    private String namBatDau;
    private String namKetThuc;

    public SuKienDTO(){
    }

    public SuKienDTO(String tenSuKien, String namBatDau, String namKetThuc) {
        this.tenSuKien = tenSuKien;
        this.namBatDau = namBatDau;
        this.namKetThuc = namKetThuc;
    }
    public String getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
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

    @Override
    public String toString() {
        return "\n\t\ttenSuKien=" + tenSuKien + ", namBatDau=" + namBatDau + ", namKetThuc=" + namKetThuc;
    }
}
