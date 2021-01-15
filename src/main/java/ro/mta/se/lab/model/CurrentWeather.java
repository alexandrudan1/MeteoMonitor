package ro.mta.se.lab.model;

/**
 * @author Dan Alexandru
 * Clasa CurrentWeather va tine evidenta vremii curente intr un anumit oras
 */
public class CurrentWeather {
    /**
     * membrul temp reprezinta temperatura in grade C
     * membrul feels_like reprezinta temperatura resimtita in grade C
     * membrul max reprezinta temperatura maxima in grade C
     * membrul min reprezinta temperatura minima in grade C
     * membrul visibility reprezinta vizibilitatea
     * membrul humidity reprezinta umiditatea
     * membrul pressure reprezinta presiunea
     */
    private String humidity;
    private String visibility;
    private String temp;
    private String feels_like;
    private String max;
    private String min;
    private String pressure;

    /**
     * constructor
     * @param temp
     * @param feels_like
     * @param max
     * @param min
     * @param pressure
     * @param visibility
     * @param humidity
     */
    public CurrentWeather(String humidity, String visibility, String temp, String feels_like, String max, String min, String pressure) {
        this.humidity = humidity;
        this.visibility = visibility;
        this.temp = temp;
        this.feels_like = feels_like;
        this.max = max;
        this.min = min;
        this.pressure = pressure;
    }

    /**
     * gettere peentru diferite date despre vreme
     * @return
     */
    public String get_humidity(){
        return humidity;
    }

    public String get_visibility(){
        return visibility;
    }
    public String get_temp(){
        return temp;
    }
    public String get_feels(){
        return feels_like;
    }
    public String get_min(){
        return min;
    }
    public String get_max(){
        return max;
    }
    public String get_pressure(){
        return pressure;
    }



}
