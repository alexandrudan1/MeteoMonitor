package ro.mta.se.lab.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ro.mta.se.lab.Parser;
import ro.mta.se.lab.Utils;

import org.mockito.*;
import org.mockito.junit.MockitoJUnit;

import ro.mta.se.lab.model.CurrentWeather;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Dan Alexandru
 * Clasa aceasta realizeaza testarea  Mockito a clasei WeatherController
 *
 */
public class WeatherControllerTestMockito {

    /**
     * membriul util de tipul mock reprezinta obiectul Utils pe care il vom utiliza la testare
     * membriul parser de tipul mock reprezinta obiectul Parser pe care il vom utiliza la testare
     */
    @Mock
    Utils util;
    @Mock
    Parser parser;
    CurrentWeather cw;
    @Rule
    public org.mockito.junit.MockitoRule MockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        cw=new CurrentWeather("1000","1000","1000", "1000","1000","1000","1000");
    }

    /**
     * testarea acestuia cu ajutorul unui obiect mockito
     */
    @Test
    public void get_Info() throws ParseException, org.json.simple.parser.ParseException, IOException {

        when(util.updateWeather(parser)).thenReturn(cw);
        when(util.get_date()).thenReturn("01:01:01 01-01-1010");
        when(parser.get_main()).thenReturn("Clouds");
        String main=parser.get_main();
        String date= util.get_date();
        assertEquals(cw.get_pressure(),"1000");
        assertEquals(date,"01:01:01 01-01-1010");
        assertEquals(main,"Clouds");

        assertNull(util.request_api("CityNotFromList"));

    }
}