package com.Main.SendWeather;

import rx.Observer;

public class SendWeatherController implements Observer<String> {
    WeatherSender weatherSender;
    int counter;

    public SendWeatherController() {
        weatherSender = new WeatherSender();
        counter =0;
    }


    public void onCompleted() {
        System.out.println("WTF completed");
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void onNext(String o) {
        weatherSender.sendWeather(o);
        System.out.println(counter+" "+o);
    }
}
