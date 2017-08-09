package com.Main.SendWeather;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherSender {

    public static final String  targetURL = "http://localhost:8080/weather";
    private URL url;

    public WeatherSender() {
        try
        {
            url = new URL(targetURL);
        }
        catch (Exception e){}
    }

    public boolean sendWeather(String weather) {


        HttpURLConnection connection = null;

        try {
            //Create connection
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Length", Integer.toString(weather.length()));
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.getOutputStream().write(weather.getBytes());




            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString().equals("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
    }
}
