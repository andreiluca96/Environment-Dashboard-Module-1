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
public class TerroristAttackTests {

    @Test
    public void contextLoads(){

    }

    @Test(expected = IllegalArgumentException.class)
    public void given_aNegativeNumberOfTerrorists_when_setNumberOfTerroristsIsCalled_then_shouldThrowException(){
        TerroristAttack terroristAttack = new TerroristAttack();
        Integer negativeNumberOfTerrorists = -1000;

        terroristAttack.setNumberOfTerrorists(negativeNumberOfTerrorists);
    }
}
