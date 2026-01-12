package com.alulacursos.conversormonedasjosue.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultarTasa {

    public Conversor obtenerTasa(String monedaBase, String monedaDestino) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/e46c3e461893c78e67674441/pair/" + monedaBase + "/" + monedaDestino);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(url).build();

        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), Conversor.class);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al consultar la API: " + e.getMessage());
            return null;
        }
    }
}