package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Pasajero;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.aerolineascanary7islands.controllers.LoginController.atributoUsuario;
import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.controllers.TicketsController.vuelosLista;
import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;

public class TicketsVuelosController {
    @FXML
    private VBox dynamicContainer;
    @FXML
    public Pane paneAsiento;
    @FXML
    public Label labelTitle;
    @FXML
    public ToggleGroup tipoAsiento;



    public void initialize() {
        paneAsiento.setVisible(false);
        int count = 0;
        // Lógica para agregar paneles con texto y botones en la misma fila
        for (int i = 0; i < vuelosLista.toArray().length; i++) {
            Label label = new Label("Vuelo Nº"+ count++ + " Origen: " + vuelosLista.get(i).getProcedencia()
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
                paneAsiento.setVisible(true);

                String labelText = ((Label)((HBox) button.getParent()).getChildren().get(0)).getText();
                System.out.println("Valor del Label en la fila " + (finalI + 1) + ": " + labelText);
                Pasajero pasajero = new Pasajero();

            });
        }
    }

    public void cancelar(){
        paneAsiento.setVisible(false);
    }

    public void confirmar(){
        RadioButton selectedRadioButton = (RadioButton) tipoAsiento.getSelectedToggle();
        Pasajero pasajero = new Pasajero(selectedRadioButton.getText(), atributoUsuario, null);
        pasajero.setId_Pasajero(atributoUsuario.getId());
        System.out.println(atributoUsuario.getId());
        insert(pasajero);

        paneAsiento.setVisible(false);
    }

    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml", "Tickets", labelTitle);

    }
}
