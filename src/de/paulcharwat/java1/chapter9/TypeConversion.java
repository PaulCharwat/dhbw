package de.paulcharwat.java1.chapter9;

import de.paulcharwat.java1.chapter9.Person;
import de.paulcharwat.java1.chapter9.Schueler;
import de.paulcharwat.java1.chapter9.Calculator;

public class TypeConversion {
    public static void main(String[] args) {
        Person schueler = new Schueler("Roger", "Rabbit", 1988, "123", "8c");
        Person lehrer = new Lehrer("Fred", "Flintstone", 1960, "456", 3000);

        // implizite Typkonvertierungen (Schueler -> Person und Lehrer -> Person) ...

        // ... gelingen sowohl bei der Zuweisung einer Variablen ...
        Person person1 = schueler;
        Person person2 = lehrer;
        System.out.println("Person #1: " + person1);
        System.out.println("Person #2: " + person2);

        // ... als auch bei der Übergabe eines Parameters an einen Konstruktor
        //Calculator tr1 = new Calculator("001", "TI-30", schueler);
        //Calculator tr2 = new Calculator("002", "HP-12C", lehrer);
        //System.out.println("Taschenrechnerbesitzer #1: " + tr1.getBesitzer());
        //System.out.println("Taschenrechnerbesitzer #2: " + tr2.getBesitzer());

        // Rückrichtung ist implizit nicht möglich, d.h. Type-Cast ist erforderlich
//      schueler = person1;             // -> Type mismatch: cannot convert from Person to Schueler

        // erfolgreiche explizite Typkonvertierung (Person -> Schueler)
        schueler = (Schueler) person1;
        System.out.println("Schüler: " + schueler);

        // erfolglose explizite Typkonvertierung (Person -> Schueler)
//      schueler = (Schueler) person2;  // Laufzeitfehler -> java.lang.ClassCastException: Lehrer cannot be cast to Schueler

        // unmögliche Typkonvertierung (Schueler -> Lehrer)
//      lehrer = schueler;              // -> Type mismatch: cannot convert from Schueler to Lehrer
//      lehrer = (Lehrer) schueler;     // -> Cannot cast from Schueler to Lehrer
    }
}