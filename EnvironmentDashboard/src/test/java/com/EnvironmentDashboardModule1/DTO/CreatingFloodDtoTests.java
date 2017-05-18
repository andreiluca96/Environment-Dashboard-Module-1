package com.EnvironmentDashboardModule1.DTO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Sabina on 5/19/2017.
 */
public class CreatingFloodDtoTests {
    @Test
    public void testGetPrecipitationLevel() {
        System.out.println("getPrecipitationLevel");
        CreatingFloodDto instance = new CreatingFloodDto();
        Double expResult = instance.precipitationLevel;
        Double result = instance.getPrecipitationLevel();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetSpeed() {
        System.out.println("setPrecipitationLevel");
        Double precipitationLevel = -1.2;
        CreatingFloodDto instance = new CreatingFloodDto();
        instance.setPrecipitationLevel(precipitationLevel);
        fail("The test case is a prototype.");
    }
}
