package com.example.juntaelectoral;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdministracionController implements Initializable {

    @FXML
    private AnchorPane rootLayout;

    @FXML
    ListView<String> lvAdmin = new ListView<String>();

    @FXML
    protected ObservableList tipoUsuario = FXCollections.observableArrayList();
    @FXML
    protected static ObservableList listadoUsuarios = FXCollections.observableArrayList();
    protected ArrayList<Usuario> listadoUsuariosAL = new ArrayList<>();

    @FXML
    private HBox hBox;
    @FXML
    ListView<String> lvUsuarios = new ListView<>();

    @FXML
    private ColorPicker cPFondo;
    @FXML
    private ColorPicker cPTexto;
    @FXML
    private ColorPicker cPResaltado;
    @FXML
    private Accordion a1 = new Accordion();
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContrasenia;
    static int contador = 0;


    private static MainApp mainApp;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoUsuario.add("Usuario");
        tipoUsuario.add("Administrador");
        lvAdmin.setItems(tipoUsuario);
        if (contador == 0) {
            listadoUsuarios.add(new Usuario("sdf", "fe", false));
            contador++;
        }

        System.out.println("Pane: " + rootLayout);
        lvUsuarios.getItems().addAll(listadoUsuarios);

    }

    @FXML
    public void cambiarPermisos() {
        ObservableList velRefresco = FXCollections.observableArrayList("Automático", "Manual", "Desactivado");
        if (lvAdmin.getSelectionModel().isSelected(1)) {
            hBox.getChildren().clear();
            a1 = new Accordion();
            TitledPane t1 = new TitledPane("Usuarios", new TextField());
            TitledPane t2 = new TitledPane("Duración", new TextField());
            TitledPane t3 = new TitledPane("Refresco", new ComboBox<String>(velRefresco));
            a1.getPanes().addAll(t1, t2, t3);
            hBox.getChildren().add(a1);
            hBox.setHgrow(a1, Priority.ALWAYS);
            cargarLayout(t1, "/com/example/juntaelectoral/listadoUsuarios.fxml", "listadoUsuarios");
            System.out.println(0);
        } else if (lvAdmin.getSelectionModel().isSelected(0)) {
            hBox.getChildren().clear();
            a1 = new Accordion();
            TitledPane t1 = new TitledPane("Usuarios", new Button("B1"));
            TitledPane t2 = new TitledPane("Contraste", new TextField());
            a1.getPanes().addAll(t1, t2);
            hBox.getChildren().add(a1);
            hBox.setHgrow(a1, Priority.ALWAYS);

            cargarLayout(t1, "/com/example/juntaelectoral/creacionUsuarios.fxml", "creacionUsuarios");
            cargarLayout(t2, "/com/example/juntaelectoral/cambioColor.fxml", "cambioColor");

            System.out.println(1);
        }
    }

    private void cargarLayout(TitledPane t1, String ruta, String controller) {
        try {
            t1.setContent(FXMLLoader.load(getClass().getResource(ruta)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(ActionEvent actionEvent) {
        String usuario = tfUsuario.getText();
        System.out.println(usuario + "AAA");
        String passwrd = tfContrasenia.getText();
        Usuario u1 = new Usuario(usuario, passwrd, false);
        listadoUsuariosAL.add(u1);
        listadoUsuarios.add(u1);
        lvUsuarios.refresh();
        tfUsuario.setText("");
        tfContrasenia.setText("");
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    public void cambiarColor(ActionEvent actionEvent) throws IOException {
        ColorPicker colorSelec = (ColorPicker) actionEvent.getSource();
        String seleccionado = colorSelec.getId();
        System.out.println(seleccionado);
        switch (seleccionado) {
            case "cPFondo":
                System.out.println("Si");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/juntaelectoral/ventanaAdministracion.fxml"));
                Parent root = (Parent) loader.load();

                if (rootLayout != null) {
                    rootLayout.setStyle("-fx-background-color: red");
                }
                System.out.println("Si");
                break;
        }
        System.out.println("Fin");
    }

    public ObservableList getTipoUsuario() {
        return tipoUsuario;
    }

    public void eliminarUsuario(ActionEvent actionEvent) {
        int indice = lvUsuarios.getSelectionModel().getSelectedIndex();
        listadoUsuarios.remove(indice);
        lvUsuarios.getItems().remove(indice);
    }

    public void convertirAdmin(ActionEvent actionEvent) {
        int indice = lvUsuarios.getSelectionModel().getSelectedIndex();
        String cambio = listadoUsuarios.get(indice).toString();
        cambio = cambio.replace("false", "true");
        listadoUsuarios.set(indice, cambio);
        lvUsuarios.getItems().set(indice, cambio);
    }
}