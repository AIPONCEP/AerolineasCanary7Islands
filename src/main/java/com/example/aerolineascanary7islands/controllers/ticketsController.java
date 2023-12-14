package com.example.aerolineascanary7islands.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private Label granCanariaLabel;

    @FXML
    private Label tenerifeLabel;

    private int indice = 0;

    public void initialize() {


        // Inicializar la animación para cambiar las imágenes
        Duration duration = Duration.seconds(10); // Cambia cada 3 segundos (puedes ajustar este valor)
        Timeline timeline = new Timeline(new KeyFrame(duration, e -> cambiarImagen()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private void cambiarImagen() {
        if (indice == 0) {
            imageView1.setVisible(false);
            imageView2.setVisible(true);
            granCanariaLabel.setVisible(false);
            tenerifeLabel.setVisible(true);
            indice = 1;
        } else {
            imageView2.setVisible(false);
            imageView1.setVisible(true);
            granCanariaLabel.setVisible(true);
            tenerifeLabel.setVisible(false);
            indice = 0;
        }
    }
}
