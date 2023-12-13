module com.example.aerolineascanary7islands {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;

    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;

    opens com.example.aerolineascanary7islands to javafx.fxml;
    exports com.example.aerolineascanary7islands;
    exports com.example.aerolineascanary7islands.controllers;
    opens com.example.aerolineascanary7islands.controllers to javafx.fxml;
    opens com.example.aerolineascanary7islands.models to org.hibernate.orm.core;

}