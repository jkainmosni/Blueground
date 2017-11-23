package com.BlueGround.ApiWeather.Utilities;

import java.io.IOException;

public class Reader {

    public static String readAll(java.io.Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = reader.read()) != -1) {
            stringBuilder.append((char) i);
        }

        return stringBuilder.toString();
    }

}
