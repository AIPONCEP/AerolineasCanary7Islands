package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class RegisterModel {
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");
    public static boolean findUsuario(String email, String contraseña) {
        try {
                EntityManager manager = managerFactory.createEntityManager();
                TypedQuery<Usuario> query = manager.createQuery("FROM Usuario WHERE mail = :mail AND contraseña = :contraseña", Usuario.class);
                query.setParameter("mail", email);
                query.setParameter("contraseña", contraseña);
                List<Usuario> resultList = query.getResultList();
                if (resultList.get(0) != null){
                    return true;
                }
                manager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
