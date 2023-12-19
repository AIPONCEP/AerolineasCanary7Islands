package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * ManipulateBd
 * Contiene métodos para interactuar con la base de datos.
 */
public class ManipulateBd {
    /**
     * managerFactory
     * Factoría para crear el EntityManager.
     */
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");
    /**
     * insert
     * Inserta un objeto en la base de datos.     *
     * @param object Objeto a insertar en la base de datos.
     */
    public static void insert(Object object){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        manager.close();
    }
    /**
     * updateBd
     * Actualiza un objeto en la base de datos.     *
     * @param object Objeto a actualizar en la base de datos.
     */
    public static void updateBd(Object object){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(object);
        manager.getTransaction().commit();
        manager.close();
    }
}
