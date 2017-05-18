package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.RainBuilder;
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
public class RainBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        String invalidName = null;
        rainBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        double invalidLatitude = -1000;
        rainBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        double invalidLongitude = -1000;
        rainBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        Date invalidStartingTime = null;
        rainBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        Date invalidEndingTime = null;
        rainBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        String invalidSeverity = "BLUE";
        rainBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        String invalidDescription = null;
        rainBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        String invalidHints = null;
        rainBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        double invalidRadius = -1000;
        rainBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setTemperatureIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        Integer temperature = -1000;
        rainBuilder.setTemperature(temperature);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        Integer invalidHumidity = -1000;
        rainBuilder.setHumidity(invalidHumidity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        RainBuilder rainBuilder = new RainBuilder();
        Integer invalidPrecipitationLevel = -1000;
        rainBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}