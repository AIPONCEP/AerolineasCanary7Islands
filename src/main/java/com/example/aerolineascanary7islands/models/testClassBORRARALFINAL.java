package com.example.aerolineascanary7islands.models;

import static com.example.aerolineascanary7islands.models.myFlightsModel.eliminarBillete;

public class testClassBORRARALFINAL {
    public static void main(String[] args) {
        BilleteComprado billeteParaEliminar = new BilleteComprado("2023-12-19 08:30:00", "GC01", 2,null,null);
        eliminarBillete(billeteParaEliminar);

    }
}
