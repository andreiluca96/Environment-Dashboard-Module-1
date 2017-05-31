package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.DTO.EventDto;
import com.EnvironmentDashboardModule1.controllers.Events.EventController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTests {

    public static final String EVENT_DESCRIPTION = "Terrorist attack on New Jersey";
    public static final String EVENT_NAME = "Fukushima";
    public static final String EVENT_HINTS = "Stay in your home";
    public static final String EVENT_USER_ID = "USER-TOKEN";

    private Event event = new Event();

    @Test
    public void contextLoad(){

    }

    @Test
    public void given_differentValues_when_getLatitudeIsCalled_then_assertEquality(){
        double latitude = 10;
        event.setLatitude(latitude);

        Assert.assertEquals(event.getLatitude(), latitude, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        double latitude = -1000;
        event.setLatitude(latitude);
    }

    @Test
    public void given_differentValues_when_getLongitudeIsCalled_then_assertEquality(){
        double longitude = 10;
        event.setLongitude(longitude);

        Assert.assertEquals(event.getLongitude(), longitude, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        double longitude = -1000;
        event.setLongitude(longitude);
    }

    @Test
    public void given_differentValues_when_getIdIsCalled_then_assertEquality(){
        Long id = new Long(10);
        event.setId(id);

        Assert.assertEquals(event.getId(), id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setIdIsCalled_then_shouldThrowException(){
        Long id = new Long(-1000);
        event.setId(id);
    }

    @Test
    public void given_differentValues_when_getNameIsCalled_then_assertEquality(){
        String name = EVENT_NAME;
        event.setName(name);

        Assert.assertEquals(event.getName(), name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        String name = null;
        event.setName(name);
    }

    @Test
    public void given_differentValues_when_getStartingTimeIsCalled_then_assertEquality(){
        Date startingTime = new Date();
        event.setStartingTime(startingTime);

        Assert.assertEquals(event.getStartingTime(), startingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTime_then_shouldThrowException(){
        Date startingTime = null;
        event.setStartingTime(startingTime);
    }

    @Test
    public void given_differentValues_when_getEndingTimeIsCalled_then_assertEquality(){
        Date endingTime = new Date();
        event.setEndingTime(endingTime);

        Assert.assertEquals(event.getEndingTime(), endingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTime_then_shouldThrowException(){
        Date endingTime = null;
        event.setEndingTime(endingTime);
    }

    @Test
    public void given_differentValues_when_getDescriptionIsCalled_then_assertEquality(){
        String description = EVENT_DESCRIPTION;
        event.setDescription(description);

        Assert.assertEquals(event.getDescription(), description);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionIsCalled_then_shouldThrowException(){
        String description = null;
        event.setDescription(description);
    }

    @Test
    public void given_differentValues_when_getHintsIsCalled_then_assertEquality(){
        String hints = EVENT_HINTS;
        event.setHints(hints);

        Assert.assertEquals(event.getHints(), hints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsIsCalled_then_shouldThrowException(){
        String hints = null;
        event.setHints(hints);
    }

    @Test
    public void given_differentValues_when_getRadiusIsCalled_then_assertEquality(){
        double radius = 10;
        event.setRadius(radius);

        Assert.assertEquals(event.getRadius(), radius, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        double radius = -1000;
        event.setRadius(radius);
    }

    @Test
    public void given_differentValues_when_getUserIdIsCalled_then_assertEquality(){
        String userId = EVENT_USER_ID;
        event.setUserId(userId);

        Assert.assertEquals(event.getUserId(), userId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setUserIdIsCalled_then_shouldThrowException(){
        String invalidUserId = null;
        event.setUserId(invalidUserId);
    }

    @Test
    public void given_aValidEventWithId_when_createEventDTO_then_shouldGetDto_Id() {
        event.setId(new Long(10));

        EventController eventController = new EventController();
        EventDto eventDto = eventController.toDto(event);

        Assert.assertEquals(event.getId(),eventDto.getId());
    }
}
