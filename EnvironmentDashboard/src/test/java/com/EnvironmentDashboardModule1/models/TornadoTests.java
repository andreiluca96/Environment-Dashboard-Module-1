package com.EnvironmentDashboardModule1.models;

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

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeWindSpeed_when_setWindSpeedIsCalled_then_shouldThrowException(){
        Tornado tornado = new Tornado();
        double negativeWindSpeed = -1000;

        tornado.setWindSpeed(negativeWindSpeed);
    }
}
