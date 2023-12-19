package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import java.util.List;
import static com.example.aerolineascanary7islands.models.ManipulateBd.managerFactory;
public class VuelosModel {
    /**
     * getVuelo
     * busca si en la base de datos hay un vuelo con el codigo mismo codigo que el introducido por parámetros
     * @param cod
     * @return devuelve true si encuentra algún resultado y false si no lo encuentra.
     */
    public static boolean getVuelo(String cod) {
        EntityManager manager = managerFactory.createEntityManager();
        try {
            List<Vuelo> listado = manager.createQuery("FROM Vuelo WHERE Cod_Vuelo = :cod", Vuelo.class)
                    .setParameter("cod", cod)
                    .getResultList();
            if(!listado.isEmpty()){
                return true;
            }else{
                return false;
            }
        } finally {
            manager.close();
        }
    }
    /**
     * obtenerTodosLosVuelos
     * Devuelve una lista con todos los vuelos encontrados en la base de datos.
     * @return
     */
    public static List<Vuelo> obtenerTodosLosVuelos() {
        EntityManager manager = managerFactory.createEntityManager();
        try {
            return manager.createQuery("FROM Vuelo", Vuelo.class).getResultList();
        } finally {
            manager.close();
        }
    }
    /**
     * eliminarVuelo
     * busca un vuelo en la base de datos para eliminarlo en funcion de su cod_vuelo
     * @param v
     */
    public static void eliminarVuelo(Vuelo v) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Vuelo vuelo = manager.find(Vuelo.class, v.getCod_Vuelo());
        manager.remove(vuelo);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void updateVuelo(Vuelo v){
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Vuelo vuelo = manager.find(Vuelo.class, v.getCod_Vuelo());
        manager.merge(v);
        manager.getTransaction().commit();
        manager.close();
    }
}
