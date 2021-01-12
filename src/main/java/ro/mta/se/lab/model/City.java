package ro.mta.se.lab.model;
import javafx.beans.property.*;

public class City {
    String mId;
    String mNume;
    String mLat;
    String mLon;
    String mCountry;

    public City(String id, String nume,
                String lat, String lon, String country)
    {
        mId = new String(id);
        mNume = new String(nume);
        mLat = new String(lat);
        mLon = new String(lon);
        mCountry = new String(country);
    }
    public String getId() {
        return mId;
    }
    public String getNume() {
        return mNume;
    }
    public String getCountry() {
        return mCountry;
    }
}
