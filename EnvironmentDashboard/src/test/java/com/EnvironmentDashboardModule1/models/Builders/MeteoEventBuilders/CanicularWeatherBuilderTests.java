package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.CanicularWeatherBuilder;
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
public class CanicularWeatherBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        String invalidName = null;
        canicularWeatherBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        double invalidLatitude = -1000;
        canicularWeatherBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        double invalidLongitude = -1000;
        canicularWeatherBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        Date invalidStartingTime = null;
        canicularWeatherBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        Date invalidEndingTime = null;
        canicularWeatherBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        String invalidSeverity = "BLUE";
        canicularWeatherBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        String invalidDescription = null;
        canicularWeatherBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        String invalidHints = null;
        canicularWeatherBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        double invalidRadius = -1000;
        canicularWeatherBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        double speed = -1000;
        canicularWeatherBuilder.setSpeed(speed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        Integer invalidHumidity = -1000;
        canicularWeatherBuilder.setHumidity(invalidHumidity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        CanicularWeatherBuilder canicularWeatherBuilder = new CanicularWeatherBuilder();
        Integer invalidPrecipitationLevel = -1000;
        canicularWeatherBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}