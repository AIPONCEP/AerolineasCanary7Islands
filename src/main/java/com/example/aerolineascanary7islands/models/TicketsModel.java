package com.example.aerolineascanary7islands.models;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.example.aerolineascanary7islands.models.RegisterLoginModel.managerFactory;

public class TicketsModel {

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
}
