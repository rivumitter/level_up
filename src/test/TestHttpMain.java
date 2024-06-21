package test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestHttpMain {

    public static void main(String[] args) throws IOException, InterruptedException {

        //uses  https://rapidapi.com/navii/api/pin-codes-india

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pincode.p.rapidapi.com/"))
                .header("content-type", "application/json")
                .header("Content-Type", "application/json")
                .header("X-RapidAPI-Key", "70331ac9c3mshda64f47fc958bb1p1c7567jsn44826bde8a98")
                .header("X-RapidAPI-Host", "pincode.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\r\n    \"searchBy\": \"pincode\",\r\n    \"value\": 711109\r\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
