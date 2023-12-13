package com.example.aerolineascanary7islands.models;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Administradores")
public class Administrador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Admin")
    private int id_Admin;
    @Column(name="Sueldo")
    private float sueldo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Admin")
    private Usuario usuario;
    public Administrador() {
        this.sueldo = 0.0F;
    }
    public Administrador(int id_Admin, float sueldo) {
        this.id_Admin = id_Admin;
        this.sueldo = sueldo;
    }
    public int getId_Admin() {
        return id_Admin;
    }
    public void setId_Admin(int id_Admin) {
        this.id_Admin = id_Admin;
    }
    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
