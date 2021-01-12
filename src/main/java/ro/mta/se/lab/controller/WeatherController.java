package ro.mta.se.lab.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ro.mta.se.lab.Utils;
import ro.mta.se.lab.model.City;

import java.io.IOException;
import java.text.ParseException;

public class WeatherController {
    private ObservableList<City> cityData;
    private ObservableList<String> countryList = FXCollections.observableArrayList();
    private String mCountry;
    private String mCity;

    @FXML
    private ComboBox<String> selectcountry;
    @FXML
    private ComboBox<String> selectcity;

    public WeatherController(ObservableList<City> cityData) {
        this.cityData = cityData;
    }



    private void initCountryList() {

        for (City city : cityData) {
            int alreadyIs = 0;
            for (String country : countryList) {
                if (city.getCountry().equals(country)) {
                    alreadyIs = 1;
                }
            }
            if (alreadyIs == 0) {
                countryList.add(city.getCountry());
            }
        }

    }

    @FXML
    private void select_country() {
        initCountryList();
        selectcountry.getItems().clear();
        for (String country : countryList) {
            selectcountry.getItems().add(country);
        }
    }
    @FXML
    private void selected_Country() {
        mCountry = (String) selectcountry.getValue();
    }

    @FXML
    private void select_city() {
        selectcity.getItems().clear();
        for (City city : cityData) {
            if(city.getCountry().equals(mCountry))
                selectcity.getItems().add(city.getNume());
        }
    }
    @FXML
    private void selected_City() throws IOException, ParseException {
        mCity = (String) selectcity.getValue();
    }
    public void get_Info() throws IOException, ParseException {

        Utils util = new Utils();
        StringBuffer json = util.request_api(mCity);
    }

}

