package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class RegisterController {
    @FXML
    private Label registerTitle;
    public void initialize(){

    }

    public void exitClick(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", registerTitle);

    }

    public void send(){
        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml","login", registerTitle);

    }
}
