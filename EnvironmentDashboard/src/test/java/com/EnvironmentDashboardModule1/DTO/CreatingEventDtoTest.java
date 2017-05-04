package com.EnvironmentDashboardModule1.DTO;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladut
 */
public class CreatingEventDtoTest {
    
 
    @Test
    public void testGetName() {
        System.out.println("getName");
        CreatingEventDto instance = new CreatingEventDto();
        String expResult = instance.name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        CreatingEventDto instance = new CreatingEventDto();
        Double expResult = instance.longitude;
        Double result = instance.getLongitude();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetLongitude() {
        System.out.println("setLongitude");
        Double longitude = - 5.6;
        CreatingEventDto instance = new CreatingEventDto();
        instance.setLongitude(longitude);
    }

    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        CreatingEventDto instance = new CreatingEventDto();
        Double expResult = instance.latitude;
        Double result = instance.getLatitude();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetLatitude() {
        System.out.println("setLatitude");
        Double latitude = -2.5;
        CreatingEventDto instance = new CreatingEventDto();
        instance.setLatitude(latitude);
    }

    @Test(expected=IllegalStateException.class)
    public void testSetRadius() {
        System.out.println("setRadius");
        Double radius = -10.9;
        CreatingEventDto instance = new CreatingEventDto();
        instance.setRadius(radius);
    }

    @Test
    public void testGetStartingDate() {
        System.out.println("getStartingDate");
        CreatingEventDto instance = new CreatingEventDto();
        Date expResult = instance.startingDate;
        Date result = instance.getStartingDate();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetEndingDate() {
        System.out.println("getEndingDate");
        CreatingEventDto instance = new CreatingEventDto();
        Date expResult = instance.endingDate;
        Date result = instance.getEndingDate();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetSeverity() {
        System.out.println("getSeverity");
        CreatingEventDto instance = new CreatingEventDto();
        String expResult = instance.severity;
        String result = instance.getSeverity();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetSeverity() {
        System.out.println("setSeverity");
        String severity = "BLUE";
        CreatingEventDto instance = new CreatingEventDto();
        instance.setSeverity(severity);
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CreatingEventDto instance = new CreatingEventDto();
        String expResult = instance.description;
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }


    @Test
    public void testGetHints() {
        System.out.println("getHints");
        CreatingEventDto instance = new CreatingEventDto();
        String expResult = instance.hints;
        String result = instance.getHints();
        assertEquals(expResult, result);
   }

    
}
