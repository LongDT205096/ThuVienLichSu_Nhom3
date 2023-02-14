package hust.oop.thuvienlichsu;

import hust.oop.thuvienlichsu.utils.JsonWriter;

public class GettingData {
    public GettingData() {
        JsonWriter writer = new JsonWriter();
        writer.thoiKiFileWriter();
        writer.nhanVatFileWriter();
        writer.suKienFileWriter();
        writer.diaDiemFileWriter();
        writer.leHoiFileWriter();
    }
}
 
