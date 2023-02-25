package com.example.juntaelectoral;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    private AnchorPane scene;

    @FXML
    private Circle circle;
    private double dx = 5; // velocidad horizontal del círculo
    private double dy = 5; // velocidad vertical del círculo
    @FXML
    Rectangle rectangulo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLayout(hbox4, "/com/example/juntaelectoral/ventanaCIS-S.fxml", "CIS");
        cargarLayout(hbox6, "/com/example/juntaelectoral/ventanaAnimacionResultados-S.fxml", "AnimacionResultados");
//        cargarLayout(hbox7, "/com/example/juntaelectoral/ventanaResumenProvincia-S.fxml", "Provincia");
        cargarLayout(hbox7, "/com/example/juntaelectoral/ventanaResumenComunidad-S.fxml", "Comunidad");

//        webView.getEngine().load("https://www.youtube.com/embed/W5xhIy2jMkY?autoplay=1");
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                // Mover el círculo
//                circle.setLayoutX(circle.getLayoutX() + dx);
//                circle.setLayoutY(circle.getLayoutY() + dy);
//
//                // Verificar si el círculo colisiona con el borde izquierdo o derecho
//                if (circle.getLayoutX() <= 0 || circle.getLayoutX() + circle.getRadius() * 2 >= scene.getWidth()) {
//                    dx = -dx;
//                }
//
//                // Verificar si el círculo colisiona con el borde superior o inferior
//                if (circle.getLayoutY() <= 0 || circle.getLayoutY() + circle.getRadius() * 2 >= scene.getHeight()) {
//                    dy = -dy;
//                }
//
//                // Verificar si el círculo colisiona con el cuadrado
//                if (circle.getBoundsInParent().intersects(rectangulo.getBoundsInParent())) {
//                    double centroX = circle.getLayoutX() + circle.getRadius();
//                    double centroY = circle.getLayoutY() + circle.getRadius();
//                    double cuadradoX = rectangulo.getX();
//                    double cuadradoY = rectangulo.getY();
//                    double cuadradoWidth = rectangulo.getWidth();
//                    double cuadradoHeight = rectangulo.getHeight();
//
//                    // Calcular la distancia entre el centro del círculo y el centro del cuadrado
//                    double distanciaX = Math.max(cuadradoX - centroX, Math.min(centroX - cuadradoX - cuadradoWidth, 0));
//                    double distanciaY = Math.max(cuadradoY - centroY, Math.min(centroY - cuadradoY - cuadradoHeight, 0));
//                    double distancia = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
//
//                    // Verificar en qué dirección se mueve el círculo y rebotarlo en consecuencia
//                    if (distancia < circle.getRadius()) {
//                        if (distanciaX == 0 || Math.abs(distanciaY / distanciaX) > cuadradoHeight / cuadradoWidth) {
//                            // Colisión vertical
//                            dy = centroY < cuadradoY + cuadradoHeight / 2 ? -dy : dy;
//                        } else {
//                            // Colisión horizontal
//                            dx = centroX < cuadradoX + cuadradoWidth / 2 ? -dx : dx;
//                        }
//                    }
//                }
//            }
//        };
//        timer.start();
    }

    @FXML
    public void expandirVentana() throws IOException {
        try {
            // Cargamos el archivo Controles Dinámicos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ResumenComunidadController.class.getResource("/com/example/juntaelectoral/ventanaResumenComunidad.fxml"));
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

//    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
//        double deltaX = 2;
//        double deltaY = 2;
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        circle.setLayoutX(circle.getLayoutX() + deltaX);
//        circle.setLayoutY(circle.getLayoutY() + deltaY);
//
//        Bounds boundsScene = scene.getBoundsInLocal();
//        Bounds boundsGrid = gridPane.getBoundsInLocal();
//        boolean rightBorder = circle.getLayoutX() >= (boundsScene.getMaxX() - circle.getRadius());
//        boolean innerRightBorder = circle.getLayoutX() <= (boundsGrid.getMinX() + circle.getRadius());
//        boolean leftBorder = circle.getLayoutX() <= (boundsScene.getMinX() + circle.getRadius());
//        boolean innerLeftBorder = circle.getLayoutX() >= (boundsGrid.getMaxX() - circle.getRadius());
//        boolean bottomBorder = circle.getLayoutY() >= (boundsScene.getMaxY() - circle.getRadius());
//        boolean innerBottomBorder = circle.getLayoutY() <= (boundsGrid.getMinY() + circle.getRadius());
//        boolean topBorder = circle.getLayoutY() <= (boundsScene.getMinY() + circle.getRadius());
//        boolean innerTopBorder = circle.getLayoutY() >= (boundsGrid.getMaxY() - circle.getRadius());
//
//        if (rightBorder || leftBorder || innerRightBorder || innerLeftBorder) {
//            deltaX *= -1;
//        }
//        if (bottomBorder || topBorder || innerBottomBorder || innerTopBorder) {
//            deltaY *= -1;
//        }
//    }
//}));

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

//    public void start(Stage stage) throws Exception {
//
//        AnchorPane root = FXMLLoader.load(getClass().getResource("view/Scene.fxml"));
//
//        root.setPrefWidth(300);  //Poner aqui vuestros valores
//
//        root.setPrefHeight(163);
//
//        Scene scene = new Scene(root);
//
//        Scale scale = new Scale(0.5, 0.5); // Cambiar
//
//        scale.setPivotX(0);
//
//        scale.setPivotY(0);
//
//        scene.getRoot().getTransforms().setAll(scale);
//
//        stage.setScene(scene);
//
//        stage.show();
//
//    }


}
