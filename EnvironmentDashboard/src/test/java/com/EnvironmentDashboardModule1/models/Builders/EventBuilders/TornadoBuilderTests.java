package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;


import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TornadoBuilder;
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
public class TornadoBuilderTests {

    @Test
    public void loadContext(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        String invalidName = null;
        tornadoBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        double invalidLatitude = -1000;
        tornadoBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        double invalidLongitude = -1000;
        tornadoBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        Date invalidStartingTime = null;
        tornadoBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        Date invalidEndingTime = null;
        tornadoBuilder.setEndingTime(invalidEndingTime);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
//        TornadoBuilder tornadoBuilder = new TornadoBuilder();
//        String invalidSeverity = "BLUE";
//        tornadoBuilder.setSeverity(invalidSeverity);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        String invalidDescription = null;
        tornadoBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        String invalidHints = null;
        tornadoBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        double invalidRadius = -1000;
        tornadoBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setWindSpeedIsCalled_then_shouldThrowException(){
        TornadoBuilder tornadoBuilder = new TornadoBuilder();
        double invalidWindSpeed = -1000;
        tornadoBuilder.setWindspeed(invalidWindSpeed);
    }

}
