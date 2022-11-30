package de.paulcharwat.java1.chapter11;

import java.util.Objects;

public abstract class Person {
    private String vorname;
    private String nachname;
    private int geburtsjahr;

    public Person() {

    }

    protected Person(String vorname, String nachname, int geburtsjahr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsjahr = geburtsjahr;
    }

    public abstract String getId();

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public String getName() {
        return vorname + " " + nachname;
    }

    public String toString() {
        return getName() + " *" + geburtsjahr;
    }

    public boolean equals(Person person) { // Problem: falsche Signatur
        return person != null &&
                Objects.equals(vorname, person.vorname) &&
                Objects.equals(nachname, person.nachname) &&
                geburtsjahr == person.geburtsjahr;
    }

    @Override

    public boolean equals(Object that) {
        if (that == this) { // ist das Objekt dasselbe wie diese Person, dann gleichen sich beide
            return true;
        }
        if (that == null || that.getClass() != getClass()) {// ein Objekt aus einer anderen Klasse kann diesem Objekt
                                                            // nicht gleichen
            return false;
        }
        Person person = (Person) that; // explizite Typkonvertierung (durch getClass-Vergleich abgesichert)
        return Objects.equals(vorname, person.vorname) && // prüft die Instanzvariablen beider Personen auf Gleichheit
                Objects.equals(nachname, person.nachname) &&
                geburtsjahr == person.geburtsjahr;
    }

    public int hashCode() {
        return Objects.hash(vorname, nachname, geburtsjahr);
    }
}
