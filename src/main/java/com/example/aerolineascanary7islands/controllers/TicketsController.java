package com.example.aerolineascanary7islands.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import static com.example.aerolineascanary7islands.controllers.MethodsForControllers.cambiarScene;

public class TicketsController {
    @FXML
    private StackPane carrousel;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Label labelTitle;

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
        Duration duration = Duration.seconds(4); // Cambia cada 3 segundos (puedes ajustar este valor)
        Timeline timeline = new Timeline(new KeyFrame(duration, e -> cambiarImagen()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    public void perfilClick(){
        cambiarScene("/com/example/aerolineascanary7islands/perfil-view.fxml","Informacion personal", labelTitle);
    }

    public void salir(){
        cambiarScene("/com/example/aerolineascanary7islands/main-view.fxml", "Main", labelTitle);
    }

    private void cambiarImagen() {
        if (indice == 0) {
            pane1.setVisible(false);
            pane2.setVisible(true);

            indice = 1;
        } else {
            pane1.setVisible(true);
            pane2.setVisible(false);
            indice = 0;
        }
    }
}
