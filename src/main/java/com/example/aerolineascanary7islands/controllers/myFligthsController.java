package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.controllers.PerfilController.vuelosListaPerfil;

/**
 * myFligthsController
 * Controlador para la vista de vuelos del perfil del usuario.
 */
public class myFligthsController {
    @FXML
    private VBox dynamicContainer;
    @FXML
    public Pane paneAsiento;

    @FXML
    private Label labelTitle;

    private String codigoVueloSeleccionado;
    /**
     * initialize
     * Inicializa la vista de vuelos del perfil del usuario.
     */
    public void initialize() {
        int count = 1;
        // Lógica para agregar paneles con texto y botones en la misma fila




        for (int i = 0; i < vuelosListaPerfil.toArray().length; i++) {
            Label label = new Label("Vuelo Nº" + count++ + " Origen: " + vuelosListaPerfil.get(i).getProcedencia()
                    + " Destino: " + vuelosListaPerfil.get(i).getDestino()
                    + " Fecha de salida: " + vuelosListaPerfil.get(i).getFecha_Salida()
                    + " Fecha de llegada: " + vuelosListaPerfil.get(i).getFecha_Llegada()
                    + " Por: " + vuelosListaPerfil.get(i).getPrecio() + "€ ");
            Button button = new Button("Eliminar");
            label.setStyle("-fx-font-size: 14.5px;-fx-font-family: Berlin Sans FB"); // Cambia el tamaño de la fuente aquí
            HBox row = new HBox(); // Contenedor para una fila
            row.getChildren().addAll(label, button); // Agregar label y button al HBox
            dynamicContainer.getChildren().add(row); // Agregar la fila al VBox

            button.setId(vuelosListaPerfil.get(i).getCod_Vuelo());
            button.setOnAction(event -> {
                codigoVueloSeleccionado = ((Button) event.getSource()).getId();
                System.out.println(codigoVueloSeleccionado);
            });
        }
    }
    /**
     * salir
     * Sale de la vista actual y muestra la vista del perfil del usuario.
     */
    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml", "Perfil", labelTitle);
    }
}
