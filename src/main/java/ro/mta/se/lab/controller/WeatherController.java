package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;
import ro.mta.se.lab.Logger;
import ro.mta.se.lab.Utils;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.Parser;
import ro.mta.se.lab.model.CurrentWeather;
import java.io.*;

/**
 * @author Dan Alexandru
 * WeatherController este un controller pentru modelul MVC si face legatura dintre model si view.
 */
public class WeatherController {

    /**
     * membrul mCity reprezinta orasul selectat de utilizator
     * membrul mCountry reprezinta tara selecata de utilizator
     * membrul cityData reprezinta lista de orase citite din fisier
     * membrul countryList reprezinta tarile din care fac parte orasele citite din fisier
     * membrul selectcountry este combobox-ul pentru alegerea tarii din interfata grafica
     * membrul selectcity este combobox-ul pentru alegerea orasului din interfata grafica
     * label-urile  sunt folosite pentru a afisa in detalii despre vreme in interfata grafica
     */
    private ObservableList<City> cityData;
    private ObservableList<String> countryList = FXCollections.observableArrayList();
    private String mCountry;
    private String mCity;

    @FXML
    private ComboBox<String> selectcountry;
    @FXML
    private ComboBox<String> selectcity;
    @FXML
    private ImageView img;
    @FXML
    private ImageView logo;
    @FXML
    private Label city_name;
    @FXML
    private Label lon;
    @FXML
    private Label lat;
    @FXML
    private Label main;
    @FXML
    private Label temp;
    @FXML
    private Label feels;
    @FXML
    private Label max;
    @FXML
    private Label min;
    @FXML
    private Label pressure;
    @FXML
    private Label wind;
    @FXML
    private Label visibility;
    @FXML
    private Label humidity;
    @FXML
    private Label time;

    /**
     * constructor pentur clasa WeatherController
     * @param cityData reprezinta orasele citite din fisier si transmise la Controller
     */
    public WeatherController(ObservableList<City> cityData) {
        this.cityData = cityData;
    }

    /**
     * Functia in care se creeaza o lista cu tarile
     */
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

    /**
     * Functia care afiseaza tarile in GUI
     */
    @FXML
    private void select_country() {
        initCountryList();
        selectcountry.getItems().clear();
        for (String country : countryList) {
            selectcountry.getItems().add(country);
        }
    }
    /**
     * functie care  pune in mCountry tara selectata de utilizator in GUI
     */
    @FXML
    private void selected_Country() {
        mCountry = (String) selectcountry.getValue();
    }

    /**
     * Functia care afiseaza orasele in GUI
     */
    @FXML
    private void select_city() {
        selectcity.getItems().clear();
        for (City city : cityData) {
            if(city.getCountry().equals(mCountry))
                selectcity.getItems().add(city.getNume());
        }
    }
    /**
     * functie care pune in mCity orasul selectat de utilizator in GUI
     * si apeleaza functia get_Info() pentru a obtine datele meteo
     */
    @FXML
    private void selected_City() throws IOException, ParseException, java.text.ParseException {
        mCity = (String) selectcity.getValue();
        if(mCity!=null)
            get_Info();
    }

    /**
     * in functia get_Info() se obtin datele meteo pentru orasul ales
     * utilizeaza un obiect din clasa Util care va efectua un request la API si returneaza un JSON
     * un obiect Parser se ocupa de parsarea fisierului JSON si returneaza datele relevante despre vreme
     * date despre vreme se retin in clasa CurrentWeather
     * se instantiaza si un obiect Logger care scrie intr-un fisier istoricul
     */
    public void get_Info() throws IOException, ParseException, java.text.ParseException {

        Utils util = new Utils();
        Logger logger=new Logger();
        StringBuffer json=util.request_api(mCity);
        if(json==null){
            System.out.println("Eroare API");
        }
        Parser parser=new Parser(json);
        CurrentWeather cw= util.updateWeather(parser);

        temp.setText(cw.get_temp());
        feels.setText(cw.get_feels());
        max.setText(cw.get_max());
        min.setText(cw.get_min());
        visibility.setText(cw.get_visibility());
        pressure.setText(cw.get_pressure());
        humidity.setText(cw.get_humidity());

        wind.setText(parser.get_wind());
        city_name.setText(mCity+ ", "+parser.get_country());
        main.setText(parser.get_main());
        lat.setText(parser.get_lat());
        lon.setText(parser.get_lon());

        String timp=util.get_date();
        time.setText(timp);

        logger.writeToFile(timp,mCity,mCountry,cw);

        /**
         * se alege o imagine in functie de starea vremii
         */
        Image  image=new Image("sun.png");
        switch(parser.get_main()) {
            case "Snow":
                image=new Image("snow.png");
                break;
            case "Clouds":
                image=new Image("cloud.png");
                break;
            case "Rain":
                image=new Image("rain.png");
                break;
            case "Clear":
                image=new Image("clear.png");
                break;
            default:
                image=new Image("sun.png");
        }
        img.setImage(image);
    }
}

