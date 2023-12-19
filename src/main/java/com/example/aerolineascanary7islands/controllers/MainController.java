package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
/**
 * MainController
 * Controlador principal de la aplicación.
 */
public class MainController {
    @FXML
    private Label mainTitle;
    /**
     * loginClick
     * Método invocado al hacer clic en el botón de inicio de sesión.
     * Cambia la escena actual por la vista de inicio de sesión.
     */
    public void loginClick(){
        cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml", "login", mainTitle);
    }
}