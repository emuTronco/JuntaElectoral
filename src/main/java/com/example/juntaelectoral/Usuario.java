package com.example.juntaelectoral;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    public final StringProperty nombre;
    public final StringProperty password;
    public final BooleanProperty esAdmin;

    public Usuario(String nombre, String password, Boolean esAdmin) {
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.esAdmin = new SimpleBooleanProperty(esAdmin);
    }


    public StringProperty nombreProperty() {
        return nombre;
    }


    public StringProperty passWordProperty() {
        return password;
    }


    public BooleanProperty esAdminProperty() {
        return esAdmin;
    }

    public String getNombre(){
        return nombre.get();
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin.set(esAdmin);
    }
}
