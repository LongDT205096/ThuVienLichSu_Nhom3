module hust.oop.thuvienlichsu {
    requires transitive javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.swing;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.jsoup;

    opens hust.oop.thuvienlichsu to javafx.fxml;
    exports hust.oop.thuvienlichsu;
    exports hust.oop.thuvienlichsu.entity;
    exports hust.oop.thuvienlichsu.entity.dto;
    exports hust.oop.thuvienlichsu.JavaFx.Controller;
}
