package com.example.aerolineascanary7islands;

import com.example.aerolineascanary7islands.models.ManipulateBd;
import com.example.aerolineascanary7islands.models.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.aerolineascanary7islands.models.RegisterModel.insertUsuario;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("AerolinesCanary7Islands");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Usuario usuario = new Usuario("Nome","Pass","Mail",100000000);
        ManipulateBd.insert(usuario);


    }
}