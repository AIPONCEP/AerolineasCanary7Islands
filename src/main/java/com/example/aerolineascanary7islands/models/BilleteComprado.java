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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodVuelo")
    private Vuelo vuelo;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdPasajero")
    private Pasajero pasajero;

    public BilleteComprado(String fecha, Vuelo vuelo, Pasajero pasajero) {
        this.fecha = fecha;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }
    public BilleteComprado() {
        this.fecha = null;
        this.vuelo = null;
        this.pasajero = null;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
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