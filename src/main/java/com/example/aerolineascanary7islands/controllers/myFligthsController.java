package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.controllers.TicketsController.vuelosLista;

public class myFligthsController {
    @FXML
    private VBox dynamicContainer;
    @FXML
    public Pane paneAsiento;

    @FXML
    private Label labelTitle;

    public void initialize() {
    }
    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml", "Perfil", labelTitle);
    }
}
