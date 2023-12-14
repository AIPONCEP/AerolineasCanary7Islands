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
    /**
     * esAdministrador comprueba que el usuario esté registrado en la tabla administradores
     * @param id se pasa el id que se supone se conoce previamente,
     * puesto que los administradores no se insertan desde la aplicación sino que se crean previamente en la base de datos.
     * nota: en nuestro caso el id siempre va a ser 1 para el admin.
     * @return true si encuentra resultados y false si no los encuentra.
     */
    public static boolean esAdministrador(int id) {
        try {
            EntityManager manager = managerFactory.createEntityManager();
            TypedQuery<Administrador> query = manager.createQuery("FROM Administrador WHERE id_Admin = :id_Admin", Administrador.class);
            query.setParameter("id_Admin", id);
            List<Administrador> resultList = query.getResultList();
            if (!resultList.isEmpty()){
                return true;
            }
            manager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
