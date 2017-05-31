package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.FogBuilder;
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
public class FogBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        String invalidName = null;
        fogBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        double invalidLatitude = -1000;
        fogBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        double invalidLongitude = -1000;
        fogBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        Date invalidStartingTime = null;
        fogBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        Date invalidEndingTime = null;
        fogBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        String invalidDescription = null;
        fogBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        String invalidHints = null;
        fogBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        double invalidRadius = -1000;
        fogBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        Integer invalidHumidity = -1000;
        fogBuilder.setHumidity(invalidHumidity);
    }


    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setTemperatureIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        Integer invalidTemperature = -1000;
        fogBuilder.setTemperature(invalidTemperature);
    }


    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        FogBuilder fogBuilder = new FogBuilder();
        Integer invalidPrecipitationLevel = -1000;
        fogBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}