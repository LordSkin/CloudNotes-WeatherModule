package com.Main.GetWeather;

import com.Main.SendWeather.SendWeatherController;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class GetWeatherController implements Observer<Long> {

    private RequestSender requestSender;
    private WeatherInterpreter weatherInterpreter;
    PublishSubject<String> observable;

    public GetWeatherController() {
        requestSender = new RequestSender();
        weatherInterpreter = new WeatherInterpreter();
        observable = PublishSubject.create();
        observable.subscribe(new SendWeatherController());
    }

    public void onCompleted() {
        System.out.println("WTF completed");
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void onNext(Long counter) {
        try
        {
            String s = requestSender.getData();
            String weather = weatherInterpreter.getWeatherFromJson(s);
            observable.onNext(weather);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
