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


public class Main extends Application {

    private ObservableList<City> orasData = FXCollections.observableArrayList();

    public static void main(String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage) {
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