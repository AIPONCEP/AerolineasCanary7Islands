package com.example.aerolineascanary7islands.models;

import java.util.ArrayList;
import java.util.List;

import static com.example.aerolineascanary7islands.models.TicketsModel.findVuelo;


public class testClassBORRARALFINAL {
    public static void main(String[] args) {
        List<Vuelo> vuelos = findVuelo("Gran Canaria", "Tenerife","2023-12-20 12:30:00", "2023-12-28 14:45:00");
        if(vuelos != null){
            System.out.println(vuelos.get(0).getPrecio());

        }
    }
}
