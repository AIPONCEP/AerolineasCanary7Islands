package com.example.aerolineascanary7islands.models;

import static com.example.aerolineascanary7islands.models.ManipulateBd.updateBd;

public class PerfilModel {
    public static boolean updateUser(Usuario usuario, String campo , String newText){
        try {
            switch (campo){
                case "Nombre":
                    usuario.setNombre(newText);
                    break;

                case "Contraseña":
                    usuario.setContraseña(newText);
                    break;

                case "Mail":
                    usuario.setMail(newText);
                    break;

                case "Telefono":
                    usuario.setTlf(Integer.parseInt(newText));
                    break;
            }
            updateBd(usuario);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
