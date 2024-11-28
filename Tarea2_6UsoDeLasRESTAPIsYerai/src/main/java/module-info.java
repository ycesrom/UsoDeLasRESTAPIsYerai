module com.example.tarea2_6usodelasrestapisyerai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea2_6usodelasrestapisyerai to javafx.fxml;
    exports com.example.tarea2_6usodelasrestapisyerai;
}