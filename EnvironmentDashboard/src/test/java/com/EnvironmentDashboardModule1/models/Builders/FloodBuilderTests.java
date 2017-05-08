package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.FloodBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by daioanei on 5/7/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FloodBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        String invalidName = null;
        floodBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        double invalidLatitude = -1000;
        floodBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        double invalidLongitude = -1000;
        floodBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        Date invalidStartingTime = null;
        floodBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        Date invalidEndingTime = null;
        floodBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        String invalidSeverity = "BLUE";
        floodBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        String invalidDescription = null;
        floodBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        String invalidHints = null;
        floodBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        double invalidRadius = -1000;
        floodBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        FloodBuilder floodBuilder = new FloodBuilder();
        double precipitationLevel = -1000;
        floodBuilder.setPrecipitationLevel(precipitationLevel);
    }

}
