package ro.mta.se.lab;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() throws Exception {

        BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/test.json"));
        StringBuffer mJson;
        mJson = new StringBuffer(1024);
        String aux = "";
        while((aux = reader.readLine()) != null)
            mJson.append(aux).append("\n");
        reader.close();
        parser=new Parser(mJson);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get_main() throws ParseException {
        assertEquals(parser.get_main(),"Clouds");
    }

    @Test
    public void get_pressure() throws ParseException {
        assertEquals(parser.get_pressure(),"1019 hPa");
    }
}