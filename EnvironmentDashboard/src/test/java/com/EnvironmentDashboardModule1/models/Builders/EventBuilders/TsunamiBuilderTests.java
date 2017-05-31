package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;


import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TsunamiBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by daioanei on 5/6/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TsunamiBuilderTests {

    @Test
    public void loadContext(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        String invalidName = null;
        tsunamiBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        double invalidLatitude = -1000;
        tsunamiBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        double invalidLongitude = -1000;
        tsunamiBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        Date invalidStartingTime = null;
        tsunamiBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        Date invalidEndingTime = null;
        tsunamiBuilder.setEndingTime(invalidEndingTime);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
//        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
//        String invalidSeverity = "BLUE";
//        tsunamiBuilder.setSeverity(invalidSeverity);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        String invalidDescription = null;
        tsunamiBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        String invalidHints = null;
        tsunamiBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        double invalidRadius = -1000;
        tsunamiBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setWindSpeedIsCalled_then_shouldThrowException(){
        TsunamiBuilder tsunamiBuilder = new TsunamiBuilder();
        double invalidMaxWaveHeight = -1000;
        tsunamiBuilder.setMaxWaveHeight(invalidMaxWaveHeight);
    }

}
