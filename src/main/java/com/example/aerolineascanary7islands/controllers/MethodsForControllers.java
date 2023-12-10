package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MethodsForControllers {
    public static void cambiarScene(String ruta, String title, Label labeltitle){
        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(MethodsForControllers.class.getResource(ruta)));
            Stage window = (Stage) labeltitle.getScene().getWindow();
            window.setScene(scene);
            window.setTitle(title);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
