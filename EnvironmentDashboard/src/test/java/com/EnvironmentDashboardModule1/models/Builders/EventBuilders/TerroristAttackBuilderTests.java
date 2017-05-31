package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TerroristAttackBuilder;
import com.EnvironmentDashboardModule1.models.Severity;
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
public class TerroristAttackBuilderTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNameIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        String invalidName = null;
        terroristAttackBuilder.setName(invalidName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLatitudeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        double invalidLatitude = -1000;
        terroristAttackBuilder.setLatitude(invalidLatitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setLongitudeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        double invalidLongitude = -1000;
        terroristAttackBuilder.setLongitude(invalidLongitude);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setStartingTimeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        Date invalidStartingTime = null;
        terroristAttackBuilder.setStartingTime(invalidStartingTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setEndingTimeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        Date invalidEndingTime = null;
        terroristAttackBuilder.setEndingTime(invalidEndingTime);
    }


    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setDescriptionTimeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        String invalidDescription = null;
        terroristAttackBuilder.setDescription(invalidDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setHintsTimeIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        String invalidHints = null;
        terroristAttackBuilder.setHints(invalidHints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setRadiusIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        double invalidRadius = -1000;
        terroristAttackBuilder.setRadius(invalidRadius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_anInvalidValue_when_setNumberOfTerroristsIsCalled_then_shouldThrowException(){
        TerroristAttackBuilder terroristAttackBuilder = new TerroristAttackBuilder();
        Integer invalidNumberOfTerrorists = -1000;
        terroristAttackBuilder.setNumberOfTerrorists(invalidNumberOfTerrorists);
    }
}
