package com.example.juntaelectoral;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CuadroMandoController implements Initializable {

    @FXML
    HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hbox9, hboxPrincipal;
    @FXML
    GridPane gridPane;
    private MainApp mainApp;
    @FXML
    WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLayout(hbox4, "/com/example/juntaelectoral/ventanaCIS-S.fxml", "CIS");
        cargarLayout(hbox6, "/com/example/juntaelectoral/ventanaAnimacionResultados-S.fxml", "AnimacionResultados");
        cargarLayout(hbox7, "/com/example/juntaelectoral/ventanaResumenProvincia-S.fxml", "Provincia");
        cargarLayout(hbox9, "/com/example/juntaelectoral/ventanaResumenComunidad-S.fxml", "Comunidad");

//        webView.getEngine().load("https://www.youtube.com/embed/W5xhIy2jMkY?autoplay=1");
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

            hbox.getChildren().clear();
            hbox.getChildren().add(listadoControles);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
