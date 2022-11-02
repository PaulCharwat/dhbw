package de.paulcharwat.java1.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AutoTest {
    
    @Test
    public void test(){
        assertEquals(new Auto("VW", "Golf").toString(), "VW Golf");
    }
}
