package hust.oop.thuvienlichsu.entity.dto;

import java.util.List;

public class NhanVatDTO {
    private String hoTen;
    private List<String> tenGoiKhac;
    private String namSinh;
    private String namMat;
    private String queQuan;

    public NhanVatDTO(){
    }

    public NhanVatDTO(String hoTen, List<String> tenGoiKhac, String namSinh, String namMat, String queQuan) {
        this.hoTen = hoTen;
        this.tenGoiKhac = tenGoiKhac;
        this.namSinh = namSinh;
        this.namMat = namMat;
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
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

    public List<String> getTenGoiKhac() {
        return tenGoiKhac;
    }

    public void setTenGoiKhac(List<String> tenGoiKhac) {
        this.tenGoiKhac = tenGoiKhac;
    }

    @Override
    public String toString() {
        return "\n\t\thoTen=" + hoTen + ", tenGoiKhac=" + tenGoiKhac + ", namSinh=" + namSinh + ", namMat="
                + namMat + ", queQuan=" + queQuan;
    }

    
}
