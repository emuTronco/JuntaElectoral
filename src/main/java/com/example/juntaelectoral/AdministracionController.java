package com.example.juntaelectoral;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministracionController implements Initializable {

    @FXML
    private AnchorPane rootLayout;

    @FXML
    ListView<String> lvAdmin = new ListView<String>();

    @FXML
    private ObservableList usuarios = FXCollections.observableArrayList();

    @FXML
    private HBox hBox;


    @FXML
    private ColorPicker cPFondo;
    @FXML
    private ColorPicker cPTexto;
    @FXML
    private ColorPicker cPResaltado;
    @FXML
    private Accordion a1 = new Accordion();


    private MainApp mainApp;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarios.add("Usuario");
        usuarios.add("Administrador");
        lvAdmin.setItems(usuarios);


    }

    @FXML
    public void cambiarPermisos() {
        ObservableList velRefresco = FXCollections.observableArrayList("Automático", "Manual", "Desactivado");
        if (lvAdmin.getSelectionModel().isSelected(1)) {
            hBox.getChildren().clear();
            Pane pane = new Pane();
            a1 = new Accordion();
            TitledPane t1 = new TitledPane();
            TitledPane t2 = new TitledPane("Duración", new TextField());
            TitledPane t3 = new TitledPane("Refresco", new ComboBox<String>(velRefresco));
            a1.getPanes().addAll(t1, t2, t3);
            hBox.getChildren().add(a1);
            hBox.setHgrow(a1, Priority.ALWAYS);
            cargarLayout(t1, "/com/example/juntaelectoral/listadoUsuarios.fxml");
            System.out.println(0);
//            mainApp.getPrimaryStage().setWidth(mainApp.getPrimaryStage().getWidth() + 0.0001);
        } else if (lvAdmin.getSelectionModel().isSelected(0)) {
            hBox.getChildren().clear();
            a1 = new Accordion();
            TitledPane t1 = new TitledPane("Usuarios", new Button("B1"));
            TitledPane t2 = new TitledPane("Contraste", new TextField());
            a1.getPanes().addAll(t1, t2);
            hBox.getChildren().add(a1);
            hBox.setHgrow(a1, Priority.ALWAYS);

            cargarLayout(t1, "/com/example/juntaelectoral/creacionUsuarios.fxml");
            cargarLayout(t2, "/com/example/juntaelectoral/cambioColor.fxml");

            System.out.println(1);
        }
    }

    private static void cargarLayout(TitledPane t1, String ruta) {
        try {
            // Cargamos el archivo Controles Dinámicos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrincipalController.class.getResource(ruta));
            AnchorPane listadoControles = (AnchorPane) loader.load();

            // Se sitúa en el centro del diseño principal

            t1.setContent(listadoControles);
//                AdministracionController controller = loader.getController();
//                controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    public void cambiarColor(ActionEvent actionEvent) {
        ColorPicker colorSelec = (ColorPicker) actionEvent.getSource();
        String seleccionado = colorSelec.getId();
        System.out.println(seleccionado);
        switch (seleccionado) {
            case "cPFondo":
                System.out.println("Si");
                colorSelec.getParent().setStyle("-fx-background-color: red");
                colorSelec.getParent().getParent().setStyle("-fx-background-color: red");
                colorSelec.getParent().getParent().getParent().getParent().setStyle("-fx-background-color: red");
//                rootLayout.setStyle("-fx-background-color: red");
                System.out.println("Si");
                break;
        }
        System.out.println("Fin");
    }
}