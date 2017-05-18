package com.EnvironmentDashboardModule1.DTO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Sabina on 5/18/2017.
 */
public class CreatingTsunamiDtoTests {

    @Test
    public void testGetMaxWaveHeight() {
        System.out.println("getMaxWaveHeight");
        CreatingTsunamiDto instance = new CreatingTsunamiDto();
        Double expResult = instance.maxWaveHeight;
        Double result = instance.getMaxWaveHeight();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMaxWaveHeight() {
        System.out.println("setMaxWaveHeight");
        Double maxWaveHeight = -1.2;
        CreatingTsunamiDto instance = new CreatingTsunamiDto();
        instance.setMaxWaveHeight(maxWaveHeight);
        fail("The test case is a prototype.");
    }
}
