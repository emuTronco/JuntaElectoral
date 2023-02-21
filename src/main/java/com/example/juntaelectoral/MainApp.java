package com.example.juntaelectoral;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private BorderPane rootLayout;

    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("ventanaPrincipal.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();
        PrincipalController menuController = fxmlLoader.getController();
        menuController.setRootLayout(rootLayout);

        Scene scene = new Scene(rootLayout);
        stage.setTitle("Junta Electoral");
        stage.setScene(scene);
        stage.show();
    }

    public MainApp() {
        rootLayout = getRootLayout();
    }

    public static void main(String[] args) {
        launch();
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}