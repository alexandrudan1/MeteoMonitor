package ro.mta.se.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.mta.se.lab.model.City;

import static org.junit.Assert.*;

public class UtilsTest {


    Utils utils;

    @Before
    public void setUp() throws Exception {
        utils = new Utils();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void initCity() {
        ObservableList<City> orasData = FXCollections.observableArrayList();
        orasData=utils.initCity();
        assertFalse(orasData.isEmpty());
    }


}