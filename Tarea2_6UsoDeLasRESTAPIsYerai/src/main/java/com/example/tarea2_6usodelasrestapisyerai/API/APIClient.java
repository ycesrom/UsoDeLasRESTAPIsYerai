package com.example.tarea2_6usodelasrestapisyerai.API;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class APIClient {

    private static Retrofit retrofit = null;

    // URL base de la API
    private static final String BASE_URL = "https://api.weatherstack.com/";
    // Tu clave de API
    private static final String API_KEY = "83373fd520b3954dad1736ccde09903b";

    public static Retrofit getClient(String city) {
        if (retrofit == null) {
            // Crea un cliente HTTP con un interceptor para agregar automáticamente la API Key y la ciudad
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            HttpUrl originalUrl = original.url();

                            // Construye la nueva URL con los parámetros necesarios
                            HttpUrl url = originalUrl.newBuilder()
                                    .addQueryParameter("access_key", API_KEY) // Agrega la API Key
                                    .addQueryParameter("query", city) // Agrega la ciudad
                                    .build();

                            // Construye la nueva solicitud con la URL actualizada
                            Request request = original.newBuilder().url(url).build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            // Configura Retrofit con el cliente HTTP modificado
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }



}
