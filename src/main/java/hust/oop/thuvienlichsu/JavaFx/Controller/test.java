package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

import hust.oop.thuvienlichsu.entity.dto.DiaDiemDTO;
import hust.oop.thuvienlichsu.entity.dto.NhanVatDTO;
import hust.oop.thuvienlichsu.entity.dto.SuKienDTO;
import hust.oop.thuvienlichsu.entity.dto.ThoiKiDTO;

public class test implements Callback<ListView<Object>, ListCell<Object>> {
    @Override
    public ListCell<Object> call(ListView<Object> param) {
        return new ListCell<>() {
            @Override
            public void updateItem(Object obj, boolean empty) {
                super.updateItem(obj, empty);
                if (empty || obj == null) {
                    setText(null);
                } else if(obj instanceof NhanVatDTO){
                    setText("Nhan vat" + ((NhanVatDTO) obj).getHoTen().toString().replace("[", "").replace("]", ""));
                } else if(obj instanceof ThoiKiDTO){
                    setText(((ThoiKiDTO) obj).getTenThoiKi());
                } else if(obj instanceof DiaDiemDTO){
                    setText(((DiaDiemDTO) obj).getTenDiaDiem());
                } else if(obj instanceof SuKienDTO){
                    setText("Su kien" + ((SuKienDTO) obj).getTenSuKien());
                }
            }
        };
    }
}
