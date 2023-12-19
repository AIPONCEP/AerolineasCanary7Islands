package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BilletesComprados")
public class BilletesComprados implements Serializable {
    @Id
    @Column(name = "Fecha")
    private String Fecha;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CodVuelo")
    private Vuelo vuelo;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdPasajero")
    private Pasajero  pasajero;
    public BilletesComprados(String fecha, Vuelo vuelo, Pasajero pasajero) {
        Fecha = fecha;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }
    public BilletesComprados() {
        Fecha = null;
        this.vuelo = null;
        this.pasajero = null;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
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