package com.example.aerolineascanary7islands.models;

import java.util.ArrayList;
import java.util.List;

import static com.example.aerolineascanary7islands.models.ManipulateBd.insert;
import static com.example.aerolineascanary7islands.models.TicketsModel.findVuelo;
import static com.example.aerolineascanary7islands.models.myFlightsModel.findVueloTickets;


public class testClassBORRARALFINAL {
    public static void main(String[] args) {
        if(findVueloTickets(2) != null){
            System.out.println(findVueloTickets(2));

        }

    }
}
