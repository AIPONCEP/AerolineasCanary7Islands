package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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
    public static void showAlert(String title, String message, javafx.scene.control.Alert.AlertType alertType) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /**
     * showAlertConfirmation
     * Se utiliza para mostrar un cuadro de dialogo donde puedes aceptar o cancelar algo...
     * @param title
     * @param message
     * @param alertType
     * @return true o false según presionas ok o cancelas la operación
     */
    public static boolean showAlertConfimation(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
          return true;
        } else {
          return false;
        }
    }
}
