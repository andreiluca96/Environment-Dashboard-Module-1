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
public class FloodTests {

    @Test
    public void contextLoad(){

    }

    @Test
    public void given_differentValues_when_getPrecipitationLevelIsCalled_then_assertEquality(){
        Flood flood = new Flood();
        double precipitationLevel = 100;
        flood.setPrecipitationLevel(precipitationLevel);

        Assert.assertEquals(flood.getPrecipitationLevel(), precipitationLevel, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativePrecipitationLevel_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        Flood flood = new Flood();
        double precipitationLevel = -1000;

        flood.setPrecipitationLevel(precipitationLevel);
    }
}
