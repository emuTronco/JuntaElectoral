package com.example.juntaelectoral;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListadoUsuariosController implements Initializable {

    @FXML
    TableView tablaUsuarios;
    @FXML
    TableColumn<Usuario, String> nameColumn;
    @FXML
    TableColumn<Usuario, String> passColumn;
    @FXML
    TableColumn<Usuario, String> adminColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList <Usuario> listaUsuarios = FXCollections.observableArrayList(new Usuario("asd", "v",true));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        adminColumn.setCellValueFactory(new PropertyValueFactory<>("esAdmin"));
        tablaUsuarios.setItems(listaUsuarios);

    }
}
