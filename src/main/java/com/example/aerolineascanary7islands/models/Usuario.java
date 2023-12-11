package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int cod;

    @Column(name="nombre")
    private String nombre;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="mail")
    private String mail;

    @Column(name="tlf")
    private String tlf;

    public Usuario() {
    }

    public Usuario( String nombre, String contraseña, String mail, String tlf) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.mail = mail;
        this.tlf = tlf;
    }

}
