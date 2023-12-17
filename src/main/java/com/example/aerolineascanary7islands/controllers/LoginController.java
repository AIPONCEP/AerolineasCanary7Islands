package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.RegisterLoginModel.*;

public class LoginController {
    @FXML
    private Label loginTitle;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldContraseña;

    public static Usuario atributoUsuario;
    public void initialize(){
    }
    public void send(){
        Usuario usuario = findUsuario(textFieldEmail.getText(), textFieldContraseña.getText());
        if (usuario != null){
            atributoUsuario = usuario;
            if(esAdministrador(1,textFieldEmail.getText())){
                cambiarScene("/com/example/aerolineascanary7islands/showVuelos-view.fxml","Panel de Control de Vuelos",loginTitle);
            }else {
                cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml", "login", loginTitle);
            }
        }else {
            MethodsForControllers.showAlert("ERROR","No se encontro el usuario", Alert.AlertType.ERROR);
        }
    }
    public void registerClick(){
        cambiarScene("/com/example/aerolineascanary7islands/register-view.fxml","register", loginTitle);
    }
}
