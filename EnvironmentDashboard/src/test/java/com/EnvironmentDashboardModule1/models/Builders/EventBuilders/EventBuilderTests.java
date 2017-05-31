package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
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
public class EventBuilderTests {

    private EventBuilder eventBuilder = new EventBuilder();

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        String invalidName = null;
        eventBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        double invalidLatitude = -1000;
        eventBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        double invalidLongitude = -1000;
        eventBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        Date invalidStartingTime = null;
        eventBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        Date invalidEndingTime = null;
        eventBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        String invalidDescription = null;
        eventBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        String invalidHints = null;
        eventBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        double invalidRadius = -1000;
        eventBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setUserIdIsCalled_then_shouldThrowException(){
        String invalidUserId = null;
        eventBuilder.setUserId(invalidUserId);
    }
}
