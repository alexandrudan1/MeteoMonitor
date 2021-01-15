package ro.mta.se.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.model.City;

import static org.junit.Assert.*;

/**
 * @author Dan Alexandru
 * Aceasta clasa realizeaza testarea unitara a clasei Utils
 */
public class UtilsTest {

    /**
     * membrul utils este obiectul ce va fi testat
     */
    Utils utils;

    /**
     * initializarea obiectului
     */
    @Before
    public void setUp() throws Exception {
        utils = new Utils();
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * verificarea citirii din fisier
     */
    @Test
    public void initCity() {
        ObservableList<City> orasData = FXCollections.observableArrayList();
        orasData=utils.initCity();
        assertFalse(orasData.isEmpty());
    }


}