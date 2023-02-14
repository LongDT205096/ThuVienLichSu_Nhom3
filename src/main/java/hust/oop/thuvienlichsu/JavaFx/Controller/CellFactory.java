package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.scene.control.ListCell;
import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.entity.LeHoi;
import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;

public class CellFactory implements Callback<ListView<Object>, ListCell<Object>> {
    @Override
    public ListCell<Object> call(ListView<Object> param) {
        return new ListCell<>() {
            @Override
            public void updateItem(Object obj, boolean empty) {
                super.updateItem(obj, empty);
                if (empty || obj == null) {
                    setText(null);
                } else if(obj instanceof NhanVat){
                    setText(((NhanVat) obj).getHoTen().toString().replace("[", "").replace("]", ""));
                } else if(obj instanceof ThoiKi){
                    setText(((ThoiKi) obj).getTenThoiKi());
                } else if(obj instanceof DiaDiem){
                    setText(((DiaDiem) obj).getTenDiaDiem());
                } else if(obj instanceof SuKien){
                    setText(((SuKien) obj).getTenSuKien());
                } else if(obj instanceof LeHoi){
                    setText(((LeHoi) obj).getTenLeHoi());
                }
            }
        };
    }
}
