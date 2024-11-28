package com.example.tarea2_6usodelasrestapisyerai.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConectorAPI
{
    private final String APIKey="83373fd520b3954dad1736ccde09903b";
    public String fetchWeather(String city) throws IOException {
        String APIUrl="https://api.weatherstack.com/current?access_key="+APIKey+"&query="+city;
        URL url = new URL(APIUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        System.out.println(response.toString());


        return APIUrl;
    }
}
