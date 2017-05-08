package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by daioanei on 5/4/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeteoBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHumidityIsCalled_then_shouldThrowException(){
        MeteoEventBuilder meteoEventBuilder = new MeteoEventBuilder();
        Integer invalidHumidity = -1000;
        meteoEventBuilder.setHumidity(invalidHumidity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setPrecipitationLevelIsCalled_then_shouldThrowException(){
        MeteoEventBuilder meteoEventBuilder = new MeteoEventBuilder();
        Integer invalidPrecipitationLevel = -1000;
        meteoEventBuilder.setPrecipitationLevel(invalidPrecipitationLevel);
    }

}
