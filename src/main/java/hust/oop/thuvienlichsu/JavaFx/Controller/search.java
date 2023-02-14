package hust.oop.thuvienlichsu.JavaFx.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.io.IOException;

import hust.oop.thuvienlichsu.entity.DiaDiem;
import hust.oop.thuvienlichsu.entity.LeHoi;
import hust.oop.thuvienlichsu.entity.NhanVat;
import hust.oop.thuvienlichsu.entity.SuKien;
import hust.oop.thuvienlichsu.entity.ThoiKi;
import hust.oop.thuvienlichsu.utils.JsonReader;

public class search extends ListCell<Object> {
    @FXML
    public Button detailButton;

    @FXML
    public TextField inputField;

    @FXML
    public ListView<Object> listViewer;

    @FXML
    public MenuButton menuList;

    @FXML
    public MenuItem listDiaDiem;

    @FXML
    public MenuItem listNhanVat;

    @FXML
    public MenuItem listSuKien;

    @FXML
    public MenuItem listThoiKi;

    @FXML
    public MenuItem listLeHoi;

    private JsonReader jsonReader;
    ObservableList<Object> list;

    @FXML
    public void initialize() throws IOException {
        this.jsonReader = new JsonReader();
        listViewer.setItems(null);
        detailButton.setVisible(false);

        listViewer.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Object>() {
                    @Override
                    public void changed(ObservableValue<? extends Object> observable, Object oldValue,
                                        Object newValue) {
                        if (newValue != null) {
                            displayDetailButton(newValue);
                        }
                    }
                });

        inputField.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue,
                                        String newValue) {
                        showFilteredString(newValue);
                    }
                });
    }

    void showFilteredString(String newValue) {
        FilteredList<Object> new_list = new FilteredList<>(list, null);

        if(menuList.getText() == "Nhân vật"){
            new_list.setPredicate(Object -> ((NhanVat) Object).filterProperty(newValue));
        } else if (menuList.getText() == "Thời kì"){
            new_list.setPredicate(Object -> ((ThoiKi) Object).filterProperty(newValue));
        } else if (menuList.getText() == "Địa điểm"){
            new_list.setPredicate(Object -> ((DiaDiem) Object).filterProperty(newValue));
        } else if (menuList.getText() == "Sự kiện"){
            new_list.setPredicate(Object -> ((SuKien) Object).filterProperty(newValue));
        } else if (menuList.getText() == "Lễ hội"){
            new_list.setPredicate(Object -> ((LeHoi) Object).filterProperty(newValue));
        }

        listViewer.setItems(new_list);
        listViewer.setCellFactory(new CellFactory());
    }

    void displayDetailButton(Object newValue) {
        detailButton.setVisible(true);
    }

    @FXML
    public void btnDetailPressed(ActionEvent event) {
        Object element = listViewer.getSelectionModel().getSelectedItem();
        new detailScreen(element);
    }

    @FXML
    public void showNhanVat(ActionEvent event) throws IOException {
        list = FXCollections.observableArrayList(jsonReader.readFileNhanVat());
        menuList.setText("Nhân vật");
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
    }

    @FXML
    public void showThoiKi(ActionEvent event) throws IOException {
        list = FXCollections.observableArrayList(jsonReader.readFileThoiKi());
        menuList.setText("Thời kì");
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
    }

    @FXML
    public void showDiaDiem(ActionEvent event) throws IOException {
        list = FXCollections.observableArrayList(jsonReader.readFileDiaDiem());
        menuList.setText("Địa điểm");
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
    }

    @FXML
    public void showSuKien(ActionEvent event) throws IOException {
        list = FXCollections.observableArrayList(jsonReader.readFileSuKien());
        menuList.setText("Sự kiện");
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
    }

    @FXML
    public void showLeHoi(ActionEvent event) throws IOException {
        list = FXCollections.observableArrayList(jsonReader.readFileLeHoi());
        menuList.setText("Lễ hội");
        listViewer.setItems(list);
        listViewer.setCellFactory(new CellFactory());
    }
}
