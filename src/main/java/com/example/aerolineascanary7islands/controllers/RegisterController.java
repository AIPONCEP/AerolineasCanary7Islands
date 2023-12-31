package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;
import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;
import static com.example.aerolineascanary7islands.models.RegisterLoginModel.existeUsuarioPorEmail;
import static com.example.aerolineascanary7islands.models.RegisterLoginModel.findUsuario;
//import static com.example.aerolineascanary7islands.models.RegisterModel.getUsuario;
import com.example.aerolineascanary7islands.models.ManipulateBd;
import javafx.scene.control.TextField;

/**
 * RegisterController
 * Controlador para la vista de registro de usuarios.
 */
public class RegisterController {
    @FXML
    private Label registerTitle;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldContraseña;
    @FXML
    private TextField textFieldTelefono;
    @FXML
    private TextField textFieldMail;

    /**
     * initialize
     * Método invocado al inicializar el controlador.
     * No contiene lógica en este momento.
     */
    public void initialize(){
    }

    /**
     * exitClick
     * Método invocado al hacer clic en el botón de salida.
     * Redirige a la vista de inicio de sesión.
     */
    public void exitClick(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml","login", registerTitle);
    }

    /**
     * send
     * Método invocado al enviar el formulario de registro.
     * Crea un nuevo usuario con los datos proporcionados y lo inserta en la base de datos.
     * Luego redirige a la vista de inicio de sesión.
     */
    public void send(){
        if(textFieldNombre.getText().isEmpty() || textFieldContraseña.getText().isEmpty() || textFieldMail.getText().isEmpty() || textFieldTelefono.getText().isEmpty()){
            MethodsForControllers.showAlert("Error", "Debes rellenar todos los campos", Alert.AlertType.ERROR);
        } else if (!textFieldMail.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
            MethodsForControllers.showAlert("Error", "Correo electrónico inválido. Ejemplo: nombredetuemail@gmail.com", Alert.AlertType.ERROR);
        } else if (!textFieldTelefono.getText().matches("\\d+")) {
            MethodsForControllers.showAlert("Error", "El teléfono debe contener solo números", Alert.AlertType.ERROR);
        } else if (!textFieldTelefono.getText().matches("\\d{9}")) {
            MethodsForControllers.showAlert("Error", "El teléfono debe contener exactamente 9 dígitos", Alert.AlertType.ERROR);
        } else if (textFieldNombre.getText().matches(".*\\d.*")) {
            MethodsForControllers.showAlert("Error", "El nombre no debe contener números", Alert.AlertType.ERROR);
        }else if(existeUsuarioPorEmail(textFieldMail.getText())){
                MethodsForControllers.showAlert("Error", "Ya existe un usuario con ese Mail", Alert.AlertType.ERROR);
            } else {
            // Resto del código para crear el Usuario y realizar la inserción en la base de datos
            Usuario usuario = new Usuario(textFieldNombre.getText(), textFieldContraseña.getText(), textFieldMail.getText(), Integer.parseInt(textFieldTelefono.getText()));
            insert(usuario);
            cambiarScene("/com/example/aerolineascanary7islands/login-view.fxml", "login", registerTitle);
        }
    }
}

