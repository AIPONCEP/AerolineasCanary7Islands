package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class MainController {
    @FXML
    private Label mainTitle;
    public void loginClick(){
        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml", "login", mainTitle);
    }
}