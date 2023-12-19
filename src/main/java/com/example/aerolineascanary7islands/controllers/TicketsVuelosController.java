package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.BilleteComprado;
import com.example.aerolineascanary7islands.models.Pasajero;
import com.example.aerolineascanary7islands.models.Vuelo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.aerolineascanary7islands.controllers.LoginController.atributoUsuario;
import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.controllers.TicketsController.vuelosLista;
import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;
/**
 * Controlador para la vista de selección de vuelos y reserva de billetes.
 */
public class TicketsVuelosController {
    @FXML
    private VBox dynamicContainer;
    @FXML
    public Pane paneAsiento;
    @FXML
    public Label labelTitle;
    @FXML
    public ToggleGroup tipoAsiento;

    private String codigoVueloSeleccionado;

    private Vuelo vueloSeleccionado;
    /**
     * Inicializa la vista de selección de vuelos.
     */
    public void initialize() {
        paneAsiento.setVisible(false);
        int count = 1;
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

            button.setId(vuelosLista.get(i).getCod_Vuelo());
            button.setOnAction(event -> {
                paneAsiento.setVisible(true);
                codigoVueloSeleccionado = ((Button) event.getSource()).getId();
            });
        }
    }
    /**
     * Cancela la selección de asiento y oculta el panel.
     */
    public void cancelar(){
        paneAsiento.setVisible(false);
    }
    /**
     * Confirma la reserva del billete seleccionado.
     */
    public void confirmar(){
        RadioButton selectedRadioButton = (RadioButton) tipoAsiento.getSelectedToggle();
        Pasajero pasajero = new Pasajero(selectedRadioButton.getText(), atributoUsuario, null);
        pasajero.setId_Pasajero(atributoUsuario.getId());

        // Obtener el vuelo seleccionado basado en el código del vuelo

        for (Vuelo vuelo : vuelosLista) {

            System.out.println(codigoVueloSeleccionado);
            if (vuelo.getCod_Vuelo().equals(codigoVueloSeleccionado)) {
                vuelo.setBilletesCompradosList(null);
                vueloSeleccionado = vuelo;
                break;
            }
        }

        if (vueloSeleccionado != null) {
            // Crear el objeto BilletesComprados con los datos recolectados
            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaFormateada = fechaHora.format(formatter);
            BilleteComprado billete = new BilleteComprado(fechaFormateada,vueloSeleccionado.getCod_Vuelo(), pasajero.getId_Pasajero(),null,null);
            insert(pasajero);
            insert(billete);
        } else {
            System.out.println("El vuelo seleccionado no fue encontrado en la lista de vuelos.");
        }

        paneAsiento.setVisible(false);
    }
    /**
     * Sale de la vista actual y muestra la vista de tickets.
     */
    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml", "Tickets", labelTitle);

    }
}
