package com.Main.GetWeather;


import org.json.JSONObject;

public class WeatherInterpreter {

    private final static int ABSOLUTE_ZERO = -273;

    public  String getWeatherFromJson(String json)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(json);
            String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            String temperature = jsonObject.getJSONObject("main").getString("temp");
            int temp = (int)Double.parseDouble(temperature)+ABSOLUTE_ZERO;
            String result = temp + "C - "+ weatherDescription;
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }

    }
}
