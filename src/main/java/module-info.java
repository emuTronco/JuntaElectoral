module com.example.juntaelectoral {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;

    opens com.example.juntaelectoral to javafx.fxml;
    exports com.example.juntaelectoral;
}