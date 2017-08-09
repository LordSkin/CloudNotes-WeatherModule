package Tests;

import com.Main.GetWeather.RequestSender;
import com.Main.GetWeather.WeatherInterpreter;
import org.junit.Assert;
import org.junit.Test;

public class GetWeatherTests {

    RequestSender requestSender;
    WeatherInterpreter weatherInterpreter;

    @Test
    public void getWeathertest1()
    {
        try
        {
            requestSender = new RequestSender();
            String s =requestSender.getData();
            Assert.assertNotNull(s);
            Assert.assertNotEquals(s,"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void InterpreterTest()
    {
        weatherInterpreter = new WeatherInterpreter();
        try
        {
            requestSender = new RequestSender();
            String s =requestSender.getData();
            String weather = weatherInterpreter.getWeatherFromJson(s);
            Assert.assertNotNull(weather);
            Assert.assertNotEquals(weather,"");

        }
        catch (Exception e)
        {
            Assert.fail();
        }
    }
}
