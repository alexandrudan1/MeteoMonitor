package ro.mta.se.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.model.City;

import java.io.*;
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

}
