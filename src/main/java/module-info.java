module com.example.aerolineascanary7islands {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aerolineascanary7islands to javafx.fxml;
    exports com.example.aerolineascanary7islands;
}