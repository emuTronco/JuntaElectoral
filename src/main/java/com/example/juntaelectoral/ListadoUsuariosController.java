package com.example.juntaelectoral;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class ListadoUsuariosController {

    @FXML
    TableView<Usuario> tablaUsuarios;
    @FXML
    TableColumn<Usuario, String> nameColumn;
    @FXML
    TableColumn<Usuario, String> passColumn;
    @FXML
    TableColumn<Usuario, Boolean> adminColumn;

    private AdministracionController administracionController = new AdministracionController();


    public void initialize() {
        List<Usuario> listaUSuarios = new ArrayList<>();
        listaUSuarios.add(new Usuario("asd", "v", true));
        ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList(listaUSuarios);


        tablaUsuarios.setItems(listaUsuarios);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//        passColumn.setCellValueFactory(cellData -> cellData.getValue().passWordProperty());
//        adminColumn.setCellValueFactory(cellData -> cellData.getValue().esAdminProperty());


    }

    public void actualizarTabla(ObservableList<Usuario> lista) {
        tablaUsuarios.setItems(lista);
    }
}
