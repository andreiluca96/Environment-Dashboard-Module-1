package com.EnvironmentDashboardModule1.models.MeteoEvents;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by daioanei on 5/4/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeteoEventTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeId_when_setIdIsCalled_then_shouldThrowException(){
        MeteoEvent meteoEvent = new MeteoEvent();
        Integer negativeId = -1000;

        meteoEvent.setId(negativeId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeHumidity_when_setIdIsCalled_then_shouldThrowException(){
        MeteoEvent meteoEvent = new MeteoEvent();
        Integer negativeHumidity = -1000;
        meteoEvent.setHumidity(negativeHumidity);
    }
}
