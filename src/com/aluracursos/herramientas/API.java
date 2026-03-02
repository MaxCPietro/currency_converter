package com.aluracursos.herramientas;

import com.aluracursos.challengeconversor.PrincipalDivisas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public String API() {
        final String keyAPI = "a07eae42ac1c092fdcaabf56";
        final String URL = "https://v6.exchangerate-api.com/v6/" + keyAPI + "/latest/" + PrincipalDivisas.divisaInicial;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la solicitud a la API");
            return null;
        }
    }
}