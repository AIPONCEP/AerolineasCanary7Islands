package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;
//import static com.example.aerolineascanary7islands.models.RegisterModel.getUsuario;
import com.example.aerolineascanary7islands.models.ManipulateBd;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private Label registerTitle;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldContraseña;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldMail;
    public void initialize(){
    }
    public void exitClick(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", registerTitle);
    }
    public void send(){
        Usuario usuario = new Usuario(textFieldNombre.getText(),textFieldContraseña.getText(),textFieldMail.getText(), Integer.parseInt(textFieldTelefono.getText()));
        insert(usuario);
        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml","login", registerTitle);
    }
}
