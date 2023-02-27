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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ResumenComunidadController implements Initializable {

    final static String pp = "PP";
    final static String bng = "BNG";
    final static String psdeg = "PSdeG";
    final static String mareaGaleguista = "M. Gal.";
    final static String podemos = "Podemos";
    final static String pacma = "PACMA";

    @FXML
    BarChart<String, Number> barChart;
    @FXML
    CategoryAxis categoryAxis;
    @FXML
    NumberAxis numberAxis;
    @FXML
    BarChart<String, Number> barChartEscaños;
    @FXML
    CategoryAxis categoryAxisE;
    @FXML
    NumberAxis numberAxisE;
    @FXML
    PieChart pieChart;
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Votado", 75), new PieChart.Data("No Votado", 25));
    double votado, noVotado;
    int votosTotales = 0;
    final int censoElectoral = 2697490;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Votos");
        series1.getData().add(new XYChart.Data(pp, 0));
        series1.getData().add(new XYChart.Data(bng, 0));
        series1.getData().add(new XYChart.Data(psdeg, 0));
        series1.getData().add(new XYChart.Data(mareaGaleguista, 0));
        series1.getData().add(new XYChart.Data(podemos, 0));
        series1.getData().add(new XYChart.Data(pacma, 0));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Escaños");
        series2.getData().add(new XYChart.Data(pp, 0));
        series2.getData().add(new XYChart.Data(bng, 0));
        series2.getData().add(new XYChart.Data(psdeg, 0));
        series2.getData().add(new XYChart.Data(mareaGaleguista, 0));
        series2.getData().add(new XYChart.Data(podemos, 0));
        series2.getData().add(new XYChart.Data(pacma, 0));

        barChart.getData().addAll(series1);
        barChartEscaños.getData().addAll(series2);

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                CuadroMandoController cmc = new CuadroMandoController();
                                ObservableList<XYChart.Data<String, Number>> listaVotos = barChart.getData().get(0).getData();
                                ObservableList<XYChart.Data<String, Number>> listaEscaños = barChartEscaños.getData().get(0).getData();
                                Random random = new Random();

                                int votosPP = (int) listaVotos.get(0).getYValue();
                                int votosBNG = (int) listaVotos.get(1).getYValue();
                                int votosPSdeG = (int) listaVotos.get(2).getYValue();
                                int votosMGAL = (int) listaVotos.get(3).getYValue();
                                int votosPodemos = (int) listaVotos.get(4).getYValue();
                                int votosPACMA = (int) listaVotos.get(5).getYValue();
                                int voto = (int) Math.round(random.nextGaussian(10000, 5000));
                                if (voto < 0) {
                                    voto = 0;
                                }
                                ArrayList<String> partidos = new ArrayList<>();
                                partidos.add("PP");
                                partidos.add("BNG");
                                partidos.add("PSdeG");
                                partidos.add("MGAL");
                                partidos.add("Podemos");
                                partidos.add("PACMA");
                                String partidoSelec = partidos.get((int) (Math.random() * partidos.size()));
                                switch (partidoSelec) {
                                    case "PP":
                                        if (voto + votosPP < cmc.votosPP) {
                                            votosPP += voto;
                                            votosTotales += voto;
                                            listaVotos.get(0).setYValue(votosPP);
                                        } else {
                                            listaVotos.get(0).setYValue(cmc.votosPP);
                                            votosPP = cmc.votosPP;
                                            votosTotales += voto;
                                            partidos.remove("PP");
                                        }
                                        break;
                                    case "BNG":
                                        if (voto + votosBNG < cmc.votosBNG) {
                                            votosBNG += voto;
                                            votosTotales += voto;
                                            listaVotos.get(1).setYValue(votosBNG);
                                        } else {
                                            listaVotos.get(1).setYValue(cmc.votosBNG);
                                            votosBNG = cmc.votosBNG;
                                            votosTotales += voto;
                                            partidos.remove("BNG");
                                        }
                                        break;
                                    case "PSdeG":
                                        if (voto + votosPSdeG < cmc.votosPSdeG) {
                                            votosPSdeG += voto;
                                            votosTotales += voto;
                                            listaVotos.get(2).setYValue(votosPSdeG);
                                        } else {
                                            listaVotos.get(2).setYValue(cmc.votosPSdeG);
                                            votosPSdeG = cmc.votosPSdeG;
                                            votosTotales += voto;
                                            partidos.remove("PSdeG");
                                        }
                                        break;
                                    case "MGAL":
                                        if (voto + votosMGAL < cmc.votosMGAL) {
                                            votosMGAL += voto;
                                            votosTotales += voto;
                                            listaVotos.get(3).setYValue(votosMGAL);
                                        } else {
                                            listaVotos.get(3).setYValue(cmc.votosMGAL);
                                            partidos.remove("MGAL");
                                            votosTotales += voto;
                                        }
                                        break;
                                    case "Podemos":
                                        if (voto + votosPodemos < cmc.votosPodemos) {
                                            votosPodemos += voto;
                                            votosTotales += voto;
                                            listaVotos.get(4).setYValue(votosPodemos);
                                        } else {
                                            listaVotos.get(4).setYValue(cmc.votosPodemos);
                                            partidos.remove("Podemos");
                                            votosTotales += voto;
                                        }
                                        break;
                                    case "PACMA":
                                        if (voto + votosPACMA < cmc.votosPACMA) {
                                            votosPACMA += voto;
                                            votosTotales += voto;
                                            listaVotos.get(5).setYValue(votosPACMA);
                                        } else {
                                            listaVotos.get(5).setYValue(cmc.votosPACMA);
                                            partidos.remove("PACMA");
                                            votosTotales += voto;
                                        }
                                        break;
                                }
                                int[] votosEscaños = {votosPP, votosBNG, votosPSdeG, votosPodemos, votosPACMA};
                                CalculoVotaciones cv = new CalculoVotaciones();
                                List<Integer> listaEscañosActual = cv.dHondt(75, votosEscaños);
                                for (int i = 0; i < listaEscañosActual.size(); i++) {
                                    listaEscaños.get(i).setYValue(listaEscañosActual.get(i));
                                }
                                double porcentajeVotos = (votosTotales * 100);
                                porcentajeVotos = (porcentajeVotos / censoElectoral) * 100;
                                double porcentaje2 = 100 - porcentajeVotos;
                                for (PieChart.Data d : pieChartData) {
                                    d.setPieValue(porcentajeVotos);
                                    d.setPieValue(porcentaje2);
                                }
//                                pieChartData.set(0, new PieChart.Data("Votado", porcentajeVotos));
//                                pieChartData.set(1, new PieChart.Data("No votado", porcentaje2));

//                                for (XYChart.Series<String, Number> series : barChart.getData())  {
//                                    for (XYChart.Data<String, Number> data : series.getData()) {
//                                        data.setYValue(Math.random() * 1000);
//                                    }
//                                }

                            }
                        }
                ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(false);
        tl.play();

        pieChart.getData().addAll(pieChartData);

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        for (
                final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }


    }
}
