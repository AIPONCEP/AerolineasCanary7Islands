package com.example.aerolineascanary7islands.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static com.example.aerolineascanary7islands.controllers.LoginController.atributoUsuario;
import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.PerfilModel.updateUser;

public class PerfilController {
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


    public void initialize(){
        /*
        comboBoxFields.getItems().add("Tenerife");
        comboBoxFields.getItems().add("Gran Canaria");
        comboBoxFields.getItems().add("La Palma");
        comboBoxFields.getItems().add("La Gomera");
        comboBoxFields.getItems().add("El Hierro");
        comboBoxFields.getItems().add("Fuerteventura");
        comboBoxFields.getItems().add("Lanzarote");
         */

        comboBoxFields.getItems().add("Nombre");
        comboBoxFields.getItems().add("Contraseña");
        comboBoxFields.getItems().add("Mail");
        comboBoxFields.getItems().add("Telefono");

        labelNombre.setText(atributoUsuario.getNombre());
        labelContraseña.setText(atributoUsuario.getContraseña());
        labelMail.setText(atributoUsuario.getMail());
        labelTelefono.setText(String.valueOf(atributoUsuario.getTlf()));

        comboBoxFields.valueProperty().addListener((obs, oldValue, newValue) -> {
            // Acciones a realizar cuando cambia la selección del ComboBox
            selectedValue = newValue.toString();
            labelNew.setText("Nuevo " + newValue + ":");
        });

        if (pane2.isVisible()) {
            pane2.setVisible(false);
        }
    }


    public void atras(){
        cambiarScene("/com/example/aerolineascanary7islands/tickets-view.fxml","Vuelos", labelTitle);

    }

    public void actualizar(){
        if (pane2.isVisible()){
            pane2.setVisible(false);
        }else {

            pane2.setVisible(true);
        }
    }

    public void confirmar(){

        if (textFieldUpdate.getText() != ""){
            if (updateUser(atributoUsuario, selectedValue, textFieldUpdate.getText())){
                cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml", "pefil", labelTitle);

            }else {
                MethodsForControllers.showAlert("ERROR","Ese valor nos es valido para el campo " + selectedValue, Alert.AlertType.ERROR);
            };
        }else {
               MethodsForControllers.showAlert("ERROR","El campo a actualizar esta vacio", Alert.AlertType.ERROR);
        }
    }




}
