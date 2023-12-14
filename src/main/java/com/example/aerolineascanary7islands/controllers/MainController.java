package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.ManipulateBd;
import com.example.aerolineascanary7islands.models.RegisterModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class MainController {
    @FXML
    private Label mainTitle;
    public void initialize(){

    }
    public void loginClick(){
        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml", "login", mainTitle);
    }

}