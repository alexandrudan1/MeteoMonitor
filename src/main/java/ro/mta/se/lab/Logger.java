package ro.mta.se.lab;

import ro.mta.se.lab.model.CurrentWeather;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @author Dan Alexandru
 * Aceasta clasa implementeaza scrierea istoricului in fisierul log.txt
 */
public class Logger {
    public Logger() {
    }
    public void writeToFile(String data,String city,String country, CurrentWeather cw) throws IOException {
        FileWriter fileWriter = new FileWriter("log.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(data+" "+city+", "+country+" temp:"+ cw.get_temp()+" humidity:"+cw.get_humidity()+
                " pressure:"+cw.get_pressure());
        printWriter.close();
    }
}
