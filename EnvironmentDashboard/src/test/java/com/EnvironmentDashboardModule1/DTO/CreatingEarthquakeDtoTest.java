
package com.EnvironmentDashboardModule1.DTO;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladut
 */
public class CreatingEarthquakeDtoTest {

    @Test
    public void testGetMercaliDegree() {
        System.out.println("getMercaliDegree");
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        Double expResult = instance.mercaliDegree;
        Double result = instance.getMercaliDegree();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMercaliDegree() {
        System.out.println("setMercaliDegree");
        Double mercaliDegree = -2.5;
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        instance.setMercaliDegree(mercaliDegree);
    }

    @Test
    public void testGetRichterDegree() {
        System.out.println("getRichterDegree");
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        Double expResult = instance.richterDegree;
        Double result = instance.getRichterDegree();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetRichterDegree() {
        System.out.println("setRichterDegree");
        Double richterDegree = - 3.2;
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        instance.setRichterDegree(richterDegree);
    }

    @Test
    public void testGetDepth() {
        System.out.println("getDepth");
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        Integer expResult = instance.depth;
        Integer result = instance.getDepth();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetDepth() {
        System.out.println("setDepth");
        Integer depth = -2;
        CreatingEarthquakeDto instance = new CreatingEarthquakeDto();
        instance.setDepth(depth);
    }

    private void assertTrue(double d, Double mercaliDegree) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
