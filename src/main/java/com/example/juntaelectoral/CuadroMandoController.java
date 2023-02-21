package com.example.juntaelectoral;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CuadroMandoController implements Initializable {

    @FXML
    HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hboxPrincipal;
    @FXML
    GridPane gridPane;
    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLayout(hbox4, "/com/example/juntaelectoral/ventanaCIS.fxml", "CIS");
        cargarLayout(hbox5, "/com/example/juntaelectoral/ventanaAnimacionResultados.fxml", "AnimacionResultados");
        cargarLayout(hbox6, "/com/example/juntaelectoral/ventanaResumenProvincia.fxml", "Provincia");
        cargarLayout(hbox7, "/com/example/juntaelectoral/ventanaResumenComunidad.fxml", "Comunidad");
    }

    @FXML
    public void expandirVentana() throws IOException {
        try {
            // Cargamos el archivo Controles Dinámicos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CuadroMandoController.class.getResource("/com/example/juntaelectoral/ventanaCIS.fxml"));
            AnchorPane listadoControles = (AnchorPane) loader.load();

            // Se sitúa en el centro del diseño principal

            hboxPrincipal.getChildren().clear();
            hboxPrincipal.getChildren().add(listadoControles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarLayout(HBox hbox, String ruta, String controller) {
        try {
            FXMLLoader loader = new FXMLLoader();
            switch (controller) {
                case "CIS":
                    loader.setLocation(CISController.class.getResource(ruta));
                    break;
                case "AnimacionResultados":
                    loader.setLocation(AnimacionResultadosController.class.getResource(ruta));
                    break;
                case "Comunidad":
                    loader.setLocation(ResumenComunidadController.class.getResource(ruta));
                    break;
                case "Provincia":
                    loader.setLocation(ResumenProvinciaController.class.getResource(ruta));
                    break;
            }
            AnchorPane listadoControles = (AnchorPane) loader.load();
            listadoControles.setMaxHeight(173);
            listadoControles.setMaxWidth(250);

            hbox.getChildren().clear();
            hbox.getChildren().add(listadoControles);

            hbox.setMaxHeight(173);
            hbox.setMaxWidth(250);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
