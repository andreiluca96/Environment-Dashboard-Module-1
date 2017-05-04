package com.EnvironmentDashboardModule1.models.Events;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by daioanei on 5/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTests {

    @Test
    public void contextLoad(){

    }

    @Test
    public void given_differentValues_when_getSeverityIsCalled_then_assertEquality(){
        Event event = new Event();
        String severity = "GREEN";
        event.setSeverity(severity);

        Assert.assertEquals(event.getSeverity(), severity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        Event event = new Event();
        String severity = "BLUE";

        event.setSeverity(severity);
    }
}
