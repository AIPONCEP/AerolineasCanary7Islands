package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import com.example.aerolineascanary7islands.models.VuelosModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
public class UpdateVueloController {
    @FXML
    public TextField textPrecio;
    @FXML
    public TextField textFechaSalida;
    @FXML
    public TextField textFechaLlegada;
    @FXML
    public Label actualizarTitle;
    public void actualizar(MouseEvent mouseEvent) {
        if (textPrecio.getText() != null) {
            float nuevoPrecio = Float.parseFloat(textPrecio.getText());
            if (nuevoPrecio > 0.0f) { // Verificar que el nuevo precio sea válido
                ShowVuelosController.vueloParaActualizar.setPrecio(nuevoPrecio);
                VuelosModel.updateVuelo(ShowVuelosController.vueloParaActualizar);
            } else {
                MethodsForControllers.showAlert("Error", "El precio no es valido", Alert.AlertType.ERROR);
            }
        }
        if (textFechaSalida.getText() != null) {
            if (textFechaSalida.getText().matches(MakeTravelController.expRegularFecha)) {
                if (Vuelo.validarFechas(textFechaSalida.getText(), ShowVuelosController.vueloParaActualizar.getFecha_Llegada())) {
                    ShowVuelosController.vueloParaActualizar.setFecha_Salida(textFechaSalida.getText());
                    VuelosModel.updateVuelo(ShowVuelosController.vueloParaActualizar);
                } else {
                    MethodsForControllers.showAlert("Error", "La fecha de salida no puede ser posterior a la fecha de llegada", Alert.AlertType.ERROR);
                }
            } else {
                MethodsForControllers.showAlert("Error", "La fecha de salida no es valida", Alert.AlertType.ERROR);
            }
        }
        if (textFechaLlegada.getText() != null) {
            if (textFechaLlegada.getText().matches(MakeTravelController.expRegularFecha)) {
                if (Vuelo.validarFechas(ShowVuelosController.vueloParaActualizar.getFecha_Salida(), textFechaLlegada.getText())) {
                    ShowVuelosController.vueloParaActualizar.setFecha_Llegada(textFechaLlegada.getText());
                    VuelosModel.updateVuelo(ShowVuelosController.vueloParaActualizar);
                } else {
                    MethodsForControllers.showAlert("Error", "La fecha de llegada no puede ser anterior a la fecha de salida", Alert.AlertType.ERROR);
                }
            } else {
                MethodsForControllers.showAlert("Error", "La fecha de salida no es valida", Alert.AlertType.ERROR);
            }
        }
    }
    public void volver(MouseEvent mouseEvent) {
        MethodsForControllers.cambiarScene("/com/example/aerolineascanary7islands/showVuelos-view.fxml","Show Vuelos",actualizarTitle);
    }
}
