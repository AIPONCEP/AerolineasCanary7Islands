package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 * RegisterLoginModel
 * Contiene métodos relacionados con el registro y el inicio de sesión de usuarios.
 */
public class RegisterLoginModel {
    public static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("Persistencia");
    /**
     * findUsuario
     * Busca un usuario en la base de datos por su correo electrónico y contraseña.     *
     * @param email       El correo electrónico del usuario.
     * @param contraseña  La contraseña del usuario.
     * @return            El objeto Usuario encontrado, o null si no se encontró ninguno.
     */
    public static Usuario findUsuario(String email, String contraseña) {
        try {
                EntityManager manager = managerFactory.createEntityManager();
                TypedQuery<Usuario> query = manager.createQuery("FROM Usuario WHERE mail = :mail AND contraseña = :contraseña", Usuario.class);
                query.setParameter("mail", email);
                query.setParameter("contraseña", contraseña);
                List<Usuario> resultList = query.getResultList();
                if (resultList.get(0) != null){
                    return resultList.get(0);
                }
                manager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
     return null;
    }
    /**
     * esAdministrador comprueba que el usuario esté registrado en la tabla administradores
     * @param idUsuario se pasa el id que se supone se conoce previamente, ya que los administradores
     * no se insertan desde la aplicación sino que se crean previamente en la base de datos.
     * nota: en nuestro caso el id siempre va a ser 1 para el admin.
     * @param mail recogemos el mail introducido
     * @return true si encuentra resultados y false si no los encuentra.
     */
    public static boolean esAdministrador(int idUsuario, String mail) {
        try {
            EntityManager manager = managerFactory.createEntityManager();
            //Cojemos el id del usuario en funcion del mail introducido
            TypedQuery<Integer> idQuery = manager.createQuery("SELECT id FROM Usuario WHERE mail = :mail", Integer.class);
            idQuery.setParameter("mail", mail);
            List<Integer> idResultList = idQuery.getResultList();
            if (!idResultList.isEmpty()) {
                int id = idResultList.get(0);
                // Comprobamos que el usuario es un administrador
                TypedQuery<Administrador> adminQuery = manager.createQuery("FROM Administrador WHERE id_Admin = :id_Admin", Administrador.class);
                adminQuery.setParameter("id_Admin", id);
                List<Administrador> adminResultList = adminQuery.getResultList();
                manager.close();
                return !adminResultList.isEmpty() && adminResultList.get(0) != null;
            }
            manager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
