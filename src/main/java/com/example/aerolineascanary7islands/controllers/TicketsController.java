package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.TicketsModel.findVuelo;
/**
 * Controlador para la vista de selección y reserva de vuelos.
 */
public class TicketsController {
    // Elementos de la interfaz gráfica
    @FXML
    private StackPane carrousel;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Label labelTitle;
    @FXML
    private Pane paneBg;
    @FXML
    private Pane paneSelection;
    @FXML
    private ComboBox comboBoxOrigen;
    @FXML
    private ComboBox comboBoxDestino;
    @FXML
    private Spinner spinnerIda;
    @FXML
    private Spinner spinnerVuelta;
    private int indice = 0;
    public static List<Vuelo> vuelosLista;
    /**
     * Inicializa la vista de selección y reserva de vuelos.
     */
    public void initialize() {
        // Configuraciones iniciales
        paneBg.setVisible(false);
        paneSelection.setVisible(false);
        // Llenar los ComboBox con nombres de islas
        List<String> islasCanarias = Arrays.asList("Tenerife", "Gran Canaria", "Lanzarote", "Fuerteventura", "La Palma");
        comboBoxOrigen.getItems().addAll(islasCanarias);
        comboBoxDestino.getItems().addAll(islasCanarias);
        // Configuración de los Spinners para fechas de ida y vuelta
        SpinnerValueFactory<LocalDate> idaValueFactory = new SpinnerValueFactory<>() {
            @Override
            public void decrement(int steps) {
                setValue(getValue().minusDays(steps));
            }
            @Override
            public void increment(int steps) {
                setValue(getValue().plusDays(steps));
            }
        };
        // Convertidores para mostrar fechas en los Spinners
        spinnerIda.setValueFactory(idaValueFactory);
        idaValueFactory.setValue(LocalDate.now());
        // Configurar Spinner de vuelta con un día después de la fecha actual
        SpinnerValueFactory<LocalDate> vueltaValueFactory = new SpinnerValueFactory<>() {
            @Override
            public void decrement(int steps) {
                setValue(getValue().minusDays(steps));
            }
            @Override
            public void increment(int steps) {
                setValue(getValue().plusDays(steps));
            }
        };
        spinnerVuelta.setValueFactory(vueltaValueFactory);
        vueltaValueFactory.setValue(LocalDate.now().plusDays(1));
        // Convertidores para mostrar fechas en los Spinners
        StringConverter<LocalDate> converter = new StringConverter<>() {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return dateFormatter.format(object);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        spinnerIda.getValueFactory().setConverter(converter);
        spinnerVuelta.getValueFactory().setConverter(converter);
        // Inicializar la animación para cambiar las imágenes
        Duration duration = Duration.seconds(4); // Cambia cada 3 segundos
        Timeline timeline = new Timeline(new KeyFrame(duration, e -> cambiarImagen()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    /**
     * Redirige a la vista del perfil.
     */
    public void perfilClick(){
        cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml","Informacion personal", labelTitle);
    }
    /**
     * Cierra la ventana actual y muestra la vista principal.
     */
    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml", "Main", labelTitle);
    }
    /**
     * Muestra el panel para reservar vuelos.
     */
    public void reservar(){
        paneBg.setVisible(true);
        paneSelection.setVisible(true);
    }
    /**
     * Cambia la imagen visible entre dos paneles.
     */
    private void cambiarImagen() {
        if (indice == 0) {
            pane1.setVisible(false);
            pane2.setVisible(true);
            indice = 1;
        } else {
            pane1.setVisible(true);
            pane2.setVisible(false);
            indice = 0;
        }
    }
    /**
     * Oculta el panel de reserva de vuelos.
     */
    public void salirPane(){
        paneBg.setVisible(false);
        paneSelection.setVisible(false);
    }
    /**
     * Busca vuelos disponibles según los criterios seleccionados.
     */
    public void buscarVuelo(){
        /*
                if(Vuelo.validarFechas(spinnerIda.getValue().toString(),spinnerVuelta.getValue().toString())){
        }else{
            MethodsForControllers.showAlert("Error","La fecha de Llegada no puede ser anterior a la fecha de salida", Alert.AlertType.ERROR);
        }
         */
            vuelosLista = findVuelo(comboBoxOrigen.getValue().toString(), comboBoxDestino.getValue().toString(), spinnerIda.getValue().toString(), spinnerVuelta.getValue().toString());
            if (vuelosLista != null){
                cambiarScene("/com/example/aerolineascanary7islands/flightsTickets-view.fxml", "Vuelos disponible", labelTitle);
            }else {
                MethodsForControllers.showAlert("ERROR", "No se encontro ningun vuelo", Alert.AlertType.ERROR);
            }


    }
}
