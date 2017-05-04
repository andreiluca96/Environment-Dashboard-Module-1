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
public class FireTests {

    @Test
    public void contextLoad(){

    }

    @Test
    public void given_differentValues_when_getSpeedIsCalled_then_assertEquality(){
        Fire fire = new Fire();
        double speed = 100;
        fire.setSpeed(speed);

        Assert.assertEquals(fire.getSpeed(), speed, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeSpedd_when_setSpeedIsCalled_then_shouldThrowException(){
        Fire fire = new Fire();
        double speed = -1000;

        fire.setSpeed(speed);
    }
}
