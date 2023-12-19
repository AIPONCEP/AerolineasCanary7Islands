package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.aerolineascanary7islands.models.RegisterLoginModel.managerFactory;

/**
 * TicketsModel
 * Contiene métodos relacionados con la gestión de tickets y vuelos.
 */
public class TicketsModel {
    /**
     * findVuelo
     * Busca vuelos en la base de datos según la procedencia, destino y un rango de fechas.     *
     * @param procedencia    La ubicación de origen del vuelo.
     * @param destino        La ubicación de destino del vuelo.
     * @param fechaInicial   La fecha inicial del rango de búsqueda.
     * @param fechaFinal     La fecha final del rango de búsqueda.
     * @return               Una lista de objetos Vuelo que cumplen con los criterios de búsqueda, o null si no se encuentran vuelos.
     */
    public static List<Vuelo> findVuelo(String procedencia, String destino, String fechaInicial, String fechaFinal) {
        EntityManager manager = null;
        try {
            manager = managerFactory.createEntityManager();
            String fechaInicialHoras = fechaInicial + " 00:00:00";
            String fechaFinalHoras = fechaFinal + " 00:00:00";
            TypedQuery<Vuelo> query = manager.createQuery(
                    "FROM Vuelo v WHERE v.procedencia = :procedencia " +
                            "AND v.destino = :destino AND v.fecha_Salida >= :fechaInicial " +
                            "AND v.fecha_Salida <= :fechaFinal", Vuelo.class);
            query.setParameter("procedencia", procedencia);
            query.setParameter("destino", destino);
            query.setParameter("fechaInicial", fechaInicialHoras);
            query.setParameter("fechaFinal", fechaFinalHoras);

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
    public static boolean existePasajeroParaUsuario(int idUsuario) {
        EntityManager manager = null;
        try {
            manager = managerFactory.createEntityManager();
            TypedQuery<Pasajero> query = manager.createQuery(
                    "SELECT p FROM Pasajero p JOIN p.usuario u WHERE u.id = :idUsuario",
                    Pasajero.class);
            query.setParameter("idUsuario", idUsuario);

            List<Pasajero> pasajeros = query.getResultList();
            if(!pasajeros.isEmpty()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según sea necesario
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return false;
    }
}
