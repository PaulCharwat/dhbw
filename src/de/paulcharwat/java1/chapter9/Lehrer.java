package de.paulcharwat.java1.chapter9;

import de.paulcharwat.java1.chapter9.Person;

public class Lehrer extends Person {
    private String personalnummer;
    private double gehalt;

    public Lehrer(String vorname, String nachname, int geburtsjahr, String personalnummer, double gehalt) {
        super(vorname, nachname, geburtsjahr); // eigener Superkonstruktor-Aufruf
        this.personalnummer = personalnummer;
        this.gehalt = gehalt;
    }

    public String getPersonalnummer() {
        return personalnummer;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        if (this.gehalt != gehalt) {
            System.out.println(getName() + " bekommt in Zukunft ein Gehalt von " + gehalt + " statt " + this.gehalt);
            this.gehalt = gehalt;
        }
    }

}
