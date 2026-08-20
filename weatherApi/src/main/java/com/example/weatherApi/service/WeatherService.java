package com.example.weatherApi.service;

import com.example.weatherApi.dto.OpenWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    // This grabs the URL from application.properties!
    @Value("${weather.api.url}")
    private String apiUrl;

    // This grabs your secret key from application.properties!
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OpenWeatherResponse getWeatherForCity(String city) {
        String finalUrl = apiUrl.replace("{city}", city).replace("{key}", apiKey);

        // Magic: We tell RestTemplate to convert the JSON directly into our DTO!
        return restTemplate.getForObject(finalUrl, OpenWeatherResponse.class);
    }
}