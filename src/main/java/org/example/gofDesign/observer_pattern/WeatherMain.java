package org.example.gofDesign.observer_pattern;

public class WeatherMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80, 65,39.4f);


    }
}
