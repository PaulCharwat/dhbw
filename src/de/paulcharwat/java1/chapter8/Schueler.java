package de.paulcharwat.java1.chapter8;

public class Schueler extends Person {
    private String schuelernummer;
    private String klasse;

    public Schueler(String vorname, String nachname, int geburtsjahr, String schuelernummer, String klasse) {
        setVorname(vorname);
        setNachname(nachname);
        setGeburtsjahr(geburtsjahr);
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
