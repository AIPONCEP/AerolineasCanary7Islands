package com.example.aerolineascanary7islands.models;

import javax.persistence.*;

@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Pasajero")
    private int Id_Pasajero;
    @Column(name="CodVuelo")
    private String nombre;
    @Column(name="Tipo_plaza")
    private String contraseña;
    @Column(name="Mail")
    private String mail;
    @Column(name="Tlf")
    private int tlf;

    public Pasajero(int id_Pasajero, String nombre, String contraseña, String mail, int tlf) {
        Id_Pasajero = id_Pasajero;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.mail = mail;
        this.tlf = tlf;
    }


}
