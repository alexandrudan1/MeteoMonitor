package ro.mta.se.lab.controller;
import javafx.collections.ObservableList;
import ro.mta.se.lab.model.City;

public class WeatherController {
    private ObservableList<City> cityData;

    public WeatherController(ObservableList<City> cityData) {
        this.cityData = cityData;
    }

}

