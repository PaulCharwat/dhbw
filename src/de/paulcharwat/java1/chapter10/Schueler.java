package de.paulcharwat.java1.chapter10;

import java.util.Objects;

public class Schueler extends Person implements TaschenrechnerBesitzer {
    private String schuelernummer;
    private String klasse;
    private int taschenrechnerAnzahl = 0;

    public Schueler(String vorname, String nachname, int geburtsjahr, String schuelernummer, String klasse) {
        super(vorname, nachname, geburtsjahr); // eigener Superkonstruktor-Aufruf
        this.schuelernummer = schuelernummer;
        this.klasse = klasse;
    }

    public String getSchuelernummer() {
        return schuelernummer;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    @Override
    public String toString() { // benutzt die toString()-Methode der Superklasse
        return super.toString() + ", Schülernummer: " + schuelernummer + ", Klasse: " + klasse;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) { // ist das Objekt dasselbe wie dieser Schüler, dann gleichen sich beide
            return true;
        }
        if (!super.equals(that)) { // prüft auf Übereinstimmung beider Klassen und Gleichheit der
                                   // Personen-Attribute
            return false;
        }
        Schueler schueler = (Schueler) that; // explizite Typkonvertierung (durch super.equals(that)-Aufruf abgesichert)
                                             // prüft die zusätzlichen Instanzvariablen von Schülern auf Gleichheit
        return Objects.equals(schuelernummer, schueler.schuelernummer) &&
                Objects.equals(klasse, schueler.klasse);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hash(schuelernummer, klasse);
    }

    @Override
    public String getId() {
        return "S-" + getSchuelernummer();
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
