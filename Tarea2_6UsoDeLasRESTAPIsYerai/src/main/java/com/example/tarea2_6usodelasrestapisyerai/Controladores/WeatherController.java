package com.example.tarea2_6usodelasrestapisyerai.Controladores;

import com.example.tarea2_6usodelasrestapisyerai.API.APIClient;
import com.example.tarea2_6usodelasrestapisyerai.API.APIWeather;
import com.example.tarea2_6usodelasrestapisyerai.Modelos.LocationWeather;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Collections;
import java.util.List;

public class WeatherController {
    // Lista observable para almacenar los datos
    private ObservableList<LocationWeather> datos;
    @FXML
    private Button btnTiempo;
    public void initialize(){
        btnTiempo.setOnAction(e-> {
    obtenerDatosRest("London");


                    });
    }
    // Método para obtener datos del clima
    public void obtenerDatosRest(String city) {
        // Crea el servicio de la API
        APIWeather apiService = APIClient.getClient("Madrid").create(APIWeather.class);

        // Llama al servicio para obtener los datos
        Call<LocationWeather> call = apiService.cargarDatosClimaticos();
        call.enqueue(new Callback<LocationWeather>() {


            @Override
            public void onResponse(Call<LocationWeather> call, Response<LocationWeather> response) {
            System.out.println("Respinse body"+response.body());
            System.out.println("Respomnse code "+response.code());

                if (response.isSuccessful()) {
                    // Si la respuesta es exitosa, se asignan los datos a la lista observable
                    List<LocationWeather> datosaux = Collections.singletonList(response.body());
                    datos = FXCollections.observableList(datosaux);

                    // Llamamos al método para cargar los datos en la tabla
                    cargarDatosTabla();
                } else {
                    // Si no se pudo conectar, muestra una alerta de error
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha podido conectar con el servidor. Inténtelo más tarde.", ButtonType.OK);
                    alert.showAndWait();
                }
            }



            public void onFailure(Call<LocationWeather> call, Throwable throwable) {
                // Imprime el error si ocurre una falla
                throwable.printStackTrace();
            }
        });
    }

    // Método para cargar los datos en la tabla (a implementar)
    private void cargarDatosTabla() {
        // Aquí debes agregar la lógica para cargar los datos en una tabla o interfaz gráfica
        // Por ejemplo, si tienes una TableView, podrías hacer algo como:
        // miTableView.setItems(datos);
    }
}
