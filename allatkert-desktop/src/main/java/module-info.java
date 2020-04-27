module hu.alkfejl {
    requires javafx.controls;
    requires javafx.fxml;
    requires allatkert.core;

    opens hu.alkfejl to javafx.fxml;
    exports hu.alkfejl;
}