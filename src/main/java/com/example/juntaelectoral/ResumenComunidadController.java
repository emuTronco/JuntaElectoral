package com.example.juntaelectoral;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ResumenComunidadController implements Initializable {

    final static String pp = "PP";
    final static String bng = "BNG";
    final static String psdeg = "PSdeG";
    final static String mareaGaleguista = "M. Gal.";
    final static String  galiciaComun= "G. Com.";
    final static String pacma = "PACMA";

    @FXML
    BarChart<String,Number> barChart;
    @FXML
    CategoryAxis categoryAxis;
    @FXML
    NumberAxis numberAxis;
    @FXML
    PieChart pieChart;
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Votado", 75), new PieChart.Data("No Votado", 25));
    double votado,noVotado;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Votos");
        series1.getData().add(new XYChart.Data(pp, 25601.34));
        series1.getData().add(new XYChart.Data(bng, 20148.82));
        series1.getData().add(new XYChart.Data(psdeg, 10000));
        series1.getData().add(new XYChart.Data(mareaGaleguista, 35407.15));
        series1.getData().add(new XYChart.Data(galiciaComun, 12000));
        series1.getData().add(new XYChart.Data(pacma, 8000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Escaños");
        series2.getData().add(new XYChart.Data(pp, 25601.34));
        series2.getData().add(new XYChart.Data(bng, 20148.82));
        series2.getData().add(new XYChart.Data(psdeg, 10000));
        series2.getData().add(new XYChart.Data(mareaGaleguista, 35407.15));
        series2.getData().add(new XYChart.Data(galiciaComun, 12000));
        series2.getData().add(new XYChart.Data(pacma, 8000));

        barChart.getData().addAll(series1, series2);

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent actionEvent) {
                                for (XYChart.Series<String, Number> series : barChart.getData()) {
                                    for (XYChart.Data<String, Number> data : series.getData()) {
                                        data.setYValue(Math.random() * 1000);
                                    }
                                }

                            }
                        }
                ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();

        pieChart.getData().addAll(pieChartData);

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }


    }
}
