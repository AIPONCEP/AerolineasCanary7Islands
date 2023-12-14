package com.example.aerolineascanary7islands.models;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class ManipulateBd extends Application {
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");
    public static void insert(Object object){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void updateBd(Object object){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(object);
        manager.getTransaction().commit();
        manager.close();
    }
    @Override
    public void start(Stage primaryStage) {

    }
}
