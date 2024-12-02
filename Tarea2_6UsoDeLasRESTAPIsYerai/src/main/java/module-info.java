module com.example.tarea2_6usodelasrestapisyerai {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires okhttp3;


    opens com.example.tarea2_6usodelasrestapisyerai to javafx.fxml;
    exports com.example.tarea2_6usodelasrestapisyerai;
    exports com.example.tarea2_6usodelasrestapisyerai.Modelos;
    opens com.example.tarea2_6usodelasrestapisyerai.Modelos to javafx.fxml;
    exports com.example.tarea2_6usodelasrestapisyerai.Controladores;
    opens com.example.tarea2_6usodelasrestapisyerai.Controladores to javafx.fxml;
}