package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BilletesComprados")
public class BilleteComprado implements Serializable {
    @Id
    @Column(name = "Fecha")
    private String fecha;
    @Id
    @Column(name = "CodVuelo")
    private String codVuelo;
    @Id
    @Column(name = "IdPasajero")
    private int idPasajero;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodVuelo")
    private Vuelo vuelo;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdPasajero")
    private Pasajero  pasajero;

    public BilleteComprado(String fecha, String codVuelo, int idPasajero, Vuelo vuelo, Pasajero pasajero) {
        this.fecha = fecha;
        this.codVuelo = codVuelo;
        this.idPasajero = idPasajero;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }
    public BilleteComprado() {
        fecha = null;
        this.codVuelo = null;
        this.idPasajero = 0;
        this.vuelo = null;
        this.pasajero = null;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        fecha = fecha;
    }
    public String getCodVuelo() {
        return codVuelo;
    }
    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }
    public int getIdPasajero() {
        return idPasajero;
    }
    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    public Pasajero getPasajero() {
        return pasajero;
    }
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}