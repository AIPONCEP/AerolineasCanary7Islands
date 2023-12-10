package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class LoginController {
    @FXML
    private Label loginTitle;

    public void initialize(){

    }

    public void send(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", loginTitle);
    }
    public void registerClick(){
        cambiarScene("/com/example/aerolineascanary7islands/register-view.fxml","register", loginTitle);

    }
}
