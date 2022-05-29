
module core {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.activation;
    requires javafx.controlsEmpty;
    requires java.transaction;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;

    opens core to javafx.fxml;
    exports core;
    exports dto;
    exports core.controllers;
    opens core.controllers to javafx.fxml;
    exports utils;
    opens utils to javafx.fxml;
}
