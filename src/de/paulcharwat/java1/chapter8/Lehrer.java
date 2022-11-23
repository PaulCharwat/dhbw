package de.paulcharwat.java1.chapter8;

public class Lehrer extends Person {
    private String personalnummer;
    private double gehalt;

    public Lehrer(String vorname, String nachname, int geburtsjahr, String personalnummer, double gehalt) {
        setVorname(vorname);
        setNachname(nachname);
        setGeburtsjahr(geburtsjahr);
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
        this.gehalt = gehalt;
    }

    
}
