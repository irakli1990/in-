package com.plangenerator.ism.JsonParser;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CostumJsonParser {


    public Reader parsUrltoJsonObject(String url) {
        InputStream is;
        Reader reader = null;
        try {
            is = new URL(url).openStream();
            reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reader;
    }
}
