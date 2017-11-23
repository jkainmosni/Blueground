package com.BlueGround.ApiWeather.Application;

import com.BlueGround.ApiWeather.Utilities.CsvHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import static com.BlueGround.ApiWeather.Utilities.JSONReader.readJsonFromUrl;

public class ApiWeatherApplication {

    public static void main(String[] args) throws IOException, JSONException {

        JSONObject json = readJsonFromUrl("http://api.wunderground.com/api/debc2020c667c511/history_20171030/q/NY/New_York.json");
        JSONObject history = (JSONObject) json.get("history");
        JSONArray dailysummary = (JSONArray) history.get("dailysummary");

        for (int i = 0; i < dailysummary.length(); i++) {

            JSONObject metrics = dailysummary.getJSONObject(i);

            System.out.println("\nWeatherUndeground metrics for NY City\n");
            System.out.println("Max percentage humidity: " + metrics.getString("maxhumidity"));
            System.out.println("Max Temp in C: " + metrics.getString("maxtempm"));
            System.out.println("Min Temp in C: " + metrics.getString("mintempm"));
            System.out.println("Precipitation in mm: " + metrics.getString("precipm"));

            String csvFile = "metrics.csv";
            FileWriter writer = new FileWriter(csvFile);

            CsvHandler.writeLine(writer, Arrays.asList("Max percentage humidity : ", metrics.getString("maxhumidity")));
            CsvHandler.writeLine(writer, Arrays.asList("Max Temp in C : ", metrics.getString("maxtempm")));
            CsvHandler.writeLine(writer, Arrays.asList("Min Temp in C : ", metrics.getString("mintempm")));
            CsvHandler.writeLine(writer, Arrays.asList("Precipitation in mm : ", metrics.getString("precipm")));

            writer.flush();
            writer.close();
        }
    }
}
