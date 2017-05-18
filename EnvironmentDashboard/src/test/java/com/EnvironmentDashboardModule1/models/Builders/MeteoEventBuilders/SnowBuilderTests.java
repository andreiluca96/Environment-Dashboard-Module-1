package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.SnowBuilder;
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
public class SnowBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        String invalidName = null;
        snowBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        double invalidLatitude = -1000;
        snowBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        double invalidLongitude = -1000;
        snowBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        Date invalidStartingTime = null;
        snowBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        Date invalidEndingTime = null;
        snowBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        String invalidSeverity = "BLUE";
        snowBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        String invalidDescription = null;
        snowBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        String invalidHints = null;
        snowBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        double invalidRadius = -1000;
        snowBuilder.setRadius(invalidRadius);
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setTemperatureIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        Integer invalidTemperature = -1000;
        snowBuilder.setTemperature(invalidTemperature);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        Integer invalidHumidity = -1000;
        snowBuilder.setHumidity(invalidHumidity);
    }*/

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        SnowBuilder snowBuilder = new SnowBuilder();
        Integer invalidPrecipitationLevel = -1000;
        snowBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}