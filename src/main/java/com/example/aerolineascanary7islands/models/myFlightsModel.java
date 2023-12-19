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
                            "JOIN Pasajero p ON bc.pasajero.Id_Pasajero = p.Id_Pasajero " +
                            "JOIN Usuario u ON p.Id_Pasajero = u.id " +
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
    public static void eliminarBillete(BilleteComprado b) {
   /*     EntityManager manager = ManipulateBd.managerFactory.createEntityManager();
        manager.getTransaction().begin();
        // Obtener el BilleteComprado por su código de vuelo
        BilleteComprado billete = manager.find(BilleteComprado.class,b);
        manager.remove(billete);
        manager.getTransaction().commit();
        manager.close();
    */
        EntityManager manager = ManipulateBd.managerFactory.createEntityManager();
        manager.getTransaction().begin();
        // Usar merge para asociar la instancia con la sesión de Hibernate
        BilleteComprado billete = manager.merge(b);
        manager.remove(billete);
        manager.getTransaction().commit();
        manager.close();
    }
}
