package Tests;

import com.Main.SendWeather.WeatherSender;
import org.junit.Assert;
import org.junit.Test;

public class SendWeatherTests {
    @Test
    public void sendingTest()
    {
        WeatherSender weatherSender = new WeatherSender();
        Assert.assertTrue(weatherSender.sendWeather("ladna pogoda"));
    }
}
