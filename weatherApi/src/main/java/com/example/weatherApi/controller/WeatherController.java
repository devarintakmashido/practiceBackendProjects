package com.example.weatherApi.controller;

import com.example.weatherApi.dto.OpenWeatherResponse;
import com.example.weatherApi.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather") // The base hallway
public class WeatherController {

    // 1. We ONLY inject the Service. The Controller doesn't need RestTemplate.
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<OpenWeatherResponse> getWeather(@PathVariable String city) {

        OpenWeatherResponse weatherData = weatherService.getWeatherForCity(city);

        return ResponseEntity.ok(weatherData);
    }
}