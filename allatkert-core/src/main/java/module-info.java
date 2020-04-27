module allatkert.core {
    requires javafx.base;
    requires java.sql;
    requires sqlite.jdbc;
    exports hu.alkfejl.allatkert.controller;
    exports hu.alkfejl.allatkert.model.bean;
}