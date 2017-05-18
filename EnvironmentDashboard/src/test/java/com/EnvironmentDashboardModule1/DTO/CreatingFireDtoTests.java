package com.EnvironmentDashboardModule1.DTO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Sabina on 5/19/2017.
 */
public class CreatingFireDtoTests {
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        CreatingFireDto instance = new CreatingFireDto();
        Double expResult = instance.speed;
        Double result = instance.getSpeed();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetSpeed() {
        System.out.println("setSpeed");
        Double speed = -1.2;
        CreatingFireDto instance = new CreatingFireDto();
        instance.setSpeed(speed);
        fail("The test case is a prototype.");
    }
}
