package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class PerfilController {
    @FXML
    private Label labelTitle;

    @FXML
    private Pane pane2;

    

    public void atras(){
        cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml","Vuelos", labelTitle);

    }

    public void actualizar(){
        pane2.setVisible(true);

    }


}
