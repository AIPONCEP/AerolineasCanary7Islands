package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.ManipulateBd;
import com.example.aerolineascanary7islands.models.Vuelo;
import com.example.aerolineascanary7islands.models.VuelosModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MakeTravelController implements Initializable {
    @FXML
    public TextField tF_cod_Vuelo;
    @FXML
    public TextField tF_precio;
    @FXML
    public TextField tF_fecha_Salida;
    @FXML
    public TextField tF_fecha_Llegada;
    @FXML
    public ComboBox cB_destino;
    @FXML
    public ComboBox cB_procedencia;
    @FXML
    public TextField tF_plazas_Turista;
    @FXML
    public TextField tF_plazas_Primera;
    @FXML
    public Label crearVueloTitle;
    private String expRegularFecha = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
    /**
     * Se declara initialize para rellenar combos de la vista con los posibles destinos y la procedencia de los vuelos.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[]islas={"Gran Canaria","Tenerife","La Palma", "El Hierro","La Gomera", "Lanzarote","Fuerteventura"};
        cB_procedencia.getItems().addAll(islas);
        cB_destino.getItems().addAll(islas);
    }
    /**
     * crearVuelo
     * comprueba que los campos no esten vacios, que el destino y la procedencia no sean los mismos y que no sean null.
     * Comprueba también que la fecha salida sea anterior a la fecha llegada llamando al método validarFechas de la clase Vuelo.
     * Si lo anterior es correcto crea el vuelo nuevo y lo inserta en la base de datos.
     * si no se cumplen las condiciones muestra los respectivos mensajes de error.
     * @param mouseEvent
     */
    public void crearVuelo(MouseEvent mouseEvent) {
        if(!VuelosModel.getVuelo(tF_cod_Vuelo.getText())) {
           if(!tF_precio.getText().isEmpty() && !tF_fecha_Salida.getText().isEmpty() && !tF_fecha_Llegada.getText().isEmpty() &&
              !tF_plazas_Turista.getText().isEmpty() && !tF_plazas_Primera.getText().isEmpty()) {
               if(cB_procedencia.getValue()!=null && cB_destino.getValue()!= null) {
                   if(cB_procedencia.getValue()!=cB_destino.getValue()) {
                       if(tF_fecha_Llegada.getText().matches(expRegularFecha) && tF_fecha_Salida.getText().matches(expRegularFecha)) {
                           if(Vuelo.validarFechas(tF_fecha_Salida.getText(),tF_fecha_Llegada.getText())){
                               Vuelo vuelo = new Vuelo(tF_cod_Vuelo.getText(), Float.parseFloat(tF_precio.getText()), tF_fecha_Salida.getText(), tF_fecha_Llegada.getText(),
                                       cB_destino.getValue().toString(), cB_procedencia.getValue().toString(), Integer.parseInt(tF_plazas_Turista.getText()), Integer.parseInt(tF_plazas_Primera.getText()));
                               ManipulateBd.insert(vuelo);
                               tF_cod_Vuelo.setText("");
                               tF_precio.setText("");
                               tF_fecha_Salida.setText("");
                               tF_fecha_Llegada.setText("");
                               cB_destino.getSelectionModel().clearSelection();
                               cB_procedencia.getSelectionModel().clearSelection();
                               tF_plazas_Turista.setText("");
                               tF_plazas_Primera.setText("");
                           }else{
                               MethodsForControllers.showAlert("Error","La fecha de Llegada no puede ser anterior a la fecha de salida", Alert.AlertType.ERROR);
                           }
                       }else{
                           MethodsForControllers.showAlert("Error","El formato de fecha llegada y salida debe ser 'YYYY-MM-DD HH:MI:SS'", Alert.AlertType.ERROR);
                       }
                   }else{
                       MethodsForControllers.showAlert("Error","El destino y la procedencia no pueden ser iguales", Alert.AlertType.ERROR);
                   }
               }else {
                   MethodsForControllers.showAlert("Error","Debe seleccionar el destino y la procedencia", Alert.AlertType.ERROR);
               }
           }else {
               MethodsForControllers.showAlert("Error","Debe rellenar todos los campos", Alert.AlertType.ERROR);
           }
        }else {
            MethodsForControllers.showAlert("Error","Existe un vuelo con ese codigo", Alert.AlertType.ERROR);
        }
    }
    public void volver(MouseEvent mouseEvent) {
        MethodsForControllers.cambiarScene("/com/example/aerolineascanary7islands/showVuelos-view.fxml","Panel de control de vuelos",crearVueloTitle);
    }
}
