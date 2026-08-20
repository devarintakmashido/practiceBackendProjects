package com.example.weatherApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OpenWeatherResponse {

    private String name; // The city name
    private Main main;   // The nested "main" object (temp, humidity, etc.)
    private List<Weather> weather; // The nested "weather" array

    // --- Inner Class for "main" ---
    public static class Main {
        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }
    }

    // --- Inner Class for "weather" ---
    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    // --- Getters and Setters for the main class ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}