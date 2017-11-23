package com.BlueGround.ApiWeather.Utilities;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CsvHandler {

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }

        return result;
    }

    public static void writeLine(Writer w, List<String> values) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        for (String value : values) {

            stringBuilder.append(followCVSformat(value));
        }
        stringBuilder.append("\n");
        w.append(stringBuilder.toString());
    }
}
