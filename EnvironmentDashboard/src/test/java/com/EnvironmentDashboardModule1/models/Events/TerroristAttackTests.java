package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;
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
public class TerroristAttackTests {

    @Test
    public void contextLoads(){

    }

    @Test
    public void given_differentValues_when_getNumberOfTerroristsIsCalled_then_assertEquality(){
        TerroristAttack terroristAttack = new TerroristAttack();
        Integer numberOfTerrorists = 100;
        terroristAttack.setNumberOfTerrorists(numberOfTerrorists);

        Assert.assertEquals(terroristAttack.getNumberOfTerrorists(), numberOfTerrorists, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeNumberOfTerrorists_when_setNumberOfTerroristsIsCalled_then_shouldThrowException(){
        TerroristAttack terroristAttack = new TerroristAttack();
        Integer negativeNumberOfTerrorists = -1000;

        terroristAttack.setNumberOfTerrorists(negativeNumberOfTerrorists);
    }
}
