package com.example.aerolineascanary7islands.controllers;

import com.example.aerolineascanary7islands.models.Vuelo;
import com.example.aerolineascanary7islands.models.VuelosModel;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowVuelosController implements Initializable {
    public Label panelControlDeVuelos;
    public TableView tablaVuelos;
    public TextField textF_EliminarVueloXCod;
    private List<Vuelo> vuelos;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaVuelos.getItems().clear();
        vuelos=VuelosModel.obtenerTodosLosVuelos();
        tablaVuelos.getItems().addAll(vuelos);
        rellenarColumnas();
    }
    public void crearVuelos(MouseEvent mouseEvent) {
        MethodsForControllers.cambiarScene("/com/example/aerolineascanary7islands/makeTravel-view.fxml","Crear vuelos",panelControlDeVuelos);
    }
    public void mostrarVuelos(MouseEvent mouseEvent) {
        vuelos = VuelosModel.obtenerTodosLosVuelos();
        tablaVuelos.getItems().clear();
        tablaVuelos.getItems().addAll(vuelos);
    }
    public void eliminarVuelos(MouseEvent mouseEvent) {
    }
    /**
     * rellenarColumnas
     * Este método se utiliza para asignar los valores encontrados en la base de datos a las tablas en inicialize y mostrar datos.
     * Primero crea diferentes instancias de tableColumn para decir que tipo de datos tiene cada columna y que pertenecen a
     * la clase vuelo.
     * Segundo, dado que las columnas se almacenan en listas determinamos los get(0-7) para obtener las columnas correspondientes.
     * Tercero, se configura setCellValueFactory para determinar cómo se deben obtener los valores para cada celda en la columna.
     * Por último, se define una función lambda que toma como argumento cellData, se crea una nueva instancia de la
     * clase SimpleStringProperty, SimpleFloatProperty..., según el tipo de dato que se necesite, y con cellData.getValue().get...()
     * se obtiene el valor que se indique en el get() del objeto vuelo.
     */
    public void rellenarColumnas(){
        //Columna cod_Vuelo
        TableColumn<Vuelo, String> colCodVuelo = (TableColumn<Vuelo, String>) tablaVuelos.getColumns().get(0);
        colCodVuelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCod_Vuelo()));
        //Columna Precio
        TableColumn<Vuelo, Float> colPrecio = (TableColumn<Vuelo, Float>) tablaVuelos.getColumns().get(1);
        colPrecio.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPrecio()).asObject());
        //Columna Fecha_Salida
        TableColumn<Vuelo, String> colFechaSalida = (TableColumn<Vuelo, String>) tablaVuelos.getColumns().get(2);
        colFechaSalida.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha_Salida()));
        //Columna Fecha_Llegada
        TableColumn<Vuelo, String> colFechaLlegada = (TableColumn<Vuelo, String>) tablaVuelos.getColumns().get(3);
        colFechaLlegada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha_Llegada()));
        //Columna Destino
        TableColumn<Vuelo, String> colDestino = (TableColumn<Vuelo, String>) tablaVuelos.getColumns().get(4);
        colDestino.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestino()));
        //Columna Procedencia
        TableColumn<Vuelo, String> colProcedencia = (TableColumn<Vuelo, String>) tablaVuelos.getColumns().get(5);
        colProcedencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProcedencia()));
        //Columna Plazas_Turista
        TableColumn<Vuelo, Integer> colPlazasTurista = (TableColumn<Vuelo, Integer>) tablaVuelos.getColumns().get(6);
        colPlazasTurista.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPlazas_Turista()).asObject());
        //Columna Plazas_Primera
        TableColumn<Vuelo, Integer> colPlazasPrimera = (TableColumn<Vuelo, Integer>) tablaVuelos.getColumns().get(7);
        colPlazasPrimera.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPlazas_Primera()).asObject());
    }
    public void actualizarVuelo(MouseEvent mouseEvent) {
    }
}
