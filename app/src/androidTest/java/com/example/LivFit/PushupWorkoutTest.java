package com.example.LivFit;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushupWorkoutTest {

    private PushupWorkout pushupWorkout;

    @Before
    public void setUp() throws Exception {
        pushupWorkout = new PushupWorkout();
    }

    /*@Test
    public void testcalculateCalBurnt(){
        int result = pushupWorkout.calculateCalBurnt(5,5.0);
        assertEquals(25.0,result);
    }

    @Test
    public void testIncrement(){
        int result = pushupWorkout.increment(10);
        assertEquals(11,result);
    }

    @Test
    public void testdecrement(){
       int result = pushupWorkout.decrement(10);
       assertEquals(9,result);
    }*/

    @Test
    public void testcaldisplay(){
        Double result = pushupWorkout.calDisplay("10.0","10.0");
        assertEquals(java.util.Optional.of(20.0),result);
    }



    @After
    public void tearDown() throws Exception {
        pushupWorkout=null;
    }
}