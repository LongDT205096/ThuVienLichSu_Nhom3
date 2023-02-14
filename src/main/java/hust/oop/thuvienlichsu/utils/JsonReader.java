package hust.oop.thuvienlichsu.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.oop.thuvienlichsu.entity.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    public List<NhanVat> readFileNhanVat() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<NhanVat> list = mapper.readValue(new File("src/main/resources/json/nhanvat.json"),
                new TypeReference<List<NhanVat>>() {
                });

        return list;
    }

    public List<DiaDiem> readFileDiaDiem() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<DiaDiem> list = mapper.readValue(new File("src/main/resources/json/diadiem.json"),
                new TypeReference<List<DiaDiem>>() {
                });

        return list;
    }

    public List<ThoiKi> readFileThoiKi() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<ThoiKi> list = mapper.readValue(new File("src/main/resources/json/thoiki.json"),
                new TypeReference<List<ThoiKi>>() {
                });

        return list;
    }

    public List<SuKien> readFileSuKien() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        List<SuKien> list = mapper.readValue(new File("src/main/resources/json/sukien.json"),
            new TypeReference<List<SuKien>>() {
            });
            
        return list;
    }

    public List<LeHoi> readFileLeHoi() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        List<LeHoi> list = mapper.readValue(new File("src/main/resources/json/lehoi.json"),
                new TypeReference<List<LeHoi>>() {
                });

        return list;
    }
}
