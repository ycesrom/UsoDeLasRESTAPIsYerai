package com.example.tarea2_6usodelasrestapisyerai;

import com.example.tarea2_6usodelasrestapisyerai.API.ConectorAPI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }





            public static void main(String[] args) {
                ConectorAPI conectorAPI = new ConectorAPI();
                String city = "Madrid"; // Cambia por la ciudad que desees consultar

                try {
                    String response = conectorAPI.fetchWeather(city);
                    System.out.println("Respuesta de la API:");
                    System.out.println(response);
                } catch (Exception e) {
                    System.err.println("Error al conectar con la API: " + e.getMessage());
                }

           launch();}
}
