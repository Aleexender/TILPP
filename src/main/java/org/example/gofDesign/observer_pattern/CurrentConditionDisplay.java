package org.example.gofDesign.observer_pattern;

import org.example.gofDesign.observer_pattern.observer.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {//float temp, float humidity, float pressure
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("current state" + temperature +
            "humidity = " + humidity);
    }
}
