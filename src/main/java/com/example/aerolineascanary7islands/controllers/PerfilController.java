package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.List;

import static com.example.aerolineascanary7islands.controllers.LoginController.atributoUsuario;
import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.controllers.TicketsController.vuelosLista;
import static com.example.aerolineascanary7islands.models.PerfilModel.updateUser;
import static com.example.aerolineascanary7islands.models.myFlightsModel.findVueloTickets;

/**
 * Controlador para la vista de perfil.
 */
public class PerfilController {
    // Etiquetas y campos de entrada definidos en la interfaz gráfica
    @FXML
    private Label labelTitle;
    @FXML
    private Pane pane2;
    @FXML
    private ComboBox comboBoxFields;
    @FXML
    public TextField textFieldUpdate;
    @FXML
    private Label labelNew;
    @FXML
    private Label labelContraseña;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelMail;
    @FXML
    private Label labelTelefono;
    private String selectedValue = "";

    // Lista de vuelos para el perfil del usuario
    public static List<Vuelo> vuelosListaPerfil;

    /**
     * Inicializa la vista del perfil.
     */
    public void initialize() {
        // Configura los elementos del ComboBox
        comboBoxFields.getItems().add("Nombre");
        comboBoxFields.getItems().add("Contraseña");
        comboBoxFields.getItems().add("Mail");
        comboBoxFields.getItems().add("Telefono");

        // Establece los valores de las etiquetas con la información del usuario actual
        labelNombre.setText(atributoUsuario.getNombre());
        labelContraseña.setText(atributoUsuario.getContraseña());
        labelMail.setText(atributoUsuario.getMail());
        labelTelefono.setText(String.valueOf(atributoUsuario.getTlf()));

        // Escucha los cambios en la selección del ComboBox
        comboBoxFields.valueProperty().addListener((obs, oldValue, newValue) -> {
            selectedValue = newValue.toString();
            labelNew.setText("Nuevo " + newValue + ":");
        });

        // Si el panel 2 está visible, lo oculta
        if (pane2.isVisible()) {
            pane2.setVisible(false);
        }
    }

    /**
     * Método para salir de la vista actual.
     */
    public void salir() {
        cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml", "Vuelos", labelTitle);
    }

    /**
     * Método para actualizar la información del usuario.
     */
    public void actualizar() {
        if (pane2.isVisible()) {
            pane2.setVisible(false);
        } else {
            pane2.setVisible(true);
        }
    }

    /**
     * Confirma la actualización de los datos del usuario.
     */
    public void confirmar() {
        if (!textFieldUpdate.getText().isEmpty()) {
            if (updateUser(atributoUsuario, selectedValue, textFieldUpdate.getText())) {
                cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml", "perfil", labelTitle);
            } else {
                MethodsForControllers.showAlert("ERROR", "Ese valor no es válido para el campo " + selectedValue, Alert.AlertType.ERROR);
            }
        } else {
            MethodsForControllers.showAlert("ERROR", "El campo a actualizar está vacío", Alert.AlertType.ERROR);
        }
    }

    /**
     * Muestra los vuelos del usuario.
     */
    public void verVuelos() {
        if (findVueloTickets(atributoUsuario.getId()) != null) {
            vuelosListaPerfil = findVueloTickets(atributoUsuario.getId());
            cambiarScene("/com/example/aerolineascanary7islands/myFlights-view.fxml", "Mis vuelos", labelTitle);
        } else {
            MethodsForControllers.showAlert("ERROR", "No tiene ningún billete comprado", Alert.AlertType.ERROR);
        }
    }
}
