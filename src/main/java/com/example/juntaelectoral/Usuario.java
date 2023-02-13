package com.example.juntaelectoral;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Usuario {
    private SimpleStringProperty nombre, password;
    private SimpleBooleanProperty esAdmin;

    public Usuario(String nombre, String password, Boolean esAdmin) {
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.esAdmin = new SimpleBooleanProperty(esAdmin);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public Boolean getEsAdmin() {
        return esAdmin.get();
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = new SimpleBooleanProperty(esAdmin);
    }
}
