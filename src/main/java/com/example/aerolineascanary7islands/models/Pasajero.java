package com.example.aerolineascanary7islands.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "pasajeros")
public class Pasajero implements Serializable {
//    @Id
//    @Column(name="Id_Pasajero")
//    private int Id_Pasajero;
    @Column(name="Tipo_plaza")
    private String Tipo_plaza;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Pasajero")
    private Usuario usuario;
    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BilleteComprado> billetesCompradosList;

    public Pasajero(int id_Pasajero, String tipo_plaza, Usuario usuario, List<BilleteComprado> billetesCompradosList) {
//        Id_Pasajero = id_Pasajero;
        Tipo_plaza = tipo_plaza;
        this.usuario = usuario;
        this.billetesCompradosList = billetesCompradosList;
    }

    public Pasajero() {
//        Id_Pasajero = 0;
        Tipo_plaza = null;
        this.usuario = null;
        this.billetesCompradosList = null;
    }


//    public int getId_Pasajero() {
//        return Id_Pasajero;
//    }

//    public void setId_Pasajero(int id_Pasajero) {
//        Id_Pasajero = id_Pasajero;
//    }

    public String getTipo_plaza() {
        return Tipo_plaza;
    }

    public void setTipo_plaza(String tipo_plaza) {
        Tipo_plaza = tipo_plaza;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<BilleteComprado> getBilletesCompradosList() {
        return billetesCompradosList;
    }

    public void setBilletesCompradosList(List<BilleteComprado> billetesCompradosList) {
        this.billetesCompradosList = billetesCompradosList;
    }

    public void addBilletesCompradosPasajerosList(BilleteComprado billete){
        this.billetesCompradosList.add(billete);
    }
}
