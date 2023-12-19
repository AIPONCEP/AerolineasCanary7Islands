package com.example.aerolineascanary7islands.models;

import static com.example.aerolineascanary7islands.models.ManipulateBd.updateBd;
/**
 * PerfilModel
 * Contiene métodos relacionados con la manipulación del perfil del usuario.
 */
public class PerfilModel {
    /**
     * updateUser
     * Actualiza los datos del usuario según el campo especificado.     *
     * @param usuario  El objeto Usuario a actualizar.
     * @param campo    El campo del usuario a modificar (Nombre, Contraseña, Mail, Telefono).
     * @param newText  El nuevo texto o valor a asignar al campo.
     * @return         Verdadero si la actualización se realizó con éxito, falso en caso contrario.
     */
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
