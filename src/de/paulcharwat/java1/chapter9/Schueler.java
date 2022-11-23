package de.paulcharwat.java1.chapter9;

public class Schueler extends Person {
    private String schuelernummer;
    private String klasse;

    public Schueler(String vorname, String nachname, int geburtsjahr, String schuelernummer, String klasse) {
        super(vorname, nachname, geburtsjahr);      // eigener Superkonstruktor-Aufruf
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

}
