package com.Main;

import com.Main.GetWeather.GetWeatherController;
import rx.Observable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Observable<Long> trigger = Observable.interval(10, TimeUnit.SECONDS);
        trigger.subscribe(new GetWeatherController());
        try
        {
            System.in.read();
        }
        catch (Exception e)
        {

        }

    }
}
