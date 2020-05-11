module hu.alkfejl {
    requires javafx.controls;
    requires javafx.fxml;
    requires allatkert.core;
    requires org.apache.commons.io;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;

    opens hu.alkfejl.view.controller to javafx.fxml;
    exports hu.alkfejl;
}