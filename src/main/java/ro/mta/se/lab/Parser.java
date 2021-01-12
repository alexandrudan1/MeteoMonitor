package ro.mta.se.lab;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
    StringBuffer json;

    public Parser(StringBuffer json )
    {
        this.json=json;
    }
    public String get_main() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) jsonn.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String main_desc= (String) weatherob.get("main");
        return main_desc;
    }
    public String get_temp() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) jsonn.get("main");
        double temperatura=  (double)mainOb.get("temp");
        temperatura=temperatura-273.15;
        int temp_i=(int)temperatura;
        String temp_s=String.valueOf(temp_i);
        return temp_s+"\u00B0" + "C";
    }
    public String get_feels() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) jsonn.get("main");
        double temperatura=  (double)mainOb.get("feels_like");
        temperatura=temperatura-273.15;
        int temp_i=(int)temperatura;
        String temp_s=String.valueOf(temp_i);
        return temp_s+"\u00B0" + "C";
    }
    public String get_max() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainOb= (JSONObject) jsonn.get("main");
        double temperatura=  (double)mainOb.get("temp_max");
        temperatura=temperatura-273.15;
        int temp_i=(int)temperatura;
        String temp_s=String.valueOf(temp_i);
        return temp_s+"\u00B0" + "C";
    }
    public String get_min() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("main");
        double temperatura=  (double)mainobj.get("temp_min");
        temperatura=temperatura-273.15;
        int temp_i=(int)temperatura;
        String temp_s=String.valueOf(temp_i);
        return temp_s+"\u00B0" + "C";
    }
    public String get_lat() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject coordOb= (JSONObject) jsonn.get("coord");
        var latitudine=coordOb.get("lat");
        return latitudine.toString();

    }
    public String get_lon() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject coordOb= (JSONObject) jsonn.get("coord");
        var lon=coordOb.get("lon");
        return lon.toString();
    }
    public String get_pressure() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("main");
        var press= mainobj.get("pressure");
        return press.toString()+" hPa";
    }
    public String get_humidiy() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("main");
        var hum= mainobj.get("humidity");
        return hum.toString()+" %";
    }
    public String get_wind() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("wind");
        var vant=mainobj.get("speed");
        return vant.toString()+" m/s";
    }
    public String get_visibility() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        long visib =(long)jsonn.get("visibility");
        visib=visib/1000;
        String visib_s=String.valueOf(visib);
        return visib_s+" km";
    }
    public String get_country() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("sys");
        var country=  mainobj.get("country");
        return country.toString();
    }

}
