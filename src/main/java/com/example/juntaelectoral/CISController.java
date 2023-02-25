package com.example.juntaelectoral;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CISController implements Initializable {

    final static String pp = "PP";
    final static String bng = "BNG";
    final static String psdeg = "PSdeG";
    final static String mareaGaleguista = "M. Gal.";
    final static String  galiciaComun= "G. Com.";
    final static String pacma = "PACMA";

    @FXML
    LineChart<String, Number> lineChart;
    @FXML
    NumberAxis numberAxis;
    @FXML
    CategoryAxis categoryAxis;
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
        series2.getData().add(new XYChart.Data(pp, 10));
        series2.getData().add(new XYChart.Data(bng, 15));
        series2.getData().add(new XYChart.Data(psdeg, 435));
        series2.getData().add(new XYChart.Data(mareaGaleguista, 354));
        series2.getData().add(new XYChart.Data(galiciaComun, 435));
        series2.getData().add(new XYChart.Data(pacma, 234));

        lineChart.getData().addAll(series1, series2);

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent actionEvent) {
                                for (XYChart.Series<String, Number> series : lineChart.getData()) {
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

    }
}
