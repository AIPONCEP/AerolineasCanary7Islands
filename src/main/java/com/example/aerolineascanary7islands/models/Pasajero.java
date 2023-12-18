package com.example.aerolineascanary7islands.models;
import javax.persistence.*;

@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @Column(name="Id_Pasajero")
    private int Id_Pasajero;
    @Column(name="Tipo_plaza")
    private String Tipo_plaza;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Pasajero")
    private Usuario usuario;

    public Pasajero(int id_Pasajero, Vuelo, String tipo_plaza) {
        Id_Pasajero = id_Pasajero;
        Tipo_plaza = tipo_plaza;
    }

    public Pasajero() {
        Id_Pasajero = 0;
       Tipo_plaza = null;
    }
}
