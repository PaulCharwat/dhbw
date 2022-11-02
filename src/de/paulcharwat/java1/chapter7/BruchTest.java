package de.paulcharwat.java1.chapter7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BruchTest {

    @Test
    public void test() {
        assertEquals(new Bruch(1, 3).toString(), "1/3");
        assertEquals(new Bruch(2, 4).toString(), "2/4");
        assertEquals(new Bruch(-2, 3).toString(), "-2/3");
        assertEquals(new Bruch(2, -3).toString(), "2/-3");
        assertEquals(new Bruch(-2, -3).toString(), "-2/-3");
        assertEquals(new Bruch(1, 3).negiere().toString(), "-1/3");
        assertEquals(new Bruch(1, 3).addiere(new Bruch(1, 2)).toString(), "5/6");
        assertEquals(new Bruch(3, 4).subtrahiere(new Bruch(5, 6)).toString(), "-2/24");
        assertEquals(new Bruch(2, 3).kehrwert().toString(), "3/2");
        assertEquals(new Bruch(2, 3).multipliziere(new Bruch(6, 8)).toString(), "12/24");
        assertEquals(new Bruch(3, 4).dividiere(new Bruch(5, 6)).toString(), "18/20");
        assertEquals(new Bruch(4, 6).potenziere(3).toString(), "64/216");
        assertEquals(new Bruch(1, 2).istGleich(new Bruch(3, 4)), false);
        assertEquals(new Bruch(3, 4).istGleich(new Bruch(6, 8)), true);
        assertEquals(new Bruch(3, 4).alsDouble(), 0.75, 0.0000000000000001);
        //assertEquals("8/27", Bruch.kuerzen(new Bruch(64, 216)));
    }
}
