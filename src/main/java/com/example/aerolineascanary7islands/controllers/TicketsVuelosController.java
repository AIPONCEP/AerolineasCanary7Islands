package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.aerolineascanary7islands.controllers.TicketsController.vuelosLista;

public class TicketsVuelosController {
    @FXML
    private VBox dynamicContainer;
    public void initialize() {
        // Lógica para agregar paneles con texto y botones en la misma fila
        for (int i = 0; i < vuelosLista.toArray().length; i++) {
            Label label = new Label("Vuelo Nº"+ i+1 + " Origen: " + vuelosLista.get(i).getProcedencia()
                    + " Destino: " + vuelosLista.get(i).getDestino()
                    + " Fecha de salida: " + vuelosLista.get(i).getFecha_Salida()
                    + " Fecha de llegada: " + vuelosLista.get(i).getFecha_Llegada()
                    + " Por: "+ vuelosLista.get(i).getPrecio() + "€ ");
            Button button = new Button("Reservar");
            label.setStyle("-fx-font-size: 14.5px;-fx-font-family: Berlin Sans FB"); // Cambia el tamaño de la fuente aquí
            HBox row = new HBox(); // Contenedor para una fila
            row.getChildren().addAll(label, button); // Agregar label y button al HBox
            dynamicContainer.getChildren().add(row); // Agregar la fila al VBox

            int finalI = i; // Se debe declarar finalI como final o usar una variable final para acceder dentro del lambda

            button.setOnAction(event -> {
                String labelText = ((Label)((HBox) button.getParent()).getChildren().get(0)).getText();
                System.out.println("Valor del Label en la fila " + (finalI + 1) + ": " + labelText);
                // Aquí puedes utilizar el valor del Label como desees
            });
        }
    }
}
