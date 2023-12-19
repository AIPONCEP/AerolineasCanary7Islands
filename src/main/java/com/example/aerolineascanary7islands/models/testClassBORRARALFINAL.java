package com.example.aerolineascanary7islands.models;

import java.util.ArrayList;
import java.util.List;

import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;
import static com.example.aerolineascanary7islands.models.TicketsModel.findVuelo;
import static com.example.aerolineascanary7islands.models.myFlightsModel.eliminarBillete;
import static com.example.aerolineascanary7islands.models.myFlightsModel.findVueloTickets;


public class testClassBORRARALFINAL {
    public static void main(String[] args) {
        BilleteComprado billeteParaEliminar = new BilleteComprado("2023-12-19 08:30:00", "GC01", 2,null,null);
        eliminarBillete(billeteParaEliminar);

    }
}
