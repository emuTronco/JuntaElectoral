package com.example.juntaelectoral;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController extends MainApp {
    @FXML
    private Label welcomeText;

    @FXML
    private BorderPane rootLayout;

    private Stage primaryStage = super.getPrimaryStage();



    public PrincipalController() {
        rootLayout = getRootLayout();
    }

//    @FXML
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        usuarios.add("Administrador");
//
//    }

    @FXML
    public void abrirAdministracion(ActionEvent event) throws IOException {
        try {
            // Cargamos el archivo Controles Dinámicos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrincipalController.class.getResource("/com/example/juntaelectoral/ventanaAdministracion.fxml"));
            AnchorPane listadoControles = (AnchorPane) loader.load();

            // Se sitúa en el centro del diseño principal

            rootLayout.setCenter(listadoControles);
            AdministracionController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }
}