package com.example.juntaelectoral;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministracionController implements Initializable{
    @FXML
    private Label welcomeText;

    @FXML
    private BorderPane rootLayout;

    @FXML
    ListView<String> lvAdmin = new ListView<String>();

    @FXML
    private ObservableList usuarios = FXCollections.observableArrayList();

    private MainApp mainApp;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarios.add("Usuario");
        usuarios.add("Administrador");
        lvAdmin.setItems(usuarios);


    }

    @FXML
    public void cambiarPermisos() {
        if (lvAdmin.getSelectionModel().isSelected(0)) {
            System.out.println(0);
        } else if (lvAdmin.getSelectionModel().isSelected(1)) {
            System.out.println(1);
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //entidadTable.setItems(mainApp.getEntidadData());
    }

    public static void main(String[] args) {
        do {

        } while (true);
    }


}