package de.paulcharwat.java1.chapter9;

import de.paulcharwat.java1.chapter9.Person;
import de.paulcharwat.java1.chapter9.Schueler;

public class Schule {
    // ...

    public void entlasse(Person person) {
        if (person instanceof Schueler schueler) {
            schueler.setKlasse(null);
        } else if (person instanceof Lehrer lehrer) {
            lehrer.setGehalt(0);
        } else {
            System.out.println("Fehler: Person " + person + " ist weder Schüler noch Lehrer.");
        }
    }
}