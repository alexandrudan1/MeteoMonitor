package ro.mta.se.lab;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Dan Alexandru
 * Aceasta clasa implementeaza parsarea json-ului primit ca raspuns de la API
 */
public class Parser {
    /**
     * membrul json reprezinta jsonul care va fi parsat
     */
    StringBuffer json;

    /** Contrustor pentru clasa
     * @param json
     */
    public Parser(StringBuffer json )
    {
        this.json=json;
    }
    /**
     * Functia va parsa json-ul si va intoarce un string ce contine descrierea main a vremii
     * @return
     * @throws ParseException
     */
    public String get_main() throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));

        JSONArray weatherArr= (JSONArray) jsonn.get("weather");
        JSONObject weatherob= (JSONObject) weatherArr.get(0);
        String main_desc= (String) weatherob.get("main");
        return main_desc;
    }
    /**
     * Functia va parsa json-ul si va intoarce temperatura in grade celsius
     * @return
     * @throws ParseException
     */
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
    /**
     * Functia va parsa json-ul si va intoarce temperatura simtita
     * @return
     * @throws ParseException
     */
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
    /**
     * Functia va parsa json-ul si va intoarce temperatura maxima
     * @return
     * @throws ParseException
     */
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
    /**
     * Functia va parsa json-ul si va intoarce temperatura minima
     * @return
     * @throws ParseException
     */
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
    /**
     * Functia va parsa json-ul si va intoarce latitudinea
     * @return
     * @throws ParseException
     */
    public String get_lat() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject coordOb= (JSONObject) jsonn.get("coord");
        var latitudine=coordOb.get("lat");
        return latitudine.toString();

    }
    /**
     * Functia va parsa json-ul si va intoarce longitudinea
     * @return
     * @throws ParseException
     */
    public String get_lon() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject coordOb= (JSONObject) jsonn.get("coord");
        var lon=coordOb.get("lon");
        return lon.toString();
    }
    /**
     * Functia va parsa json-ul si va intoarce presiunea
     * @return
     * @throws ParseException
     */
    public String get_pressure() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("main");
        var press= mainobj.get("pressure");
        return press.toString()+" hPa";
    }
    /**
     * Functia va parsa json-ul si va intoarce umiditatea
     * @return
     * @throws ParseException
     */
    public String get_humidiy() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("main");
        var hum= mainobj.get("humidity");
        return hum.toString()+" %";
    }
    /**
     * Functia va parsa json-ul si va intoarce viteza vantului
     * @return
     * @throws ParseException
     */
    public String get_wind() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("wind");
        var vant=mainobj.get("speed");
        return vant.toString()+" m/s";
    }
    /**
     * Functia va parsa json-ul si va intoarce vizibilitatea
     * @return
     * @throws ParseException
     */
    public String get_visibility() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        long visib =(long)jsonn.get("visibility");
        visib=visib/1000;
        String visib_s=String.valueOf(visib);
        return visib_s+" km";
    }
    /**
     * Functia va parsa json-ul si va intoarce tara
     * @return
     * @throws ParseException
     */
    public String get_country() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonn = (JSONObject) parser.parse(String.valueOf(this.json));
        JSONObject mainobj= (JSONObject) jsonn.get("sys");
        var country=  mainobj.get("country");
        return country.toString();
    }

}
