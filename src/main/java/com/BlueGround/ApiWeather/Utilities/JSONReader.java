package com.BlueGround.ApiWeather.Utilities;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import static com.BlueGround.ApiWeather.Utilities.Reader.readAll;

public class JSONReader {

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream inputStream = new URL(url).openStream();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String jsonText = readAll(bufferedReader);
            JSONObject json = new JSONObject(jsonText);

            return json;

        } finally {
            inputStream.close();
        }
    }

}
