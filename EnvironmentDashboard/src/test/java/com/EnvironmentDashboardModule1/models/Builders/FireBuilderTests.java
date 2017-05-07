package com.EnvironmentDashboardModule1.models.Builders;

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
public class FireBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        String invalidName = null;
        fireBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        double invalidLatitude = -1000;
        fireBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        double invalidLongitude = -1000;
        fireBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        Date invalidStartingTime = null;
        fireBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        Date invalidEndingTime = null;
        fireBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        String invalidSeverity = "BLUE";
        fireBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        String invalidDescription = null;
        fireBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        String invalidHints = null;
        fireBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        double invalidRadius = -1000;
        fireBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        FireBuilder fireBuilder = new FireBuilder();
        double speed = -1000;
        fireBuilder.setSpeed(speed);
    }

}
