/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EnvironmentDashboardModule1.DTO;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladut
 */
public class CreatingTornadoDtoTests {
    

    @Test
    public void testGetWindspeed() {
        System.out.println("getWindspeed");
        CreatingTornadoDto instance = new CreatingTornadoDto();
        Double expResult = instance.windspeed;
        Double result = instance.getWindspeed();
        assertEquals(expResult, result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetWindspeed() {
        System.out.println("setWindspeed");
        Double windspeed = -1.2;
        CreatingTornadoDto instance = new CreatingTornadoDto();
        instance.setWindspeed(windspeed);
        fail("The test case is a prototype.");
    }
    
}
