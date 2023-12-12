package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.RegisterModel.getUsuario;

public class LoginController {
    @FXML
    private Label loginTitle;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldContraseña;

    public void initialize(){

    }

    public void send(){
        if (getUsuario()){
            cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", loginTitle);
        }else {
            MethodsForControllers.showAlert("ERROR","No se encontro el usuario", Alert.AlertType.ERROR);
        }


    }
    public void registerClick(){
        cambiarScene("/com/example/aerolineascanary7islands/register-view.fxml","register", loginTitle);

    }
}
