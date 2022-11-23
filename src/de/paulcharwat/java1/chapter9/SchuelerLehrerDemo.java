package de.paulcharwat.java1.chapter9;

import de.paulcharwat.java1.chapter10.Schueler;
import de.paulcharwat.java1.chapter9.Person;

public class SchuelerLehrerDemo {
    public static void main(String[] args) {
        Person person = new Person("Pink", "Panther", 1963);
//      Schueler schueler = new Schueler();                         // -> The constructor Schueler() is undefined
        Schueler schueler = new Schueler("Roger", "Rabbit", 1988, "123", "8c");
//      Lehrer lehrer = new Lehrer("Fred", "Flintstone", 1960);     // -> The constructor Lehrer(String, String, int) is undefined
        Lehrer lehrer = new Lehrer("Fred", "Flintstone", 1960, "456", 3000);

        System.out.println("Person: " + person);                    // toString()-Aufruf
        System.out.println("Schüler: " + schueler);                 // toString()-Aufruf der Superklasse
        System.out.println("Lehrer: " + lehrer);                    // toString()-Aufruf der Superklasse
        System.out.println();
        System.out.println("Schüler-Schülernummer: " + schueler.getSchuelernummer());
        System.out.println("Schüler-Klasse: " + schueler.getKlasse());
        System.out.println("Lehrer-Personalnummer: " + lehrer.getPersonalnummer());
        System.out.println("Lehrer-Gehalt: " + lehrer.getGehalt());
    }
}