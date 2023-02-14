package hust.oop.thuvienlichsu.JavaFx.Controller;

import java.io.IOException;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.entity.LeHoi;
import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.service.SearchString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class detail {
    @FXML
    public Button backButton;

    @FXML
    public Button detailButton;

    @FXML
    public TextArea textDetail;

    @FXML
    public ListView listDetail;

    private Object obj;
    public detail(Object obj){
        this.obj = obj;
    }
    
    ObservableList<String> list;
    @FXML public void initialize(){
        textDetail.setText(obj.toString());
        showListView();
    }

    SearchString search = new SearchString();

    void showListView(){
        if(obj instanceof NhanVat){
            list = FXCollections.observableList(((NhanVat) obj).getThongTinLienQuan());
        } else if(obj instanceof DiaDiem) {
            list = FXCollections.observableList(((DiaDiem) obj).getThongTinLienQuan());
        } else if (obj instanceof ThoiKi){
            list = FXCollections.observableList(((ThoiKi) obj).getThongTinLienQuan());
        } else if (obj instanceof SuKien){
            list = FXCollections.observableList(((SuKien) obj).getThongTinLienQuan());
        } else if (obj instanceof LeHoi){
            list = FXCollections.observableList(((LeHoi) obj).getThongTinLienQuan());
        }
        
        listDetail.setItems(list);
    }

    @FXML
    public void backToSearchScreen(ActionEvent event) {
        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=1; i<win.length; i++){
            win[i].setVisible(false);
        }
    }

    @FXML
    public void btnDetailPressed(ActionEvent event) throws IOException {
        String element = (String) listDetail.getSelectionModel().getSelectedItem();
        new detailScreen(search.filterProperty1(element));
    }
}
