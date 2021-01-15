package ro.mta.se.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.CurrentWeather;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Dan Alexandru
 * Aceasta clasa este implementata pentru a realiza diverse functionalitati
 */
public class Utils {

    /**
     * functia initCity() este folosita pentru a citi orasele din fisier
     * si returneaza o lista de orase
     */
    public ObservableList<City> initCity() {
        /**
         * orasData reprezinta lista de orase
         */
        ObservableList<City> orasData = FXCollections.observableArrayList();

        try {
            File obj = new File("src/main/resources/input.txt");
            Scanner scan = new Scanner(obj);
            String data = scan.nextLine();
            while (scan.hasNextLine()) {
                data = scan.nextLine();
                String[] array = data.split(" +");
                City orasNou = new City(array[0], array[1], array[2], array[3], array[4]);
                orasData.add(orasNou);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return orasData;
    }

    /**
     * Aceasta clasa este implementata pentru a realiza conexiunea cu Api-ul Weather pentru a obtine datele
     * de care avem nevoie returnate sub forma unui JSON
     */
    public StringBuffer request_api(String mCity) throws IOException {

        if(mCity!=null) {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + mCity + "&APPID=14a0d1ff361c469075a692aa39f96e6d\n");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer mJson;
            mJson = new StringBuffer(1024);
            String aux = "";

            while ((aux = reader.readLine()) != null)
                mJson.append(aux).append("\n");
            reader.close();

            return mJson;
        }
        else
            return null;
    }
    /**
     * Aceasta clasa este implementata pentru a salva detaliile despre vreme in clasa CurrentWeather
     * returneaza un obiect de tip CurrentWeather
     * @param p
     */
    public CurrentWeather updateWeather(Parser p) throws ParseException, org.json.simple.parser.ParseException {

        CurrentWeather cw=new CurrentWeather(p.get_humidiy(),p.get_visibility(), p.get_temp(), p.get_feels(),p.get_max(),p.get_min(),p.get_pressure());
        return cw;
    }
    /**
     * Aceasta clasa este implementata pentru a obtine ora si data curenta
     * returneaza un obiect de tip string
     */
    public String get_date(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyy");
        LocalDateTime now = LocalDateTime.now();
        String time= dtf.format(now);
        return time;
    }

}
