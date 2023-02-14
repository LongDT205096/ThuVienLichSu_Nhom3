package hust.oop.thuvienlichsu.entity.dto;

public class DiaDiemDTO {
    private String tenDiaDiem;

    public DiaDiemDTO(){
    }

    public DiaDiemDTO(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    @Override
    public String toString() {
        return tenDiaDiem;
    }
}
