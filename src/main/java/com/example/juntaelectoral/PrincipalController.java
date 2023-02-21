package com.example.juntaelectoral;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Optional;

public class PrincipalController extends MainApp {
    @FXML
    private Label welcomeText;

    @FXML
    private BorderPane rootLayout;

    private Stage primaryStage = super.getPrimaryStage();

    private boolean loginCorrecto = false;
    @FXML
    private TextField usuarioLogin;
    @FXML
    private PasswordField passwordLogin;

    private ObservableList<Usuario> listadoUsuarios = AdministracionController.getListadoUsuarios();
    final String[] usuario = new String[2];


    public PrincipalController() {
        rootLayout = getRootLayout();
    }

    @FXML
    public void cerrarVentana(ActionEvent event) throws IOException {
        try {
            // Cargamos el archivo Controles Dinámicos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrincipalController.class.getResource("/com/example/juntaelectoral/ventanaPrincipalCerrada.fxml"));
            BorderPane listadoControles = (BorderPane) loader.load();

            // Se sitúa en el centro del diseño principal

            rootLayout.setCenter(listadoControles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    @FXML
    public void abrirCuadroMando() throws IOException {
        comprobarLogin();
        if (loginCorrecto) {
            try {
                // Cargamos el archivo Controles Dinámicos
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(PrincipalController.class.getResource("/com/example/juntaelectoral/ventanaCuadroMando.fxml"));
                AnchorPane listadoControles = (AnchorPane) loader.load();

                // Se sitúa en el centro del diseño principal

                rootLayout.setCenter(listadoControles);
                CuadroMandoController controller = loader.getController();
                controller.setMainApp(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void abrirLogin(ActionEvent event) throws IOException {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Usuario");
        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");

        grid.add(new Label("Usuario:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Contraseña:"), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            usuario[0] = usernamePassword.getKey();
            usuario[1] = usernamePassword.getValue();
        });
        System.out.println(usuario[0] + usuario[1]);
        abrirCuadroMando();
    }

    @FXML
    public void comprobarLogin() {
        Usuario userLogin = new Usuario(usuario[0], usuario[1], true);
        for (Usuario user : listadoUsuarios) {
            if (userLogin.getNombre().equals(user.getNombre()) && userLogin.getPassword().equals(user.getPassword()) && user.getEsAdmin() == true) {
                loginCorrecto = true;
            }
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