package com.EnvironmentDashboardModule1.DTO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Sabina on 5/19/2017.
 */
public class CreatingTerroristAttackDtoTests {

    @Test
    public void testGetNumberOfTerrorists() {
        System.out.println("getNumberOfTerrorists");
        CreatingTerroristAttackDto instance = new CreatingTerroristAttackDto();
        Integer expResult = instance.numberOfTerrorists;
        Integer result = instance.getNumberOfTerrorists();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetNumberOfTerrorists() {
        System.out.println("setNumberOfTerrorists");
        Integer numberOfTerrorists = -10;
        CreatingTerroristAttackDto instance = new CreatingTerroristAttackDto();
        instance.setNumberOfTerrorists(numberOfTerrorists);
        fail("The test case is a prototype.");
    }

}
