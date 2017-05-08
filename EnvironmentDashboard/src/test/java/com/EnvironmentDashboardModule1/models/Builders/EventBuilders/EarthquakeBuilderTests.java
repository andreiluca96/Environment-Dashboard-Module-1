package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EarthquakeBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by daioanei on 5/7/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EarthquakeBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        String invalidName = null;
        earthquakeBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        double invalidLatitude = -1000;
        earthquakeBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        double invalidLongitude = -1000;
        earthquakeBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        Date invalidStartingTime = null;
        earthquakeBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        Date invalidEndingTime = null;
        earthquakeBuilder.setEndingTime(invalidEndingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setSeverityIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        String invalidSeverity = "BLUE";
        earthquakeBuilder.setSeverity(invalidSeverity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        String invalidDescription = null;
        earthquakeBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        String invalidHints = null;
        earthquakeBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        double invalidRadius = -1000;
        earthquakeBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRichterDegreeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        double invalidRichterDegree = -1000;
        earthquakeBuilder.setRichterDegree(invalidRichterDegree);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setMercalliDegreeIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        double invalidMercalliDegree = -1000;
        earthquakeBuilder.setRichterDegree(invalidMercalliDegree);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDepthIsCalled_then_shouldThrowException(){
        EarthquakeBuilder earthquakeBuilder = new EarthquakeBuilder();
        Integer invalidDepth = -1000;
        earthquakeBuilder.setDepth(invalidDepth);
    }

}
