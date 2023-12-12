package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class RegisterModel {
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");

    public static ArrayList<Usuario> findUsuario(String nombre, String contraseña){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        ArrayList<Usuario> listado = (ArrayList<Usuario>) manager.createQuery("FROM Usuario WHERE nombre = :nombre and contraseña = :contraseña").setParameter("nombre", nombre).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return listado;
    }

    (Session session){
        SQLQuery sqlQuery = session.createSQLQuery( "SELECT * FROM clientes WHERE nombre = :nombre" );
        sqlQuery.setParameter( "nombre" , "PACO");
        sqlQuery.addEntity(Client. class);
        List<Client> resultado = sqlQuery.getResultList();


}
