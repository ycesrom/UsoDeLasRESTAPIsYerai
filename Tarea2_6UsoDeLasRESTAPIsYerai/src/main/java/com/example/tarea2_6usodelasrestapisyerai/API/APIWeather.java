package com.example.tarea2_6usodelasrestapisyerai.API;


import com.example.tarea2_6usodelasrestapisyerai.Modelos.LocationWeather;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface APIWeather {

    @GET("current")
    Call<LocationWeather> cargarDatosClimaticos();
}
