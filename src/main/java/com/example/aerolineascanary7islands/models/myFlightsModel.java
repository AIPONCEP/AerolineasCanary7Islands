package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.aerolineascanary7islands.models.RegisterLoginModel.managerFactory;

public class myFlightsModel {
    public static List<Vuelo> findVueloTickets(int idUsuario) {
        EntityManager manager = null;
        try {
            manager = managerFactory.createEntityManager();
            // Cambia la consulta para seleccionar los vuelos comprados por el usuario específico
            TypedQuery<Vuelo> query = manager.createQuery(
                    "SELECT v FROM Vuelo v " +
                            "JOIN BilleteComprado bc ON v.cod_Vuelo = bc.vuelo.cod_Vuelo " +
                            "JOIN Pasajero p ON bc.pasajero.usuario.id = p.usuario.id " +
                            "JOIN Usuario u ON  p.usuario.id = u.id " +
                            "WHERE u.id = :idUsuario", Vuelo.class);
            query.setParameter("idUsuario", idUsuario);

            List<Vuelo> resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                return resultList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return null;
    }
    public static void eliminarBillete(int IdPasajero, String codVuelo) {
        EntityManager manager = null;
        try {
            manager = managerFactory.createEntityManager();
            // Aquí cambia la consulta para seleccionar el billete comprado por el pasajero específico
            TypedQuery<BilleteComprado> query = manager.createQuery(
                    "SELECT bc FROM BilleteComprado bc " +
                            "WHERE bc.pasajero.usuario.id = :IdPasajero AND bc.vuelo.id = :CodVuelo" , BilleteComprado.class);

            query.setParameter("IdPasajero", IdPasajero);
            query.setParameter("CodVuelo", codVuelo);

            List<BilleteComprado> resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                manager.getTransaction().begin();
                BilleteComprado billete = resultList.get(0);
                manager.remove(billete);
                manager.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

}
