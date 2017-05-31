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

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        String invalidName = null;
        coldWeatherBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        double invalidLatitude = -1000;
        coldWeatherBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        double invalidLongitude = -1000;
        coldWeatherBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        Date invalidStartingTime = null;
        coldWeatherBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        Date invalidEndingTime = null;
        coldWeatherBuilder.setEndingTime(invalidEndingTime);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
//        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
//        String invalidSeverity = "BLUE";
//        coldWeatherBuilder.setSeverity(invalidSeverity);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        String invalidDescription = null;
        coldWeatherBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        String invalidHints = null;
        coldWeatherBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        double invalidRadius = -1000;
        coldWeatherBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setTemperatureIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        Integer invalidTemperature = -1000;
        coldWeatherBuilder.setTemperature(invalidTemperature);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        Integer invalidHumidity = -1000;
        coldWeatherBuilder.setHumidity(invalidHumidity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        ColdWeatherBuilder coldWeatherBuilder = new ColdWeatherBuilder();
        Integer invalidPrecipitationLevel = -1000;
        coldWeatherBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}