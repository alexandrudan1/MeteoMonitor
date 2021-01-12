package ro.mta.se.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.model.City;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Utils {

    public ObservableList<City> initCity() {
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
    public StringBuffer request_api(String mCity) throws IOException {

        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+mCity+"&APPID=14a0d1ff361c469075a692aa39f96e6d\n");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer mJson;
        mJson = new StringBuffer(1024);
        String aux = "";

        while((aux = reader.readLine()) != null)
            mJson.append(aux).append("\n");
        reader.close();

        return mJson;
    }

}
