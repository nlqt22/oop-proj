module hust.oop.thuvienlichsu {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens hust.oop.thuvienlichsu to javafx.fxml;
    exports hust.oop.thuvienlichsu;
    exports hust.oop.thuvienlichsu.entity;
    exports hust.oop.thuvienlichsu.controller;
    // exports hust.oop.thuvienlichsu.service;
}