package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Tsunami;
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
public class TsunamiTests {

    @Test
    public void contextLoads(){

    }

    @Test
    public void given_differentValues_when_getMaxWaveHeightIsCalled_then_assertEquality(){
        Tsunami tsunami = new Tsunami();
        double maxWaveHeight = 100;
        tsunami.setMaxWaveHeight(maxWaveHeight);

        Assert.assertEquals(tsunami.getMaxWaveHeight(), maxWaveHeight, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeMaxWaveHeight_when_setMaxWaveHeightIsCalled_then_shouldThrowException(){
        Tsunami tsunami = new Tsunami();
        double negativeWaveHeight = -1000;

        tsunami.setMaxWaveHeight(negativeWaveHeight);
    }
}
