module com.example.juntaelectoral {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juntaelectoral to javafx.fxml;
    exports com.example.juntaelectoral;
}