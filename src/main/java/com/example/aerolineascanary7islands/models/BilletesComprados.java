package com.example.aerolineascanary7islands.models;

import javax.persistence.*;

@Entity
@Table(name = "BilletesComprados")
public class BilletesComprados {
    @Id
    private String Fecha;

    @ManyToOne
    @MapsId("CodVuelo")
    @JoinColumn(name = "CodVuelo")
    private Vuelo vuelo;

    @ManyToOne
    @MapsId("idPasajero")
    @JoinColumn(name = "IdPasajero")
    private Pasajero pasajero;


}
