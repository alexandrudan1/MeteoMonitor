package ro.mta.se.lab.model;

public class CurrentWeather {
    private String humidity;
    private String visibility;
    private String temp;
    private String feels_like;
    private String max;
    private String min;
    private String pressure;

    public CurrentWeather(String humidity, String visibility, String temp, String feels_like, String max, String min, String pressure) {
        this.humidity = humidity;
        this.visibility = visibility;
        this.temp = temp;
        this.feels_like = feels_like;
        this.max = max;
        this.min = min;
        this.pressure = pressure;
    }

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
