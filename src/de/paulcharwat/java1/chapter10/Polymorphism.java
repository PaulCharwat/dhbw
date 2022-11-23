package de.paulcharwat.java1.chapter10;

public class Polymorphism {
    public static void drucke(Person person) {                  // person kann eine Person sein, oder ein Schüler, oder ein Lehrer
        System.out.println("getName():  " + person.getName());  // getName()-Methode aus der Klasse Person oder aus der Klasse Lehrer
        System.out.println("toString(): " + person.toString()); // toString()-Methode aus der Klasse Person benutzt getName() aus Person oder Lehrer
    }

    public static void main(String[] args) {
        //Person person = new Person("Pink", "Panther", 1963);
        Schueler schueler = new Schueler("Roger", "Rabbit", 1988, "123", "8c");
        Lehrer lehrer = new Lehrer("Fred", "Flintstone", 1960, "456", 3000, "Herr");

        //drucke(person);                                         // keine Typkonvertierung erforderlich
        drucke(schueler);                                       // implizite Typkonvertierung: Schueler -> Person
        drucke(lehrer);                                         // implizite Typkonvertierung: Lehrer -> Person
    }
}