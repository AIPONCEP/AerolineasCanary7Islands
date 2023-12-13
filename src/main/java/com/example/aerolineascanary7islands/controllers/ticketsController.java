package com.example.aerolineascanary7islands.controllers;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ticketsController {
    @FXML
    private StackPane carrousel;

    public void initialize(){
        List<ImageView> images = new ArrayList<>();


        // Agregar todas las imágenes al StackPane
        carrousel.getChildren().addAll(images);

// Configurar la transición de desplazamiento
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), carrousel);
        transition.setByX(-200); // Ajusta el valor para el desplazamiento horizontal
        transition.setCycleCount(Timeline.INDEFINITE); // Repetir la transición infinitamente

// Reproducir la transición
        transition.play();

    }
}
