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
public class EarthquakeTests {

    @Test
    public void contextLoad(){

    }

    @Test
    public void given_differentValues_when_getRichterDegreeIsCalled_then_assertEquality(){
        Earthquake earthquake = new Earthquake();
        double richterDegree = 10.3;
        earthquake.setRichterDegree(richterDegree);

        Assert.assertEquals(earthquake.getRichterDegree(), richterDegree, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeRichterDegree_when_setRichterDegreeIsCalled_then_shouldThrowException(){
        Earthquake earthquake = new Earthquake();
        double richterDegree = -10.3;

        earthquake.setRichterDegree(richterDegree);
    }

    @Test
    public void given_differentValues_when_getMercalliDegreeIsCalled_then_assertEquality(){
        Earthquake earthquake = new Earthquake();
        double mercalliDegree = 10.3;
        earthquake.setMercalliDegree(mercalliDegree);

        Assert.assertEquals(earthquake.getMercalliDegree(), mercalliDegree, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeMercalliDegree_when_setMercalliDegreeIsCalled_then_shouldThrowException(){
        Earthquake earthquake = new Earthquake();
        double mercalliDegree = -10;

        earthquake.setRichterDegree(mercalliDegree);
    }

    @Test
    public void given_differentValues_when_getDepthIsCalled_then_assertEquality(){
        Earthquake earthquake = new Earthquake();
        Integer depth = 100;
        earthquake.setDepth(depth);

        Assert.assertEquals(earthquake.getDepth(), depth, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeDepth_when_setDepthIsCalled_then_shouldThrowException(){
        Earthquake earthquake = new Earthquake();
        Integer depth = -100;

        earthquake.setDepth(depth);
    }
}
