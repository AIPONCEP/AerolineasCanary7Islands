package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.RegisterModel.getUsuario;
import static com.example.aerolineascanary7islands.models.RegisterModel.insertUsuario;

public class RegisterController {
    @FXML
    private Label registerTitle;
    public void initialize(){
        Usuario usuario = new Usuario("Nombre","Pass","Mail",100000000);
        getUsuario(usuario);
    }

    public void exitClick(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", registerTitle);

    }

    public void send(){

        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml","login", registerTitle);

    }
}
