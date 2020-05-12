module allatkert.core {
    requires javafx.base;
    requires java.sql;
    requires sqlite.jdbc;
    requires javafx.graphics;
    requires java.desktop;
    requires bcrypt;
    requires javafx.controls;
    exports hu.alkfejl.allatkert.controller;
    exports hu.alkfejl.allatkert.model.bean;
    exports hu.alkfejl.allatkert.model;
    exports hu.alkfejl.allatkert.utils;
}