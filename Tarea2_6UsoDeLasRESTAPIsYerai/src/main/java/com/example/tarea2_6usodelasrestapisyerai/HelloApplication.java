package com.example.tarea2_6usodelasrestapisyerai;

import com.example.tarea2_6usodelasrestapisyerai.API.APIClient;
import com.example.tarea2_6usodelasrestapisyerai.Controladores.WeatherController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.show();
    }





            public static void main(String[] args) {

            WeatherController controller = new WeatherController();
            controller.obtenerDatosRest("London");
           launch();}
}
