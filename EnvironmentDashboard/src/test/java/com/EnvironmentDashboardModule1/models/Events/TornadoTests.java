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
public class TornadoTests {

    @Test
    public void contextLoads(){

    }

    @Test
    public void given_differentValues_when_getWindSpeedIsCalled_then_assertEquality(){
        Tornado tornado = new Tornado();
        double windSpeed = 100;
        tornado.setWindSpeed(windSpeed);

        Assert.assertEquals(tornado.getWindSpeed(), windSpeed, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeWindSpeed_when_setWindSpeedIsCalled_then_shouldThrowException(){
        Tornado tornado = new Tornado();
        double negativeWindSpeed = -1000;

        tornado.setWindSpeed(negativeWindSpeed);
    }
}
