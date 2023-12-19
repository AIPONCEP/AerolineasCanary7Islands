package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="vuelos")
public class Vuelo implements Serializable {
    @Id
    @Column(name="Cod_Vuelo")
    private String cod_Vuelo;
    @Column(name = "Precio")
    private float precio;
    @Column(name = "Fecha_Salida")
    private String fecha_Salida;
    @Column(name = "Fecha_Llegada")
    private String fecha_Llegada;
    @Column(name = "Destino")
    private String destino;
    @Column(name = "Procedencia")
    private String procedencia;
    @Column(name = "Plazas_Turista")
    private int plazas_Turista;
    @Column(name = "Plazas_Primera")
    private int plazas_Primera;
    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<BilleteComprado> billetesCompradosList;

    public Vuelo() {
        this.cod_Vuelo = "";
        this.precio = 0.0F;
        this.fecha_Salida = "";
        this.fecha_Llegada = "";
        this.destino = "";
        this.procedencia = "";
        this.plazas_Turista = 0;
        this.plazas_Primera = 0;
        this.billetesCompradosList = new ArrayList<>();
    }
    public Vuelo(String cod_Vuelo, float precio, String fecha_Salida,
                 String fecha_Llegada, String destino, String procedencia,
                 int plazas_Turista, int plazas_Primera, List<BilleteComprado> billetesCompradosList) {
        this.cod_Vuelo = cod_Vuelo;
        this.precio = precio;
        this.fecha_Salida = fecha_Salida;
        this.fecha_Llegada = fecha_Llegada;
        this.destino = destino;
        this.procedencia = procedencia;
        this.plazas_Turista = plazas_Turista;
        this.plazas_Primera = plazas_Primera;
        this.billetesCompradosList = billetesCompradosList;
    }
    public String getCod_Vuelo() {
        return cod_Vuelo;
    }
    public void setCod_Vuelo(String cod_Vuelo) {
        this.cod_Vuelo = cod_Vuelo;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getFecha_Salida() {
        return fecha_Salida;
    }
    public void setFecha_Salida(String fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }
    public String getFecha_Llegada() {
        return fecha_Llegada;
    }
    public void setFecha_Llegada(String fecha_Llegada) {
        this.fecha_Llegada = fecha_Llegada;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getProcedencia() {
        return procedencia;
    }
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
    public int getPlazas_Turista() {
        return plazas_Turista;
    }
    public void setPlazas_Turista(int plazas_Turista) {
        this.plazas_Turista = plazas_Turista;
    }
    public int getPlazas_Primera() {
        return plazas_Primera;
    }
    public void setPlazas_Primera(int plazas_Primera) {
        this.plazas_Primera = plazas_Primera;
    }
    public static boolean validarFechas(String fecha_Salida, String fecha_Llegada) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateSalida = sdf.parse(fecha_Salida);
            Date dateLlegada = sdf.parse(fecha_Llegada);
            return dateSalida.before(dateLlegada);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void addBilletesCompradosVuelosList(BilleteComprado billete){
        this.billetesCompradosList.add(billete);
    }
    public List<BilleteComprado> getBilletesCompradosList() {
        return billetesCompradosList;
    }
    public void setBilletesCompradosList(List<BilleteComprado> billetesCompradosList) {
        this.billetesCompradosList = billetesCompradosList;
    }
}
