package com.Main.GetWeather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RequestSender {

    public final String API_KEY = "7581278e44dc57268a083f8645c8327f";
    public final String LOCATION = "Wroclaw";
    private String url;

    public RequestSender() {
        url = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&APPID="+API_KEY;
    }

    public  String getData() throws Exception
    {
        String result="";
        URL openWeather = new URL(url);
        URLConnection connection = openWeather.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            result+=inputLine;
        }
        in.close();
        return result;
    }


}
