package de.paulcharwat.java1.chapter10;

import java.util.Objects;

public class Lehrer extends Person implements TaschenrechnerBesitzer {
    private String personalnummer;
    private double gehalt;
    private String anrede; // neue Instanzvariable
    private int taschenrechnerAnzahl = 0;

    public Lehrer(String vorname, String nachname, int geburtsjahr, String personalnummer, double gehalt,
            String anrede) {
        super(vorname, nachname, geburtsjahr);
        this.personalnummer = personalnummer;
        this.gehalt = gehalt;
        this.anrede = anrede; // Konstruktor erweitert
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

    public String getAnrede() { // Getter für neue Instanzvariable
        return anrede;
    }

    @Override
    public String getName() { // überschriebene Instanzmethode
        return anrede + " " + getNachname();
    }

    public String toString() { // benutzt die toString()-Methode der Superklasse
        return super.toString() + ", Personalnummer: " + personalnummer + ", Gehalt: " + gehalt;
    }

    public boolean equals(Object that) {
        if (that == this) { // ist das Objekt dasselbe wie dieser Lehrer, dann gleichen sich beide
            return true;
        }
        if (!super.equals(that)) { // prüft auf Übereinstimmung beider Klassen und Gleichheit der
                                   // Personen-Attribute
            return false;
        }
        Lehrer lehrer = (Lehrer) that; // explizite Typkonvertierung (durch super.equals(that)-Aufruf abgesichert)
                                       // prüft die zusätzlichen Instanzvariablen von Lehrern auf Gleichheit
        return Objects.equals(personalnummer, lehrer.personalnummer) &&
                gehalt == lehrer.gehalt && // Variable vom Typ double kann mit == verglichen werden
                Objects.equals(anrede, lehrer.anrede);
    }

    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(personalnummer, gehalt, anrede);
    }

    public String getId() {
        return "L-" + getPersonalnummer();
    }

    @Override
    public int getTaschenrechnerAnzahl() {
        return taschenrechnerAnzahl;
    }

    @Override
    public void erhoeheTaschenrechnerAnzahl() {
        taschenrechnerAnzahl++;
    }

    @Override
    public void vermindereTaschenrechnerAnzahl() {
        taschenrechnerAnzahl--;
    }
}