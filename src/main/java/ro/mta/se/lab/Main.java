package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.controller.WeatherController;
import ro.mta.se.lab.model.City;

/**
 * @author Dan Alexandru
 * clasa Main realizeaza citirea oraselor din fisier si
 * pornirea aplicatiei prin initializarea controller-ului si a scenei(view)
 */



public class Main extends Application {
    /**
     * membrul orasData reprezinta lista de orase citite din fisier
     * care urmeaza a fi trimisa Controller-ului
     */

    private ObservableList<City> orasData = FXCollections.observableArrayList();

    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * Pornirea aplicatiei pe modelul mvc
     */
    public void start(Stage primaryStage) {
        /**
         * se apeleaza functia initCity() din Utils care returneaza lista de orase
         * citite din fisierul de intrare
         */
        Utils utils=new Utils();
        orasData=utils.initCity();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new WeatherController(orasData));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}