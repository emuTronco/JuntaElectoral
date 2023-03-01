package com.example.juntaelectoral;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AnimacionResultadosController implements Initializable {
    @FXML
    CategoryAxis categoryAxisSAC, categoryAxisLC;
    @FXML
    NumberAxis numberAxisSAC, numberAxisLC;

    @FXML
    StackedAreaChart <String, Number> stackedAreaChart;
    @FXML
    LineChart lineChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryAxisSAC.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("9:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00" )));
        categoryAxisLC.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("9:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00" )));

        //Prepare XYChart.Series objects by setting data
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data("9:00", 502));
        series1.getData().add(new XYChart.Data("11:00", 635));
        series1.getData().add(new XYChart.Data("13:00", 809));
        series1.getData().add(new XYChart.Data("15:00", 947));
        series1.getData().add(new XYChart.Data("17:00", 1402));
        series1.getData().add(new XYChart.Data("19:00", 3634));
        series1.getData().add(new XYChart.Data("21:00", 5268));

        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data("9:00", 106));
        series2.getData().add(new XYChart.Data("11:00", 107));
        series2.getData().add(new XYChart.Data("13:00", 111));
        series2.getData().add(new XYChart.Data("15:00", 133));
        series2.getData().add(new XYChart.Data("17:00", 221));
        series2.getData().add(new XYChart.Data("19:00", 767));
        series2.getData().add(new XYChart.Data("21:00", 1766));

        stackedAreaChart.getData().addAll(series1, series2);

        XYChart.Series series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data("9:00", 20));
        series3.getData().add(new XYChart.Data("11:00", 25));
        series3.getData().add(new XYChart.Data("13:00", 36));
        series3.getData().add(new XYChart.Data("15:00", 47));
        series3.getData().add(new XYChart.Data("17:00", 52));
        series3.getData().add(new XYChart.Data("19:00", 60));
        series3.getData().add(new XYChart.Data("21:00", 65));

        lineChart.getData().add(series3);


    }
}
