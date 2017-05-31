package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.ColdWeatherBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by Radu Lungu on 5/18/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColdWeatherBuilderTests {

    private ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        String invalidName = null;
        coldWeatherBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        double invalidLatitude = -1000;
        coldWeatherBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        double invalidLongitude = -1000;
        coldWeatherBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        Date invalidStartingTime = null;
        coldWeatherBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        Date invalidEndingTime = null;
        coldWeatherBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        String invalidDescription = null;
        coldWeatherBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        String invalidHints = null;
        coldWeatherBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        double invalidRadius = -1000;
        coldWeatherBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setTemperatureIsCalled_then_shouldThrowException(){
        Integer invalidTemperature = -1000;
        coldWeatherBuilder.setTemperature(invalidTemperature);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        Integer invalidHumidity = -1000;
        coldWeatherBuilder.setHumidity(invalidHumidity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        Integer invalidPrecipitationLevel = -1000;
        coldWeatherBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setUserIdTimeIsCalled_then_shouldThrowException(){
        String invalidUserId = null;
        coldWeatherBuilder.setUserId(invalidUserId);
    }
}