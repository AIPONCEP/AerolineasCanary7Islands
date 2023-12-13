package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Contraseña")
    private String contraseña;
    @Column(name="Mail")
    private String mail;
    @Column(name="Tlf")
    private int tlf;
    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    public Usuario() {
        this.id = 0;
        this.nombre = null;
        this.contraseña = null;
        this.mail = null;
        this.tlf = 0;
    }
    public Usuario(String nombre, String contraseña, String mail, int tlf) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.mail = mail;
        this.tlf = tlf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public int getTlf() {
        return tlf;
    }
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", mail='" + mail + '\'' +
                ", tlf=" + tlf +
                '}';
    }
}
