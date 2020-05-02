module allatkert.core {
    requires javafx.base;
    requires java.sql;
    requires sqlite.jdbc;
    requires javafx.graphics;
    requires java.desktop;
    exports hu.alkfejl.allatkert.model.bean;
    exports hu.alkfejl.allatkert.controller;
}