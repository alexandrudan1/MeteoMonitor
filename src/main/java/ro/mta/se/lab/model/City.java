package ro.mta.se.lab.model;

/**
 * Aceasta clasa este o clasa specifica unui oras citit din fisier
 * @author Dan Alexandru
 *
 */
public class City {
    /**
     * membrul mId reprezinta id-ul orasului
     * membrul mNume reprezinta numele orasului
     * membrul mLat reprezinta latitudinea orasului
     * membrul mLon reprezinta longitudinea orasului
     * membrul mCountry reprezinta tar din care face parte orasul
     */
    String mId;
    String mNume;
    String mLat;
    String mLon;
    String mCountry;

    /**
     * @param nume reprezinta numele orasului
     * @param id reprezinta id-ul orasului
     * @param lat reprezinta latitudinea orasului
     * @param lon reprezinta longitudinea orasului
     * @param country reprezinta numele tarii
     */
    public City(String id, String nume,
                String lat, String lon, String country)
    {
        mId = new String(id);
        mNume = new String(nume);
        mLat = new String(lat);
        mLon = new String(lon);
        mCountry = new String(country);
    }
    /**
     * @return getter pentru id-ul orasului
     */
    public String getId() {
        return mId;
    }
    /**
     * @return getter pentru numele orasului
     */
    public String getNume() {
        return mNume;
    }
    /**
     * @return getter pentru tara din care face orasul parte
     */
    public String getCountry() {
        return mCountry;
    }
}
