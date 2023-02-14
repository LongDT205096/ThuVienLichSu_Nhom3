package hust.oop.thuvienlichsu.JavaFx.Controller;

import java.io.IOException;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class searchScreen extends JFrame {
    public searchScreen() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("LichSuVietNam");
        this.setSize(1280, 768);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/oop/thuvienlichsu/JavaFx/FXML/searchScreen.fxml"));
                    loader.setController(new search());
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}  
