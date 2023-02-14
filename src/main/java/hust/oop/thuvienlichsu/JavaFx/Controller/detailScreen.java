package hust.oop.thuvienlichsu.JavaFx.Controller;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
 
public class detailScreen extends JFrame {
    private Object obj;
    
    public detailScreen(Object obj){
        this.obj = obj;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Detail");
        this.setSize(1280, 768);
        this.setVisible(true);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{           
                    FXMLLoader loader = new FXMLLoader(getClass()
                                            .getResource("/hust/oop/thuvienlichsu/JavaFx/FXML/detailScreen.fxml"));
                    loader.setController(new detail(obj));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }   
}
