package com.example.juntaelectoral;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    private String nombre;
    private String password;
    private Boolean esAdmin;
    private String formatoToString = "Nombre: %s   Contraseña: %s   Admin: %s";

    public Usuario(String nombre, String password, Boolean esAdmin) {
        this.nombre = nombre;
        this.password = password;
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        formatoToString = String.format(formatoToString, nombre, password, esAdmin);
        return formatoToString;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean b) {
        esAdmin = b;
    }

}
