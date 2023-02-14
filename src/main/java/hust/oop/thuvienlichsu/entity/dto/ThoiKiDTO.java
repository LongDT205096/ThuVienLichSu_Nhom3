package hust.oop.thuvienlichsu.entity.dto;

public class ThoiKiDTO {
    private String tenThoiKi;
    private String namBatDau;
    private String namKetThuc;

    public ThoiKiDTO(){

    }

    public ThoiKiDTO(String tenThoiKi, String namBatDau, String namKetThuc) {
        this.tenThoiKi = tenThoiKi;
        this.namBatDau = namBatDau;
        this.namKetThuc = namKetThuc;
    }

    public String getTenThoiKi() {
        return tenThoiKi;
    }

    public void setTenThoiKi(String tenThoiKi) {
        this.tenThoiKi = tenThoiKi;
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
        return "\n\t\tThoi ki: tenThoiKi=" + tenThoiKi + ", namBatDau=" + namBatDau + ", namKetThuc=" + namKetThuc;
    }

    
    
}
